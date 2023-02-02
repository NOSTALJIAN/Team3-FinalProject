<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<link rel="stylesheet" href="../css/map.css" />
	<meta charset="UTF-8">
</head>

<body style="margin: 200px" >
<%@ include file="../common/top.jsp" %>
	
	<h2>그룹운동 게시판</h2>
	<a href="/board/write" class="btn btn-outline-light" style="background-color: purple;">
    	<small>게시글 쓰기</small></a>

	<table>
			<colgroup>
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
			</colgroup>
			<tr>
				<th><label>게시글번호</label></th>
				<th><label>제목</label></th>
				<th><label>운동종목</label></th>
				<th><label>작성일자</label></th>
			</tr>
			<c:forEach var="b" items="${blist}">
				<tr>
					<td><a href="/board/detail/${b.bid}">${b.bid}</a></td>
					<td>${b.bTitle}</td>
					<td>${b.bCategory}</td>
					<td>${fn:replace(b.bRegTime, 'T', ' ')}</td>
				</tr>
			</c:forEach>
		
		</table>
	
	
</body>
</html>