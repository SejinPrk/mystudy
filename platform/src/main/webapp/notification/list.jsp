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

<a href='/app/notification/form'>새 알림</a>
<table border='1'>
  <thead>
    <tr> <th>번호</th> <th>내용</th> <th>날짜</th> <th>조회여부</th> </tr>
  </thead>
  <tbody>

<c:forEach items="${list}" var="notification">
    <tr>
      <td>${notification.no}</td>
      <td><a href='/app/notification/view?no=${notification.no}'>${notification.content}</a></td>
      <td>${notification.date}</td>
      <td>${notification.checked}</td>
    </tr>
</c:forEach>

  </tbody>
</table>

<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>