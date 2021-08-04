<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<!-- 공통 헤드 -->
  	<c:import url="/import/head"/>
</head>
<body>
<header>
  	<c:import url="/import/header/1"/>
</header>
<section>
<div class="controll-div">
	<div class="right">
		<button type="button" onClick="moveList()" class="btn btn-secondary"><i class="fas fa-bars"></i> 목록</button>
		<button type="button" onClick="submit()" class="btn btn-success"><i class="fas fa-edit"></i> 저장</button>
	</div>
</div>
<br/>
<c:if test="${form eq 'create'}">
<form id="form" action="/board/create" method="post">
</c:if>
<c:if test="${form eq 'modify'}">
<form id="form" action="/board/modify" method="post">
<input type="hidden" name="id" value="<c:out value="${boardVO.id}"/>"/>
</c:if>
<div class="board-contain">
	<div class="title">
		<i class="fas fa-align-justify"></i> <input style="width:500px;" name="title" type="text" placeholder="게시판 제목" 
		<c:if test="${form eq 'modify'}">value="<c:out value="${boardVO.title}"/>"</c:if>
		/>
	</div>
	<div class="content">
		<textarea class="content-inner" name="content"><c:if test="${form eq 'modify'}"><c:out value="${boardVO.content}"/></c:if></textarea>
	</div>
</div>
</form>
</section>
<footer>
	<c:import url="/import/footer"/>
</footer>

<script>

function moveList(){
	//게시판 목록으로 이동
	window.location = "/board/list";
}

function submit(){
	
	<c:if test="${form eq 'create'}">
	var message = '저장하시겠습니까?';
	</c:if>
	<c:if test="${form eq 'modify'}">
	var message = '수정하시겠습니까?';
	</c:if>


	var form = document.getElementById("form");
	form.submit();		


}

</script>
</body>
</html>