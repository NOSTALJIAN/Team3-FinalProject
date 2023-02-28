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
    <link rel="stylesheet" href="/css/sidebars.css">
	<title>매칭 조건</title>
	<style>
	tr {padding-bottom: 30px; margin: 20px;
	}
	td {
		text-align: right;
		padding-left: 50px;
	}
	</style>
</head>
<body style="margin-bottom: 100px; background-color: black; color: white;">
	<%@ include file="../common/top.jsp" %>
	<div style="display: flex;">
		<%@ include file="../common/sidebar.jsp" %>
		<div class="myPage-size" style="margin-top: 60px; margin-left: 180px;">
			<h5>운동친구 매칭조건</h5><hr style="color: white;">
			<div style="margin-top: 30px; margin-left: 250px;">
				<form action="/matching/condition" method="post">
					<table style="width: 100%; padding-bottom: 50px; ">
						<tr>
							<th>MY 매칭운동</th>
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
					<button class="btn-hover color-9 write-btn" type="submit" value="조건 설정" style="margin-left: 95px;">설정</button>
					<button class="btn-hover color-8 write-btn" type="reset" style="margin-left: 50px;">취소</button>
				</form>
			</div>
		</div>
	</div>
	
	<script src="/js/matchingCondition.js"></script>
	<script>
	${mC.pGender}.checked = true;
	</script>
</body>
</html>