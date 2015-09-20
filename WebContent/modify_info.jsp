<%@page import="model.domain.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	String cp = request.getContextPath();%>
<!doctype html>
<html lang="ko">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="generator" content="Bootply" />
<meta name="viewport"	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel='stylesheet'	href="http://fonts.googleapis.com/earlyaccess/nanumbrushscript.css">
<link rel='stylesheet'	href="http://fonts.googleapis.com/earlyaccess/nanumgothic.css">
<link href="<%=cp%>/css/bootstrap.min.css" rel="stylesheet">
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

<title>회원정보입력</title>

<%
	String nickname = (String) request.getAttribute("nickname");
	int age = (Integer) request.getAttribute("age");
	String gender = (String) request.getAttribute("gender");
	String inter_loc = (String) request.getAttribute("inter_loc");
	String inter_sport = (String) request.getAttribute("inter_sport");
%>


<style type="text/css">
.header {
	background: rgba(0, 153, 253, 0.6);
	color: white;
	font-size: 70px;
	font-family: "Nanum Brush Script";
	text-align: center;
	margin-bottom: 15px;
	height: 180px;
	padding: 8px;
}

body {
	font-family: "Nanum Gothic";
}

.logo_img {
	height: 100px;
}

p {
	margin-top: 30px;
	margin-bottom: 30px;
}
.box{
	height: auto; 
	width: 80%; 
	border: 5px solid ;
	border-color: rgba(0, 153, 253, 0.6);
	text-indent: 0%; 
	margin: 0 auto; 
	overflow: auto;
	color:#428bca;
	border-radius:10px;
	font-family: "Nanum Gothic";
}
.sub_title{
	text-align: center;
	font-size: 20px;
	font-weight: bold;
}
</style>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>

<script type="text/javascript">
	var count = 0;

	function idCheck() {
		var text = $("#nickname").val();

		var regexp = /[0-9a-zA-Z가-힣]/;

		for (var i = 0; i < text.length; i++) {
			if (text.charAt(i) != " " && regexp.test(text.charAt(i)) == false) {
				alert("올바른 문자가 아닙니다..");
				return false;
			}
		}
		overlapCheck();
	}

	function overlapCheck() {

		if ($("#nickname").val() == '' || $("#nickname").val() == null) {
			alert("아이디를 입력하세요");
			return false;
		}
		var param = "nickname" + "=" + $("#nickname").val();
		$.ajax({
			url : "idCheck.jsp",
			type : "POST",
			data : param,
			dataType : "text",

			success : function(response) {
				if (response == 1) {
					count = 1;
					alert("아이디가 중복이 되지 않습니다. 쓰셔도 됩니다.")
				} else {
					alert("아이디가 중복이 됩니다. 다시 입력 해주세요");
					return false;
				}
			},
			error : function(request, status, error) {
				if (request.status != '0') {
					alert("code : " + request.status + "\r\nmessage : "
							+ request.reponseText + "\r\nerror : " + error);
				}
			}
		});
	}
</script>
<script type="text/javascript">
	function setAble(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t) {
		// EXECUTE PLUGIN ON DOM READY - START
		document.getElementById(a).disabled = false;
		document.getElementById(b).disabled = false;
		document.getElementById(c).disabled = false;
		document.getElementById(d).disabled = false;
		document.getElementById(e).disabled = false;
		document.getElementById(f).disabled = false;
		document.getElementById(g).disabled = false;
		document.getElementById(h).disabled = false;
		document.getElementById(i).disabled = false;
		document.getElementById(j).disabled = false;
		document.getElementById(k).disabled = false;
		document.getElementById(l).disabled = false;
		document.getElementById(m).disabled = false;
		document.getElementById(n).disabled = false;
		document.getElementById(o).disabled = false;
		document.getElementById(p).disabled = false;
		document.getElementById(q).disabled = false;
		document.getElementById(r).disabled = false;
		document.getElementById(s).disabled = false;
		document.getElementById(t).disabled = false;
		//EXECUTE PLUGIN ON DOM READY - END
	}
</script>



</head>

