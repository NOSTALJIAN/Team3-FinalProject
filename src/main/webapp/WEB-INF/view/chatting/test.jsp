<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<%@ include file="../common/heading.jsp" %>
			<meta charset="UTF-8">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
			<link rel="stylesheet" href="/css/chat.css">
	</head>

	<body>
		<%@ include file="../common/top.jsp" %>
			<script src="/js/chat.js"></script>
			<div id="container" class="container" style="margin-top: 120px; padding-bottom: 300px;">
				<h1>채팅</h1>
				<textarea id="chatBoxArea" class="chatBoxArea"></textarea>
				<!-- <div id="yourName">
					<table class="inputTable">
					<tr>
						<th>사용자명</th>
						<th><input type="text" name="userName" id="userName"></th>
						<th><button onclick="chatName()" id="startBtn">이름 등록</button></th>
					</tr>
				</table>
				</div> -->

				<c:forEach var="uid" items="${sessionUid}">
					<input type="hidden" id="uid" value="${uid}">
				</c:forEach>

				<div id="yourMsg">
					<table class="inputTable">
						<tr>
							<th>메세지</th>
							<th><input id="inputMsgBox" placeholder="보내실 메세지를 입력하세요."></th>
							<th><button onclick="send()" id="sendBtn">보내기</button></th>
						</tr>
					</table>
				</div>
			</div>
	</body>

	</html>