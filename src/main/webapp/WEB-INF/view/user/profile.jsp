<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<link rel="stylesheet" href="/css/board.css">
	<style >
	body {
		padding: 10px; margin: 0px;
	}
	span {
		color: #92B3B7;
	}
	.profilebox input[type="file"] {
	  position: absolute;
	  width: 1px;
	  height: 1px;
	  padding: 0;
	  margin: -1px;
	  overflow: hidden;
	  clip:rect(0,0,0,0);
	  border: 0;
	}
	
	.profilebox label {
	  display: inline-block;
	  padding: .5em .75em;
	  color: black;
	  font-size: inherit;
	  line-height: normal;
	  vertical-align: middle;
	  background-color: #fdfdfd;
	  cursor: pointer;
	  border: 1px solid #ebebeb;
	  border-bottom-color: #e2e2e2;
	  border-radius: .25em;
	}
	
	/* named upload */
	.profilebox .upload-name {
	  display: inline-block;
	  padding: .5em .75em;  /* label의 패딩값과 일치 */
	  font-size: inherit;
	  font-family: inherit;
	  line-height: normal;
	  vertical-align: middle;
	  background-color: #f5f5f5;
	  border: 1px solid #ebebeb;
	  border-bottom-color: #e2e2e2;
	  border-radius: .25em;
	  -webkit-appearance: none; /* 네이티브 외형 감추기 */
	  -moz-appearance: none;
	  appearance: none;
	}
	</style>
</head>
<body style="margin-left: 400px; margin-top: 180px; margin-bottom: 100px; background-color: black;" class="register">
	<%@ include file="../common/top.jsp" %>
	<h3 style="color: white;">회원 프로필 사진 수정</h3>
	<hr style="color: white;">
	<form name="profile" action="/user/profile" method="post" class="mb-auto col-12 text" enctype="multipart/form-data">
		<div>
			<c:if test="${empty profileImg}">
			<img id="profileImg" src="/img/basicProfile.png" style="width: 300px; height: 300px;">
			</c:if>
			<c:if test="${not empty profileImg}">
			<img id="profileImg" src="/board/download?file=${profileImg}" style="width: 300px; height: 300px;">
			</c:if>
		</div><br>
		<div class="profilebox bs3-primary">
			<label for="regProfile">프로필 사진 업로드</label> 
			<input type="file" id="regProfile" name="regProfile" class="upload-hidden">
			<!-- <input class="upload-name" value="파일선택" disabled="disabled"> -->
			<span>jpg, png, gif 파일만 가능</span>
		</div><br>
		<div><input type="submit" value="프로필 등록"></div>
	</form>
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

		//인풋 태그에 파일이 이쓴경우
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