<body>

	<div class="header">
		<p>
			<img class="logo_img" src="img/checkered12.png">이 구역의 체육인은
			나야<img class="logo_img" src="img/first33.png">
		</p>
	</div>

	<div class="box">
		<h1 style="text-align: center">회원 관심 정보 수정하기</h1>




		<form action="editinfo" name ="modify" method="post">

			<p class="sub_title">
				닉네임<br> <br>
				<!-- <input type="text" size="10" id="member_id"  name="nickname" maxlength="10" onkeydown="countCheck();" onkeypress="countCheck();">&nbsp; -->

				<input type="text" size="10" id="nickname" name="nickname"
					value="${nickname}" disabled="disabled" maxlength="10">&nbsp;
				<input type="button" class="btn btn-primary" onclick='idCheck()' value="중복확인" />



				<p class="sub_title">
					지역<br> <br> <select id="inter_loc" name="inter_loc"
						disabled="disabled"
						onchange="alert(this.option[this.selectedIndex].text)">
						<option id="가평군">가평군</option>
						<option id="고양시 덕양구">고양시 덕양구</option>
						<option id="고양시 일산동구">고양시 일산동구</option>
						<option id="고양시 일산서구">고양시 일산서구</option>
						<option id="과천시">과천시</option>
						<option id="광명시">광명시</option>
						<option id="광주시">광주시</option>
						<option id="구리시">구리시</option>
						<option id="군포시">군포시</option>
						<option id="김포시">김포시</option>
						<option id="남양주시">남양주시</option>
						<option id="동두천시">동두천시</option>
						<option id="부천시 소사구">부천시 소사구</option>
						<option id="부천시 오정구">부천시 오정구</option>
						<option id="부천시 원미구">부천시 원미구</option>
						<option id="부천시">부천시</option>
						<option id="성남시 분당구">성남시 분당구</option>
						<option id="성남시 수정구">성남시 수정구</option>
						<option id="성남시 중원구">성남시 중원구</option>
						<option id="성남시">성남시</option>
						<option id="수원시 권선구">수원시 권선구</option>
						<option id="수원시 영통구">수원시 영통구</option>
						<option id="수원시 장안구">수원시 장안구</option>
						<option id="수원시 팔달구">수원시 팔달구</option>
						<option id="시흥시">시흥시</option>
						<option id="안산시 단원구">안산시 단원구</option>
						<option id="안산시 상록구">안산시 상록구</option>
						<option id="안성시">안성시</option>
						<option id="안양시 동안구">안양시 동안구</option>
						<option id="얀양시 만안구">얀양시 만안구</option>
						<option id="양주시">양주시</option>
						<option id="양평군">양평군</option>
						<option id="여주시">여주시</option>
						<option id="연천군">연천군</option>
						<option id="오산시">오산시</option>
						<option id="용인시 기흥구">용인시 기흥구</option>
						<option id="용인시 수지구">용인시 수지구</option>
						<option id="용인시 처인구">용인시 처인구</option>
						<option id="의왕시">의왕시</option>
						<option id="의정부시">의정부시</option>
						<option id="이천시">이천시</option>
						<option id="파주시">파주시</option>
						<option id="평택시">평택시</option>
						<option id="포천시">포천시</option>
						<option id="하남시">하남시</option>
						<option id="화성시">화성시</option>
						</datalist>
					</select>

					<p class="sub_title">
						성별 <br>
							<input type="radio" name="gender"
								id="gender1" value="1" disabled="disabled"><img
								src="img/man.png"><abbr title="남자"></abbr> <input type="radio" name="gender"
								id="gender2" value="2" disabled="disabled"><img
								src="img/female.png"><abbr title="여자"></abbr>
					
							

								<p class="sub_title">
							연령대<br>
							<br> 
							
							<input type="radio" name="age" id="age1" value=10 disabled="disabled">
								<img src="img/1.png" alt="10대">
							<input type="radio" name="age" id="age2" value=20 disabled="disabled">
								<img src="img/2.png"><abbr title="20대"></abbr>
							<input type="radio" name="age" id="age3" value=30 disabled="disabled">
								<img src="img/3.png"><abbr title="30대"></abbr>
							<input type="radio" name="age" id="age4" value=40 disabled="disabled">
								<img src="img/4.png"><abbr title="40대"></abbr>
							<input type="radio" name="age" id="age5" value=50 disabled="disabled">
							<img src="img/5.png"><abbr title="50대"></abbr>
							<input type="radio" name="age" id="age6" value=60 disabled="disabled">
								<img src="img/6.png"><abbr title="60대"></abbr>
							<input type="radio" name="age" id="age7" value=70 disabled="disabled">
								<img src="img/7.png"><abbr title="70대"></abbr> 
							<input type="radio" name="age" id="age8" value=80 disabled="disabled">
								<img src="img/8.png"><abbr title="80대"></abbr> 
							<input type="radio" name="age"	id="age9" value=90 disabled="disabled">
								<img src="img/9.png"><abbr title="90대"></abbr>

							<p class="sub_title">
								관심종목<br>
								<br> <input type="radio" 	name="inter_sport" id="interest1" value="1" disabled="disabled">
								<img src="img/table tennis equipment.png"><abbr title="탁구"></abbr>
								<input type="radio" name="inter_sport"id="interest2" value="2" disabled="disabled">
								<img src="img/baseball23.png"><abbr title="야구"></abbr> 
								<input type="radio" name="inter_sport" id="interest3" value="3" disabled="disabled">
								<img src="img/basketball51.png"><abbr title="농구"></abbr> 
								<input type="radio" name="inter_sport" id="interest4" value="4" disabled="disabled">
								<img src="img/cycling.png"><abbr title="자전거"></abbr> 
								<input type="radio" name="inter_sport" id="interest5" value="5" disabled="disabled">
								<img src="img/sprint.png"><abbr title="런닝"></abbr> 
								<input type="radio" name="inter_sport"	id="interest6" value="6" disabled="disabled">
								<img src="img/football68.png"><abbr title="축구"></abbr> 
								<input type="radio"	name="inter_sport" id="interest7" value="7" disabled="disabled">
								<img src="img/sports ball30.png"><abbr title="베드민턴"></abbr>

								<p class="sub_title">
									<b>알림:</b> 관심정보에 따라 제공되는 서비스가 달라질수 있습니다.
								</p>


								<div class="col-md-2" style="float: right">
									<input type="button" class="btn btn-primary btn-block" id="submitBtn2" value="수정하기"
										onclick="javascript:setAble(	'nickname',
																							'inter_loc',
																							'gender1',
																							'gender2',
																							'age1','age2','age3',
																							'age4','age5','age6',
																							'age7','age8','age9',
																							'inter_sport1','inter_sport2','inter_sport3',
																							'inter_sport4','inter_sport5','inter_sport6',
																							'inter_sport7')" />

								</div>



								<div class="col-md-2" style="float: right">
									<input type="button" class="btn btn-primary btn-block"  value="저장하기" onclick="submit();">
									<input type="hidden" name="command" value="regist_request">
								</div>
		</form>
	</div>
	<script>
		var loc = document.getElementById("inter_loc");

		var i;
		var selectedtext;
		for (i = 0; i < loc.options.length; i++) {
			selectedtext = loc.options[i].text;

			if (selectedtext == "${inter_loc}") {
				loc.options[i].selected = true;
				break;
			}
		}
		var gender = document.getElementsByName("gender");
		var checkedvalue;
		for (i = 0; i < gender.length; i++) {
			checkedvalue = gender[i].value;
			if (checkedvalue == "${gender}") {
				gender[i].checked = true;
				break;
			}
		}
		var age = document.getElementsByName("age");
		var checkedvalue;
		for (i = 0; i < age.length; i++) {
			checkedvalue = age[i].value;
			if (checkedvalue == "${age}") {
				age[i].checked = true;
				break;
			}
		}
		var inter_sport = document.getElementsByName("inter_sport");
		var checkedvalue;
		for (i = 0; i < inter_sport.length; i++) {
			checkedvalue = inter_sport[i].value;
			if (checkedvalue == "${inter_sport}") {
				inter_sport[i].checked = true;
				break;
			}
		}
	</script>
	<script>
	function submit() { //submit
		 document.modify.submit();
	}
</script>
	<script src="http://code.jquery.com/jquery-2.1.1.min.js"
		type="text/javascript"></script>
	<script src="<%=cp%>/js/bootstrap.min.js"></script>
</body>
</html>
