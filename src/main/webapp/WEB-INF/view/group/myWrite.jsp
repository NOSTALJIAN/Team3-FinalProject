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
</head>
<body>
	<%@ include file="../common/top.jsp" %>
	<div class="container" style="margin-top: 150px;">
		<div class="row frame">
			<div class="col custom-btn btn-5">
				<a class="nav-link fs-5" href="/boardMypage/myWrite" aria-label="A sample content page">작성글</a></div>
			<div class="col custom-btn btn-5">
				<a class="nav-link fs-5" href="/boardMypage/applyList" aria-label="A sample content page">신청글</a></div>
			<div class="col custom-btn btn-5">
				<a class="nav-link fs-5" href="/boardMypage/applyDone" aria-label="A sample content page">신청완료</a></div>
		</div>
	</div>
	<div class="mypage">
		<h3>작성글 목록</h3>
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
						<td onclick="location.href='/board/detail?bid=${my.bid}&uid=${my.uid}'">${my.bid}</td>
						<td onclick="location.href='/board/detail?bid=${my.bid}&uid=${my.uid}'">${my.bCategory}</td>
						<td onclick="location.href='/board/detail?bid=${my.bid}&uid=${my.uid}'">${my.bUserCount}</td>
						<td onclick="location.href='/board/detail?bid=${my.bid}&uid=${my.uid}'">${fn:replace(my.bRegTime, 'T', ' ')}</td>
						<td onclick="location.href='/board/detail?bid=${my.bid}&uid=${my.uid}'">${my.bViewCount}</td>
						<td onclick="location.href='/board/detail?bid=${my.bid}&uid=${my.uid}'">${my.bReplyCount}</td>
						<td><button onclick="location.href='/group/applyPerson?bid=${my.bid}&uid=${my.uid}'" class="btn-hover color-8 write-btn">신청자 목록</button></td>
						<td><button class="btn-hover color-8 write-btn">모집중</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>