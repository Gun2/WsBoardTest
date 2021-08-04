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
	<button type="button" onClick="create()" class="btn btn-dark" style="float:right;">
		글쓰기
	</button>
</div>

<table class="table">
  <thead>
    <tr>
      <th scope="col" style="width:1200px">제목</th>
      <th scope="col">작성자</th>
      <th scope="col">등록일</th>
      <th scope="col">조회수</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="board" varStatus="status">
  	<tr>
      <th scope="row">
      	<a href="/board/view/<c:out value="${board.id}"/>"><c:out value="${board.title}"/></a>
      </th>
      <td>TEST</td>
      <td><c:out value="${board.sdate}"/></td>
      <td><c:out value="${board.view}"/></td>
  	</tr>
  </c:forEach>
  </tbody>
</table>

<ul class="btn-group pagination">
    <c:if test="${pageMaker.prev }">
    <li>
        <a href='<c:url value="/board/list?page=${pageMaker.startPage-1 }"/>'><i class="fa fa-chevron-left"></i></a>
    </li>
    </c:if>
    <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">
    <li>
        <a href='<c:url value="/board/list?page=${pageNum }"/>'><i class="fa">${pageNum }</i></a>
    </li>
    </c:forEach>
    <c:if test="${pageMaker.next && pageMaker.endPage >0 }">
    <li>
        <a href='<c:url value="/board/list?page=${pageMaker.endPage+1 }"/>'><i class="fa fa-chevron-right"></i></a>
    </li>
    </c:if>
</ul>
</section>
<footer>
	<c:import url="/import/footer"/>
</footer>
<script type="text/javascript">
	function create(){
		window.location = "/board/create";
	}
	
	function view(id){
		var form = document.createElement('form');
		form.method = "get";
		form.action = `/board/view/\${id}`;
		form.submit();
	}
</script>
</body>
</html>