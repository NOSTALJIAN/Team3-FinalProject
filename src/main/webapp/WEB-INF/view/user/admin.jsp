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
	<button onclick="all()">전체회원</button>
	<button onclick="normal()">정상회원</button>
	<button onclick="delete()">탈퇴예정회원</button>
	<button onclick="exile()">추방회원</button>
	<table border="1" style="margin: 50px; width: 80%">
		<tr>
			<th>UID</th><th>이름</th>
			<th>email</th><th>전화번호</th>
			<th>등록일</th><th>탈퇴여부</th>
		</tr>
		<c:forEach var="user" items="${userList}">
		<tr>
			<td>${user.uid}</td>
			<td>${user.uname}</td>
			<td>${user.email}</td>
			<td>${user.phoneNum}</td>
			<td>${user.uRegDate}</td>
			<c:if test="${user.uIsDeleted eq 0}">
			<td>정상회원</td>	
			<td><button onclick="">추방하기</button></td>
			</c:if>
			<c:if test="${user.uIsDeleted eq 1}">
			<td>탈퇴예정</td>	
			<td><button onclick="">탈퇴취소</button></td>
			</c:if>
			<c:if test="${user.uIsDeleted eq 2}">
			<td>추방예정</td>	
			<td><button onclick="">추방취소</button></td>
			</c:if>
		</tr>
		</c:forEach>
	</table>
	<script>
	
	</script>
</body>
</html>