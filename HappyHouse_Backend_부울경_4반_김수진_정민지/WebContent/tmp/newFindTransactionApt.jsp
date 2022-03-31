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
	
	<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>

<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#searchAptBtn").click(function() {
			console.log("hi");
			$("#transactionFormApt").attr("action", "${root}/houseDeal").submit();
		})

	});
</script>

</head>
<body>
	<form id="transactionFormApt" class="text-left mb-3" method="post"
		action="">
		<input type="hidden" name="act" id="act" value="searchByApt">
		<div class="form-group">
			<label for="userpwd">동</label> <input type="text"
				class="form-control" id="aptName" value="아남1" name="aptName"
				placeholder="아파트명">
		</div>

		<div class="form-group text-center">
			<button type="button" id="searchAptBtn"
				class="btn btn-outline-primary">조회</button>
		</div>

		<h3>아파트로 검색</h3>
		<div class=".table-bordered">
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

		<map></map>	
</body>

</html>