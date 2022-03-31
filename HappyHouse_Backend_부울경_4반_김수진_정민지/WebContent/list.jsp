<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="header.jsp" %>  
<body>

	<h3>공지사항</h3>
	<c:if test="${!empty nlist}">
		<table border="1" style="border-collapse: collapse">
			<tr><th>글번호</th><th>제목</th><th>내용</th><th>작성자</th><th>작성일</th></tr>
			<c:forEach var="nlist" items="${nlist}">
				<tr>
					<td>${nlist.noticeID}</td>
					<td><a href="${root}/NoticeMain?act=view&noticeID=${nlist.noticeID}">${nlist.noticeTitle}</a></td>
					<td>${nlist.noticeContent}</td>
					<td>${nlist.userID}</td>
					<td>${nlist.noticeDate}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${empty nlist}">
		<p>검색된 상품이 없습니다.</p>
	</c:if>
	<p>
	<a href="${root}/NoticeMain?act=NoticeinsertForm">공지등록</a>
	<a href="${root}">메인으로</a>
	
</body>

<%@ include file="footer.jsp" %>
