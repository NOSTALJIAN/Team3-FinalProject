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
<body style=" margin-bottom: 100px; background-color: black;  color: white;" class="delete">
	<%@ include file="../common/top.jsp" %>
	<div style="display: flex;">
		<%@ include file="../common/sidebar.jsp" %>
		<div class="myPage-size" style="margin-top: 60px; margin-left: 180px;">
			<h5>회원탈퇴</h5><hr>
			<div style="margin-top: 110px; margin-left: 280px;">
				<p>탈퇴하시는 경우 일정기간 또는 영구적으로 재가입이 제한됩니다. 정말로 삭제하시겠습니까?</p>
				<form id="id_delete" action="/user/delete" method="post" class="mb-auto col-12 text">
					<table>
						<tr>
							<th>아이디</th>
							<td><input style="width: 250px;" class="form-control  bg-gray-800 border-dark" type="text" name="uid" id="uid" placeholder="" maxlength="60" value="${sessionUid}" disabled/></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input style="width: 250px;" class="form-control  bg-gray-800 border-dark" type="password" name="pwd"  id="pwd" placeholder="" maxlength="60" required /></td>
						</tr>
						<tr style="margin-left: 60px;">		
							<td><input class="btn-hover color-9" onclick="delete_submit()" type="button" value="탈퇴"></td>
							<td><input class="btn-hover color-8" type="reset" value="취소"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<script>
		function delete_submit(){
			const uid = document.getElementById('uid').value;
			const pwd = document.getElementById('pwd').value;
			$.ajax({
				type:'GET',
				url: '/user/pwdConfirm',
				data: {'pwd': pwd},
				success: function(result){
					if (result == 0){
						alert('현재 비밀번호가 올바르지 않습니다.');
					} else if (result == 1){
						if(confirm('정말로 탈퇴하시겠습니까?')){
							$(id_delete).submit();
						} else
							return false;
					} 
				}
			});
		}
	</script>
	<%@ include file="../common/bottom1.jsp" %>
</body>
</html>