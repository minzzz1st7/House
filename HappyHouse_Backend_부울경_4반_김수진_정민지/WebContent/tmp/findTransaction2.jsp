<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
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

  <body>
    <!-- ======= Header ======= -->
    <header id="header" class="fixed-top">
      <div class="container d-flex align-items-center">
        <div class="logo me-auto">
          <h1 class="text-light">
            <a href="index.html"
              ><span
                >Happy<span id="logo-a " style="color: rgb(217, 219, 252); font-size: 26px"
                  >House</span
                ></span
              ></a
            >
          </h1>
          <!-- Uncomment below if you prefer to use an image logo -->
          <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
        </div>

        <nav id="navbar" class="navbar order-last order-lg-0">
          <ul>
            <li><a class="nav-link scrollto" href="index.html#hero">Home</a></li>
            <li><a class="nav-link scrollto" href="index.html#services">회사 소개</a></li>
            <li><a class="nav-link scrollto" href="notice.html">공지사항</a></li>
            <li><a class="nav-link scrollto findTrans" href="findTransaction.html">주택실거래가조회</a></li>
            <!-- 로그인 안 한 상태 inactive -->
            <li class="dropdown findTrans">
              <a href="findTransaction.html"
                ><span>관심지역조회</span> <i class="bi bi-chevron-down"></i
              ></a>
              <ul>
                <li><a href="registerInterest.html">관심 지역 등록</a></li>
                <li><a href="interest.html">주변탐방 업종 정보 조회</a></li>
              </ul>
            </li>
            <li><a class="nav-link scrollto findTrans" href="findHospital.html".html">안심병원 조회</a></li>
          </ul>
          <i class="bi bi-list mobile-nav-toggle"></i>
        </nav>

        <div class="dropdown dropdown-menu-right info-btn-container">
          <a class="log-btn dropdown-toggle btn-default btn-sm flip" data-bs-toggle="dropdown">
            회원 정보
          </a>
          <div
            class="dropdown-menu dropdown-menu-end dropdown-animation panel form info-container show"
            style="display: none"
          >
            <a class="mypage-btn" href="myPage.html">MyPage</a>
            <button class="btn mypage-btn" onclick="logout()" type="button">Logout</button>
          </div>
        </div>

        <div class="dropdown dropdown-menu-right log-btn-container">
          <a class="log-btn dropdown-toggle btn-default btn-sm flip" data-bs-toggle="dropdown">
            Login
          </a>
          <div
            class="dropdown-menu dropdown-menu-end dropdown-animation panel form show"
            style="display: none"
          >
            <form name="login-form" class="login-form">
              <h2>Login</h2>
              <div class="txtb">
                <input id="id" name="id" type="text" />
                <span data-placeholder="ID"></span>
              </div>
              <div class="txtb">
                <input id="password" name="password" type="password" />
                <span data-placeholder="Password"></span>
              </div>
              <button class="login-btn" onclick="login()" type="button">Login</button>
              <div class="bottom-text">
                <p class="mt-2 mb-2">
                  Don’t have account ? <a href="register.html">Sign up</a> <br />
                </p>
                <p class="mt-2 mb-2">
                  Forget your password ?
                  <a href="findPwd.html">Find Password</a>
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
            <form name="register-form" class="search-form">
              <!-- <input id="pageNo" name="pageNo" type="text" placeholder="pageNo" />
              <input id="numOfRows" name="numOfRows" type="text" placeholder="numOfRows" />
              <input id="LAWD_CD" name="LAWD_CD" type="text" placeholder="LAWD_CD" />
              <input id="DEAL_YMD" name="DEAL_YMD" type="DEAL_YMD" placeholder="DEAL_YMD" />
               -->

              <div>
                <p class="search-element">도시</p>
                <select class="selectpicker" id="sido">
                  <option value="">시도선택</option>
                </select>

                <select class="selectpicker" id="sigugun">
                  <option value="">구군선택</option>
                </select>
                <select class="selectpicker" id="dong">
                  <option value="">동선택</option>
                </select>
              </div>

              <p class="search-element">계약월</p>
              <input
                id="contractDay"
                class="search-element text-input"
                name="contractDay"
                type="text"
                value="201902"
              />

              <button id="listBtn2" type="button">검색</button>
              <!-- <a id="listBtn2" class="search-element" type="button">검색</button> -->
            </form>
          </div>
        </div>
        <div class="row">
          <div class="col-sm-4">
            <p class="apart_list_title my-5">아파트 정보 목록</p>
            <div id="aptinfo"></div>
          </div>
          <div id="map" class="col-sm-8 my-5"></div>
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
                  싸피광역시 싸피동 11-11, 대한민국<br /><br />
                  <strong>Phone:</strong> 5959-5959<br />
                  <strong>Email:</strong> contact@happyhouse.co.kr<br />
                </p>
                <div class="social-links mt-3">
                  <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
                  <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
                  <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
                  <a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
                  <a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
                </div>
              </div>
            </div>

            <div class="col-lg-3 mx-4 col-md-6 footer-links">
              <h4>Useful Links</h4>
              <ul class="divided-list list-unstyled text-center">
                <li><i class="bx bx-chevron-right"></i> <a href="index.html#hero">Home</a></li>
                <li><i class="bx bx-chevron-right"></i> <a href="index.html#services">회사 소개</a></li>
                <li><i class="bx bx-chevron-right"></i> <a href="index.html#contact">고객센터</a></li>
                <li><i class="bx bx-chevron-right"></i> <a href="notice.html">공지사항</a></li>
                <li><i class="bx bx-chevron-right"></i> <a href="sitemap.html">사이트맵</a></li>
              </ul>
            </div>

            <div class="col-lg-3 col-md-6 footer-links">
              <h4>서비스들</h4>
              <ul class="divided-list list-unstyled text-center">
                <li><i class="bx bx-chevron-right"></i> <a href="findTransaction.html">주택 실거래가 조회</a></li>
                <li><i class="bx bx-chevron-right"></i> <a href="registerInterest.html">관심 지역 등록</a></li>
                <li><i class="bx bx-chevron-right"></i> <a href="interest.html">주변탐방 업종 정보 조회</a></li>
                <li><i class="bx bx-chevron-right"></i> <a href="findHospital.html">안심병원 조회</a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>

      <div class="container">
        <div class="copyright">
          &copy; Copyright <strong><span>Squadfree</span></strong
          >. All Rights Reserved
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

    <a href="#" class="back-to-top d-flex align-items-center justify-content-center"
      ><i class="bi bi-arrow-up-short"></i
    ></a>

    <!-- Vendor JS Files -->
    <script src="assets/vendor/purecounter/purecounter.js"></script>
    <script src="assets/vendor/aos/aos.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
    <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
    <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
    <script src="assets/vendor/php-email-form/validate.js"></script>

    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5604814141adf4eb08f174929c528f6e&libraries=services"
    ></script>
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
    <script src="assets/js/transaction.js"></script>
    <script src="assets/js/interest.js"></script>
  </body>
</html>
