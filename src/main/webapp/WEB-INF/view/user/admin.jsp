<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<meta charset="UTF-8">
	<title>관리자 페이지</title>
</head>
<body>
	<%@ include file="../common/top.jsp" %>
	<div style="margin-bottom: 600px;">
	<div style="margin-left: 450px;margin-top: 20px;">
	<button onclick="location.href ='/user/admin'">전체회원</button>
	<button onclick="location.href ='/user/admin?isDeleted=0'">정상회원</button>
	<button onclick="location.href ='/user/admin?isDeleted=1'">탈퇴예정회원</button>
	<button onclick="location.href ='/user/admin?isDeleted=2'">추방회원</button>
	</div>
	<table border="1" style="margin-top:-0.5px;margin-left:170px; width: 80%">
		<tr>
			<th width="10%">UID</th><th width="7%">이름</th>
			<th width="13%">email</th><th width="10%">전화번호</th>
			<th width="13%">등록일</th><th width="7%">탈퇴여부</th>
			<th width="30%">회원 상태 변경</th>
		</tr>
		<c:forEach var="user" items="${userList}">
		<tr>
			<td>${user.uid}</td>
			<td>${user.uname}</td>
			<td>${user.email}</td>
			<td>${user.phoneNum}</td>
			<td>${user.uRegDate}</td>
			<c:if test="${user.uIsDeleted eq 0}">
			<td id="${user.uid}">정상회원</td>	
			</c:if>
			<c:if test="${user.uIsDeleted eq 1}">
			<td id="${user.uid}">탈퇴회원</td>	
			</c:if>
			<c:if test="${user.uIsDeleted eq 2}">
			<td id="${user.uid}">추방회원</td>	
			</c:if>
			<td><button onclick="cancle('${user.uid}')">추방/탈퇴취소</button>
			<button onclick="delete1('${user.uid}')">강제 탈퇴</button>
			<button onclick="exile('${user.uid}')">추방하기</button></td>
		</tr>
		</c:forEach>
	</table>
	</div>
	
	<script>
	function cancle(uid){
		const fcuid = document.getElementById(uid);
		if (fcuid.innerText != '정상회원'){
			$.ajax({
				type:'GET',
				url: '/user/isDeleted',
				data: { 'uid': uid,
						'isNum' : '0'		
				},
				success: function(result){
					fcuid.innerText = '정상회원';
				}
			});
		}
	}
	function delete1(uid){
		const fcuid = document.getElementById(uid);
		if (fcuid.innerText != '탈퇴회원'){
			$.ajax({
				type:'GET',
				url: '/user/isDeleted',
				data: { 'uid': uid,
						'isNum' : '1'		
				},
				success: function(result){
					fcuid.innerText = '탈퇴회원';
				}
			});
		}
	}
	function exile(uid){
		const fcuid = document.getElementById(uid);
		if (fcuid.innerText != '추방회원'){
			$.ajax({
				type:'GET',
				url: '/user/isDeleted',
				data: { 'uid': uid,
						'isNum' : '2'		
				},
				success: function(result){
					fcuid.innerText = '추방회원';
				}
			});
		}
	}
	</script>
</body>
</html>