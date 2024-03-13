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

<h1>결제내역</h1>

<a href='/app/payment/form'>새 결제내역</a>
<table border='1'>
  <thead>
    <tr> <th>번호</th> <th>시작일</th> <th>종료일</th> <th>가격</th> </tr>
  </thead>
  <tbody>

<c:forEach items="${list}" var="payment">
    <tr>
      <td>${assignment.no}</td>
      <td><a href='/app/payment/view?no=${payment.no}'>${payment.start}</a></td>
      <td>${payment.end}</td>
      <td>${payment.amount}</td>
    </tr>
</c:forEach>

  </tbody>
</table>

<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>