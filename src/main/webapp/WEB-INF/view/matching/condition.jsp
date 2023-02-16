<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
  	<link rel="stylesheet" href="/css/board.css">
  	<link rel="stylesheet" href="/css/matchingCondition.css">
  	<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Cormorant+Garamond:wght@500&display=swap" rel="stylesheet">
  	
	<title>매칭 조건</title>
	<style>
	tr {
		padding-bottom: 30px;
	}
	td {
		text-align: right;
	}
	</style>
</head>
<body style="padding-bottom: 200px;">
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
	<h3>1:1운동 매칭조건</h3><hr>
	<form action="/matching/condition" method="post">
		<table style="width: 100%; padding-bottom: 50px; ">
			<tr>
				<th>MY 매칭운동 설정</th>
				<td><c:forEach var="ex" items="${likeExercise}">
					<c:if test="${ex eq mC.bestExercise}">
					${ex}<input class="form-check-input" type="radio" name="bestExercise" value="${ex}" checked>
					</c:if>
					<c:if test="${ex ne mC.bestExercise}">
					${ex}<input class="form-check-input" type="radio" name="bestExercise" value="${ex}">
					</c:if>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>모두<input class="form-check-input" type="radio" id="모두" name="pGender" value="모두">
					남자<input class="form-check-input" type="radio" id="남" name="pGender" value="남">
					여자<input class="form-check-input" type="radio" id="여" name="pGender" value="여">
				</td>
			</tr>
		</table>
		<hr><label>연령대</label>
		<div>
			<Strong id="ageMin"></Strong> - <Strong id="ageMax"></Strong>
		</div>
		<br>
		<div class="middle">
			<div class="multi-range-slider">
			    <!-- 진짜 슬라이더 -->
			    <input type="range" id="input-left" name="minAge" min="10" max="100" value="${mC.minAge}" />
			    <input type="range" id="input-right" name="maxAge" min="10" max="100" value="${mC.maxAge}" />
		    	<!-- 커스텀 슬라이더 -->
			    <div class="slider">
			    	<div class="track"></div>
			      	<div class="range"></div>
			      	<div class="thumb left"></div>
			      	<div class="thumb right"></div>
			    </div>
			</div>
		</div>
		<hr>
		<label>검색반경 설정</label>
		<div>
			<Strong id="DXMin"></Strong> - <Strong id="DXMax"></Strong>
		</div>
		<br>
		<div class="middle2">
			<div class="multi-range-slider2">
			    <!-- 진짜 슬라이더 -->
			    <input type="range" id="input-left2" name="minDistance" min="0" max="300" value="${mC.minDistance}" />
			    <input type="range" id="input-right2" name="maxDistance" min="0" max="300" value="${mC.maxDistance}" />
		    	<!-- 커스텀 슬라이더 -->
			    <div class="slider2">
			    	<div class="track"></div>
			      	<div class="range"></div>
			      	<div class="thumb left"></div>
			      	<div class="thumb right"></div>
			    </div>
			</div>
		</div>
		<hr>
		<button class="btn-hover color-8 write-btn" type="submit" value="조건 설정">설정</button>
	</form>
	</div>
	<script src="/js/matchingCondition.js"></script>
	<script>
	${mC.pGender}.checked = true;
	</script>
</body>
</html>