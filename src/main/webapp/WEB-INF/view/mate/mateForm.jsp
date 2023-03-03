<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

				th,
				td {
					border-bottom: 1px solid #444444;
					padding: 5px;
				}

				img {
					width: 70px;
					height: 70px;
					border-radius: 70%;
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
									<c:forEach var="m" items="${mateList}">
										<tr id="${m.receiveUser}">
											<c:if test="${empty m.uImage}">
												<td><img src="/img/basicProfile.png"></td>
											</c:if>
											<c:if test="${not empty m.uImage}">
												<td><img src="/board/download?file=${m.uImage}"></td>
											</c:if>
											<td>${m.nickname}</td>
											<td>${m.likeExerList}</td>
											<td>${m.gender}</td>
											<td>${m.age}</td>
											<!-- <td><button onclick="window.open('http://localhost:8080/chat/${m.receiveUser}')" -->
											<td><button onclick="window.open('http://localhost:8080/chat')" class="btn-hover color-9"
													style="width: 110px;">채팅</button>
												<button onclick="mateDelete('${m.receiveUser}')" class="btn-hover color-8"
													style="width: 125px;">친구끊기</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
			</div>
			<script>
				function mateDelete(mateId) {
					if (confirm("친구관계를 끊으시겠습니까?")) {
						const mateForm = document.getElementById(mateId);
						$.ajax({
							type: 'GET',
							url: '/mate/mateDelete',
							data: { 'mateId': mateId },
							success: function (result) {
								mateForm.style.display = 'none';
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