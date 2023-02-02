<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<meta charset="UTF-8">
	<script src="https://cdn.ckeditor.com/4.18.0/standard/ckeditor.js"></script>
	<link rel="stylesheet" href="/css/map.css" />
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${kakaoAppKey}&libraries=services"></script>
</head>

<body style="margin: 100px ">
	<%@ include file="../common/top.jsp" %>

	<div class="container" style="margin: 50px">
		<div class="row" style="justify-content: space-evenly" >

			<div class="inputtb content col-lg-8">
				<!-- 타이틀 -->
				<div class="inputtb content-title pb-4">
					<div style="margin: 40px ">
						<button class="btn small subcolor"
							onclick="location.href='/board/list'">&lt; List</button>
					</div>
				</div>
				<!-- 타이틀 끝 -->
				<form action="/board/write" class="pt-4 mx-3" method="post" enctype="multipart/form-data">
					<input type="hidden" name="uid" value="${sessionUid}">
					<input type="hidden" name="bAddr" id="bAddr">
					<table class="inputtb board-desc">
						<tr>
							<td><input style="border: 1px solid #d1d1d1;"
								class="board-input" type="text" placeholder="제목" name="bTitle"
								maxlength="128" required /></td>
						</tr>
						<tr>
							<td><input style="border: 1px solid #d1d1d1;"
								class="board-input" type="text" placeholder="운동장소" name="bLocation" id="bLocation"
								maxlength="128" required /></td>
						</tr>
						<tr>
							<td><input style="border: 1px solid #d1d1d1;"
								class="board-input" type="number" placeholder="인원수" name="bUserCount"/></td>
						</tr>
						<tr>
							<td><input style="border: 1px solid #d1d1d1;"
								class="board-input" type="datetime-local" placeholder="운동시간" name="bAppointment" maxlength="128" /></td>
						</tr>
						<tr>
							<td>
								관심운동<br>
								<select name="bCategory">
									<option value="축구">축구</option>
									<option value="농구">농구</option>
									<option value="야구">야구</option>
									<option value="E-sports">E-sports</option>
									<option value="등산">등산</option>
									<option value="당구">당구</option>
									<option value="볼링">볼링</option>
									<option value="싸이클">싸이클</option>
									<option value="테니스">테니스</option>
									<option value="조깅">조깅</option>
									<option value="수영">수영</option>
									<option value="헬스">헬스</option>
								</select>
							</td>
						</tr>
						<tr>
							<td><input style="border: 1px solid #d1d1d1;"
								class="board-input" type="file" name="files"/></td>
						</tr>
					
						<tr>
							<td><textarea class="board-input" name="bContent" placeholder="내용" maxlength="5000" rows="10"></textarea></td>
						</tr>
						<tr>
							<td colspan="2" class="multibtn pt-4"><input type="submit" class="btn full maincolor" value="글쓰기" /></td>
							<td><input type="reset" class="btn full subcolor" value="취소" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="map_wrap">	
		    <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
		    
		    <div id="menu_wrap" class="bg_white">
		        <div class="option">
		            <div>
		                키워드 : <input type="text" value="" id="keyword" size="15">
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
	    <script src="/js/map.js"></script>
    </div>
	
	<script>
		CKEDITOR.replace('content', {
			filebrowserImageUploadUrl : '/board/upload',
			filebrowserUploadMethod : 'form',
			height : 400
		});
	</script>
</body>
</html>