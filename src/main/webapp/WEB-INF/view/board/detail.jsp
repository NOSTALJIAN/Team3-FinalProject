<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%	pageContext.setAttribute("newline", "\n"); %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <%@ include file="../common/heading.jsp" %>
    <style>
        .disabled-link { pointer-events: none; }
		    table {
		    width: 300px;
		    height: 300px;
		    border-top: 1px solid #444444;
		    border-collapse: collapse;
		  }
		  th, td {
		    border-bottom: 1px solid #444444;
		    padding: 3px;
		    padding-top: 0.1px;
		    padding-bottom: 1px;
		  }
    </style>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${kakaoAppKey}&libraries=services"></script>
</head>

<body>
	<%@ include file="../common/top.jsp" %>
	<div class="container" style="margin: 120px; padding-bottom: 400px;">
		<div class="row" style="justify-content: space-evenly">
			<!-- =================== main =================== -->
			<div class="">
				<h3 class=""><strong>${b.bTitle}</strong></h3>
				<span style="font-size: 0.6em; margin-left: 200px;" >
					<button onclick="location.href='/board/list'" class="btn-hover color-8 ms-5 col-2" style="width: 100px" type="button" value="글쓰기">목록</button>
					
					<!-- 본인만 수정 가능 -->
					<c:if test="${b.uid eq sessionUid}">
						<button onclick="location.href='/board/update?bid=${b.bid}'" class="btn-hover color-8 ms-3 col-2" style="width: 100px" type="button" value="수정">수정</button>
					</c:if>
					<c:if test="${b.uid ne sessionUid}">
						<!--   <a href="#" class="ms-3 disabled-link"><i class="far fa-edit"></i> 수정</a>   -->
					</c:if>
					
					<!-- 본인 또는 관리자만 삭제 가능 -->
					<c:if test="${b.uid eq sessionUid || b.uid eq 'admin'}">
						<button onclick="location.href='/board/delete?bid=${b.bid}'" class="btn-hover color-8 ms-3 col-2" style="width: 100px" type="button" value="삭제">삭제</button>
					</c:if>
					<c:if test="${b.uid ne sessionUid}">
						<!--  <a href="#" class="ms-3 disabled-link"><i class="fas fa-trash-alt"></i> 삭제</a> -->
					</c:if>
				</span>
				<hr>
			</div>
			<div class="detail-title">
				<!-- 이미지 -->
				<div class="detailbox">
					<img src="/board/download?file=${b.bFiles}" class="img-size rounded-3" style="margin-top: 50px;" />
				</div>
				<div class="space"></div>
				<!-- Info -->	
				<div class="">
					<table class="" style="margin-left: 650px; margin-top:-14px; width: 400px;height: 400px;">
						<tr>
							<th>운동 종목</th>
							<td>${b.bCategory}</td>
						</tr>
						<tr>
							<th>운동 일자</th>
							<td> ${fn:replace(b.bAppointment, 'T', ' ')}</td>
						</tr>
						<tr>
							<th>운동 장소</th>
							<td>${b.bLocation}</td>
						</tr>
						<tr>
							<th>운동 인원</th>
							<td>${b.bUserCount}명</td>
						</tr>
						<tr>
							<th>작성 일자</th>
							<td>${fn:replace(b.bRegTime, 'T', ' ')}</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td>${b.uid}</td>
						</tr>
					</table>
				</div>
				<div class="col-12"><hr></div>
            
				<div class="board-view-content rounded-3" style="text-align: left;">
					${fn:replace(b.bContent, newline, '<br>')}
				</div>
				<div class="board-view-map" id="map"></div>
        	
        	
				<!-- 댓글 -->
				<div class="col-12"></div>
				<div class="col-12" style="margin-top: 450px">
					<c:forEach var="reply" items="${replyList}" varStatus="loop">
						<c:if test="${reply.rIsMine eq 0}">
							<div class="d-flex flex-row mt-1">
								<div class="card bg-light text-dark w-75">
									<div class="card-body" id="reply${loop.count}">		
										${reply.uid}&nbsp;&nbsp;${fn:replace(reply.rRegTime,'T',' ')}
										<c:if test="${reply.uid eq sessionUid}">
											<button onclick="replyUpdate('block', ${loop.count})" style="float: right">수정</button>
											<button onclick="deleteConfirm(${b.bid}, ${reply.rid})" style="float: right">삭제</button>
										</c:if><br>    <!-- uname, regTime-->
										${fn:replace(reply.rContent, newline, '<br>')}  <!-- content -->
									</div>
									<!-- 댓글 수정기능 추가  -->
									<form class="form-inline d-none" action="/board/replyUpdate" id="replyUpdate${loop.count}" method="post">
										<input type="hidden" name="bid" value="${b.bid}">     <!-- bid -->
										<input type="hidden" name="uid" value="${b.uid}">     <!-- uid -->
										<input type="hidden" name="rid" value="${reply.rid}">     <!-- rid -->
										<table class="table table-borderless mt-2">
											<tr class="d-flex">
												<td class="col-2 text-end">
													<label for="rContent">댓글수정</label>
												</td>
												<td class="col-6">
													<textarea class="form-control" id="rContent" name="rContent" rows="3">${fn:replace(reply.rContent, newline, '<br>')}</textarea>
												</td>
												<td class="col-4">
													<button type="submit" class="btn btn-primary">수정</button>
													<button onclick="replyUpdate('none', ${loop.count})" class="btn btn-primary">취소</button>
												</td>
											</tr>
										</table>
									</form>
								</div>
							</div>
						</c:if>
						<c:if test="${reply.rIsMine eq 1}">
							<div class="d-flex flex-row-reverse mt-1">
								<div class="card w-75">
									<div class="card-body text-end" id="reply${loop.count}">		
										${reply.uid}&nbsp;&nbsp;${fn:replace(reply.rRegTime,'T',' ')}
										<c:if test="${reply.uid eq sessionUid}">
											<button onclick="replyUpdate('block', ${loop.count})" style="float: right">수정</button>
											<button onclick="deleteConfirm(${b.bid}, ${reply.rid})" style="float: right">삭제</button>
										</c:if><br>    <!-- uname, regTime-->
										${fn:replace(reply.rContent, newline, '<br>')}  <!-- content -->
									</div>
									<!-- 댓글 수정기능 추가  -->
									<form class="form-inline d-none" action="/board/replyUpdate" id="replyUpdate${loop.count}" method="post">
										<input type="hidden" name="bid" value="${b.bid}">     <!-- bid -->
										<input type="hidden" name="uid" value="${b.uid}">     <!-- uid -->
										<input type="hidden" name="rid" value="${reply.rid}">     <!-- rid -->
										<table class="table table-borderless mt-2">
											<tr class="d-flex">
												<td class="col-1 text-end">
													<label for="rContent">댓글수정</label>
												</td>
												<td class="col-9">
													<textarea class="form-control" id="rContent" name="rContent" rows="3">${fn:replace(reply.rContent, newline, '<br>')}</textarea>
												</td>
												<td class="col-2">
													<button type="submit" class="btn btn-primary">수정</button>
													<button onclick="replyUpdate('none', ${loop.count})" class="btn btn-primary">취소</button>
												</td>
											</tr>
										</table>
									</form>
								</div>
							</div>
						</c:if>
					</c:forEach>
					<c:if test="${not empty sessionUid}">
						<form class="form-inline" action="/board/reply" method="post">
							<input type="hidden" name="bid" value="${b.bid}">     <!-- bid -->
							<input type="hidden" name="uid" value="${b.uid}">     <!-- uid -->
							<table class="table table-borderless mt-2">
								<tr class="d-flex">
									<td class="col-1 text-end">
										<label for="rContent">댓글</label>
									</td>
									<td class="col-9">
										<textarea class="form-control" id="rContent" name="rContent" rows="3"></textarea>
									</td>
									<td class="col-2">
										<button type="submit" class="btn-hover color-8">제출</button>
									</td>
								</tr>
							</table>
						</form>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<!-- 지도 -->
	<script>
	  var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	      mapOption = {
	          center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	          level: 3 // 지도의 확대 레벨
	      };  
	
	  // 지도를 생성합니다    
	  var map = new kakao.maps.Map(mapContainer, mapOption); 
	
	  // 주소-좌표 변환 객체를 생성합니다
	  var geocoder = new kakao.maps.services.Geocoder();
	
	  // 주소로 좌표를 검색합니다
	  var bAddr = '${b.bAddr}';
	  geocoder.addressSearch(bAddr, function(result, status) {
	
	      // 정상적으로 검색이 완료됐으면 
	       if (status === kakao.maps.services.Status.OK) {
	
	          var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	
	          // 결과값으로 받은 위치를 마커로 표시합니다
	          var marker = new kakao.maps.Marker({
	              map: map,
	              position: coords
	          });
	
	          // 인포윈도우로 장소에 대한 설명을 표시합니다
	          var infowindow = new kakao.maps.InfoWindow({
	              content: '<div style="width:150px;text-align:center;padding:6px 0;">${b.bLocation}</div>'
	          });
	          infowindow.open(map, marker);
	
	          // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	          map.setCenter(coords);
	      } 
	  });    
	</script>
	<!-- 댓글 수정/삭제 -->
	<script>
    	function deleteConfirm(bid, rid) {
			if(confirm("삭제하시겠습니까?")) {
			 	location.href = "/board/reply/delete?bid=" + bid + "&rid=" + rid;
				return true;
			} else {
				return false;
			}
		}
    	function replyUpdate(oc, replyNum) {
    		console.log(oc);
    		console.log(replyNum);
    		if (oc == "block"){
    			document.getElementById('reply'+replyNum).className = 'card-body d-none';
    			document.getElementById('replyUpdate'+replyNum).className = 'form-inline';
    		} else {
    			document.getElementById('reply'+replyNum).className = 'card-body';
    			document.getElementById('replyUpdate'+replyNum).className = 'form-inline d-none';
    		}
    	}
    </script>
    <!-- 게시판 검색 -->
    <script>
    	function search() {
    		const field = document.getElementById("field").value;
    		const query = document.getElementById("query").value;
    		console.log("search()", field, query);
    		location.href = "/board/list?p=${currentBoardPage}&f=" + field + "&q=" + query;
    	}
	</script>
<%@ include file="../common/top.jsp" %>
</body>
</html>