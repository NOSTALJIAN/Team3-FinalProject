<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/css/board.css">
  	<link rel="stylesheet" href="/css/sidebars.css">
</head>

<body style="margin-bottom: 100px; background-color: black; color: white;">
	<%@ include file="../common/top.jsp" %>
	<div style="display: flex;">
		<%@ include file="../common/sidebar.jsp" %>
			<div class="myPage-size" style="margin-top: 60px; margin-left:180px;">
			<h5>회원정보</h5><hr>
			<div style="margin-top: 30px;">
				<div class="box">
					<c:if test="${empty profileImg}">
					<img id="profileImg" src="/img/basicProfile.png" style="width: 250px; height: 250px;">
					</c:if>
					<c:if test="${not empty profileImg}">
					<img id="profileImg" src="/board/download?file=${profileImg}" style="width: 250px; height: 250px;">
					</c:if>
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