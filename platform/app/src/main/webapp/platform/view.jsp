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

<h1>플랫폼</h1>

<form action='/app/platform/update' method='post'>
<div>
  번호: <input readonly name='no' type='text' value='${notification.no}'>
</div>
<div>
  플랫폼명: <input name='name' type='text' value='${platform.name}'>
</div>
<div>
  가격: <textarea name='price'>${platform.price}</textarea>
</div>
<div>
  결제주기: <textarea name='term'>${platform.term}</textarea>
</div>
<div>
  <button>변경</button>
  <a href='/app/platform/delete?no=${platform.no}'>[삭제]</a>
</div>
</form>

<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>