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
  h6 {
  display: inline-block;
  position: relative;
  text-align: center;
  font-size: 1.5em;
  color: linear-gradient(to right, #29323c, #485563, #2b5876, #4e4376);
  
}
h6:before {
  content: "\25C0";
  position: absolute;
  left: -50px;
  -webkit-animation: leftRight 2s linear infinite;
  animation: leftRight 2s linear infinite;
}
h6:after {
  content: "\25b6";
  position: absolute;
  right: -50px;
  -webkit-animation: leftRight 2s linear infinite reverse;
  animation: leftRight 2s linear infinite reverse;
}
</style>
</head>
<body  style="margin-bottom: 100px; background-color: black; color: white;">
	<%@ include file="../common/top.jsp" %>
	<div style="display: flex;">
		<%@ include file="../common/sidebar.jsp" %>
			<div class="myPage-size" style="margin-top: 60px; margin-left: 180px;">
			<div style="display: flex;">
			<h5>그룹운동 참가자 목록</h5>
			<c:forEach var="gm" items="${groupMateList}" varStatus="loop">
				<c:if test="${loop.first}">
    				<h6 style="margin-left: 250px;margin-top:-3px; font-size: 23px;"onclick="location.href='/board/detail?bid=${gm.bid}&uid=${gm.uid}'">${gm.bid}. ${gm.bTitle}</h6>
    			</c:if>
    		</c:forEach>
    		<button class="btn-hover color-9 write-btn" style="margin-left: 300px;margin-top: -15px;margin-bottom: -45px;width: 115px;">
    			그룹채팅</button>
    		</div>
    		<div style="margin-top: 20px;">
				<table>
					<thead>
						<tr>
							<th>프로필</th>
							<th>닉네임</th>
							<th>관심운동</th>
							<th>성별</th>
							<th>나이</th>
							<!-- <th>신청시간</th> -->
						</tr>
					</thead>
					<tbody>
					<c:forEach var="gm" items="${groupMateList}" varStatus="status">
						<tr id="${gm.uid}">
							<td><img src="/board/download?file=${infoList[status.index].uImage}" ></td>
							<td>${infoList[status.index].nickname}</td>
							<td>${infoList[status.index].coincideExer}</td>
							<td>${gm.gender}</td>
							<td>${infoList[status.index].age}</td>
							<%-- <td>${fn:replace(gm.sendTime, 'T', ' ')}</td> --%>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<%@ include file="../common/bottom1.jsp" %>
</body>
</html>