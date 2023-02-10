<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<link rel="stylesheet" href="/css/board.css">
	<meta charset="UTF-8">
	<script src="https://cdn.ckeditor.com/4.18.0/standard/ckeditor.js"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${kakaoAppKey}&libraries=services"></script>
	<link rel="stylesheet" href="/css/map.css" />
</head>

<body style="margin: 100px ">
	<%@ include file="../common/top.jsp" %>
	<div class="container" >
		<div class="inputtb content">
				<!-- 타이틀 -->
				<div class="board-title" >
				<table>
					<tr>
						<td class="col-6" style="text-align: left;"><h3 class="board-title"><strong>게시글 수정</strong></h3></td>
						<td class="col-2">
							<button onclick="location.href='/board/list'" class="btn-hover color-8 ">목록</button>
						</td>
					</tr>
				</table>
				</div>
				<!-- 타이틀 끝 -->
				<div class="write-zone center ">
				<form action="/board/update" class="content-center" method="post" enctype="multipart/form-data">
					<input type="hidden" name="uid" value="${sessionUid}" />
					<input type="hidden" name="bid" value="${b.bid}" />
					<input type="hidden" name="bAddr" id="bAddr" value="${b.bAddr}"/>
					<input type="hidden" name="bFileName" value="${b.bFiles}">
					<table class="board-desc" style="margin-left: 230px;">
						<tr>
							<td><input style="border: 1px solid #808080;"
								class="board-input" type="text" placeholder="제목" name="bTitle" value="${b.bTitle}"
								maxlength="128" required /></td>
						</tr>
						<tr>
							<td><input style="border: 1px solid #808080;"
								class="board-input" type="text" placeholder="운동장소" name="bLocation" value="${b.bLocation}"
								 id="bLocation" maxlength="128" required/></td>
						</tr>
						<tr>
							<td><input style="border: 1px solid #808080;"
								class="board-input" type="number" placeholder="인원수" name="bUserCount" value="${b.bUserCount}"/></td>
						</tr>
						<tr>
							<td><input style="border: 1px solid #808080;"
								class="board-input" type="datetime-local" placeholder="운동시간" name="bAppointment" value="${b.bAppointment}" maxlength="128" /></td>
						</tr>
						<tr>
							<td>
								<select name="bCategory" class="board-input" style="border: 1px solid #808080;">
									<c:forEach var="sports" items="${sportsArray}">
										<option value="${sports}" ${b.bCategory eq sports ? "selected" : ""}>${sports}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td><input style="border: 1px solid #808080;" class="board-input" type="file" name="bFiles"/>${b.bFiles}</td>
						</tr>
					
						<tr>
							<td><textarea class="board-input" name="bContent" placeholder="내용" maxlength="5000" rows="10">${b.bContent}</textarea></td>
						</tr>
					</table>
					<div class="buttons" style="margin-left: 15px; margin-top: 10px;">
						<button class="btn-hover color-8 write-btn" type="submit" value="글쓰기">수정</button>
						<button class="btn-hover color-8 write-btn" type="reset" value="취소">취소</button>
					</div>
				</form>
			</div>
		</div>
		
		<div class="map_wrap"  style="margin-top: -100px;">	
		    <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
		    <div id="menu_wrap" class="bg_white">
		        <div class="option">
		            <div>
		                키워드 : <input type="text" value="${b.bLocation}" id="keyword" size="15">
		                <form onsubmit="searchPlaces(); return false;">
		                    <button type="submit">검색하기</button> 
		                </form>
		            </div>
		        </div>
		        <hr>
		        <ul id="placesList"></ul>
		        <div id="pagination"></div>
		    </div>
	    </div>
	    <script src="/js/map.js?q=1"></script>
    </div>
    
	
	<script>
		CKEDITOR.replace('bContent', {
			filebrowserImageUploadUrl : '/board/upload',
			filebrowserUploadMethod : 'form',
			height : 400
		})
	</script>
</body>
</html>