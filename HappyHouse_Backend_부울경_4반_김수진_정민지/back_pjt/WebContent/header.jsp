<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />

    <title>HappyHouse</title>


    <!-- Favicons -->
    <link href="assets/img/favicon.png" rel="icon" />
    <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon" />

    <!-- Google Fonts -->
    <link
      href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
      rel="stylesheet"
    />

    <!-- Vendor CSS Files -->
    <link href="assets/vendor/aos/aos.css" rel="stylesheet" />
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet" />
    <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet" />
    <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet" />
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- =======================================================
  * Template Name: Squadfree - v4.7.0
  * Template URL: https://bootstrapmade.com/squadfree-free-bootstrap-template-creative/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
  </head>


	<script>
		$(document).ready(function () {
		  $(".flip").click(function () {
		    $(".panel").slideToggle("slow");
		  });
		// ???????????? ??? ????????? ?????? ??????(login, password ?????? ??????)
		  $(".login-form input").on("focus", function () {
		    $(this).addClass("focus");
		    $(this).parent().addClass("focus-box");
		  });
		  $(".login-form input").on("blur", function () {
		    if ($(this).val() == "") {
		      $(this).removeClass("focus");
		      $(this).parent().removeClass("focus-box");
		    }
		  });
		  if ($("#navbar").hasClass("navbar-mobile")) {
		    console.log("?????????");
		    $(".mobile-nav-toggle").css("display", "block");
		  }

		  
		  $(".login-form").submit(function(e){
			  e.preventDefault();
		  })

		  
		  $("#login-btn").on("click", function () {
			  
			  $.ajax({
	          	url: '${root}/user',
	          	data: {'act': 'login', 'userid': $("#userid").val(), 'userpwd': $("#userpwd").val()},
	            	type: 'Post',
	            	dataType: 'text',
	            	success: function (response) {
	              		if (response==1){location.reload();}
	              		else if (response==0) {
	              			$("#error-msg").text("?????? ????????? ???????????? ????????????.");
	              		} else {
	              			location.href="user?act=error&msg="+response;
	              		}
	              	},
	          		error: function (error){
	          			console.log(error);
	          		}
	           	});
			  
			  
		  });
		  
		});
	</script>
	
	<c:if test="${empty userInfo}">
			<script>
			$(document).ready(function () {
		    $(".loginOnly").addClass("d-none");
		    $(".logoutOnly").removeClass("d-none");
			});
		    </script>
	</c:if>
	<c:if test="${!empty userInfo}">
		<script>
		$(document).ready(function () {
		    $(".loginOnly").removeClass("d-none");
		    $(".logoutOnly").addClass("d-none");
		    });
	    </script>
	
	</c:if>	    


<body>

<!-- ????????? ????????? -->
<header id="header" class="fixed-top">
      <div class="container d-flex align-items-center">
        <div class="logo me-auto">
          <h1 class="text-light">
            <a href="index.jsp"
              ><span
                >Happy<span id="logo-a " style="color: rgb(217, 219, 252); font-size: 26px"
                  >House</span
                ></span
              ></a
            >
          </h1>
          <!-- Uncomment below if you prefer to use an image logo -->
          <!-- <a href="index.jsp"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
        </div>

        <nav id="navbar" class="navbar order-last order-lg-0">
          <ul>
            <li><a class="nav-link scrollto" href="index.jsp">????????????</a></li>
            <li><a class="nav-link scrollto" href="index.jsp#services">????????? ??????</a></li>
            <li><a class="nav-link scrollto loginOnly" href="${root}/NoticeMain2?act=selectAll">????????????</a></li>
            <!-- <li><a class="nav-link scrollto loginOnly" href="findTransaction.jsp">????????????????????????</a></li> -->
            <li class="dropdown loginOnly">
              <a href="houseDeal?act=goPage">
                <span>???????????? ??????</span> <i class="bi bi-chevron-down"></i
              ></a>
              <ul>
                <li><a href="houseDeal?act=goPage">?????? ?????? ???????????? ??????</a></li>
                <li><a href="houseDeal?act=goPageApt">???????????? ?????? ???????????? ??????</a></li>
                            </ul>
            </li>
            <!-- ????????? ??? ??? ?????? inactive -->
            <li class="dropdown loginOnly">
              <a href="main?act=store&cmd=mvInterest"
                ><span>??????????????????</span> <i class="bi bi-chevron-down"></i
              ></a>
              <ul>
                <li><a href="main?act=store&cmd=mvInterest">?????? ?????? ??????</a></li>
                <li><a href="interest?act=mvAddInterest">?????? ?????? ??????</a></li>
                <li><a href="main?act=store&cmd=mvStore">???????????? ?????? ?????? ??????</a></li>
                <li><a href="main?act=env&cmd=mvEnv">???????????? ?????? ??????</a></li>
              </ul>
            </li>
          </ul>
          <i class="bi bi-list mobile-nav-toggle"></i>
        </nav>

        <div class="dropdown dropdown-menu-right info-btn-container loginOnly">
          <a class="log-btn dropdown-toggle btn-default btn-sm flip" data-bs-toggle="dropdown">
            ?????? ??????
          </a>
          <div
            class="dropdown-menu dropdown-menu-end dropdown-animation panel menu-form info-container show"
            style="display: none"
          >
            <a class="mypage-btn" href="user?act=mvmypage">MyPage</a>
            <button class="btn mypage-btn" onclick="location.href='user?act=logout'" type="button">Logout</button>
          </div>
        </div>

        <div class="dropdown dropdown-menu-right log-btn-container logoutOnly">
        
          <a class="log-btn dropdown-toggle btn-default btn-sm flip" data-bs-toggle="dropdown">
            Login
          </a>
          
          
          
          
          <!-- ??? -->
          <div
            class="dropdown-menu dropdown-menu-end dropdown-animation panel menu-form show"
            style="display: none"
          >
            <form class="login-form">
              <h2>Login</h2>
              <div class="txtb">
                <input id="userid" name="userid" type="text" autocomplete="off"/>
                <span data-placeholder="ID" ></span>
              </div>
              <div class="txtb">
                <input id="userpwd" name="userpwd" type="password" />
                <span data-placeholder="Password"></span>
              </div>
              <button type="submit" class="login-btn" id="login-btn"  >Login</button>
              <div id="error-msg"> </div>
              <div class="bottom-text">
                <p class="mt-2 mb-2">
                  Don???t have account ? <a href="user?act=mvregister">Sign up</a> <br />
                </p>
                <p class="mt-2 mb-2">
                  Forget your password ?
                  <a href="user?act=mvfindpwd">Find Password</a>
                </p>
              </div>
            </form>
          </div>
        </div>

        <!-- .navbar -->
      </div>
    </header>
    
    
    
    
    
    
    
    
        <!-- ======= Footer ======= -->
 