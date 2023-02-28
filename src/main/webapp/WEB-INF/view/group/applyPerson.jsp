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
    width: 1300px;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;
  }
   img {
		  	width: 70px; height: 70px; border-radius: 70%;
		  }
</style>
</head>
<body  style="margin-bottom: 400px; background-color: black; color: white;">
	<%@ include file="../common/top.jsp" %>
	<div style="display: flex;">
		<%@ include file="../common/sidebar.jsp" %>
			<div class="myPage-size" style="margin-top: 60px; margin-left: 180px;">
			<div  style="display: flex;">
			     <h5>신청자 목록</h5>
			      <c:forEach var="re" items="${receiveList}">
	    			<h6 style="margin-left: 270px;">게시글 제목 : ${re.bTitle}</h6>
	    		</c:forEach>
			  </div>
				<!--  <h5>신청자 목록</h5>
				<c:forEach var="re" items="${receiveList}">
	    			<h6>${re.bTitle}</h6>
	    		</c:forEach>-->
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
							<c:if test="${empty re.uImage}">
							<td><img src="/img/basicProfile.png" ></td>
							</c:if>
							<c:if test="${not empty re.uImage}">
							<td><img src="/board/download?file=${infoList[status.index].uImage}" ></td>
							</c:if>
							<!-- <td>${infoList[status.index].uImage}</td> -->
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
			if(confirm("참가신청을 수락하겠습니까?")) {
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
				return true;
			} else {
				return false;
				}
			}
		function applyReject(uid, bid){
			if(confirm("참가신청을 거절하겠습니까?")) {
			const mateuid2 = document.getElementById(uid);
			$.ajax({
					type:'GET',
					url: '/group/applyReject',
					data: {'receiveUser': uid, 'bid': bid},
					success: function(result){
						mateuid2.style.display='none';
					}
				});
				return true;
			} else {
				return false;
				}
			}
	</script>
</body>
</html>