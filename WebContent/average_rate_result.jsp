<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%	String cp = request.getContextPath(); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="generator" content="Bootply" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="<%=cp%>/css/bootstrap.min.css" rel="stylesheet">
<title>result.jsp</title>
</head>
<body>
회원 평균 정보입니다.<br>----------------------<br>
db에서 불러온 정보<br>
<form action="rate" method="post">
	<input type="submit" name="command" value="showaverage" >
	</form>
	<table>
		<c:forEach items="${requestScope.allData}" var="allData">
			<div class="col-md-3">
				<div class="row example-progress">
					<p>${allData.nickname}</p>
						<div class="col-md-12">
							<div class="progress">
								<div class="progress-bar" role="progressbar" aria-valuenow="${allData.rate}"
							aria-valuemin="0" aria-valuemax="10" style="width: ${allData.rate}0%;">${allData.rate}0%</div>
							</div>
						</div>
					</div>
				</div>
		</c:forEach>
		</table>
<script src="http://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
	<script src="<%=cp%>/js/bootstrap.min.js"></script>
	
</body>
</html>