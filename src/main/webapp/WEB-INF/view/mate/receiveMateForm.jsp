<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<meta charset="UTF-8">
	<title>친구 수락창</title>
	<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Cormorant+Garamond:wght@500&display=swap" rel="stylesheet">
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
		
   <%--  <div class="mypage">
		<c:forEach var="re" items="${receiveMateList}">
			<div id="${re.uid}">
				<p>아이디 : ${re.uid}</p>
				<p>보낸시간 : ${fn:replace(re.sendTime, 'T', ' ')}</p>
				<button onclick="mateAccept('${re.uid}')" class="btn-hover color-8 write-btn">수락</button>
				<button onclick="mateReject('${re.uid}')" class="btn-hover color-8 write-btn">거절</button>
			</div>
		</c:forEach>
	</div> --%>
	
	<div class="mypage">
		<h3>받은 친구신청</h3>
			<table>
				<thead>
					<tr>
						<th>프로필</th>
						<th>아이디</th>
						<th>관심운동</th>
						<th>성별</th>
						<th>나이</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="re" items="${receiveMateList}">
					<tr id="${re.uid}">
						<td>[프로필]</td>
						<td>${re.uid}</td>
						<td>[농구,테니스,수영]</td>
						<td>[성별]</td>
						<td>[남/여]</td>
						<td><button onclick="mateAccept('${re.uid}')" class="btn-hover color-8 write-btn">수락</button></td>
						<td><button onclick="mateReject('${re.uid}')" class="btn-hover color-8 write-btn">거절</button></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
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