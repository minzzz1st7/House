<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta content="width=device-width, initial-scale=1.0" name="viewport" />

<title>Squadfree Bootstrap Template - Index</title>
<meta content="" name="description" />
<meta content="" name="keywords" />

<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon" />
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon" />

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet" />

<!-- Vendor CSS Files -->
<link href="assets/vendor/aos/aos.css" rel="stylesheet" />
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet" />
<link href="assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet" />
<link href="assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet" />
<link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet" />

<!-- Template Main CSS File -->
<link href="assets/css/custom.css" rel="stylesheet" />
<link href="assets/css/interest.css" rel="stylesheet" />
<link href="assets/css/listMap.css" rel="stylesheet" />
<link href="assets/css/myPage.css" rel="stylesheet" />
<link href="assets/css/notice.css" rel="stylesheet" />
<link href="assets/css/register.css" rel="stylesheet" />
<link href="assets/css/registerInterest.css" rel="stylesheet" />
<link href="assets/css/style.css" rel="stylesheet" />
<link href="assets/css/transaction.css" rel="stylesheet" />

<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- =======================================================
  * Template Name: Squadfree - v4.7.0
  * Template URL: https://bootstrapmade.com/squadfree-free-bootstrap-template-creative/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#searchBtn").click(
								function() {
									console.log("hi");
									$("#transactionForm").attr("action",
											"${root}/houseDeal").submit();
								})

						//sido option 추가
						$.each(hangjungdong.sido, function(idx, code) {
							//append를 이용하여 option 하위에 붙여넣음
							$("#sido")
									.append(fn_option(code.sido, code.codeNm));
						});

						//sido 변경시 시군구 option 추가
						$("#sido")
								.change(
										function() {
											$("#sigugun").show();
											$("#sigugun").empty();
											$("#sigugun").append(
													fn_option("", "구군선택")); //
											$
													.each(
															hangjungdong.sigugun,
															function(idx, code) {
																if ($(
																		"#sido > option:selected")
																		.val() == code.sido)
																	$(
																			"#sigugun")
																			.append(
																					fn_option(
																							code.sigugun,
																							code.codeNm));
															});

											//세종특별자치시 예외처리
											//옵션값을 읽어 비교
											if ($("#sido option:selected")
													.val() == "36") {
												$("#sigugun").hide();
												//index를 이용해서 selected 속성(attr)추가
												//기본 선택 옵션이 최상위로 index 0을 가짐
												$("#sigugun option:eq(1)")
														.attr("selected",
																"selected");
												//trigger를 이용해 change 실행
												$("#sigugun").trigger("change");
											}
										});

						//시군구 변경시 행정동 옵션추가
						$("#sigugun")
								.change(
										function() {
											//option 제거
											$("#dong").empty();
											$
													.each(
															hangjungdong.dong,
															function(idx, code) {
																if ($(
																		"#sido > option:selected")
																		.val() == code.sido
																		&& $(
																				"#sigugun > option:selected")
																				.val() == code.sigugun)
																	$("#dong")
																			.append(
																					fn_option(
																							code.dong,
																							code.codeNm));
															});
											//option의 맨앞에 추가
											$("#dong").prepend(
													fn_option("", "동선택"));
											//option중 선택을 기본으로 선택
											$('#dong option:eq("")').attr(
													"selected", "selected");
										});

						$("#dong").change(function() {
							var sido = $("#sido option:selected").val();
							var sigugun = $("#sigugun option:selected").val();
							var dong = $("#dong option:selected").val();
							var dongCode = sido + sigugun + dong + "00";
							console.log(sido);
							console.log(sigugun);
							console.log(dong);
						});

					});
</script>
<script src="assets/js/hangjungdong.js"></script>
</head>
<script>
	function fn_option(code, name) {
		return '<option value="' + code + '">' + name + "</option>";
	}
