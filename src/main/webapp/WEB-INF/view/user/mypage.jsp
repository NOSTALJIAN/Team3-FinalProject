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
<style>
.frame {
  width: 90%;
  margin: 40px auto;
  text-align: center;
}
button {
  margin: 20px;
  outline: none;
}
.custom-btn {
  width: 130px;
  height: 40px;
  padding: 10px 25px;
  border: 2px solid #000;
  font-family: 'Lato', sans-serif;
  font-weight: 500;
  background: transparent;
  cursor: pointer;
  transition: all 0.3s ease;
  position: relative;
  display: inline-block;
}

/* 5 */
.btn-5 {
  background: #000;
  color: #fff;
  line-height: 42px;
  padding: 0;
  border: none;
}
.btn-5:hover {
  background: transparent;
  color: #000;
   box-shadow:
   -7px -7px 20px 0px #fff9,
   -4px -4px 5px 0px #fff9,
   7px 7px 20px 0px #0002,
   4px 4px 5px 0px #0001;
}
.btn-5:before,
.btn-5:after{
  content:'';
  position:absolute;
  top:0;
  right:0;
  height:2px;
  width:0;
  background: #000;
  transition:400ms ease all;
}
.btn-5:after{
  right:inherit;
  top:inherit;
  left:0;
  bottom:0;
}
.btn-5:hover:before,
.btn-5:hover:after{
  width:100%;
  transition:800ms ease all;
}
</style>
</head>
<body>
	<%@ include file="../common/top.jsp" %>
	 <div class="container" style="margin-top: 150px;">
        <div class="row frame">
            <div class="col custom-btn btn-5">
                <a class="nav-link fs-5" href="/mate/addMateForm" aria-label="A sample content page">친구추가</a></div>
            <div class="col custom-btn btn-5">
                <a class="nav-link fs-5" href="/mate/receiveMateForm" aria-label="A sample content page">친구수락</a></div>
            <div class="col custom-btn btn-5">
                <a class="nav-link fs-5" href="/mate/mateForm" aria-label="A sample content page">친구목록</a></div>
            <div class="col custom-btn btn-5">
                <a class="nav-link fs-5" href="/matching/condition" aria-label="A sample content page">매칭조건</a></div>
        </div>
    </div>
    <hr>
</body>
</html>