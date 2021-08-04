<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link <c:if test="${tab eq '1'}">active</c:if>" aria-current="page" href="/">SSR 게시판</a>
  </li>
  <li class="nav-item">
    <a class="nav-link <c:if test="${tab eq '2'}">active</c:if>" href="/spa/board/view">SPA 게시판</a>
  </li>
  <li class="nav-item">
    <a class="nav-link <c:if test="${tab eq '3'}">active</c:if>" href="/spa/wsBoard/view">SPA+WS 게시판</a>
  </li>
</ul>