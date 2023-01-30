<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<meta charset="UTF-8">
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
				<form action="/board/write" class="pt-4 mx-3" method="post"
					enctype="multipart/form-data">
					<table class="inputtb board-desc">
						<tr>
							<td><input style="border: 1px solid #d1d1d1;"
								class="board-input" type="file" name="file" /></td>
						</tr>
						<tr>
							<td><input style="border: 1px solid #d1d1d1;"
								class="board-input" type="text" placeholder="제목" name="title"
								maxlength="128" required /></td>
						</tr>
						<tr>
							<td><input style="border: 1px solid #d1d1d1;"
								class="board-input" type="map" placeholder="운동장소" name="addr"
								maxlength="128" required /></td>
						</tr>
						<tr>
							<td><input style="border: 1px solid #d1d1d1;"
								class="board-input" type="number" placeholder="인원수"
								name="number" maxlength="128" /></td>
						</tr>
						<tr>
							<td><input style="border: 1px solid #d1d1d1;"
								class="board-input" type="time" placeholder="운동시간"
								name="Time" maxlength="128" /></td>
						</tr>
					<tr>
					<br>관심운동
					<br>축구<input onclick="limit(this)" type="checkbox" name="likeExercise" value="1">농구<input onclick="limit(this)" type="checkbox" name="likeExercise" value="2">야구<input onclick="limit(this)" type="checkbox" name="likeExercise" value="4">E-sports<input onclick="limit(this)" type="checkbox" name="likeExercise" value="8">
					<br>등산<input onclick="limit(this)" type="checkbox" name="likeExercise" value="16">당구<input onclick="limit(this)" type="checkbox" name="likeExercise" value="32">볼링<input onclick="limit(this)" type="checkbox" name="likeExercise" value="64">싸이클<input onclick="limit(this)" type="checkbox" name="likeExercise" value="128">
					<br>테니스<input onclick="limit(this)" type="checkbox" name="likeExercise" value="256">조깅<input onclick="limit(this)" type="checkbox" name="likeExercise" value="512">수영<input onclick="limit(this)" type="checkbox" name="likeExercise" value="1024">헬스<input onclick="limit(this)" type="checkbox" name="likeExercise" value="2048">
					</tr>
					
					
						<tr>
							<td><textarea class="board-input" name="content"
									placeholder="내용" maxlength="5000" rows="10"></textarea></td>
						</tr>
						<tr>
							<td colspan="2" class="multibtn pt-4"><input type="submit"
								class="btn full maincolor" value="글쓰기" /></td>
							<td><input type="reset"
								class="btn full subcolor" value="취소" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
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