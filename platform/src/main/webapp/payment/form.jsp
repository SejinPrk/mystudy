<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang='en'>
  <head>
  <meta charset='UTF-8'>
  <title>비트캠프 데브옵스 5기</title>
</head>
<body>

<jsp:include page="/header.jsp"></jsp:include>

<h1>플랫폼 관리 시스템</h1>

<h2>결제내역</h2>

<form action='/app/payment/add' method='post'>
  <div>
     시작일: <input name='start' type='date'>
  </div>
  <div>
     종료일: <input name='end' type='date'>
  </div>
  <div>
      가격: <input name='amount' type='number'>
  </div>
  <div>
    <button>등록</button>
  </div>
</form>

<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>