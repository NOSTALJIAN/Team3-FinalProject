<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<meta charset="UTF-8">
	<title>친구 수락창</title>
</head>
<body>
	<%@ include file="../common/top.jsp" %>
	<br><br><br><br>
	<h3>친구 수락/거절</h3>
	<hr>
	<c:forEach var="re" items="${receiveMateList}">
	<div id="${re.uid}">
		<p>보낸사람 : ${re.uid}</p>
		<p>보낸시간 : ${re.sendTime}</p>
		<button onclick="mateAccept('${re.uid}')">친구수락</button>
		<button onclick="mateReject('${re.uid}')">친구거절</button>
	</div>
	</c:forEach>
	
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