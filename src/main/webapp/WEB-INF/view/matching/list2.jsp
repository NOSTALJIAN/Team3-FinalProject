<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/css/board.css">
</head>

<body style="margin: 200px" >
<%@ include file="../common/top.jsp" %>
	
	<h3>그룹운동 게시판</h3>
	<a href="/board/write" class="btn btn-outline-light write-btn">
    	<small>+글쓰기</small></a>
    	
	 <%--  	<div class=" content-list">
				<c:forEach var="b" items="${blist}">
			    	<div class="content-list-col" >
					     <div class="board-card " data-aos="zoom-in-up">
					        <div class="bg-dark shadow rounded-5 p-0">
					          <img src="/board/download?file=${b.bFiles }" width="582" height="442" alt="abstract image" class="img-fluid rounded-5 no-bottom-radius" 
					          loading="lazy" onclick="location.href='/board/detail/${b.bid}'">
					          <div class="p-5">
					           <h2 style="color: white">${b.bTitle}</h2>
					            <p class="pb-4 text-secondary" style="color: white;">${b.bCategory}</p>
					            <p class="pb-4 text-secondary" style="color: white;">${b.bLocation}</p>
					            <p class="pb-4 text-secondary" style="color: white;">${fn:replace(b.bRegTime, 'T', ' ')}</p>
					            <a href="/board/detail/${b.bid}" class="link-fancy link-fancy-light">GOgo</a>
					          </div>
					        </div>
					      </div>
	    			</div>
				</c:forEach>
    		</div> --%>


	<table>
			<colgroup>
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
			</colgroup>
			<tr>
				<th><label>게시글번호</label></th>
				<th><label>썸네일</label></th>
				<th><label>제목</label></th>
				<th><label>운동종목</label></th>
				<th><label>작성일자</label></th>
			</tr>
			<c:forEach var="b" items="${blist}">
				<tr>
					<td><a href="/board/detail/${b.bid}">${b.bid}</a></td>
					<td><img src="/board/download?file=${b.bFiles }" height="40" onclick="location.href='/board/detail/${b.bid}" /></td>
					<td>${b.bTitle}</td>
					<td>${b.bCategory}</td>
					<td>${fn:replace(b.bRegTime, 'T', ' ')}</td>
				</tr>
			</c:forEach>
		
		</table> 
	
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