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
    width: 1200px;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;
  }
</style>
</head>
<body style="margin-bottom: 400px; background-color: black; color: white;">
	<%@ include file="../common/top.jsp" %>
	<div style="display: flex;">
		<%@ include file="../common/sidebar.jsp" %>
		<div class="myPage-size" style="margin-top: 60px; margin-left: 180px;">
			<h5>그룹운동 수락완료 목록</h5>
			<div style="margin-top: 30px;">
			<table>
				<thead>
					<tr>
						<th>제목</th>
						<th>운동종목</th>
						<th>운동장소</th>
						<th>운동시간</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="done" items="${myDoneList}">
					<tr>
						<td onclick="location.href='/board/detail?bid=${done.bid}&uid=${done.uid}'">${done.bTitle}</td>
						<td onclick="location.href='/board/detail?bid=${done.bid}&uid=${done.uid}'">${done.bCategory}</td>
						<td onclick="location.href='/board/detail?bid=${done.bid}&uid=${done.uid}'">${done.bLocation}</td>
						<td onclick="location.href='/board/detail?bid=${done.bid}&uid=${done.uid}'">${fn:replace(done.bAppointment, 'T', ' ')}</td>
						<td><button onclick="location.href='/group/groupMateList?bid=${done.bid}&uid=${done.uid}'" class="btn-hover color-8 write-btn">참가자 목록</button></td>
						<td><button class="btn-hover color-3 write-btn">${done.applyCount}/${done.bUserCount} ${done.bIsFull eq 1 ? '모집 마감': '모집중'}</button></td>
					<!-- <td><button class="btn-hover color-9 write-btn">그룹채팅</button></td> -->	
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>