</script>
<script>
	function checkCity(cityCode) {
		let cityName = "";
		switch (cityCode) {
		case "27110":
			cityName = "대구광역시";
			break;
		case "30110":
			cityName = "대전광역시";
			break;
		case "26110":
			cityName = "부산광역시";
			break;
		case "11110":
			cityName = "서울특별시";
			break;
		case "36110":
			cityName = "세종특별자치시";
			break;
		case "31110":
			cityName = "울산광역시";
			break;
		case "28110":
			cityName = "인천광역시";
			break;
		case "46110":
			cityName = "전라남도";
			break;
		case "45111":
			cityName = "전라북도";
			break;
		case "50110":
			cityName = "제주특별자치도";
			break;
		case "44131":
			cityName = "충청남도";
			break;
		case "43111":
			cityName = "충청북도";
			break;
		}
		return cityName;
	}
</script>


</head>

<body>
	<!-- ======= Header ======= -->
	<header id="header" class="fixed-top">
		<div class="container d-flex align-items-center">
			<div class="logo me-auto">
				<h1 class="text-light">
					<a href="index.html"><span>Happy<span id="logo-a "
							style="color: rgb(217, 219, 252); font-size: 26px">House</span></span></a>
				</h1>
				<!-- Uncomment below if you prefer to use an image logo -->
				<!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
			</div>

			<nav id="navbar" class="navbar order-last order-lg-0">
				<ul>
					<li><a class="nav-link scrollto" href="index.html#hero">Home</a></li>
					<li><a class="nav-link scrollto" href="index.html#services">회사
							소개</a></li>
					<li><a class="nav-link scrollto" href="notice.html">공지사항</a></li>
					<li><a class="nav-link scrollto findTrans"
						href="findTransaction.html">주택실거래가조회</a></li>
					<!-- 로그인 안 한 상태 inactive -->
					<li class="dropdown findTrans"><a href="findTransaction.html"><span>관심지역조회</span>
							<i class="bi bi-chevron-down"></i></a>
						<ul>
							<li><a href="registerInterest.html">관심 지역 등록</a></li>
							<li><a href="interest.html">주변탐방 업종 정보 조회</a></li>
						</ul></li>
					<li><a class="nav-link scrollto findTrans"
						href="findHospital.html".html">안심병원 조회</a></li>
				</ul>
				<i class="bi bi-list mobile-nav-toggle"></i>
			</nav>

			<div class="dropdown dropdown-menu-right info-btn-container">
				<a class="log-btn dropdown-toggle btn-default btn-sm flip"
					data-bs-toggle="dropdown"> 회원 정보 </a>
				<div
					class="dropdown-menu dropdown-menu-end dropdown-animation panel form info-container show"
					style="display: none">
					<a class="mypage-btn" href="myPage.html">MyPage</a>
					<button class="btn mypage-btn" onclick="logout()" type="button">Logout</button>
				</div>
			</div>

			<div class="dropdown dropdown-menu-right log-btn-container">
				<a class="log-btn dropdown-toggle btn-default btn-sm flip"
					data-bs-toggle="dropdown"> Login </a>
				<div
					class="dropdown-menu dropdown-menu-end dropdown-animation panel form show"
					style="display: none">
					<form name="login-form" class="login-form">
						<h2>Login</h2>
						<div class="txtb">
							<input id="id" name="id" type="text" /> <span
								data-placeholder="ID"></span>
						</div>
						<div class="txtb">
							<input id="password" name="password" type="password" /> <span
								data-placeholder="Password"></span>
						</div>
						<button class="login-btn" onclick="login()" type="button">Login</button>
						<div class="bottom-text">
							<p class="mt-2 mb-2">
								Don’t have account ? <a href="register.html">Sign up</a> <br />
							</p>
							<p class="mt-2 mb-2">
								Forget your password ? <a href="findPwd.html">Find Password</a>
							</p>
						</div>
					</form>
				</div>
			</div>

			<!-- .navbar -->
		</div>
	</header>
	<!-- End Header -->
	<main id="main">
		<!-- ======= Breadcrumbs Section ======= -->
		<section class="breadcrumbs">
			<div class="container">
				<div class="d-flex justify-content-between align-items-center">
					<h2>실거래가 조회</h2>
					<ol>
						<li><a href="index.html">Home</a></li>
						<li>실거래가 조회</li>
					</ol>
				</div>
			</div>
		</section>
		<!-- Breadcrumbs Section -->

		<!-- ======= Portfolio Details Section ======= -->


		<div class="container">
			<div class="login-page">
				<div class="form">
					<form id="transactionForm" name="transactionForm"
						class="search-form">
						<input type="hidden" name="act" id="act" value="searchByRegion">

						<div>
							<p class="search-element">도시</p>
							<select class="selectpicker" id="sido" value="부산광역시" name="sido"
								placeholder="시">
								<option value="">시도선택</option>
							</select> <select class="selectpicker" id="sigugun" value="연제구"
								name="sigugun" placeholder="구군">
								<option value="">구군선택</option>
							</select> <select class="selectpicker" id="dong" value="사직동" name="dong"
								placeholder="동">
								<option value="">동선택</option>
							</select>
						</div>

						<button id="searchBtn" type="button">검색</button>
						<!-- <a id="listBtn2" class="search-element" type="button">검색</button> -->

					</form>
				</div>
			</div>
		</div>
		<!-- 카카오 지도 넣을 자리  -->
		<div class="row">
			<div clsass=".col-sm-8">
				<h3>지역 검색</h3>
				<div class="table table-striped">
					<table>
						<tr>
							<td>dealID</td>
							<td>LAWD_CD</td>
							<td>DEAL_YMD</td>
							<td>dealAmount</td>
							<td>buildYear</td>
							<td>dealYear</td>
							<td>dong</td>
							<td>aptName</td>
							<td>dealMonth</td>
							<td>dealDay</td>
							<td>area</td>
							<td>relativeNumber</td>
							<td>floor</td>
						</tr>

						<ul>
							<c:forEach var="housedeal" items="${housedealInfo}">
								<tr>
									<td>${housedeal.dealID}</td>
									<td>${housedeal.LAWD_CD}</td>
									<td>${housedeal.DEAL_YMD}</td>
									<td>${housedeal.dealAmount}</td>
									<td>${housedeal.buildYear}</td>
									<td>${housedeal.dealYear}</td>
									<td>${housedeal.dong}</td>
									<td>${housedeal.aptName}</td>
									<td>${housedeal.dealMonth}</td>
									<td>${housedeal.dealDay}</td>
									<td>${housedeal.area}</td>
									<td>${housedeal.relativeNumber}</td>
									<td>${housedeal.floor}</td>
								</tr>
							</c:forEach>
						</ul>
					</table>
				</div>
			</div>

			<div clsass=".col-sm-4">
				<div id="map"></div>
				<h3>지역 검색</h3>
				<div class="table table-striped">
					<table>
						<tr>
							<td>dealID</td>
							<td>LAWD_CD</td>
							<td>DEAL_YMD</td>
							<td>dealAmount</td>
							<td>buildYear</td>
							<td>dealYear</td>
							<td>dong</td>
							<td>aptName</td>
							<td>dealMonth</td>
							<td>dealDay</td>
							<td>area</td>
							<td>relativeNumber</td>
							<td>floor</td>
						</tr>

						<ul>
							<c:forEach var="housedeal" items="${housedealInfo}">
								<tr>
									<td>${housedeal.dealID}</td>
									<td>${housedeal.LAWD_CD}</td>
									<td>${housedeal.DEAL_YMD}</td>
									<td>${housedeal.dealAmount}</td>
									<td>${housedeal.buildYear}</td>
									<td>${housedeal.dealYear}</td>
									<td>${housedeal.dong}</td>
									<td>${housedeal.aptName}</td>
									<td>${housedeal.dealMonth}</td>
									<td>${housedeal.dealDay}</td>
									<td>${housedeal.area}</td>
									<td>${housedeal.relativeNumber}</td>
									<td>${housedeal.floor}</td>
								</tr>
							</c:forEach>
						</ul>
					</table>
				</div>
			</div>
		</div>
		
		<!-- End Portfolio Details Section -->
	</main>

	<!-- End #main -->

	<!-- ======= Footer ======= -->
	<footer id="footer">
		<div class="footer-top">
			<div class="container">
				<div class="row">
					<div class="col-lg-4 col-md-6">
						<div class="footer-info">
							<h3>HappyHouse</h3>
							<p class="pb-3">
								<em>후회없는 삶을 살자</em>
							</p>
							<p>
								싸피광역시 싸피동 11-11, 대한민국<br /> <br /> <strong>Phone:</strong>
								5959-5959<br /> <strong>Email:</strong>
								contact@happyhouse.co.kr<br />
							</p>
							<div class="social-links mt-3">
								<a href="#" class="twitter"><i class="bx bxl-twitter"></i></a> <a
									href="#" class="facebook"><i class="bx bxl-facebook"></i></a> <a
									href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
								<a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
								<a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
							</div>
						</div>
					</div>

					<div class="col-lg-3 mx-4 col-md-6 footer-links">
						<h4>Useful Links</h4>
						<ul class="divided-list list-unstyled text-center">
							<li><i class="bx bx-chevron-right"></i> <a
								href="index.html#hero">Home</a></li>
							<li><i class="bx bx-chevron-right"></i> <a
								href="index.html#services">회사 소개</a></li>
							<li><i class="bx bx-chevron-right"></i> <a
								href="index.html#contact">고객센터</a></li>
							<li><i class="bx bx-chevron-right"></i> <a
								href="notice.html">공지사항</a></li>
							<li><i class="bx bx-chevron-right"></i> <a
								href="sitemap.html">사이트맵</a></li>
						</ul>
					</div>

					<div class="col-lg-3 col-md-6 footer-links">
						<h4>서비스들</h4>
						<ul class="divided-list list-unstyled text-center">
							<li><i class="bx bx-chevron-right"></i> <a
								href="findTransaction.html">주택 실거래가 조회</a></li>
							<li><i class="bx bx-chevron-right"></i> <a
								href="registerInterest.html">관심 지역 등록</a></li>
							<li><i class="bx bx-chevron-right"></i> <a
								href="interest.html">주변탐방 업종 정보 조회</a></li>
							<li><i class="bx bx-chevron-right"></i> <a
								href="findHospital.html">안심병원 조회</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="container">
			<div class="copyright">
				&copy; Copyright <strong><span>Squadfree</span></strong>. All Rights
				Reserved
			</div>
			<div class="credits">
				<!-- All the links in the footer should remain intact. -->
				<!-- You can delete the links only if you purchased the pro version. -->
				<!-- Licensing information: https://bootstrapmade.com/license/ -->
				<!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/squadfree-free-bootstrap-template-creative/ -->
				Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
			</div>
		</div>
	</footer>
	<!-- End Footer -->

	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Vendor JS Files -->
	<script src="assets/vendor/purecounter/purecounter.js"></script>
	<script src="assets/vendor/aos/aos.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
	<script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
	<script src="assets/vendor/php-email-form/validate.js"></script>

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5604814141adf4eb08f174929c528f6e&libraries=services"></script>
	<!-- Template Main JS File -->
	<script src="assets/js/custom.js"></script>
	<script src="assets/js/hangjungdong.js"></script>
	<script src="assets/js/login.js"></script>
	<script src="assets/js/main.js"></script>
	<script src="assets/js/myPage.js"></script>
	<script src="assets/js/notice.js"></script>
	<script src="assets/js/register.js"></script>
	<script src="assets/js/registerInterest.js"></script>
	<script src="assets/js/test2.js"></script>
	<script src="assets/js/interest.js"></script>
</body>
</html>
