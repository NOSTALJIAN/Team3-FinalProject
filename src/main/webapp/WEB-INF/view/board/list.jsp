<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<meta charset="UTF-8"> 
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<style>
	p {
		text-align: left;
	}
	</style>
</head>

<body class="bg-black text-white mt-0" data-bs-spy="scroll" data-bs-target="#navScroll">
	<%@ include file="../common/top.jsp" %>
	<div class="container" style="margin: 120px; padding-bottom: 260px;">
		<div class="row" style="justify-content: space-evenly">
			<!-- =================== main =================== -->
			<div class="col-sm-9"  >
				<table class="table table-sm table-borderless" style="margin-left: 200px;">
					<tr class="d-flex">
						<td class="col-6" style="text-align: left;">
							<h3 style="color: white; margin-left: 90px;"><strong>그룹운동 게시판</strong></h3>
							<div class="board-list">
								<button type="button" class="btn-hover color-8 fix-position " onclick="location.href='/board/write'">+글쓰기</button>
							</div>
						</td>
						<td class="col-2" style="margin-left:50px;">
							<select name="f" class="board-input" id="field" style="background-color: white; width: 100px; height: 42px;">
								<c:forEach var="sports" items="${sportsArray}">
									<option value="${sports}">${sports}</option>
								</c:forEach>
							</select>
						</td>
						<td class="col-3" >
							<input class="form-control me-2" type="search" placeholder="검색 내용" name="q" id="query" style="width: 200px;">
						</td>
						<td class="col-2" >
							<button class="btn btn-outline-light" onclick="search()" style="width: 70px; margin-left:-200px;">검색</button>
						</td>
					</tr>
				</table>
				
				<div class="container" style="margin-top: -60px">
					<div class="row d-flex justify-content-center py-vh-5 pb-0">
						<div class="col-12 col-lg-10 col-xl-8">
							<c:forEach var="b" items="${blist}">
							<div class="row d-flex align-items-start" data-aos="fade-right">
								<div class="col-12 col-lg-7">
									<h4 class="h3 mt-5 border-top pt-5" onclick="location.href='/board/detail?bid=${b.bid}&uid=${b.uid}'"><strong>${b.bTitle}</strong></h4>
									<p onclick="location.href='/board/detail?bid=${b.bid}&uid=${b.uid}'">운동 종목 : ${b.bCategory}</p>
									<p onclick="location.href='/board/detail?bid=${b.bid}&uid=${b.uid}'">운동 장소 : ${b.bLocation}</p>
									<p onclick="location.href='/board/detail?bid=${b.bid}&uid=${b.uid}'">운동 날짜 : ${fn:replace(b.bAppointment, 'T', ' ')}</p>
									<p onclick="location.href='/board/detail?bid=${b.bid}&uid=${b.uid}'">운동 인원 : ${b.bUserCount}명</p>
									<button class="btn-hover color-8 write-btn" type="submit" value="신청">신청</button>
								</div>
								<!--  div class="col-12 col-lg-4 offset-lg-1 bg-gray-900 p-5 mt-5" >
									<p class="text-secondary">작성일 </p>
									<p class="text-secondary">: ${fn:replace(b.bRegTime, 'T', ' ')}</p>
									<p class="text-secondary">조회수 : ${b.bViewCount } </p>
									<p class="text-secondary">댓글 : ${b.bReplyCount }  </p>
									<p class="text-secondary">마감일정: D-4 </p>
								</div> -->
							</div>
							</c:forEach>
						</div>
					</div>
				</div>
				
				<ul class="pagination justify-content-center mt-4">
					<c:if test="${currentBoardPage gt 10}">
						<li class="page-item"><a class="page-link" href="/board/list?p=${startPage - 1}&f=${field}&q=${query}">&laquo;</a></li>
					</c:if>
					<c:if test="${currentBoardPage le 10}">
						<li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
					</c:if>
					<c:forEach var="page" items="${pageList}" varStatus="loop">    
						<li class="page-item ${(currentBoardPage eq page) ? 'active' : ''}">
							<a class="page-link" href="/board/list?p=${page}&f=${field}&q=${query}">${page}</a>
						</li>
					</c:forEach>  
					<c:if test="${totalPages gt endPage}">                    
						<li class="page-item"><a class="page-link" href="/board/list?p=${endPage + 1}&f=${field}&q=${query}">&raquo;</a></li>
					</c:if>
					<c:if test="${totalPages le endPage}">                    
						<li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
					</c:if>
				</ul>
			</div>
		</div>
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