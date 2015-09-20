<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	String cp = request.getContextPath();
	if (request.getAttribute("data") == null) {
		response.sendRedirect("mydb?command=get_location");
		return;
	}
%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel='stylesheet'
	href="http://fonts.googleapis.com/earlyaccess/nanumbrushscript.css">
<link rel='stylesheet'
	href="http://fonts.googleapis.com/earlyaccess/nanumgothic.css">
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css">
<link href="<%=cp%>/css/bootstrap.min.css" rel="stylesheet">
<!--light box start -->
<link rel="stylesheet" href="css/style_lightbox.css" />
<link rel="stylesheet" href="css/style_lightbox2.css" />
<script type="text/javascript" src="js/tinybox_lightbox.js"></script>
<script type="text/javascript" src="js/tinybox_lightbox2.js"></script>
<!-- light box end-->
<!-- light box end-->

<!-- 다음 API 라이브러리 호출 스크립트 -->
<!-- 다음 API 키 : d25a39803c684e42f879ec420b0f1fa8 -->
<link rel="stylesheet" href="css/map.css" />
<script type="text/javascript"
	src="//apis.daum.net/maps/maps3.js?apikey=d25a39803c684e42f879ec420b0f1fa8&libraries=services">
	
</script>

<!-- floating start-->
<link href="css/page_floating.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="js/jquery_mini_floating.js"></script>
<script language="javascript" src="js/jquery.dimensions_floating.js"></script>
<script language="javascript">
	var name = "#floatMenu";
	var menuYloc = null;

	$(document).ready(
			function() {
				menuYloc = parseInt($(name).css("top").substring(0,
						$(name).css("top").indexOf("px")))
				$(window).scroll(function() {
					offset = menuYloc + $(document).scrollTop() + "px";
					$(name).animate({
						top : offset
					}, {
						duration : 500,
						queue : false
					});
				});
			});
</script>
<!-- floating end-->


<title>main.jsp</title>
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

body {
	font-family: "Nanum Gothic";
}

.icon {
	width: 35px;
	height: 35px;
	color: rgba(0, 153, 255, 0.6);
}

.logo_img {
	height: 150px;
}

.time {
	color: #428bca;
}

/*floating start*/
#floatMenu {
	position: absolute;
	top: 0px;
	left: -100%;
	right: 0%;
	margin-left: 250px;
	width: 300px;
}

#floatMenu ul {
	margin-bottom: 20px;
}

#floatMenu ul li a {
	display: block;
	border: 1px solid #999;
	background-color: #222;
	border-left: 6px solid #999;
	text-decoration: none;
	color: #ccc;
	padding: 5px 5px 5px 25px;
}

#floatMenu ul li a:hover {
	color: #fff;
	background-color: #333333;
}

#floatMenu ul.menu1 li a:hover {
	border-color: #09f;
}

#floatMenu ul.menu2 li a:hover {
	border-color: #9f0;
}

