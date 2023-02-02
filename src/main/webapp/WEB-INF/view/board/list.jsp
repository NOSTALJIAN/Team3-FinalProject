
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<meta charset="UTF-8"> 
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<link rel="stylesheet" href="/css/board.css">
</head>

<body style="margin: 200px" >
<%@ include file="../common/top.jsp" %>
	<div class="">
		<h3 class="board-title">그룹운동 게시판</h3>
		<hr>
		<div class="">
			<button type="button" class="btn-hover color-8 fix-position" onclick="location.href='/board/write'">+글쓰기</button>
	<table class="board-list">
			<tr>
				<th><label>제목</label></th>
				<th><label>운동종목</label></th>
				<th><label>작성시간</label></th>	
				<th><label>인원수</label></th>
			</tr>
			<c:forEach var="b" items="${blist}">
				<tr>
			 		<td onclick="location.href='/board/detail/${b.bid}'" >${b.bTitle}</td>
					<td>${b.bCategory}</td>
					<td>${fn:replace(b.bRegTime, 'T', ' ')}</td>
					<td>${b.bUserCount}명</td>
				</tr>
			</c:forEach>
		</table> 
		</div>
	

<script src="/js/bootstrap.bundle.min.js"></script>
<script src="/js/aos.js"></script>
<script>
AOS.init({
 duration: 800, // values from 0 to 3000, with step 50ms
});
</script>
<script>
  let scrollpos = window.scrollY
  const header = document.querySelector(".navbar")
  const header_height = header.offsetHeight

  const add_class_on_scroll = () => header.classList.add("scrolled", "shadow-sm")
  const remove_class_on_scroll = () => header.classList.remove("scrolled", "shadow-sm")

  window.addEventListener('scroll', function() {
    scrollpos = window.scrollY;

    if (scrollpos >= header_height) { add_class_on_scroll() }
    else { remove_class_on_scroll() }

    console.log(scrollpos)
  })
</script>
</body>
</html>