<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<meta charset="UTF-8">
</head>

<body>
<h1>게시판 상세보기</h1>
		<table>
			<colgroup>
				<col width="5%"/>
				<col width="20%"/>
			</colgroup>
			<tr>
				<th>게시글번호</th>
				<td>${board.bid }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${board.uid }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${board.title }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${board.content }</td>
			</tr>
			<tr>
				<th>작성일자</th>
				<td>${board.modTime }</td>
			</tr>
		
		</table>
	
</body>
</html>