#floatMenu ul.menu3 li a:hover {
	border-color: #f09;
}
/*floating end*/
</style>
</head>
<body>
	<script>
		if ("${requestScope.data}" == "loc") {
			$(document).ready(function() {
				$('#loc_tab').addClass('active');
				$('#peo_tab').removeClass('active');

			});
		} else if ("${requestScope.data}" == "peo") {
			$(document).ready(function() {
				$('#peo_tab').addClass('active');
				$('#loc_tab').removeClass('active');
			});
		}
	</script>
	<div class="header">
		<p>
			<img class="logo_img" src="img/checkered12.png"> 이 구역의 체육인은 나야
			<img class="logo_img" src="img/first33.png">
		</p>

	</div>
	<div class="container-fluid">
		<!--left메뉴-->
		<div class="col-sm-2">
			<!--  운동종목 카테고리 -->
			<div class="row" id="floatMenu">
				<div class="col-md-8">

					<div class="list-group">
						<a href="#" class="list-group-item active"
							style="background: rgba(0, 153, 255, 0.6)">Category</a>

						<form name="soccer_code" action="mydb" method="post"
							id="soccer_code">
							<script>
								if ("${requestScope.data}" == "loc") {
									document.getElementById("soccer_code").innerHTML += "<input type='hidden' name='reqData' value='location'>";
								} else if ("${requestScope.data}" == "peo") {
									document.getElementById("soccer_code").innerHTML += "<input type='hidden' name='reqData' value='people'>";
								}
							</script>
							<a href="#" class="list-group-item" onclick="myfunc('soccer');">
								<abbr title="축구"> <img class="icon"
									src="img/sport-pictos/soccer42.png" alt="Soccer" id="Soccer">
									축구
							</abbr>
							</a> <input type="hidden" name="command" value="get_sport"> <input
								type="hidden" name="sports" value="get_soccer">

						</form>


						<form name="baseball_code" id="baseball_code" action="mydb"
							method="post">
							<a href="#" class="list-group-item" onclick="myfunc('baseball');">
								<abbr title="야구"> <img class="icon"
									src="img/sport-pictos/baseball23.png" alt="Baseball"> 야구
							</abbr>
							</a> <input type="hidden" name="command" value="get_sport"> <input
								type="hidden" name="sports" value="get_baseball">
							<script>
								if ("${requestScope.data}" == "loc") {
									document.getElementById("baseball_code").innerHTML += "<input type='hidden' name='reqData' value='location'>";
								} else if ("${requestScope.data}" == "peo") {
									document.getElementById("baseball_code").innerHTML += "<input type='hidden' name='reqData' value='people'>";
								}
							</script>
						</form>


						<form name="tennis_code" id="tennis_code" action="mydb"
							method="post">
							<a href="#" class="list-group-item" onclick="myfunc('tennis');">
								<abbr title="테니스"> <img class="icon"
									src="img/sport-pictos/tennis17.png" alt="Tennis"> 테니스
							</abbr>
							</a> <input type="hidden" name="sports" value="get_tennis"> <input
								type="hidden" name="command" value="get_sport">
							<script>
								if ("${requestScope.data}" == "loc") {
									document.getElementById("tennis_code").innerHTML += "<input type='hidden' name='reqData' value='location'>";
								} else if ("${requestScope.data}" == "peo") {
									document.getElementById("tennis_code").innerHTML += "<input type='hidden' name='reqData' value='people'>";
								}
							</script>
						</form>


						<form name="basketball_code" id="basketball_code" action="mydb"
							method="post">
							<a href="#" class="list-group-item"
								onclick="myfunc('basketball');"> <abbr title="농구"> <img
									class="icon" src="img/sport-pictos/basketball34.png"
									alt="Basketball"> 농구
							</abbr></a> <input type="hidden" name="command" value="get_sport"> <input
								type="hidden" name="sports" value="get_basketball">
							<script>
								if ("${requestScope.data}" == "loc") {
									document.getElementById("basketball_code").innerHTML += "<input type='hidden' name='reqData' value='location'>";
								} else if ("${requestScope.data}" == "peo") {
									document.getElementById("basketball_code").innerHTML += "<input type='hidden' name='reqData' value='people'>";
								}
							</script>
						</form>


						<form name="running_code" id="running_code" action="mydb"
							method="post">
							<a href="#" class="list-group-item" onclick="myfunc('running');">
								<span class="badge badge-primary">38</span> <abbr title="런닝">
									<img class="icon" src="img/sport-pictos/sprint.png"
									alt="Running">런닝
							</abbr>
							</a> <input type="hidden" name="sports" value="get_running">
							<input type="hidden" name="command" value="get_sport">
							<script>
								if ("${requestScope.data}" == "loc") {
									document.getElementById("running_code").innerHTML += "<input type='hidden' name='reqData' value='location'>";
								} else if ("${requestScope.data}" == "peo") {
									document.getElementById("running_code").innerHTML += "<input type='hidden' name='reqData' value='people'>";
								}
							</script>
						</form>

					</div>



					<hr>
					<div>
						<h2>&nbsp;사용자 정보</h2>
						<div class="col-md-16">
							<div class="thumbnail">
								<img class="img-rounded" src="img/IMG_0597.PNG">
								<div class="caption text-center">
									<h3>웅비니</h3>
									<p>(양주시,야구)<br></p>
										
										
										<div class="col-md-12">
                              <div class="row example-progress">
                                 <p>[나의 참여도]</p>
                                    <div class="col-md-12">
                                       <div class="progress">
                                          <div class="progress-bar-warning" role="progressbar" aria-valuenow="60"
                                       aria-valuemin="0" aria-valuemax="10" style="width: 60%;">60%</div>
                                       </div>
                                    </div>
                                 </div>
                              </div>
										
									<div class="col-md-16">
										<div class="btn-group">
											<button type="button" class="btn btn-primary">
												<i class="glyphicon glyphicon-user"></i>
											</button>
											<button type="button" class="btn btn-primary">
												<i class="glyphicon glyphicon-comment"></i>
											</button>
											<!-- 자기 정보 수정으로 넘어가기 -->
											<a href="modify_info.jsp">
												<button type="button" class="btn btn-primary">
													<i class="glyphicon glyphicon-cog"></i>
												</button>
											</a>
											<!-- 자기 정보 수정으로 넘어가기 -->

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<hr>
				</div>

			</div>
		</div>

		<!--/left 메뉴-->

		<!--center 메뉴-->
		<!-- 장소/사람 게시판 탭 -->
		<div class="col-sm-6">
			<div class="row">
				<div class="panel">
					<ul id="myTab1" class="nav nav-tabs nav-justified">

						<li id="loc_tab" class="active">

							<form name="loc" action="mydb" method="post">
								<input type="hidden" name="command" value="get_location">
								<input type="hidden" name="reqData" value="location">

							</form> <a href="#location" data-toggle="tab" id="tab_loc"
							onclick="myfunc('loc', 'location'); "> 장소게시판 </a>
						</li>

						<li id="peo_tab">
							<form name="pp" action="mydb" method="post">
								<input type="hidden" name="command" value="get_people">
								<input type="hidden" name="reqData" value="people">
							</form> <a href="#people" data-toggle="tab" id="tab_pp"
							onclick="myfunc('pp');  ">사람게시판</a>

						</li>

					</ul>
				</div>
				<div>

					<div id="myTabContent" class="tab-content">
						<!-- 장소게시판 시작 -->
						<div class="tab-pane fade active in" id="location">

							<div class="col-xs-12" style="font-family: 'Nanum Gothic'">

								<c:forEach items="${requestScope.regiLocationData}"
									var="regiLocationData">
									<h2>${regiLocationData.article_number }.${regiLocationData.title}</h2>
									<p>
										지역 : ${regiLocationData.region}<br> 날짜:
										${regiLocationData.regi_date}<br>
									<p class="lead">
										<button type="button" class="btn btn-default"
											data-toggle="collapse"
											data-target="#loc_readMore${regiLocationData.article_number}">더보기</button>
									</p>
									<div id="loc_readMore${regiLocationData.article_number}"
										class="panel-collapse collapse ">
										<div class="panel-body">
											<p>게시자 : ${regiLocationData.user_id} 상세 정보:
												${regiLocationData.detail}</p>
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
													<li><a href="#"><i
															class="glyphicon glyphicon-user"></i>
															${regiLocationData.user_id}</a></li>
													<li>
													<li><div class="time">
															<i class="glyphicon glyphicon-calendar"></i>
															<fmt:formatDate value="${regiLocationData.regi_date}"
																pattern="yyyy.MM.dd HH:mm" />
														</div></li>
													<li><a type="button" data-toggle="collapse"
														data-target="#loc_comment${regiLocationData.article_number}"
														onclick="findchild('${regiLocationData.article_number}')"><i
															class="glyphicon glyphicon-comment"></i> Comments</a></li>
													<a href="#"><i class="glyphicon glyphicon-heart"></i>
														찜하기</a>
													</li>
												</ul>
											</div>
											<div id="loc_comment${regiLocationData.article_number}"
												class="panel-collapse collapse ">
												<div class="panel-body">
													<iframe id="iframe${regiLocationData.article_number}"
														style="MIN-HEIGHT: 200px; MIN-WIDTH: 600px" width="600px"
														height="1000px" frameborder="0" width="relative"
														height="relative" marginwidth="0" marginheight="0"
														scrolling="no"></iframe>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
						<!-- 장소게시판 끝 -->

						<!--  사람게시판 시작 -->
						<div class="tab-pane fade active in" id="people">
							<div class="col-xs-12">
								<c:forEach items="${requestScope.regiPeopleData}"
									var="regiPeopleData">
									<h2>${regiPeopleData.article_number}.${regiPeopleData.title}</h2>
									<p>
										지역 : ${regiPeopleData.region}<br> 날짜:
										${regiPeopleData.regi_date}<br>
									<p class="lead">
										<button type="button" class="btn btn-default"
											data-toggle="collapse"
											data-target="#pp_readMore${regiPeopleData.article_number}">더보기</button>
									</p>
									<div id="pp_readMore${regiPeopleData.article_number}"
										class="panel-collapse collapse ">
										<div class="panel-body">
											<p>
												모집 인원: ${regiPeopleData.number_of_person}<br> 나이대 :
												${regiPeopleData.age}<br> 성별 : ${regiPeopleData.gender}<br>
												게시자 : ${regiPeopleData.user_id}<br> 상세 정보:
												${regiPeopleData.detail}<br> 게시자 :
												${regiPeopleData.user_id}
											<div id="map" style="width: 700px; height: 350px;">
											
											<img src="img/map.png">
											
											</div>


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
													<li><a href="#"><i
															class="glyphicon glyphicon-user"></i>
															${regiPeopleData.user_id}</a></li>
													<li>
													<li><div class="time">
															<i class="glyphicon glyphicon-calendar"></i>
															<fmt:formatDate value="${regiPeopleData.regi_date}"
																pattern="yyyy.MM.dd HH:mm" />
														</div></li>
													<li><a type="button" data-toggle="collapse"
														data-target="#pp_comment${regiPeopleData.article_number}"
														onclick="findchild('${regiPeopleData.article_number}')"><i
															class="glyphicon glyphicon-comment"></i>Comments</a></li>
													<li><a href="#"><i
															class="glyphicon glyphicon-heart"></i> 찜하기</a></li>
												</ul>
											</div>
											<div id="pp_comment${regiPeopleData.article_number}"
												class="panel-collapse collapse ">
												<div class="panel-body">
													<iframe id="iframe${regiPeopleData.article_number}"
														style="MIN-HEIGHT: 200px; MIN-WIDTH: 600px" width="600px"
														height="1000px" frameborder="0" width="relative"
														height="relative" marginwidth="0" marginheight="0"
														scrolling="no"> </iframe>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--  /사람게시판 -->
		</div>

		<!--right 메뉴-->
		<div class="col-sm-3">
			<h2>Side</h2>
			<div class="panel panel-default">
				<div class="panel-heading">나의 찜 리스트</div>
				<div class="panel-body">장소좀 구해주세요 축구 7인 있습니다</div>
				<div class="panel-body">공격수 구합니다.</div>
			</div>
			<hr>
			<div class="panel panel-default">
				<div class="panel-heading">알림</div>
				<div class="panel-body">
				 
					항공대에서 농구 센터 1명 구합니다.
					<form action="rate" name="eval" method="post">
					<input type="button" class="btn btn-primary" value="평가하기" onclick="submit();">
					<input type="hidden" name="command" value="all">
						</form>
				</div>
			</div>
			<hr>
			<!--  하단 버튼(글쓰기) -->
			<div class="col-md-3" style="float: left" id="testclick1">
				<input type="button" class="btn btn-primary btn-block" value="글쓰기"
					style="align: right">
			</div>
		</div>


		<!--/right 메뉴-->
		<hr>

	</div>


	<!--/container-fluid-->
	<!-- script references -->
	<script src="http://code.jquery.com/jquery-2.1.1.min.js"
		type="text/javascript"></script>
	<script src="<%=cp%>/js/bootstrap.min.js"></script>

	<!-- function -->
	<script type="text/javascript">
		function myfunc(loc) { //submit
			if (loc == "loc") {
				document.loc.submit();
			} else if (loc == "pp") {

				document.pp.submit();
			} else if (loc == "soccer") {
				document.soccer_code.submit();
			} else if (loc == "baseball") {
				document.baseball_code.submit();
			} else if (loc == "tennis") {
				document.tennis_code.submit();
			} else if (loc == "basketball") {
				document.basketball_code.submit();
			} else if (loc == "running") {
				document.running_code.submit();
			}

		}
	</script>

	<script type="text/javascript">
		function findchild(v) {
			document.getElementById("iframe" + v).src = "mydb?command=get_comment&arti_num="
					+ v;
		}
	</script>

	<!-- light box start-->
	<script type="text/javascript">
		T$('testclick1').onclick = function() {
			if ("${requestScope.data}" == "loc") {
				$(document).ready(function() {
					TINY.box.show('regi_location.jsp', 1, 640, 640, 0.5)

				});
			} else if ("${requestScope.data}" == "peo") {
				$(document).ready(function() {
					TINY.box.show('regi_people.jsp', 1, 642, 730, 0.5)
				});
			}
		};
		
		function showbox() {
			TINY2.box.show('show_map.jsp', 1, 900, 600, 1);
		}
		
	</script>
	
	<!-- eval start-->
	<script type="text/javascript">
	function submit() {
		document.eval.submit();
		}
	</script>
</body>
</html>