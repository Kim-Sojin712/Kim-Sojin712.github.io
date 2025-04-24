<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
	<link rel="stylesheet" href="assets/css/join.css">
    <title>회원 가입</title>
</head>
<body>
<div class="container py-4">
<jsp:include page="header.inc.jsp" />
<div class="p-5 mb-4 bg-primary text-white rounded shadow-sm">
    <div class="container-fluid py-5 text-center">
        <h1 class="display-4 fw-bold mb-3">회원 가입</h1>
        <hr class="my-4">
        <p class="fs-5">Create your account to get started</p>
    </div>
</div>
<div class="row align-items-md-stretch text-center">
    <form name="join" action="join_process.jsp" method="post" onsubmit="return checkForm()">
        <div class="mb-3 row">
            <div class="d-grid gap-2 d-md-flex">
                <h5 style="font-weight: bold;">※ '<span class="color" style="color: red;">*</span>'표시 항목은 필수작성 항목 입니다.</h5>
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label"><span class="must">*</span>아이디</label>
            <div class="col-sm-3">
                <input name="id" type="text" class="form-control" placeholder="아이디를 입력하세요." >
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label"><span class="must">*</span>비밀번호</label>
            <div class="col-sm-3">
                <input name="password" type="password" class="form-control" placeholder="비밀번호를 입력하세요." >
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label"><span class="must">*</span>비밀번호확인</label>
            <div class="col-sm-3">
                <input name="password_confirm" type="password" class="form-control" placeholder="다시 한 번 비밀번호를 입력해주세요." >
            </div>
            <div class="col-sm-3" style="text-align: left;">
                <div id="passwordHelpInline" class="form-text" style="color: red; font-weight: bold; display: none;">
                    비밀번호가 일치하지 않습니다.
                </div>
            </div>
        </div>
		<div class="mb-3 row">
            <label class="col-sm-2 col-form-label"><span class="must">*</span>보안 질문</label>
            <div class="col-sm-3">
                <select name="security_question" class="form-select">
                    <option value="">보안 질문을 선택하세요.</option>
                    <option value="첫 번째 학교 이름은?">내가 재학중인 학교 이름은?</option>
                    <option value="어머니의 성함은?">어머니의 성함은?</option>
                    <option value="반려동물의 이름은?">반려동물의 이름은?</option>
                </select>
            </div>
        </div>
		<div class="mb-3 row">
            <label class="col-sm-2 col-form-label"><span class="must">*</span>보안 질문 답변</label>
            <div class="col-sm-3">
                <input name="security_answer" type="text" class="form-control" placeholder="답변을 입력하세요." >
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label"><span class="must">*</span>이름</label>
            <div class="col-sm-3">
                <input name="name" type="text" class="form-control" placeholder="이름을 입력하세요." >
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label"><span class="must">*</span>성별</label>
            <div class="col-sm-3" style="text-align: left;">
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" value="남">
                    <label class="form-check-label">남</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" value="여">
                    <label class="form-check-label">여</label>
                </div>
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label"><span class="must">*</span>생년월일</label>
            <div class="col-sm-3">
                <div class="row">
                    <div class="col-sm-4">
                        <input type="text" name="birthyy" maxlength="4" class="form-control" placeholder="EX)1900" >
                    </div>
                    <div class="col-sm-4">
                        <select name="birthmm" class="form-select" >
                            <option value="">선택</option>
                            <option value="01">01</option>
                            <option value="02">02</option>
                            <option value="03">03</option>
                            <option value="04">04</option>
                            <option value="05">05</option>
                            <option value="06">06</option>
                            <option value="07">07</option>
                            <option value="08">08</option>
                            <option value="09">09</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                        </select>
                    </div>
                    <div class="col-sm-4">
                        <select name="birthdd" class="form-select" >
                            <option value="">선택</option>
                            <option value="01">01</option>
                            <option value="02">02</option>
                            <option value="03">03</option>
                            <option value="04">04</option>
                            <option value="05">05</option>
                            <option value="06">06</option>
                            <option value="07">07</option>
                            <option value="08">08</option>
                            <option value="09">09</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                            <option value="13">13</option>
                            <option value="14">14</option>
                            <option value="15">15</option>
                            <option value="16">16</option>
                            <option value="17">17</option>
                            <option value="18">18</option>
                            <option value="19">19</option>
                            <option value="20">20</option>
                            <option value="21">21</option>
                            <option value="22">22</option>
                            <option value="23">23</option>
                            <option value="24">24</option>
                            <option value="25">25</option>
                            <option value="26">26</option>
                            <option value="27">27</option>
                            <option value="28">28</option>
                            <option value="29">29</option>
                            <option value="30">30</option>
                            <option value="31">31</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">이메일</label>
            <div class="col-sm-3">
                <div class="input-group">
                    <input type="text" name="mail1" maxlength="50" class="form-control" placeholder="email">
                    <span class="input-group-text">@</span>
                    <select name="mail2" class="form-select">
                        <option>naver.com</option>
                        <option>daum.net</option>
                        <option>gmail.com</option>
                        <option>nate.com</option>
						<option>hanmail.com</option>
						<option>gmail.com</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label"><span class="must">*</span>전화번호</label>
            <div class="col-sm-3">
                <input name="phone" type="text" class="form-control" placeholder="전화번호를 입력해주세요." >
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">주소</label>
            <div class="col-sm-3">
                <div class="input-group mb-3">
                    <input type="text" class="form-control" name="postcode" placeholder="우편번호" readonly required>
                    <button class="btn btn-secondary" type="button" id="postcode">우편번호 찾기</button>
                </div>
                <input type="text" class="form-control mb-3" name="addr1" placeholder="도로명 주소" readonly required>
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label"><span class="must">*</span>약관 동의</label>
            <div class="col-sm-10" style="text-align: left;">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="terms" id="terms" >
                    <label class="form-check-label" for="terms">
                        <a href="#" target="_self">이용 약관</a> 및 <a href="#" target="_self">개인정보 처리방침</a>에 동의합니다. <span class="must">(필수)</span>
                    </label>
                </div>
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">마케팅 정보 수신 동의</label>
            <div class="col-sm-10" style="text-align: left;">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="marketing" id="marketing">
                    <label class="form-check-label" for="marketing">
                        이메일 또는 SMS로 마케팅 정보를 수신합니다. <span class="select">(선택)</span>
                    </label>
                </div>
            </div>
        </div>
        <div class="mb-3 row">
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <input type="submit" class="btn btn-outline-primary" value="가입하기">
            </div>
        </div>
    </form>
    <div class="mb-3 row align" id="align" style="text-align: left;">
        <jsp:include page="footer.inc.jsp" />
    </div>
	
</div>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="assets/js/join_javascript.js"></script>

</body>
</html>