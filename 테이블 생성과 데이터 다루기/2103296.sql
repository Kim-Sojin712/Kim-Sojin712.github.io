--database 생성 : 2103296Mall이라는 이름의 database 생성
create database 2103296Mall;

--생성한 2103296Mall database 사용
use 2103296Mall

--sales table 생성
create table sales (select employees.employeeNumber as s_id, concat(employees.firstName, ' ', employees.lastName) as s_name, employees.reportsTo as s_mgr from classicmodels.employees);

--customers table 생성
create table customers (select customers.customerNumber as c_id, customers.customerName as c_name, customers.city as city, customers.country as country, customers.salesRepEmployeeNumber as sales from classicmodels.customers);

--orders table 생성
create table orders (select orders.orderNumber as o_id, orders.orderDate as o_date, orders.customerNumber as c_id from classicmodels.orders);

--orderdetails table 생성
create table orderdetails (select orderdetails.orderNumber as o_id, orderdetails.productCode as p_id, orderdetails.quantityOrdered as qty, orderdetails.priceEach as price from classicmodels.orderdetails);

--1번 문제 : 고객의 거주 국가(customers.country) 별로 판매(주문 금액 기준)
select C.country, sum(OD.qty * OD.price) as Total from customers C, orderdetails OD, orders O
where C.c_id = O.c_id and O.o_id = OD.o_id group by country order by Total desc;

--2번 문제 : 월별/제품별 판매 수량. (연도 무관.. 2000년 8월, 2001년 8월 모두 8월 판매수량으로 합산)
select OD.p_id as ProductID, date_format(O.o_date, '%m') as Month, sum(OD.qty) as Total
from orders O, orderdetails OD where O.o_id = OD.o_id group by Month, OD.p_id order by Month;

--3번 문제 : 영업 사원별 매출 (group by s_id 로 집계, 실적이 없는 영업 사원도 출력되어야 함 - 외부 조인)
select S.s_id as Code , S.s_name as Name, sum(OD.qty * OD.price) as Total
from sales S left join customers C on S.s_id = C.sales
left join orders O on C.c_id = O.c_id left join orderdetails OD on O.o_id = OD.o_id
group by Code order by Total desc;

--4번 문제 : 사원번호 1088 인 영업관리자의 전체 매출 (시작점을 s_id = '1088'로 해서 재귀query 사용)
with recursive TEST as (
select s_id, s_name, s_mgr from sales where s_id = 1088
union
select S.s_id, S.s_name, S.s_mgr
from sales S, TEST T where S.s_mgr = T.s_id),
subTEST as (
select  T.s_id, T.s_name, T.s_mgr, coalesce(sum(OD.qty * OD.price), 0) as Total
from TEST T
left join customers C on T.s_id = C.sales
left join orders O on C.c_id = O.c_id
left join orderdetails OD on O.o_id = OD.o_id
group by s_id, s_name, s_mgr)
select T.s_id as ID, T.s_name as Name, coalesce(sum(sT.Total), 0) as Result
from TEST T, subTEST sT where T.s_id = sT.s_id;