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
    <style type="text/css">
		  table {
		    width: 1100px;
		    border-top: 1px solid #444444;
		    border-collapse: collapse;
		  }
		  th, td {
		    border-bottom: 1px solid #444444;
		    padding: 2px;
		  }
  	</style>
</head>
<body  style="margin-bottom: 100px; background-color: black; color: white;">
	<%@ include file="../common/top.jsp" %>
	<div style="display: flex;">
		<%@ include file="../common/sidebar.jsp" %>
		<div class="myPage-size" style="margin-top: 60px; margin-left: 180px;">
			<h5>그룹운동 신청현황</h5>
			<div style="margin-top: 30px;">
				<table>
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>종목</th>
							<th>장소</th>
							<th>시간</th>
							<th>총인원</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="apply" items="${applyList}">
						<tr>
							<td>${apply.bid}</td>
							<td>${apply.bTitle}</td>
							<td>${apply.bCategory}</td>
							<td>${apply.bLocation}</td>
							<td>${fn:replace(apply.bAppointment, 'T', ' ')}</td>
							<td>${apply.bUserCount}</td>
							<td><button class="btn-hover color-8 ">참가신청중</button></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- 참가 신청 -->
	<script>
		function apply(bid, uid){
			  const applybid = document.getElementById(bid);
			  console.log(bid, uid);
			  if (applybid.innerText == '참가신청'){
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
			  else if (applybid.innerText == '참가신청중'){
				  $.ajax({
					type:'GET',
					url: '/group/applyCancel',
					data: {'bid': bid, 'receiveUser': uid},
					success: function(result){
						applybid.innerText = result;
						console.log(result);
						applybid.style.cssText = 'background-color:white; color:black;'
					}
				  });
			  }
		  }
	</script>
		
</body>
</html>