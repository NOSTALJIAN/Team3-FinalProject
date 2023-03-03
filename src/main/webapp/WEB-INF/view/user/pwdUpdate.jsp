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
	table {
		border-spacing: 50px;
	    }
	th, td {
		padding: 15px;
		padding-top: 10px;
	    padding-bottom: 20px;
	    padding-left: 30px;
	    padding-right: 40ox;
	   }
	</style>
</head>
<body style=" margin-bottom: 100px; background-color: black;  color: white;" class="register">
	<%@ include file="../common/top.jsp" %>
	<div style="display: flex;">
		<%@ include file="../common/sidebar.jsp" %>
		<div class="myPage-size" style="margin-top: 60px; margin-left: 180px;">
			<h5>비밀번호 변경</h5><hr>
			<div style="margin-top: 110px; margin-left: 280px;">
				<form id="pwd_sub" action="/user/pwdUpdate" method="post" class="mb-auto col-12 text">
					<table>
						<tr>
							<th>현재 비밀번호</th>
							<td><input style="width: 250px;" class="form-control  bg-gray-800 border-dark" type="password" name="pwd" id="pwd" placeholder="" maxlength="60" required /></td>
						</tr>
						<tr>
							<th>새 비밀번호</th>
							<td><input style="width: 250px;" class="form-control  bg-gray-800 border-dark" type="password" name="newpwd"  id="newpwd" placeholder="" maxlength="60" required /></td>
						</tr>
						<tr>
							<th>새 비밀번호 확인</th>
							<td><input style="width: 250px;" class="form-control  bg-gray-800 border-dark" type="password" name="newpwd2"  id="newpwd2" placeholder="" maxlength="60" required /></td>
						</tr>
						<tr style="margin-left: 60px;">		
							<td><input class="btn-hover color-9" onclick="checked_submit()" type="button" value="변경"></td>
							<td><input class="btn-hover color-8" type="reset" value="취소"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<script>
	function checked_submit(){
		const pwd = document.getElementById('pwd').value; 
		const newpwd = document.getElementById('newpwd').value; 
		const newpwd2 = document.getElementById('newpwd2').value; 
		$.ajax({
			type:'GET',
			url: '/user/pwdConfirm',
			data: {'pwd': pwd},
			success: function(result){
				if (result == 0){
					alert('현재 비밀번호가 올바르지 않습니다.');
				} else if (result == 1 && newpwd==newpwd2){
					$(pwd_sub).submit();
				} else if(result == 1 && newpwd!=newpwd2){
					alert('새 비밀번호가 일치하지 않습니다.');
				}
			}
		});
	}
	</script>
	<div style="margin-top: 280px;">
	<%@ include file="../common/bottom1.jsp" %></div>
</body>
</html>