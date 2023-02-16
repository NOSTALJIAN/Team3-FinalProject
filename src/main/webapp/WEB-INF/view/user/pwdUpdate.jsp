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
<body style="margin-left: 400px; margin-top: 180px; margin-bottom: 100px; background-color: black;" class="register">
	<%@ include file="../common/top.jsp" %>
	<h3 style="color: white;">비밀번호 변경</h3>
	<hr style="color: white;">
	<form id="pwd_sub" action="/user/pwdUpdate" method="post" class="mb-auto col-12 text">
		<table>
			<tr>
				<th>현재 비밀번호</th>
				<td><input style="width: 250px;" class="form-control  bg-gray-800 border-dark" type="password" name="pwd" id="pwd" placeholder="*패스워드" maxlength="60" required /></td>
			</tr>
			<tr>
				<th>새 비밀번호</th>
				<td><input style="width: 250px;" class="form-control  bg-gray-800 border-dark" type="password" name="newpwd"  id="newpwd" placeholder="*패스워드 확인" maxlength="60" required /></td>
			</tr>
			<tr>
				<th>새 비밀번호 확인</th>
				<td><input style="width: 250px;" class="form-control  bg-gray-800 border-dark" type="password" name="newpwd2"  id="newpwd2" placeholder="*패스워드 확인" maxlength="60" required /></td>
			</tr>
			<tr style="margin-left: 60px;">		
				<td><input class="btn-hover color-8" onclick="checked_submit()" type="button" value="비밀번호 변경"></td>
				<td><input class="btn-hover color-8" type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
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
</body>
</html>