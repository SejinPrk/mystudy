<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang='en'>
  <head>
  <meta charset='UTF-8'>
  <title>비트캠프 데브옵스 5기</title>
</head>
<body>

<jsp:include page="/header.jsp"></jsp:include>

<h1>알림</h1>

<form action='/app/notification/update' method='post'>
<div>
  번호: <input readonly name='no' type='text' value='${notification.no}'>
</div>
<div>
  내용: <textarea name='content'>'${notification.content}'</textarea>
</div>
<div>
  날짜: <input name='date' type='Date' value='${notification.date}'>
</div>
<div>
  조회여부: <input name='checked' type='boolean' value='${notification.checked}'>
</div>
<div>
  <button>변경</button>
  <a href='/app/notification/delete?no=${notification.no}'>[삭제]</a>
</div>
</form>

<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>