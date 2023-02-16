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
    	.box-size {
    	border: 1px ;
    	border-color: white;
    	width: 270px;
    	height: 120px;
    	margin: 10spx;
    	padding: 3px;
    	}
    	 .double {
        border-style: double;
      }
     
    </style>
</head>
<body class="bg-black text-white mt-0" data-bs-spy="scroll" data-bs-target="#navScroll">
	<%@ include file="../common/top.jsp" %>
	<div class="container" style="margin: 120px; padding-bottom: 260px;">
		<div class="row" style="justify-content: space-evenly; margin-left:70px;">
			<!-- =================== main =================== -->
			<div class="col-sm-9" >
				<h3 style=" margin-left: 10px;"><strong>MyPage</strong></h3>
				<hr>
			<div class="myPage" style=" margin-left: 110px;">
				<div class="myPageBox box-size double" >
					프로필 사진 수정
					<div class="mypage-btn" style="margin-top: 10px;"><button class="btn-hover color-8 write-btn" onclick="location.href='/user/profile'">프로필</button></div>
				</div>
				<div class="content-list-mypage box-size double" >
					비밀번호 수정
					<div class="mypage-btn" style="margin-top: 10px;"><button class="btn-hover color-8 write-btn" onclick="location.href='/user/pwdUpdate'">정보수정</button></div>
				</div>
				<div class="content-list-mypage box-size double" >
					1:1운동 매칭조건 설정
					<div class="mypage-btn" style="margin-top: 10px;"><button class="btn-hover color-8 write-btn" onclick="location.href='/matching/condition'">매칭조건</button></div>
				</div>
				<div class="content-list-mypage box-size double" >
					1:1운동 친구관리
					<div class="mypage-btn" style="margin-top: 10px;"><button class="btn-hover color-8 write-btn" onclick="location.href='/mate/addMateForm'">친구관리</button></div>
				</div>
				<div class="content-list-mypage box-size double" >
					그룹운동 관리
					<div class="mypage-btn" style="margin-top: 10px;"><button class="btn-hover color-8 write-btn" onclick="location.href='/group/myWrite'">그룹운동</button></div>
				</div>
				<div class="content-list-mypage box-size double" >
					운동일정 관리
					<div class="mypage-btn" style="margin-top: 10px;"><button class="btn-hover color-8 write-btn" onclick="location.href='/schedule/calendar'">운동일정</button></div>
				</div>
			</div>
				
			</div>
		</div>
	</div>

	<script src="/js/bootstrap.bundle.min.js"></script>
	<script src="/js/aos.js"></script>
</body>
</html>