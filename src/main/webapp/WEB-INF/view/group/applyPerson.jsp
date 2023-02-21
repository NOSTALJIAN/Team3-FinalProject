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
.frame {
  width: 90%;
  margin: 40px auto;
  text-align: center;
}
 table {
    width: 1000px;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
    padding: 5px;
  }
</style>
</head>
<body  style="margin-bottom: 100px; background-color: black; color: white;">
	<%@ include file="../common/top.jsp" %>
	<div style="display: flex;">
		<%@ include file="../common/sidebar.jsp" %>
			<div class="myPage-size" style="margin-top: 60px; margin-left: 180px;">
			<h4>신청자 목록</h4><hr>
    		<h5>[게시글 제목]</h5>
    		<div style="margin-top: 30px;">
				<table>
					<thead>
						<tr>
							<th>프로필</th>
							<th>아이디</th>
							<th>관심운동</th>
							<th>성별</th>
							<th>나이</th>
							<th>신청시간</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="re" items="${receiveList}">
						<tr>
							<td>[프로필]</td>
							<td>${re.uid}</td>
							<td>${re.likeExercise}</td>
							<td>${re.gender}</td>
							<td>${re.birthDate}</td>
							<td>[신청시간]</td>
							<td><button onclick="mateAccept('${re.uid}')" class="btn-hover color-8 write-btn">수락</button></td>
							<td><button onclick="mateReject('${re.uid}')" class="btn-hover color-8 write-btn">거절</button></td>
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