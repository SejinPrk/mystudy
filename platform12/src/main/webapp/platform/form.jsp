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

<h2>플랫폼</h2>

<form action='/app/platform/add' method='post'>
  <div>
     플랫폼: <input name='title' type='text'>
  </div>
  <div>
     이름: <input name='name'></in>"
  </div>
  <div>
     가격: <input name='price'>
  </div>
  <div>
     결제주기: <input name='term'>
    </div>
  <div>
    <button>등록</button>
  </div>
</form>

<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>