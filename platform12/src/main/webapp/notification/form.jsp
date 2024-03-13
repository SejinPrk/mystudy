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

<h2>알림</h2>

<form action='/app/notification/add' method='post'>
  <div>
     내용:  <textarea name='content'></textarea>
  </div>
  <div>
     날짜: <input name='date' type='date'>
  </div>
  <div>
     조회여부: <input name='check' type='checkbox'>
  </div>
  <div>
    <button>등록</button>
  </div>
</form>

<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>