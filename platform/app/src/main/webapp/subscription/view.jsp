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

<h1>구독내역</h1>

<form action='/app/subscription/update' method='post'>
<div>
  번호: <input readonly name='no' type='text' value='${subscription.no}'>
</div>
<div>
  시작일: <input name='start' type='date' value='${subscription.start}'
</div>
<div>
  종료일: <input name='end'> type='date' value='{subscription.end}'>
</div>
<div>
  <button>변경</button>
  <a href='/app/subscription/delete?no=${subscription.no}'>[삭제]</a>
</div>
</form>

<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>