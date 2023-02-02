
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<meta charset="UTF-8"> 
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<link rel="stylesheet" href="/css/board.css">
	
	<style>
  table {
    width: 100%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;
  }
</style>
	
</head>

<body style="margin: 200px" >
<%@ include file="../common/top.jsp" %>
	<div class="board-title">
		<h3 class="board-title">그룹운동 게시판</h3>
		<hr>
		<div class="">
			<button type="button" class="btn-hover color-8 fix-position" onclick="location.href='/board/write'">+글쓰기</button>
			<table class="board-list">
				<tr>
					<th><label>제목</label></th>
					<th><label>운동 종목</label></th>
					<th><label>운동 시간</label></th>	
					<th><label>인원수</label></th>
				</tr>
				<c:forEach var="b" items="${blist}">
					<tr>
				 		<td onclick="location.href='/board/detail/${b.bid}'" >${b.bTitle}</td>
						<td onclick="location.href='/board/detail/${b.bid}'" >${b.bCategory}</td>
						<td onclick="location.href='/board/detail/${b.bid}'" >${fn:replace(b.bAppointment, 'T', ' ')}</td>
						<td>${b.bUserCount}명</td>
					</tr>
				</c:forEach>
			</table> 
		</div>
		</div>
	


</body>
</html>