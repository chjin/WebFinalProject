<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
	EL : 데이터르 출력
	= ${requestScope.no1}   = request.getAttribute("no1")
				== key
	  ${no1}
	= ${sessionScope.id}    = session.getAttribute("id")
	= ${param.id}           = request.getParameter("id")
	
	JSTL : 태그
	= core (제어문,URL)
	  <c:forEach>
	  <c:if>
	  <c:redirct>
	= fmt (날짜변환)
	  <fmt:formatDate>   			
 --%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>영화통계 사이트</title>
	<link href="styles.css" rel="stylesheet" type="text/css" media="screen"/>
	<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
	<script type="text/javascript">
		$(function(){
			
		});
	
	</script>
</head>
<body>
	<div id="wrap">
		<div id="menu">
			<ul>
				<li><a href="main.do" class="active">홈</a></li>
				<c:if test="${sessionScope.id==null }">
					<li><a href="blog.html">회원가입</a></li>
				</c:if>
				
				<li><a href="movie.do">영화</a></li>
			</ul>
		</div>
		
		<div id="top_padding"></div>
		<!-- include -->
		<jsp:include page="${jsp }"></jsp:include>
	</div>
</body>
</html>














































