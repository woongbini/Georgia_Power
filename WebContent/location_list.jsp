<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String cp_1 = request.getContextPath(); %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel='stylesheet'	href="http://fonts.googleapis.com/earlyaccess/nanumbrushscript.css">
<link rel='stylesheet'	href="http://fonts.googleapis.com/earlyaccess/nanumgothic.css">
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css">
<link href="<%=cp_1%>/css/bootstrap.min.css" rel="stylesheet">
<title>location_list.jsp</title>
<style>
body {
	font-family: "Nanum Gothic";
}
</style>
</head>
<body>
	<div class="col-xs-12" style="height: 400px">
		<c:forEach items="${requestScope.regiData}" var="regiData">
			<h2>${regiData.board_number }-${regiData.title}</h2>
			<p>
				지역 : ${regiData.region}<br> 날짜: ${regiData.date}<br>
			<p class="lead">
				<button type="button" class="btn btn-default" data-toggle="collapse"
					data-target="#loc_readMore${regiData.board_number}">더보기</button>
			</p>
			<div id="loc_readMore${regiData.board_number}" class="panel-collapse collapse ">
				<div class="panel-body">
					<p>
						모집 인원: ${regiData.number_of_person}<br> 
						나이대 : ${regiData.age}<br>
						성별 : ${regiData.gender}<br> 
						게시자 : ${regiData.user_id}<br>
						위치 x좌표: ${regiData.location_x}<br> 
						위치 y좌표: ${regiData.location_y}<br> 
						상세 정보: ${regiData.detail}
					</p>
				</div>
			</div>
			<div class="panel-group" id="accordion1">
				<div class="panel">
					<div class="panel-heading">
						<ul class="list-inline">
							<p class="pull-right">
								<span class="label label-default">keyword</span> <span
									class="label label-default">tag</span> <span
									class="label label-default">post</span>
							</p>
							<li><a href="#">2 Days Ago</a></li>
							<li><a type="button" data-toggle="collapse"
								data-target="#loc_comment1"><i
									class="glyphicon glyphicon-comment"></i> 2 Comments</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-share"></i>
									14 Shares</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-heart"></i>
									찜하기</a></li>
						</ul>
					</div>
					<div id="loc_comment1" class="panel-collapse collapse ">
						<div class="panel-body">댓글보여주는 페이지</div>
					</div>
				</div>
			</div>
			</c:forEach>
	</div>
	
	<script src="http://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script src="<%=cp_1%>/js/bootstrap.min.js"></script>


</body>
</html>