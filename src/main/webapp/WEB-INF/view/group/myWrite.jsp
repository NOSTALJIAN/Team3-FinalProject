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
  	</style>
</head>
<body style="margin-bottom: 100px; background-color: black; color: white;">
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
						<th>조회수</th>
						<th>댓글</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="my" items="${myList}">
						<tr>
							<td onclick="location.href='/board/detail?bid=${my.bid}&uid=${my.uid}'">${my.bTitle}</td>
							<td onclick="location.href='/board/detail?bid=${my.bid}&uid=${my.uid}'">${my.bCategory}</td>
							<td onclick="location.href='/board/detail?bid=${my.bid}&uid=${my.uid}'">${my.bUserCount}명</td>
							<td onclick="location.href='/board/detail?bid=${my.bid}&uid=${my.uid}'">${fn:replace(my.bRegTime, 'T', ' ')}</td>
							<td onclick="location.href='/board/detail?bid=${my.bid}&uid=${my.uid}'">${my.bViewCount}</td>
							<td onclick="location.href='/board/detail?bid=${my.bid}&uid=${my.uid}'">${my.bReplyCount}</td>
							<td><button onclick="location.href='/group/applyPerson?bid=${my.bid}&uid=${my.uid}'" class="btn-hover color-8 write-btn">신청자 목록</button></td>
							<td><span>${my.bUserCount eq my.applyCount ? '모집 마감': '모집중' ? '모집 마감': '모집중'}</span></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- 모집 마감 -->
	<script>
		function updateIsFull(bid){
			  $.ajax({
				type:'GET',
				url: '/group/updateIsFull',
				data: {'bid': bid},
				success: function(result){
					if(result == '0') {
						$('#msg').html('모집중');
					} else
						$('#msg').html('모집 마감');
				}
			  });
		  }
	</script>
</body>
</html>