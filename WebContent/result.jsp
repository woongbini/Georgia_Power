<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<title>result.jsp</title>
</head>
<body>
등록하는 정보입니다.<br><br>
<font color="purple">${requestScope.insertData.title}</font><br>

db에서 불러온 정보
<table border="1" bgcolor="#FF7575" bordercolor="white">
		<c:forEach items="${requestScope.regiData}" var="regiData">
			<tr>
				<td>${regiData.board_number }</td>
				<td>${regiData.title}</td>
				<td>${regiData.region}</td>
				<td>${regiData.date}</td>
				<td>${regiData.number_of_person}</td>
				<td>${regiData.age}</td>
				<td>${regiData.gender}</td>
				<td>${regiData.sport}</td>
				<td>${regiData.user_id}</td>
				<td>${regiData.location_x}</td>
				<td>${regiData.location_y}</td>
				<td>${regiData.detail}</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>