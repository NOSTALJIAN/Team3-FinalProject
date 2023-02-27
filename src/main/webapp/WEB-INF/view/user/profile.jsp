<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<link rel="stylesheet" href="/css/board.css">
	<link rel="stylesheet" href="/css/sidebars.css">
	<style >
	body {
		padding: 10px; margin: 0px;
	}
	span {
		color: white;
	}
	.box {
		border-radius: 70%;
	}
	img {
	  border-radius: 70%;
}
	</style>
</head>
<body style="margin-bottom: 100px; background-color: black; color: white; " class="register">
	<%@ include file="../common/top.jsp" %>
	<div style="display: flex;">
		<%@ include file="../common/sidebar.jsp" %>
		<div class="myPage-size" style="margin-top: 60px; margin-left: 180px;">
			<h5>프로필 수정</h5><hr>
			<div style="margin-top: 110px; margin-left: 280px;">
				<form name="profile" action="/user/profile" method="post" class="mb-auto col-12 text" enctype="multipart/form-data">
					<div class="box">
						<c:if test="${empty profileImg}">
						<img id="profileImg" src="/img/basicProfile.png" style="width: 250px; height: 250px;">
						</c:if>
						<c:if test="${not empty profileImg}">
						<img id="profileImg" src="/board/download?file=${profileImg}" style="width: 250px; height: 250px;">
						</c:if>
					</div><br>
					<div class="profilebox bs3-primary">
						<label for="regProfile" style="color: white;width: 89px;height: 45px;">업로드</label> 
						<input type="file" id="regProfile" name="regProfile" class="upload-hidden">
						<!-- <input class="upload-name" value="파일선택" disabled="disabled"> -->
						<span>jpg, png, gif 파일만 가능</span>
					</div><br>
					<div>
					<button type="submit" value="프로필 등록" class="btn-hover color-9 ">프로필 등록</button></div>
					<!-- <div><input type="submit" value="프로필 등록"></div> -->
				</form>
			</div>
		</div>
	</div>
	
	<script>
	// $(function(){
	// 	var fileTarget = $('.profilebox .upload-hidden');
	
	// 	fileTarget.on('change', function(){  // 값이 변경되면
	// 		if(window.FileReader){  // modern browser
	// 		  var filename = $(this)[0].files[0].name;
	// 		} 
	// 		else {  // old IE
	// 			var filename = $(this).val().split('/').pop().split('\\').pop();  // 파일명만 추출
	// 		}
	// 		// 추출한 파일명 삽입
	// 		console.log(this);
	// 	    $(this).siblings('.upload-name').val(filename);
	// 	});
	// }); 
	
	function readProfileImage(input){
		const profileImg = document.getElementById('profileImg');

		//인풋 태그에 파일이 있는 경우
		if(input.files){
			console.log("인풋파일: "+input.files);
			// 유사배열을 배열로 전환(forEach문으로 처리하기 위해)
			const fileArr = Array.from(input.files);
			fileArr.forEach((file, index) => {
				const reader = new FileReader();
				reader.onload = e => {
					profileImg.src = e.target.result;
				};
				console.log("파일 네임" + file.name);
				reader.readAsDataURL(file);
			})
		}
	}


	const regProfile = document.getElementById('regProfile');
	regProfile.addEventListener('change', e => {
		readProfileImage(e.target);
	})

	
	
	</script>
</body>
</html>