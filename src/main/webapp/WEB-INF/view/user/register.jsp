<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<script src="/js/jquery-3.6.3.min.js"></script>
	<title>사용자 등록</title>
</head>
<body>
   	<%@ include file="../common/top.jsp" %>
	<h3>사용자 등록</h3>
	<hr>
	<form name="reg_sub" action="/user/register" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="uid"></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="pwd" id="pwd"></td>
			</tr>
			<tr>
				<td>패스워드 확인</td>
				<td><input type="password" name="pwd2" id="pwd2"></td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td><input type="text" name="nickname"></td>
			</tr>
			
			<tr>
				<td>이름</td>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="tel" name="phoneNum"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td>이메일수신여부</td>
				<td>수신<input type="radio" name="email_check" value="1">수신거부<input type="radio" name="email_check" value="0"></td>
			</tr>
			<tr>
				<td>주민번호</td>
				<td><input type="number" name="birth_date" maxlength="6">-<input type="number" name="gender" maxlength="1"></td>
			</tr>
			<tr>
				<td>관심운동</td>
				<td>
				축구<input onclick="limit(this)" type="checkbox" name="likeExercise" value="1">농구<input onclick="limit(this)" type="checkbox" name="likeExercise" value="2">야구<input onclick="limit(this)" type="checkbox" name="likeExercise" value="4">E-sports<input onclick="limit(this)" type="checkbox" name="likeExercise" value="8">
				등산<input onclick="limit(this)" type="checkbox" name="likeExercise" value="16">당구<input onclick="limit(this)" type="checkbox" name="likeExercise" value="32">볼링<input onclick="limit(this)" type="checkbox" name="likeExercise" value="64">싸이클<input onclick="limit(this)" type="checkbox" name="likeExercise" value="128">
				테니스<input onclick="limit(this)" type="checkbox" name="likeExercise" value="256">조깅<input onclick="limit(this)" type="checkbox" name="likeExercise" value="512">수영<input onclick="limit(this)" type="checkbox" name="likeExercise" value="1024">헬스<input onclick="limit(this)" type="checkbox" name="likeExercise" value="2048">
				</td>
			</tr>
			<tr>
				<td colspan="4"><input onclick="checked_submit()" type="button" value="제출"></td>
			</tr>
		</table>
	</form>
	
	<script>
		let mc = 5;	// 체크박수 갯수 제한
		let tc = 0; //카운트 증가
		var checked_num = $("input[name=likeExercise]:checked").length;
		console.log(checked_num);
		console.log("확인용");
		function limit(ff){
			if (ff.checked)
				checked_num +=1;
			else 
				checked_num -=1;

			if (checked_num > mc){
				alert("5개까지만 선택해주세요");
				ff.checked = false;
				checked_num -= 1;
			}
		}
		function checked_submit(){
			var checked_num = $('input[name="likeExercise"]:checked').length;
			const pwd = $('#pwd').val();
			const pwd2 = $('#pwd2').val();
			if (pwd != pwd2) {
				alert("비밀번호가 일치하지 않습니다.");
				return false;
			} else if(checked_num < 3){
				console.log(checked_num);
				console.log("확인용");
				alert("체크박스를 3개이상 선택해 주세요");
				return false;
			} else {
				const reg_sub = document.reg_sub;
				reg_sub.submit();
			}
		}
		
	</script>
</body>
</html>