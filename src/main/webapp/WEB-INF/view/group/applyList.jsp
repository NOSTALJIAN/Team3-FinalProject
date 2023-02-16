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
<style>
.frame {
  width: 90%;
  margin: 40px auto;
  text-align: center;
}
button {
  margin: 20px;
  outline: none;
}
.custom-btn {
  width: 130px;
  height: 40px;
  padding: 10px 25px;
  border: 2px solid #000;
  font-family: 'Lato', sans-serif;
  font-weight: 500;
  background: transparent;
  cursor: pointer;
  transition: all 0.3s ease;
  position: relative;
  display: inline-block;
}

/* 5 */
.btn-5 {
  background: #000;
  color: #fff;
  line-height: 42px;
  padding: 0;
  border: none;
}
.btn-5:hover {
  background: transparent;
  color: #000;
   box-shadow:
   -7px -7px 20px 0px #fff9,
   -4px -4px 5px 0px #fff9,
   7px 7px 20px 0px #0002,
   4px 4px 5px 0px #0001;
}
.btn-5:before,
.btn-5:after{
  content:'';
  position:absolute;
  top:0;
  right:0;
  height:2px;
  width:0;
  background: #000;
  transition:400ms ease all;
}
.btn-5:after{
  right:inherit;
  top:inherit;
  left:0;
  bottom:0;
}
.btn-5:hover:before,
.btn-5:hover:after{
  width:100%;
  transition:800ms ease all;
}
</style>
</head>
<body>
	<%@ include file="../common/top.jsp" %>
	 <div class="container" style="margin-top: 150px;">
         <div class="row frame">
            <div class="col custom-btn btn-5">
                <a class="nav-link fs-5" href="/boardMypage/myWrite" aria-label="A sample content page">작성글</a></div>
            <div class="col custom-btn btn-5">
                <a class="nav-link fs-5" href="/boardMypage/applyList" aria-label="A sample content page">신청글</a></div>
            <div class="col custom-btn btn-5">
                <a class="nav-link fs-5" href="/boardMypage/applyDone" aria-label="A sample content page">신청완료</a></div>
        </div>
    </div>
    <div class="mypage">
    	<h3>그룹운동 신청현황</h3>
		<table>
			<thead>
				<tr>
					<th>게시글 번호</th>
					<th>제목</th>
					<th>운동종목</th>
					<th>운동장소</th>
					<th>운동시간</th>
					<th>총인원</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="apply" items="${applyList}">
				<tr>
					<td>${apply.bid}</td>
					<td>${apply.bTitle}</td>
					<td>${apply.bCategory}</td>
					<td>${apply.bLocation}</td>
					<td>${apply.bAppointment}</td>
					<td>${apply.bUserCount}</td>
					<td><button class="btn-hover color-8 write-btn">참가신청중</button></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- 참가 신청 -->
	<script>
		function apply(bid, uid){
			  const applybid = document.getElementById(bid);
			  console.log(bid, uid);
			  if (applybid.innerText == '참가신청'){
				  $.ajax({
					type:'GET',
					url: '/group/apply',
					data: {'bid': bid, 'receiveUser': uid},
					success: function(result){
						applybid.innerText = result;
						console.log(result);
						applybid.style.cssText = 'background-color:black; color:white;'
					}
				  });
			  }
			  else if (applybid.innerText == '참가신청중'){
				  $.ajax({
					type:'GET',
					url: '/group/applyCancel',
					data: {'bid': bid, 'receiveUser': uid},
					success: function(result){
						applybid.innerText = result;
						console.log(result);
						applybid.style.cssText = 'background-color:white; color:black;'
					}
				  });
			  }
		  }
	</script>
		
</body>
</html>