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

<a href='/app/platform/form'>새 알림</a>
<table border='1'>
  <thead>
    <tr> <th>번호</th> <th>이름</th> <th>가격</th> <th>결제주기</th> </tr>
  </thead>
  <tbody>

<c:forEach items="${list}" var="notification">
    <tr>
      <td>${platform.no}</td>
      <td><a href='/app/platform/view?no=${platform.no}'>${platform.name}</a></td>
      <td>${platform.price}</td>
      <td>${platform.term}</td>
    </tr>
</c:forEach>

  </tbody>
</table>

<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>