<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<meta charset="UTF-8">
	<title>친구창</title>
</head>
<body>
	<%@ include file="../common/top.jsp" %>
	<br><br><br><br>
	<h3>친구창</h3>
	<hr>
	<c:forEach var="mate" items="${mateList}">
	<div>
		<p>친구아이디 : ${mate}</p>
	</div>
	</c:forEach>

</body>
</html>