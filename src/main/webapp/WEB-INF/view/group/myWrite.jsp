<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<meta charset="UTF-8">
	<title>그룹운동 마이페이지</title>
	<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Cormorant+Garamond:wght@500&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="/css/sidebars.css">
	<style>
	  table {
	    width: 1100px;
	    border-top: 1px solid #444444;
	    border-collapse: collapse;
	  }
	  th, td {
	    border-bottom: 1px solid #444444;
	    padding: 2px;
	  }
	  .btn-hover.color-3 {
	    background-image: linear-gradient(to right, #667eea, #764ba2, #6B8DD6, #8E37D7);
	    box-shadow: 0 4px 15px 0 rgba(116, 79, 168, 0.75);
	}
	.pagination{--bs-pagination-color: #363a3e;}
  	</style>
</head>
<body style="margin-bottom: 500px; background-color: black; color: white;">
	<%@ include file="../common/top.jsp" %>
	<div style="display: flex;">
		<%@ include file="../common/sidebar.jsp" %>
		<div class="myPage-size" style="margin-top: 60px; margin-left: 180px;">
			<h5>작성글 목록</h5>
			<table>
				<thead>
					<tr>
						<th>제목</th>
						<th>운동종목</th>
						<th>모집인원</th>
						<th>작성일</th>
						<th>조회</th>
						<th>댓글</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="my" items="${myList}">
						<tr>
							<td onclick="location.href='/board/detail?bid=${my.bid}&uid=${my.uid}'">${my.bTitle}</td>
							<td onclick="location.href='/board/detail?bid=${my.bid}&uid=${my.uid}'">${my.bCategory}</td>
							<td onclick="location.href='/board/detail?bid=${my.bid}&uid=${my.uid}'">${my.bUserCount}</td>
							<td onclick="location.href='/board/detail?bid=${my.bid}&uid=${my.uid}'">${fn:replace(my.bRegTime, 'T', ' ')}</td>
							<td onclick="location.href='/board/detail?bid=${my.bid}&uid=${my.uid}'">${my.bViewCount}</td>
							<td onclick="location.href='/board/detail?bid=${my.bid}&uid=${my.uid}'">${my.bReplyCount}</td>
							<td><button onclick="location.href='/group/applyPerson?bid=${my.bid}&uid=${my.uid}'" class="btn-hover color-8 write-btn">신청자 목록</button>
							<button class="btn-hover color-3 write-btn" style="width: 120px;">모집중</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<ul class="pagination justify-content-center mt-4">
					<c:if test="${currentBoardPage gt 10}">
						<li class="page-item"><a class="page-link" href="/group/myWrite?p=${startPage - 1}&f=${field}&q=${query}">&laquo;</a></li>
					</c:if>
					<c:if test="${currentBoardPage le 10}">
						<li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
					</c:if>
					<c:forEach var="page" items="${pageList}" varStatus="loop">    
						<li class="page-item ${(currentBoardPage eq page) ? 'active' : ''}">
							<a class="page-link" href="/group/myWrite?p=${page}&f=${field}&q=${query}">${page}</a>
						</li>
					</c:forEach>  
					<c:if test="${totalPages gt endPage}">                    
						<li class="page-item"><a class="page-link" href="/group/myWrite?p=${endPage + 1}&f=${field}&q=${query}">&raquo;</a></li>
					</c:if>
					<c:if test="${totalPages le endPage}">                    
						<li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
					</c:if>
				</ul>
		</div>
	</div>
</body>
</html>