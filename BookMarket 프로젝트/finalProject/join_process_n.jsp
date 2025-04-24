<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>가입 완료</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link rel="stylesheet" href="assets/css/join_process.css">
</head>
<body>
  <div class="container py-4">
    <jsp:include page="header.inc.jsp" />
    <div class="p-5 mb-4 bg-primary text-white rounded shadow-sm">
        <div class="container-fluid py-5 text-center">
            <h1 class="display-4 fw-bold mb-3">가입 완료</h1>
            <hr class="my-4">
            <p class="fs-5">Create account complete</p>
        </div>
    </div>
    <div class="row">
      <div class="col-md-12">
          <h2>입력한 정보</h2>
          <ul class="list-group">
              <li class="list-group-item"><strong>아이디:</strong> null</li>
              <li class="list-group-item"><strong>비밀번호:</strong> null</li>
              <li class="list-group-item"><strong>이름:</strong> null</li>
              <li class="list-group-item"><strong>성별:</strong> null</li>
              <li class="list-group-item"><strong>전화번호:</strong> null</li>
              <li class="list-group-item"><strong>이메일:</strong> null</li>
              <li class="list-group-item"><strong>우편번호:</strong> null</li>
              <li class="list-group-item"><strong>주소:</strong> null</li>
          </ul>
      </div>
  </div>
    <jsp:include page="footer.inc.jsp" />

  </div>
</body>
</html>