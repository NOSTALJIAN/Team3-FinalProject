
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<meta charset="UTF-8"> 
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<style>
	 /*  table {
	    width: 100%;
	    border-top: 1px ;
	    border-collapse: collapse;
	  }
	  th, td {
	    border-bottom: 1px solid #444444;
	    padding: 10px;
	  } */
	</style>
</head>

<body>
<%@ include file="../common/top.jsp" %>
	<div class="container" style="margin-top: 120px; padding-bottom: 300px;">
        <div class="row" style="justify-content: space-evenly">
            <!-- =================== main =================== -->
            <div class="">
		<h3><strong>그룹운동 게시판</strong></h3>
		<div class="board-list">
			<button type="button" class="btn-hover color-8 fix-position " onclick="location.href='/board/write'">+글쓰기</button>
			<table class="" style="margin-top: 30px;">
				<tr>
					<th><label>제목</label></th>
					<th><label>운동 종목</label></th>
					<th><label>운동 시간</label></th>
					<th><label>운동 장소</label></th>		
					<th><label>인원수</label></th>
					<th><label>조회수</label></th>
					<!-- <th><label>조회수</label></th> -->
				</tr>
				<c:forEach var="b" items="${blist}">
					<tr>
				 		<td onclick="location.href='/board/detail?bid=${b.bid}&uid=${b.uid}'" >${b.bTitle}</td>
						<td onclick="location.href='/board/detail?bid=${b.bid}&uid=${b.uid}'" >${b.bCategory}</td>
						<td onclick="location.href='/board/detail?bid=${b.bid}&uid=${b.uid}'" >${fn:replace(b.bAppointment, 'T', ' ')}</td>
						<td onclick="location.href='/board/detail?bid=${b.bid}&uid=${b.uid}'">${b.bLocation}</td>
						<td onclick="location.href='/board/detail?bid=${b.bid}&uid=${b.uid}'">${b.bUserCount}명</td>
						<td onclick="location.href='/board/detail?bid=${b.bid}&uid=${b.uid}'">${b.bViewCount}</td> 
					</tr>
				</c:forEach>
			</table> 
			 <ul class="pagination justify-content-center mt-4">
                <c:if test="${currentBoardPage gt 10}">
                    <li class="page-item"><a class="page-link" href="/board/list?p=${startPage - 1}&f=${field}&q=${query}">&laquo;</a></li>
                </c:if>
                <c:if test="${currentBoardPage le 10}">
                    <li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
                </c:if>
                <c:forEach var="page" items="${pageList}" varStatus="loop">    
                    <li class="page-item ${(currentBoardPage eq page) ? 'active' : ''}">
                    	<a class="page-link" href="/board/list?p=${page}&f=${field}&q=${query}">${page}</a>
                    </li>
                </c:forEach>  
                <c:if test="${totalPages gt endPage}">                    
                    <li class="page-item"><a class="page-link" href="/board/list?p=${endPage + 1}&f=${field}&q=${query}">&raquo;</a></li>
                </c:if>
                <c:if test="${totalPages le endPage}">                    
                    <li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
                </c:if>
                </ul>
		</div>
		</div>
		</div>
		</div>
	

<%@ include file="../common/top.jsp" %>
</body>
</html>