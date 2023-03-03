<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>

<head>
	<%@ include file="../common/heading.jsp" %>
		<meta charset="UTF-8">
		<script src="https://cdn.ckeditor.com/4.18.0/standard/ckeditor.js"></script>
		<script type="text/javascript"
			src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${kakaoAppKey}&libraries=services"></script>
		<link rel="stylesheet" href="/css/map.css" />
		<style type="text/css">
		input {background-color: lightgray;
		}
		</style>
</head>

<body style="margin-bottom: 500px; background: black; ">
	<%@ include file="../common/top.jsp" %>
	<div style="display: flex;">
		<div class="container">
			<div class="inputtb content">
				<!-- 타이틀 -->
				<div class="board-title">
					<table>
						<tr>
							<td class="col-8">
								<h3 class="board-title" style="color: white;"><strong>게시글 쓰기</strong></h3>
							</td>
							<td class="col-2">
								<button onclick="location.href='/board/list'" class="btn-hover color-8" style="width: 100px;">목록</button>
							</td>
						</tr>
					</table>
				</div>
				<!-- 타이틀 끝 -->
				<div class="write-zone center ">
					<form name="detail_sub" action="/board/write" class="content-center" method="post" enctype="multipart/form-data">
						<input type="hidden" name="uid" value="${sessionUid}" />
						<input type="hidden" name="bAddr" id="bAddr" />
						<table style="margin-left: 230px;">
							<tr>
								<td><input style="border: 1px solid #808080;background-color: lightgray;" class="board-input" type="text" placeholder="*제목"
										id="bTitle" name="bTitle" maxlength="128" required />
								</td>
							</tr>
							<tr>
								<td><input style="border: 1px solid #808080;background-color: lightgray;" class="board-input" type="number" placeholder="*모집인원"
										id="bUserCount" name="bUserCount" />
								</td>
							</tr>
							<tr>
								<td><input style="border: 1px solid #808080;background-color: lightgray;" class="board-input" type="datetime-local"
										placeholder="운동시간" id="bAppointment" name="bAppointment" maxlength="128" />
								</td>
							</tr>
							<tr>
								<td>
									<select id="bCategory" name="bCategory" class="board-input" style="border: 1px solid #808080 background-color: lightgray;">
										<c:forEach var="sports" items="${sportsArray}">
											<option value="${sports}">${sports}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td><input style="border: 1px solid #808080; background-color: lightgray;" class="board-input" type="text"
										placeholder="*우측지도에서 운동장소를 검색해주세요" id="bLocation" name="bLocation" maxlength="128" required />
								</td>
							</tr>
							<tr>
								<td><textarea class="board-input" style="border: 1px solid #808080;" id="bContent" name="bContent" placeholder="내용"
										maxlength="5000" rows="10"></textarea></td>
							</tr>
						</table>

					</div>
					<!-- 타이틀 끝 -->
					<div class="write-zone center ">
						<form action="/board/write" class="content-center" method="post" enctype="multipart/form-data">
							<input type="hidden" name="uid" value="${sessionUid}" />
							<input type="hidden" name="bAddr" id="bAddr" />
							<table style="margin-left: 230px;">
								<tr>
									<td><input style="border: 1px solid #808080;background-color: lightgray;" class="board-input" type="text" placeholder="*제목"
											name="bTitle" maxlength="128" required /></td>
								</tr>
								<tr>
									<td><input style="border: 1px solid #808080;background-color: lightgray;" class="board-input" type="number" placeholder="*모집인원"
											name="bUserCount" /></td>
								</tr>
								<tr>
									<td><input style="border: 1px solid #808080;background-color: lightgray;" class="board-input" type="datetime-local"
											placeholder="운동시간" name="bAppointment" maxlength="128" /></td>
								</tr>
								<tr>
									<td>
										<select name="bCategory" class="board-input" style="border: 1px solid #808080 background-color: lightgray;">
											<c:forEach var="sports" items="${sportsArray}">
												<option value="${sports}">${sports}</option>
											</c:forEach>
										</select>
									</td>
								</tr>
								<tr>
									<td><input style="border: 1px solid #808080; background-color: lightgray;" class="board-input" type="text"
											placeholder="*우측지도에서 운동장소를 검색해주세요" name="bLocation" id="bLocation" maxlength="128" required />
									</td>
								</tr>
								<tr>
									<td><textarea class="board-input" style="border: 1px solid #808080;" name="bContent" placeholder="내용"
											maxlength="5000" rows="10"></textarea></td>
								</tr>
							</table>
							<div class="btn-place" style="margin-left:160px;">
								<button class="btn-hover color-9 write-btn" type="submit" value="글쓰기"
									style="margin-left: -110px;">글쓰기</button>
								<button class="btn-hover color-8 write-btn" type="reset" value="취소" style="margin-left: 40px;">취소</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="map_wrap" style="margin-top: 150px; margin-right: 120px;">
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
	</div>
	<%@ include file="../common/bottom1.jsp" %>	
			
	<script src="/js/map.js?q=1"></script>
	<script>
		// const test = document.querySelector("input[type=datetime-local]");
		// test.addEventListener("mouseover", () => {
		// 	console.log(test.value);
		// 	console.log(test.type);
		// });

		CKEDITOR.replace('bContent', {
			filebrowserImageUploadUrl: '/board/upload',
			filebrowserUploadMethod: 'form',
			height: 400
		})
		
		function detail_submit(){
			const bTitle = $('#bTitle').val();
			const bUserCount = $('#bUserCount').val();
			const bAppointment = $('#bAppointment').val();
			const bCategory = $('#bCategory').val();
			const bLocation = $('#bLocation').val();
			const bContent = CKEDITOR.instances.bContent.getData()
			console.log(bAppointment);
			
			if (bTitle == '') {
				alert('제목을 작성해 주세요.');
				return false;
			} else if (bUserCount == '') {
				alert('모집인원을 작성해주세요.');
				return false;
			} else if (bAppointment == '') {
				alert('운동 시간을 작성해주세요.');
				return false;
			} else if (bCategory == '') {
				alert('카테고리를 설정해주세요.');
				return false;
			} else if (bLocation == '') {
				alert('장소를 지도에서 검색해 입력해주세요.');
				return false;
			} else if (bContent == '') {
				alert('내용을 입력해주세요');
				return false;
			} else {
				const detail_sub = document.detail_sub;
				detail_sub.submit(); 
			}
		}
	</script>
</body>

</html>