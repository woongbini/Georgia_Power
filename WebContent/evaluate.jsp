<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--  jstl이라는 외부 tag library를 사용한다는 선언   c:으로 시작되는 모든 tag는 jstl core tag라고 표기-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String cp = request.getContextPath(); %> <%--ContextPath 선언 --%>


<head>
<link href="<%=cp%>/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <meta name="generator" content="Bootply" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel='stylesheet' 	href="http://fonts.googleapis.com/earlyaccess/nanumbrushscript.css">
	<link rel='stylesheet' 	href="http://fonts.googleapis.com/earlyaccess/nanumgothic.css">
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css">
	<link href="<%=cp%>/css/bootstrap.min.css" rel="stylesheet">

<title>successAll.jsp</title>
	<style type="text/css">
	.header {
		background: rgba(0, 153, 255, 0.6);
		color: white;
		font-size: 120px;
		font-family: "Nanum Brush Script";
		text-align: center;
		margin-bottom: 15px;
		height: 200px;
		padding: 8px;
	}
	</style>
</head>

<body>
	<div class="header">
		<p>
			<img class="logo_img" src="img/checkered12.png"> 이 구역의 체육인은 나야
			<img class="logo_img" src="img/first33.png">
		</p>

	</div>
	<br>
	<center><h3>참석여부와 매너도를 평가해 주세요 </h3> </center>
	<br>

	
	
	<form action="rate" method="post">
	
             
         <div style="height:auto; width: 80%; border:5px light blue; text-indent:0%; margin:0 auto; ">
          <div style= "align:middle"class="alert alert-info alert-dismissable">
		<table style ="border-radius:7px;">
		<c:set var ="i" value="0"/>
		<c:set var ="j" value="6"/>
			<c:forEach  var="participants" items="${requestScope.allData}" varStatus="counterVal">
			<c:if test= "${i%j ==0}">
			<tr>
			</c:if>
				
					<td><strong>${participants}&nbsp;</strong>
					<input type="hidden"name="name${counterVal.count}" value="${participants}">
					
					</td>
					
				

				<td><select name="star${counterVal.count}">
						<option value="0" >불참</option>
						<option value="1">★</option>
						<option value="2">★★</option>
						<option value="3">★★★</option>
						<option value="4">★★★★</option>
						<option value="5">★★★★★</option>
				</select></td>
				
				<c:if test = "${i%j == j-1}">
				</tr>
				</c:if>
				<c:set var="i" value="${i+1}"/>
				<input id= "count" type="hidden" name="count" value="${counterVal.count}">
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		
		
			</c:forEach>
	
	
		</table>
			  </div>
		<center> <input type="submit" name="command" value="saveddata" > </center>
	</div>		
	</form>


	<script src="http://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script src="<%=cp%>/js/bootstrap.min.js"></script>
  
</body>
</html>