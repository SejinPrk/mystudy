<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
  <img src='https://images.unsplash.com/photo-1621360841013-c7683c659ec6?q=80&w=2664&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D' height='80px'>
  <a href='/platform/list'>플랫폼</a>
  <a href='/category/list'>분류</a>
  <a href='/member/list'>회원</a>
  <a href='/notification/list'>알림</a>
  <a href='/payment/list'>결제내역</a>
  <a href='/subscription/list'>구독내역</a>

<c:if test="${not empty loginUser}">
  <span>${loginUser.name}</span>
  <a href='/app/auth/logout'>로그아웃</a>
</c:if>

<c:if test="${empty loginUser}">
  <a href='/app/auth/form'>로그인</a>
</c:if>

  <a href='/app/about'>소개</a>
</header>
