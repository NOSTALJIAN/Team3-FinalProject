<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<meta charset="UTF-8">
	<title>Insert title here</title>
    <link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Cormorant+Garamond:wght@500&display=swap" rel="stylesheet">
   	<link rel="stylesheet" href="/css/sidebars.css">
   	<link rel="canonical" href="https://getbootstrap.kr/docs/5.2/examples/sidebars/">
	<link href="/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/sidebars.css">
	
</head>
	<body style="margin-bottom: 100px; background-color: black; color: white;">
	<%@ include file="../common/top.jsp" %>
	<div style="display: flex;">
		<%@ include file="../common/sidebar.jsp" %>
			<div class="myPage-size" style="margin-top: 60px; margin-left:180px;">
			<h5>회원정보</h5><hr>
		    <div class="container" style="margin-top: 30px; padding-bottom: 260px;">
		      <div class="row" style="justify-content: space-evenly; margin-left:70px;">
		        <!-- =================== main =================== -->
		        <div class="col-sm-9" >
		
		
		        </div>
		      </div>
		    </div>
  </div>
 </div>
 	<script src="/docs/5.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <script src="/js/sidebars.js"></script>
    <script src="/js/bootstrap.bundle.min.js"></script>
	<script src="/js/aos.js"></script>
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