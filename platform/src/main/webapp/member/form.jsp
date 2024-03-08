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

<h2>회원</h2>

<form action='/app/member/add' method='post' enctype='multipart/form-data'>
  <div>
        이메일: <input name='email' type='text'>
  </div>
  <div>
        이름: <input name='name' type='text'>
  </div>
  <div>
        암호: <input name='password' type='password'>
  </div>
  <div>
        전화번호: <input tel='tel' type='text'>
  </div>
  <div>
        사진: <input name='photo' type='file'>
  </div>
  <div>
      카드번호: <input name='creditNo' type='text'>
  </div>
  <div>
      유효기간: <input name='creditDate' type='text'>
  </div>
  <div>
      알림설정: <input name='notification' type='tinyint'>
  </div>
  <div>
    <button>등록</button>
  </div>
</form>

<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>