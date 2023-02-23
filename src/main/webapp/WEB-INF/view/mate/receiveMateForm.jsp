<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
<link rel="stylesheet" href="/css/sidebars.css">
	<meta charset="UTF-8">
	<title>친구 수락창</title>
	<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Cormorant+Garamond:wght@500&display=swap" rel="stylesheet">
	<style type="text/css">
		  table {
		    width: 1300px;
		    border-top: 1px solid #444444;
		    border-collapse: collapse;
		  }
		  th, td {
		    border-bottom: 1px solid #444444;
		    padding: 3px;
		  }
		  img {
		  	width: 70px; height: 70px;
		  }
    </style>
</head>
<body style="margin-bottom: 100px; background-color: black; color: white;">
	<%@ include file="../common/top.jsp" %>
	<div style="display: flex;">
		<%@ include file="../common/sidebar.jsp" %>
		<div class="myPage-size" style="margin-top: 60px; margin-left: 180px;">
			<h5>받은 친구신청</h5>
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
					<c:forEach var="re" items="${receiveMateList}">
						<tr id="${re.uid}">
							<td><img id="profileImg" src="/img/basicProfile.png" ></td>
							<td>${re.uid}</td>
							<td>[관심운동]</td>
							<td>[성별]</td>
							<td>[나이]</td>
							<td>${fn:replace(re.sendTime, 'T', ' ')}</td>
							<td><button onclick="mateAccept('${re.uid}')" class="btn-hover color-9" >수락</button></td>
							<td><button onclick="mateReject('${re.uid}')" class="btn-hover color-8" >거절</button></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<script>
	function mateAccept(uid){
		const mateuid1 = document.getElementById(uid);
		$.ajax({
				type:'GET',
				url: '/mate/mateAccept',
				data: {'receiveUser': uid},
				success: function(result){
					mateuid1.style.display='none';
				}
			});
		}
	function mateReject(uid){
		const mateuid2 = document.getElementById(uid);
		$.ajax({
				type:'GET',
				url: '/mate/mateReject',
				data: {'receiveUser': uid},
				success: function(result){
					mateuid2.style.display='none';
				}
			});
		}
	</script>
</body>
</html>