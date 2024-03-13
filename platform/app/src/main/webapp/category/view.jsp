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

<h1>분류</h1>

<form action='/app/category/update' method='post'>
<div>
  번호: <input readonly name='no' type='text' value='${category.no}'>
</div>
<div>
  이름: <input name='name' type='text' value='${category.name}'>
</div>
<div>
  <button>변경</button>
  <a href='/app/category/delete?no=${category.no}'>[삭제]</a>
</div>
</form>

<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>