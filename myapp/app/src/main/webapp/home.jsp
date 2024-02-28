<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
 <html lang='en'>
 <head>
  <meta charset='UTF-8'>
  <title>비트캠프 데브옵스 5기</title>
 </head>
 <body>

    request.getRequestDispatcher("/header").include(request, response);

 <h1>과제 관리 시스템</h1>
 <p>환영합니다! 교육 센터 과제 관리 시스템입니다.</p>

    request.getRequestDispatcher("/footer").include(request, response);

   </body>
   </html>