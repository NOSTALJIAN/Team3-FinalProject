<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
.frame {
  width: 90%;
  margin: 40px auto;
  text-align: center;
}
 table {
    width: 1150px;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
    padding-right: 5px;
  }
</style>
</head>
<body style="margin-bottom: 100px; background-color: black; color: white;">
	<%@ include file="../common/top.jsp" %>
	<div style="display: flex;">
		<%@ include file="../common/sidebar.jsp" %>
		<div class="myPage-size" style="margin-top: 60px; margin-left: 180px;">
			<h5>그룹운동 참여현황</h5>
			<div style="margin-top: 20px;">
			<table>
				<thead>
					<tr>
						<th>제목</th>
						<th>종목</th>
						<th>운동장소</th>
						<th>운동시간</th>
						<th>참가인원</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="done" items="${applyDoneList}">
					<tr>
						<td onclick="location.href='/board/detail?bid=${done.bid}&uid=${done.uid}'">${done.bTitle}</td>
						<td onclick="location.href='/board/detail?bid=${done.bid}&uid=${done.uid}'">${done.bCategory}</td>
						<td onclick="location.href='/board/detail?bid=${done.bid}&uid=${done.uid}'">${done.bLocation}</td>
						<td onclick="location.href='/board/detail?bid=${done.bid}&uid=${done.uid}'">${fn:replace(done.bAppointment, 'T', ' ')}</td>
						<td onclick="location.href='/board/detail?bid=${done.bid}&uid=${done.uid}'">${done.bUserCount}명</td>
						<td><button class="btn-hover color-9 write-btn" style="width: 115px;">그룹채팅</button></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<ul class="pagination justify-content-center mt-4">
			<c:if test="${currentBoardPage gt 10}">
				<li class="page-item"><a class="page-link" href="/group/applyDone?p=${startPage - 1}&f=${field}&q=${query}">&laquo;</a></li>
			</c:if>
			<c:if test="${currentBoardPage le 10}">
				<li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
			</c:if>
			<c:forEach var="page" items="${pageList}" varStatus="loop">    
				<li class="page-item ${(currentBoardPage eq page) ? 'active' : ''}">
					<a class="page-link" href="/group/applyDone?p=${page}&f=${field}&q=${query}">${page}</a>
				</li>
			</c:forEach>  
			<c:if test="${totalPages gt endPage}">                    
				<li class="page-item"><a class="page-link" href="/group/applyDone?p=${endPage + 1}&f=${field}&q=${query}">&raquo;</a></li>
			</c:if>
			<c:if test="${totalPages le endPage}">                    
				<li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
			</c:if>
		</ul>
	</div>
</div>
<%@ include file="../common/bottom1.jsp" %>
</body>
</html>