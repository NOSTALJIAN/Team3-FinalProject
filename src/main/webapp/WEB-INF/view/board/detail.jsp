<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%	pageContext.setAttribute("newline", "\n"); %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <%@ include file="../common/heading.jsp" %>
    <link rel="stylesheet" href="/css/board.css">
    <style>
        .disabled-link { pointer-events: none; }
    </style>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${kakaoAppKey}&libraries=services"></script>
</head>

<body style="height: 2000px">
    <%@ include file="../common/top.jsp" %>

    <div class="container" style="margin: 50px">
        <div class="row" style="justify-content: space-evenly">
			<div class="inputtb content-title pb-4">
				<div style="margin: 40px ">
					<button class="btn small subcolor"
						onclick="location.href='/board/list'">&lt; List</button>
				</div>
			</div>          
            <!-- =================== main =================== -->
            <div class="">
                <h3 class=""><strong>게시글 상세 조회</strong>
                	<span style="font-size: 0.6em; margin-left: 300px" >
                		 <button onclick="location.href='/board/list'" class="btn-hover color-8 " type="button" value="글쓰기">목록</button>
                    
                    <!-- 본인만 수정 가능 -->
                    <c:if test="${b.uid eq uid}">
                		 <button onclick="location.href='/board/update?bid=${b.bid}'" class="btn-hover color-8 " type="button" value="글쓰기">수정</button>                 
                    </c:if>
                    <c:if test="${b.uid ne uid}">
                        <a href="#" class="ms-3 disabled-link"><i class="far fa-edit"></i> 수정</a>  
                    </c:if>
                    
                    <!-- 본인만 삭제 가능 -->
                    <c:if test="${b.uid eq uid}">
                    	 <button onclick="location.href='/board/delete?bid=${b.bid}'" class="btn-hover color-8 " type="button" value="글쓰기">삭제</button>                                          
                    </c:if>
                    <c:if test="${b.uid ne uid}">
                        <a href="#" class="ms-3 disabled-link"><i class="fas fa-trash-alt"></i> 삭제</a>
                    </c:if>
                    </span>
                </h3> 
                <hr>
                </div>
                <div class="detail-title">
                	<!-- 이미지 -->
                	<div class="detailbox">
                		<img src="/board/download?file=${b.bFiles }" class="img-size" />
                	</div>
                	<div class="space"></div>
                	<!-- Info -->	
                    <div class="">
	                    <table class="board-view-infomation">
	                    	<tr style="width: 100px">
	                        	<th>${b.bTitle}</th>
	                        </tr>
	                        <tr>
								<th>작성 일자</th>
								<td> ${fn:replace(b.bRegTime, 'T', ' ')}</td>
							</tr>
							<tr>
								<th>운동 종목</th>
								<td>${b.bCategory}</td>
							</tr>
							<tr>
								<th>운동 장소</th>
								<td>${b.bLocation}</td>
							</tr>
							<tr>
								<th>운동 일자</th>
								<td>${fn:replace(b.bAppointment, 'T', ' ')}</td>
							</tr>
							<tr>
								<th>운동 인원</th>
								<td>${b.bUserCount}명</td>
							</tr>
	                     </table>
                    </div>
                    
                   <div class="col-12"><hr></div>
                   <div class="board-view-content">
                        ${fn:replace(b.bContent, newline, '<br>')}
                   </div>
                </div>
            </div>
        <div id="map" style="width:50%;height:350px;"></div>
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
		</div>
	

</body>
</html>