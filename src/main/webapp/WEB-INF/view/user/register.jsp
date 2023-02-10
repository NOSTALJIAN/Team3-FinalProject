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
	<h3 style="color: white;">회원가입</h3>
	<hr style="color: white;">
	<form name="reg_sub" action="/user/register" method="post" class="mb-auto col-12 text">
		<table>
			 <tr>
				<th>아이디</th>
				<td><input style="width: 250px;" class="form-control bg-gray-800 border-dark " type="text" name="uid" placeholder="*아이디" maxlength="12" required /></td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input style="width: 250px;" class="form-control  bg-gray-800 border-dark" type="password" name="pwd" id="pwd" placeholder="*패스워드" maxlength="60" required /></td>
			</tr>
			<tr>
				<th>패스워드 확인</th>
				<td><input style="width: 250px;" class="form-control  bg-gray-800 border-dark" type="password" name="pwd2"  id="pwd2" placeholder="*패스워드 확인" maxlength="60" required /></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input style="width: 250px;" class="form-control  bg-gray-800 border-dark" type="text" name="uname" placeholder="*이름" maxlength="10" required /></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input style="width: 250px;" class="form-control  bg-gray-800 border-dark" type="email" name="email" placeholder="*이메일" maxlength="40"  />
				</td>
			</tr>
			<tr>
				<th>이메일 수신</th>
				<td>수신<input type="radio" name="emailCheck" value="1" checked />
				 수신거부<input type="radio" name="emailCheck" value="0" />
				</td>
			</tr> 
			<tr>
				<th>휴대폰번호</th>
				<td><input style="width: 250px;" class="form-control  bg-gray-800 border-dark" type="tel" name="phoneNum" placeholder="('-'없이 번호만 입력)" maxlength="40" />
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input style="width: 250px;" class="form-control  bg-gray-800 border-dark" type="number" name="birthDate" id="birthDate" placeholder="ex) 20230101" />
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>여자<input type="radio" name="gender" value="여"  checked/>
				 남자<input type="radio" name="gender" value="남" />
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input class="btn-hover color-8" type="button" onclick="sample3_execDaumPostcode()" value="우편번호 찾기" /><input class="form-control  bg-gray-800 border-dark" type="text" id="postcode" name="postcode" placeholder="우편번호" />
				<br><input class="form-control  bg-gray-800 border-dark" type="text" id="addr" name="addr" placeholder="주소" />
				<br><input class="form-control  bg-gray-800 border-dark" type="text" id="detailAddr" name="detailAddr" placeholder="상세주소" />
				<div id="wrap" style="display:none;border:1px solid;width:500px;height:300px;margin:5px 0;position:relative">
				<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnFoldWrap" style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1" onclick="foldDaumPostcode()" alt="접기 버튼">
				</div>
				</td>
			</tr>
			<tr>
				<th>관심운동</th>
				<td>축구<input class="form-check-input" onclick="limit(this)" type="checkbox" name="likeExercise" value="1"><label class="form-check-label"></label>
				농구<input class="form-check-input" onclick="limit(this)" type="checkbox" name="likeExercise" value="2"><label class="form-check-label"></label>
				야구<input class="form-check-input" onclick="limit(this)" type="checkbox" name="likeExercise" value="4"><label class="form-check-label"></label>
				E-sports<input class="form-check-input" onclick="limit(this)" type="checkbox" name="likeExercise" value="8"><label class="form-check-label"></label>
				<br>등산<input class="form-check-input" onclick="limit(this)" type="checkbox" name="likeExercise" value="16"><label class="form-check-label"></label>
				당구<input class="form-check-input" onclick="limit(this)" type="checkbox" name="likeExercise" value="32"><label class="form-check-label"></label>
				볼링<input class="form-check-input" onclick="limit(this)" type="checkbox" name="likeExercise" value="64"><label class="form-check-label"></label>
				싸이클<input class="form-check-input" onclick="limit(this)" type="checkbox" name="likeExercise" value="128"><label class="form-check-label"></label>
				<br>테니스<input class="form-check-input" onclick="limit(this)" type="checkbox" name="likeExercise" value="256"><label class="form-check-label"></label>
				조깅<input class="form-check-input" onclick="limit(this)" type="checkbox" name="likeExercise" value="512"><label class="form-check-label"></label>
				수영<input class="form-check-input" onclick="limit(this)" type="checkbox" name="likeExercise" value="1024"><label class="form-check-label"></label>
				헬스<input class="form-check-input" onclick="limit(this)" type="checkbox" name="likeExercise" value="2048"><label class="form-check-label"></label>
				</td>
			</tr>
			<tr style="margin-left: 60px;">		
				<td><input class="btn-hover color-8" onclick="checked_submit()" type="button" value="회원가입"></td>
				<td><input class="btn-hover color-8" onclick="checked_submit()" type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
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
	<script>
		let mc = 5;	// 체크박수 갯수 제한
		let tc = 0; //카운트 증가
		var checked_num = $("input[name=likeExercise]:checked").length;
		console.log(checked_num);
		console.log("확인용");
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
			
			const pwd = $('#pwd').val();
			var checked_num = $("input[name=likeExercise]:checked").length;
			//const pwd = $('#pwd').val();
			const pwd2 = $('#pwd2').val();
			const birthDate = $('#birthDate').val();
			if (pwd != pwd2) {
				alert("비밀번호가 일치하지 않습니다.");
				return false;
			} else if (birthDate.length != 8) {
				alert("생년월일 8자리를 입력해주세요");
				return false;		
			} else if(checked_num < 3){
				alert("체크박스를 3개이상 선택해 주세요");
				return false;
			} else {
				const reg_sub = document.reg_sub;
				reg_sub.submit();
			}
		}
	</script>
	<%@ include file="../common/top.jsp" %>
</body>
</html>
