<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/css/board.css">
  	<link rel="stylesheet" href="/css/sidebars.css">
  	<style>
	  	img {
	  	  border-radius: 70%;}
  	  th,td,tr {
  	  	padding: 10px;
  	  } 
  	/*   table {
	    border-top: 1px solid #444444;
	    border-collapse: collapse;
	  }
	  th, td {
	    border-bottom: 1px solid #444444;
	    padding: 6px;
	  } */
  	</style>
</head>

<body style="margin-bottom: 100px; background-color: black; color: white;">
	<%@ include file="../common/top.jsp" %>
	<div style="display: flex;">
		<%@ include file="../common/sidebar.jsp" %>
			<div class="myPage-size" style="margin-top: 60px; margin-left:180px;">
			<h5>회원정보</h5><hr>
			<div style="margin-top: 110px; margin-left: 280px; display: flex;">
				<div>
				<div class="box">
					<c:if test="${empty profileImg}">
					<img id="profileImg" src="/img/basicProfile.png" style="width: 250px; height: 250px;">
					</c:if>
					<c:if test="${not empty profileImg}">
					<img id="profileImg" src="/board/download?file=${profileImg}" style="width: 250px; height: 250px;">
					</c:if>
				</div>
				<div style="margin-top: 20px;"><button onclick="location.href='/user/profile'" class="btn-hover color-8 profile-btn">프로필 수정</button></div>
				</div>
				<div class="profile-info">
					<table>
						<tr>
							<th>이름</th>
							<td>${user.uname}</td>
						</tr>
						<tr>
							<th>닉네임</th>
							<td>${user.nickname}</td>
						</tr>
						<tr>
							<th>관심운동</th>
							<td>${likeExerList}</td>
						</tr>
						<tr>
							<th>번호</th>
							<td>${user.phoneNum}</td>
						</tr>
						<tr>
							<th>이메일</th>
							<td>${user.email}</td>
						</tr>
						<tr>
							<th></th>
							<td><button onclick="location.href='/user/update'" class="btn-hover color-8 profile-btn" style="margin-left: 10px;">개인정보 수정</button></td>
						</tr>
					</table>
  				</div>
	</div>
	</div>
	</div>
 
 
 
 
 <script>
	/* global bootstrap: false */
	(() => {
	  'use strict'
	  const tooltipTriggerList = Array.from(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
	  tooltipTriggerList.forEach(tooltipTriggerEl => {
	    new bootstrap.Tooltip(tooltipTriggerEl)
	  })
	})()

   </script>
</body>
</html>