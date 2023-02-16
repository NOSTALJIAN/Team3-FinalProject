<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<link rel="stylesheet" href="/css/board.css">
	<style >
	body {
		padding: 10px; margin: 0px;
	}
	table {
		border-spacing: 50px;
	    }
	th, td {
		padding: 15px;
		padding-top: 10px;
	    padding-bottom: 20px;
	    padding-left: 30px;
	    padding-right: 40ox;
	   }
	</style>
</head>
<body style="margin-left: 400px; margin-top: 180px; margin-bottom: 100px; background-color: black;" class="register">
	<%@ include file="../common/top.jsp" %>
	<h3 style="color: white;">회원 정보 수정</h3>
	<hr style="color: white;">
	<form name="reg_sub" action="/user/update" method="post" class="mb-auto col-12 text">
		<input type="hidden" id="likeExerList" value="${likeExerList}"/>
		<table>
			<tr>
				<th>이메일</th>
				<td><input style="width: 250px;" class="form-control  bg-gray-800 border-dark" type="email" name="email" value="${user.email}" maxlength="40"  />
				</td>
			</tr>
			<tr>
				<th>이메일 수신</th>
				<c:if test="${user.emailCheck eq 1}">
				<td>수신<input type="radio" name="emailCheck" value="1" checked/>
				 수신거부<input type="radio" name="emailCheck" value="0"/>
				</td>
				</c:if>
				<c:if test="${user.emailCheck eq 0}">
				<td>수신<input type="radio" name="emailCheck" value="1"/>
				 수신거부<input type="radio" name="emailCheck" value="0" checked/>
				</td>
				</c:if>
			</tr> 
			<tr>
				<th>휴대폰번호</th>
				<td><input style="width: 250px;" class="form-control  bg-gray-800 border-dark" type="tel" name="phoneNum" value="${user.phoneNum}" maxlength="40" />
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input class="btn-hover color-8" type="button" onclick="sample3_execDaumPostcode()" value="우편번호 찾기" />
				<input class="form-control  bg-gray-800 border-dark" type="text" id="postcode" name="postcode" value="${userInfo.uPostcode}" />
				<br><input class="form-control  bg-gray-800 border-dark" type="text" id="addr" name="addr" value="${userInfo.uAddr}"/>
				<br><input class="form-control  bg-gray-800 border-dark" type="text" id="detailAddr" name="detailAddr" value="${userInfo.uDetailAddr}"/>
				<div id="wrap" style="display:none;border:1px solid;width:500px;height:300px;margin:5px 0;position:relative">
				<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnFoldWrap" style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1" onclick="foldDaumPostcode()" alt="접기 버튼">
				</div>
				</td>
			</tr>
			<tr>
				<th>관심운동</th>
				<td>축구<input class="form-check-input" onclick="limit(this)" type="checkbox" name="likeExercise" id="축구" value="1"><label class="form-check-label"></label>
				농구<input class="form-check-input" onclick="limit(this)" type="checkbox" name="likeExercise" id="농구" value="2"><label class="form-check-label"></label>
				야구<input class="form-check-input" onclick="limit(this)" type="checkbox" name="likeExercise" id="야구" value="4"><label class="form-check-label"></label>
				E-sports<input class="form-check-input" onclick="limit(this)" type="checkbox" name="likeExercise" id="E-sports" value="8"><label class="form-check-label"></label>
				<br>등산<input class="form-check-input" onclick="limit(this)" type="checkbox" name="likeExercise" id="등산" value="16"><label class="form-check-label"></label>
				당구<input class="form-check-input" onclick="limit(this)" type="checkbox" name="likeExercise" id="당구" value="32"><label class="form-check-label"></label>
				볼링<input class="form-check-input" onclick="limit(this)" type="checkbox" name="likeExercise" id="볼링" value="64"><label class="form-check-label"></label>
				싸이클<input class="form-check-input" onclick="limit(this)" type="checkbox" name="likeExercise" id="싸이클" value="128"><label class="form-check-label"></label>
				<br>테니스<input class="form-check-input" onclick="limit(this)" type="checkbox" name="likeExercise" id="테니스" value="256"><label class="form-check-label"></label>
				조깅<input class="form-check-input" onclick="limit(this)" type="checkbox" name="likeExercise" id="조깅" value="512"><label class="form-check-label"></label>
				수영<input class="form-check-input" onclick="limit(this)" type="checkbox" name="likeExercise" id="수영" value="1024"><label class="form-check-label"></label>
				헬스<input class="form-check-input" onclick="limit(this)" type="checkbox" name="likeExercise" id="헬스" value="2048"><label class="form-check-label"></label>
				</td>
			</tr>
			<tr style="margin-left: 60px;">		
				<td><input class="btn-hover color-8" onclick="checked_submit()" type="button" value="정보수정"></td>
				<td><input class="btn-hover color-8" type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
	<script>
		// hidden으로 입력한 문자열 배열로 바꾸기
		var likeExerList = document.getElementById('likeExerList').value.replace(/\s/g,'').replace(/\[/g,'').replace(/\]/g,''); 
		let ExerList = likeExerList.split(',');
		// 사용자가 입력한 관심운동 체크하기
		for (let i in ExerList){
			document.getElementById(ExerList[i]).checked = true;
		};
		
		// 체크박스 개수제한 컨트롤
		let mc = 5;	// 체크박수 갯수 제한
		var checked_num = $("input[name=likeExercise]:checked").length;
		function limit(ff){
			if (ff.checked)
				checked_num +=1;
			else 
				checked_num -=1;

			if (checked_num > mc){
				alert("5개까지만 선택해주세요");
				ff.checked = false;
				checked_num -= 1;
			}
		}
		function checked_submit(){
			if(checked_num < 3){
				alert("체크박스를 3개이상 선택해 주세요");
				return false;
			} else {
				const reg_sub = document.reg_sub;
				reg_sub.submit();
			}
		}
		
	</script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	    // 우편번호 찾기 찾기 화면을 넣을 element
	    var element_wrap = document.getElementById('wrap');
	
	    function foldDaumPostcode() {
	        // iframe을 넣은 element를 안보이게 한다.
	        element_wrap.style.display = 'none';
	    }
	
	    function sample3_execDaumPostcode() {
	        // 현재 scroll 위치를 저장해놓는다.
	        var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var addr = ''; // 주소 변수
	                var extraAddr = ''; // 참고항목 변수
	
	                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }
	
	                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	                if(data.userSelectedType === 'R'){
	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있고, 공동주택일 경우 추가한다.
	                    if(data.buildingName !== '' && data.apartment === 'Y'){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                    if(extraAddr !== ''){
	                        extraAddr = ' (' + extraAddr + ')';
	                    }
	                    // 조합된 참고항목을 해당 필드에 넣는다.
	                    // document.getElementById("sample3_extraAddress").value = extraAddr;
	                
	                } 
	                /*  else {
	                    document.getElementById("sample3_extraAddress").value = '';
	                } */
	
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('postcode').value = data.zonecode;
	                document.getElementById("addr").value = addr;
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("detailAddr").focus();
	
	                // iframe을 넣은 element를 안보이게 한다.
	                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
	                element_wrap.style.display = 'none';
	
	                // 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
	                document.body.scrollTop = currentScroll;
	            },
	            // 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
	            onresize : function(size) {
	                element_wrap.style.height = size.height+'px';
	            },
	            width : '100%',
	            height : '100%'
	        }).embed(element_wrap);
	
	        // iframe을 넣은 element를 보이게 한다.
	        element_wrap.style.display = 'block';
	    }
	</script>
</body>
</html>