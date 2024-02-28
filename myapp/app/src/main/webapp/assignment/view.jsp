<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="bitcamp.myapp.vo.Member"%>
<!DOCTYPE html>
<html lang='en'>
  <head>
  <meta charset='UTF-8'>
  <title>비트캠프 데브옵스 5기</title>
</head>
<body>

<jsp:include page="/header.jsp"></jsp:include>

  <h1>과제</h1>
       <form action='/assignment/update' method='post'>
       <div>
      out.printf("  번호: <input readonly name='no' type='text' value='%d'>\n", assignment.getNo());
       </div>
       <div>
      out.printf("  과제명: <input name='title' type='text' value='%s'>\n", assignment.getTitle());
       </div>
       <div>
      out.printf("  내용: <textarea name='content'>%s</textarea>\n", assignment.getContent());
       </div>
       <div>
      out.printf("  제출마감일: <input name='deadline' type='date' value='%s'>\n",
          assignment.getDeadline());
       </div>
       <div>
         <button>변경</button>
      out.printf("  <a href='/assignment/delete?no=%d'>[삭제]</a>\n", no);
       </div>
       </form>

<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>