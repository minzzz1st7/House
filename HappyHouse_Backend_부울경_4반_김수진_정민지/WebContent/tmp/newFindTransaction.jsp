<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>

<html>
<head>
<meta charset="UTF-8">
<title>SSAFY</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#searchBtn").click(function() {
			console.log("hi");
			$("#transactionForm").attr("action", "${root}/houseDeal").submit();
		})
		
		
		//sido option 추가
		  $.each(hangjungdong.sido, function (idx, code) {
		    //append를 이용하여 option 하위에 붙여넣음
		    $("#sido").append(fn_option(code.sido, code.codeNm));
		  });

		  //sido 변경시 시군구 option 추가
		  $("#sido").change(function () {
		    $("#sigugun").show();
		    $("#sigugun").empty();
		    $("#sigugun").append(fn_option("", "구군선택")); //
		    $.each(hangjungdong.sigugun, function (idx, code) {
		      if ($("#sido > option:selected").val() == code.sido)
		        $("#sigugun").append(fn_option(code.sigugun, code.codeNm));
		    });

		    //세종특별자치시 예외처리
		    //옵션값을 읽어 비교
		    if ($("#sido option:selected").val() == "36") {
		      $("#sigugun").hide();
		      //index를 이용해서 selected 속성(attr)추가
		      //기본 선택 옵션이 최상위로 index 0을 가짐
		      $("#sigugun option:eq(1)").attr("selected", "selected");
		      //trigger를 이용해 change 실행
		      $("#sigugun").trigger("change");
		    }
		  });

		  //시군구 변경시 행정동 옵션추가
		  $("#sigugun").change(function () {
		    //option 제거
		    $("#dong").empty();
		    $.each(hangjungdong.dong, function (idx, code) {
		      if (
		        $("#sido > option:selected").val() == code.sido &&
		        $("#sigugun > option:selected").val() == code.sigugun
		      )
		        $("#dong").append(fn_option(code.dong, code.codeNm));
		    });
		    //option의 맨앞에 추가
		    $("#dong").prepend(fn_option("", "동선택"));
		    //option중 선택을 기본으로 선택
		    $('#dong option:eq("")').attr("selected", "selected");
		  });
			
		  $("#dong").change(function () {
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
<body>

	<div class="container">
		<div class="login-page">
			<div class="form">
				<form id="transactionForm" name ="transactionForm" class="search-form">
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

					<h3>출력부</h3>
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
				</form>
			</div>
		</div>
		<!-- 카카오 지도 넣을 자리  -->
		<div id="map" class="col-sm-8 my-5"></div>
</body>
</html>