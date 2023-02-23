<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
<link rel="stylesheet" href="/css/sidebars.css">
	<meta charset="UTF-8">
	<title>친구창</title>
	<style type="text/css">
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
		  width: 70px; height: 70px;
		  }
    </style>
</head>
<body style="margin-bottom: 100px; background-color: black; color: white;">
	<%@ include file="../common/top.jsp" %>
	<div style="display: flex;">
		<%@ include file="../common/sidebar.jsp" %>
			<div class="myPage-size" style="margin-top: 60px; margin-left:180px;">
			<h5>친구목록</h5>
			<div style="margin-top: 30px;">
				<table>
					<thead>
						<tr>
							<th>프로필</th>
							<th>닉네임</th>
							<th>관심운동</th>
							<th>성별</th>
							<th>나이</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="mate" items="${mateList}">
						<tr>
							<td><img id="profileImg" src="/img/basicProfile.png" ></td>
							<td>${mate}</td>
							<td>[관심운동]</td>
							<td>[남/여]</td>
							<td>[24]</td>
							<td><button onclick="mateAccept('${re.uid}')" class="btn-hover color-8 " type="button">메세지</button></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<%-- <div class="mypage">
		<h4>친구 목록</h4>
		<c:forEach var="mate" items="${mateList}">
			<div>
				<p>친구아이디 : ${mate}</p>
			</div>
		</c:forEach>
	</div> --%>
</body>
</html>
