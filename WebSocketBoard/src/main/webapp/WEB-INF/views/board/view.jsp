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
<form id="deleteForm" method="GET" action="/board/delete/<c:out value="${boardVO.id}"/>">
</form>
<form id="modifyForm" method="GET" action="/board/modify/<c:out value="${boardVO.id}"/>">
</form>

<div class="controll-div">
	<div class="right">
		<button type="button" onClick="moveList()" class="btn btn-secondary"><i class="fas fa-bars"></i> 목록</button>
		<button type="button" onClick="modifyBoard()" class="btn btn-success"><i class="fas fa-edit"></i> 수정</button>
		<button type="button" onClick="deleteBoard()" class="btn btn-danger"><i class="fas fa-trash-alt"></i> 삭제</button>
	</div>
</div>
<br/>
<div class="board-contain">
	<div class="view">
		<div class="view-inner">
			<i class="fas fa-eye"></i> <c:out value="${boardVO.view}"></c:out>
		</div>
	</div>
	<div class="title">
		<i class="fas fa-align-justify"></i> <c:out value="${boardVO.title}"></c:out>
	</div>
	<div class="content">
		<textarea class="content-inner" readonly><c:out value="${boardVO.content}"></c:out></textarea>
	</div>
</div>
</section>
<footer>
	<c:import url="/import/footer"/>
</footer>

<script>

function moveList(){
	//게시판 목록으로 이동
	window.location = "/board/list";
}

function deleteBoard(){
	//해당 글 삭제
	if(confirm('해당 게시글을 삭제하시겠습니까?')){
		var form = document.getElementById('deleteForm');
		form.submit()
	}
}

function modifyBoard(){
	//해당 글 수정 
	if(confirm('해당 게시글을 수정하시겠습니까?')){
		var form = document.getElementById('modifyForm');
		form.submit()
	}
}
</script>
</body>
</html>