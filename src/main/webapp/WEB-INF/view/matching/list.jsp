<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
</head>
<body style="margin-left: 40px; margin-top: 50px;">
	<%@ include file="../common/top.jsp" %>
	<h2>매칭 리스트</h2>
	<div class="container" style="margin-top: 80px;">
	<c:forEach var="user" items="${matchingList}">
		<div>아이디 : ${user.uid}</div>
		<div>거리 : ${user.distance}</div>
		<div>나이 : ${user.age}</div>
		<div>일치하는 운동 목록 : ${user.coincideExer}</div>
		<div>성별 : ${user.gender}</div>
		<div>평점 : ${user.uRating}</div>
		<div>매칭점수 : ${user.score}</div>
		<hr>
	</c:forEach>
	</div>
</body>
</html>