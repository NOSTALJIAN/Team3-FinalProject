<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<meta charset="UTF-8">
	<title>그룹운동 마이페이지</title>
    <link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Cormorant+Garamond:wght@500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/css/sidebars.css">
    <style>
		  table {
		    width: 1100px;
		    border-top: 1px solid #444444;
		    border-collapse: collapse;
		  }
		  th, td {
		    border-bottom: 1px solid #444444;
		    padding: 0px;
		  }
		  .btn-hover.color-10 {
        background-image: linear-gradient(to right, #ed6ea0, #ec8c69, #f7186a , #FBB03B);
    box-shadow: 0 4px 15px 0 rgba(236, 116, 149, 0.75);
}
  	</style>
</head>
<body  style="margin-bottom: 600px; background-color: black; color: white;">
	<%@ include file="../common/top.jsp" %>
	<div style="display: flex;">
		<%@ include file="../common/sidebar.jsp" %>
		<div class="myPage-size" style="margin-top: 60px; margin-left: 180px;">
			<h5>그룹운동 신청현황</h5>
			<div style="margin-top: 20px;">
				<table>
					<thead>
						<tr>
							<th>제목</th>
							<th>종목</th>
							<th>장소</th>
							<th>운동시간</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="apply" items="${applyList}">
						<tr>
							<td onclick="location.href='/board/detail?bid=${apply.bid}&uid=${apply.uid}'">${apply.bTitle}</td>
							<td onclick="location.href='/board/detail?bid=${apply.bid}&uid=${apply.uid}'">${apply.bCategory}</td>
							<td onclick="location.href='/board/detail?bid=${apply.bid}&uid=${apply.uid}'">${apply.bLocation}</td>
							<td onclick="location.href='/board/detail?bid=${apply.bid}&uid=${apply.uid}'">${fn:replace(apply.bAppointment, 'T', ' ')}</td>
							<td><button class="btn-hover color-8" onclick="apply(${apply.bid}, '${apply.uid}')" id="${apply.bid}">참가신청중</button></td>
							<td>
								<c:if test="${apply.bIsFull eq 1}">
								<button class="btn-hover color-10 write-btn" style="margin-left: -50px;">${apply.applyCount}/${apply.bUserCount} 모집 마감</button>
							</c:if>
							<c:if test="${apply.bIsFull ne 1}">
								<button class="btn-hover color-3 write-btn" style="margin-left: -50px;">${apply.applyCount}/${apply.bUserCount} 모집중</button>
							</c:if>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			
			<ul class="pagination justify-content-center mt-4">
					<c:if test="${currentBoardPage gt 10}">
						<li class="page-item"><a class="page-link" href="/group/myWrite?p=${startPage - 1}&f=${field}&q=${query}">&laquo;</a></li>
					</c:if>
					<c:if test="${currentBoardPage le 10}">
						<li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
					</c:if>
					<c:forEach var="page" items="${pageList}" varStatus="loop">    
						<li class="page-item ${(currentBoardPage eq page) ? 'active' : ''}">
							<a class="page-link" href="/group/myWrite?p=${page}&f=${field}&q=${query}">${page}</a>
						</li>
					</c:forEach>  
					<c:if test="${totalPages gt endPage}">                    
						<li class="page-item"><a class="page-link" href="/group/myWrite?p=${endPage + 1}&f=${field}&q=${query}">&raquo;</a></li>
					</c:if>
					<c:if test="${totalPages le endPage}">                    
						<li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
					</c:if>
				</ul>
		</div>
	</div>
	<!-- 참가 신청 -->
	<script>
		function apply(bid, uid){
			  const applybid = document.getElementById(bid);
			  console.log(bid, uid);
			  if (applybid.innerText == '참가신청중'){
				  $.ajax({
					type:'GET',
					url: '/group/applyCancel',
					data: {'bid': bid, 'receiveUser': uid},
					success: function(result){
						applybid.innerText = result;
						console.log(result);
						applybid.style.cssText = 'background-color:white; color:pink;'
					}
				  });
			  }
			  else if (applybid.innerText == '참가신청'){
				  $.ajax({
					type:'GET',
					url: '/group/apply',
					data: {'bid': bid, 'receiveUser': uid},
					success: function(result){
						applybid.innerText = result;
						console.log(result);
						applybid.style.cssText = 'background-color:black; color:white;'
					}
				  });
			  }
		  }
	</script>
		<%@ include file="../common/bottom1.jsp" %>
</body>
</html>