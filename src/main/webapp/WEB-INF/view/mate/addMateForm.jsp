<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<meta charset="UTF-8">
	  <link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Cormorant+Garamond:wght@500&display=swap" rel="stylesheet">
	
	<title>친구 신청 확인창</title>
		<link rel="stylesheet" href="/css/board.css">
		<style type="text/css">
		  table {
    width: 100%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;
  }
  </style>
</head>
<body>
	<%@ include file="../common/top.jsp" %>
	  <div class="container" style="margin-top: 150px;">
         <div class="row frame">
            <div class="col custom-btn btn-5">
                <a class="nav-link fs-5" href="/mate/addMateForm" aria-label="A sample content page">보낸 친구신청</a></div>
            <div class="col custom-btn btn-5">
                <a class="nav-link fs-5" href="/mate/receiveMateForm" aria-label="A sample content page">받은 친구신청</a></div>
            <div class="col custom-btn btn-5">
                <a class="nav-link fs-5" href="/mate/mateForm" aria-label="A sample content page">친구목록</a></div>
            <div class="col custom-btn btn-5">
                <a class="nav-link fs-5" href="/matching/condition" aria-label="A sample content page">매칭조건</a></div>
        </div>
    </div>
    
    <div class="mypage">
    	<h3>보낸 신구신청</h3>
		<%-- <c:forEach var="add" items="${addMateList}">
			<div>
				<p>상대방아이디 : ${add.receiveUser}</p>
				<p>보낸시간 : ${add.sendTime}</p>
				<button onclick="addMate('${add.receiveUser}')"  id="${add.receiveUser}" class="btn-hover color-8 write-btn">친구신청중</button>
			</div> --%>
			<table>
				<thead>
					<tr>
						<th>아이디</th>
						<th>관심운동</th>
						<th>성별</th>
						<th>나이</th>
						<th>친구신청 상태</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="add" items="${addMateList}">
					<tr>
						<td>${add.receiveUser}</td>
						<td>[농구,테니스,수영]</td>
						<td>[성별]</td>
						<td>[남/여]</td>
						<td><button onclick="addMate('${add.receiveUser}')"  id="${add.receiveUser}" class="btn-hover color-8 write-btn">친구신청중</button></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
	</div>
	
	
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