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
   img {
		  	width: 70px; height: 70px;   border-radius: 70%;
		  }
</style>
</head>
<body  style="margin-bottom: 100px; background-color: black; color: white;">
	<%@ include file="../common/top.jsp" %>
	<div style="display: flex;">
		<%@ include file="../common/sidebar.jsp" %>
			<div class="myPage-size" style="margin-top: 60px; margin-left: 180px;">
			<h4>신청자 목록</h4><hr>
			<c:forEach var="re" items="${receiveList}">
    			<h5>${re.bid} [${re.bTitle}]</h5>
    		</c:forEach>
    		<div style="margin-top: 30px;">
				<table>
					<thead>
						<tr>
							<th>프로필</th>
							<th>닉네임</th>
							<th>관심운동</th>
							<th>성별</th>
							<th>나이</th>
							<th>신청시간</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="re" items="${receiveList}" varStatus="status">
						<tr id="${re.uid}">
							<td>${infoList[status.index].uImage}</td>
							<td>${infoList[status.index].nickname}</td>
							<td>${infoList[status.index].coincideExer}</td>
							<td>${re.gender}</td>
							<td>${infoList[status.index].age}</td>
							<td>${fn:replace(re.sendTime, 'T', ' ')}</td>
							<td><button onclick="applyAccept('${re.uid}', '${re.bid}')" class="btn-hover color-9 write-btn">수락</button></td>
							<td><button onclick="applyReject('${re.uid}', '${re.bid}')" class="btn-hover color-8 write-btn">거절</button></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script>
		function applyAccept(uid, bid){
			const mateuid1 = document.getElementById(uid);
			const applybid = document.getElementById(bid);
			console.log(bid);
			$.ajax({
					type:'GET',
					url: '/group/applyAccept',
					data: {'receiveUser': uid, 'bid': bid },
					success: function(result){
						mateuid1.style.display='none';
					}
				});
			}
		function applyReject(uid, bid){
			const mateuid2 = document.getElementById(uid);
			$.ajax({
					type:'GET',
					url: '/group/applyReject',
					data: {'receiveUser': uid, 'bid': bid},
					success: function(result){
						mateuid2.style.display='none';
					}
				});
			}
	</script>
</body>
</html>