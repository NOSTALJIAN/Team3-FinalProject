<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<meta charset="UTF-8">
	<title>친구창</title>
</head>
<body>
	<%@ include file="../common/top.jsp" %>
	<div class="container" style="margin-top: 150px;">
         <div class="row frame">
            <div class="col custom-btn btn-5">
                <a class="nav-link fs-5" href="/mate/addMateForm" aria-label="A sample content page">보낸 친구신청</a></div>
            <div class="col custom-btn btn-5">
                <a class="nav-link fs-5" href="/mate/receiveMateForm" aria-label="A sample content page">받은 친구신청</a></div>
            <div class="col custom-btn btn-5">
                <a class="nav-link fs-5" href="/mate/mateForm" aria-label="A sample content page">친구목록</a></div>
            <div class="col custom-btn btn-5">
                <a class="nav-link fs-5" href="/matching/condition" aria-label="A sample content page">매칭조건</a></div>
        </div>
    </div>
	<div class="mypage">
		<h3>친구창</h3>
		<c:forEach var="mate" items="${mateList}">
			<div>
				<p>친구아이디 : ${mate}</p>
			</div>
		</c:forEach>
	</div>
</body>
</html>