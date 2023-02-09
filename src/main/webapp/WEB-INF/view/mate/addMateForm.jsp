<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<meta charset="UTF-8">
	<title>친구 신청 확인창</title>
</head>
<body>
	<%@ include file="../common/top.jsp" %>
	<br><br><br><br>
	<h3>친구 추가 신청 상태</h3>
	<hr>
	<c:forEach var="add" items="${addMateList}">
	<div>
		<p>상대방아이디 : ${add.receiveUser}</p>
		<p>보낸시간 : ${add.sendTime}</p>
		<button onclick="addMate('${add.receiveUser}')" style="background-color:black; color:white;" id="${add.receiveUser}">친구신청중</button>
	</div>
	</c:forEach>
	
	<script>
	function addMate(uid){
		  const mateuid = document.getElementById(uid);
		  if (mateuid.innerText =='친구신청'){
			  $.ajax({
				type:'GET',
				url: '/mate/addMate',
				data: {'receiveUser': uid},
				success: function(result){
					mateuid.innerText = result;
					console.log(result);
					mateuid.style.cssText = 'background-color:black; color:white;'
				}
			  });
		  }
		  else if (mateuid.innerText =='친구신청중'){
			  $.ajax({
				type:'GET',
				url: '/mate/mateCancle',
				data: {'receiveUser': uid},
				success: function(result){
					mateuid.innerText = result;
					console.log(result);
					mateuid.style.cssText = 'background-color:white; color:black;'
				}
			  });
		  }
	  }
	</script>
</body>
</html>