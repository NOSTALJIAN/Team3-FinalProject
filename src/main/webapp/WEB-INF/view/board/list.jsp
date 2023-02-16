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
		<div class="row" style="justify-content: space-evenly; margin-left:70px;">
			<!-- =================== main =================== -->
			<div class="col-sm-9" >
				<table class="table table-sm table-borderless" style="margin-left: 150px;">
					<tr class="d-flex">
						<td class="col-6" >
							<h3 style="color: white; margin-left:90px;"><strong>그룹운동 게시판</strong></h3>
							<div class="board-list">
								<button type="button" class="btn-hover color-8 fix-position " onclick="location.href='/board/write'">+글쓰기</button>
							</div>
						</td>
						<td class="col" style="margin-left:70px;">
							<select class="board-input" name="f" id="field" style="background-color: white; width: 100px; height: 42px;">
								<option value="bCategory" selected>종목</option>
								<option value="bLocation">장소</option>
								<option value="bUserCount">인원</option>
							</select>
						</td>
						<td>
							<select class="board-input" name="period" id="period" style="background-color: white; width: 100px; height: 42px;">
								<option value="all" selected>모든 날짜</option>
								<option value="week">일주일</option>
								<option value="month">한달</option>
							</select>
						</td>
						<td class="col" >
							<input class="form-control me-2" type="search" placeholder="검색 내용" name="q" id="query" style="width: 200px;">
						</td>
						<td class="col" >
							<button class="" onclick="search()" style="width:70px;">검색</button>
						</td>
					</tr>
				</table>
				
				<div class="container" style="margin-top: -60px;">
					<div class="row ">
						<div class="content-list">
							<c:forEach var="b" items="${blist}">
							<div class="content-list-col" data-aos="fade-right">
								<div class="">
									<h5 class="mt-5 border-top pt-5" onclick="location.href='/board/detail?bid=${b.bid}&uid=${b.uid}'"><strong>${b.bTitle}</strong></h5>
									<p onclick="location.href='/board/detail?bid=${b.bid}&uid=${b.uid}'">종목 : ${b.bCategory}</p>
									<p onclick="location.href='/board/detail?bid=${b.bid}&uid=${b.uid}'">장소 : ${b.bLocation}</p>
									<p onclick="location.href='/board/detail?bid=${b.bid}&uid=${b.uid}'">날짜 : ${fn:replace(b.bAppointment, 'T', ' ')}</p>
									<p onclick="location.href='/board/detail?bid=${b.bid}&uid=${b.uid}'">인원 : ${b.bUserCount}명</p>
									<button class="btn-hover color-8 write-btn" type="submit" value="신청">신청</button>
								</div>
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
	<!-- 게시판 검색 -->
    <script>
    	function search() {
    		const field = document.getElementById("field").value;
    		const query = document.getElementById("query").value;
    		const period = document.getElementById("period").value;
    		console.log("search()", field, query, period);
    		location.href = "/board/list?p=${currentBoardPage}&f=" + field + "&q=" + query +"&period=" + period;
    	}
	</script>
</body>
</html>