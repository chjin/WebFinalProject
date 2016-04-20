<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>영화 통계 그래프로 보기</title>
	<link rel="stylesheet" type="text/css" href="movie.css">
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script>
	  google.charts.load('current', {'packages': ['corechart']});
	  google.charts.setOnLoadCallback(drawChart);
	  
	  function drawChart() {
	      // Define the chart to be drawn.
	      var data = google.visualization.arrayToDataTable([
	      	['영화명', '예매율'],
	      	<c:forEach var="vo" items="${list}">
	      	['<c:out value="${vo.title}"/>', <c:out value="${vo.reserve}"/>],
	      	</c:forEach>
	      ]);
	      
	      var options={ 
	   		title: '예매현황보기' 		  
	      };
	      
	      // Instantiate and draw the chart.
	      var chart = new google.visualization.PieChart(document.getElementById('piechart'));
	      chart.draw(data, options);
	      
	  }



	</script>
</head>
<body>
	<center>
		<table id="table_content">
			<tr>
				<c:forEach var="vo" items="${list }">
					<td>
						<img src="${vo.image }" width="100" height="120" border=0>
					</td>
				</c:forEach>
			</tr>
			<tr>
			</tr>
		</table>
		
		<table id="table_content">
			<tr>
				<td class="tdcenter">
					<div id="piechart" style="width: 450px; height: 550px;"></div>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>



























































