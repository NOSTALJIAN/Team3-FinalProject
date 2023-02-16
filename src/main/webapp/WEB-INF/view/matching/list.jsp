<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/css/board.css">
	<style>
	p {
		text-align: left;
	}
	</style>
</head>

<body class="bg-black text-white mt-0" data-bs-spy="scroll" data-bs-target="#navScroll">
<%@ include file="../common/top.jsp" %>
	<div class="container" style="margin: 100px; margin-left:200px; padding-bottom: 260px;">
        <div class="row" style="justify-content: space-evenly">
            <!-- =================== main =================== -->
            <div class="col-sm-9">
				<h3 style="color: white; margin-left:200px;"><strong>1:1운동 매칭</strong></h3>
						<button type="button" class="btn-hover color-8 postion" onclick="location.href='/matching/condition'" style="margin-left: 200px;">
						매칭조건</button>
							
			<div class="container" style="margin-top: -90px">
		      <div class="row d-flex justify-content-center py-vh-5 pb-0">
		        <div class="col-12 col-lg-10 col-xl-8">
		        <c:forEach var="m" items="${matchingList}">
			      <div class="row d-flex align-items-start" data-aos="fade-right">
			        <div class="col-12 col-lg-7">
			          <h4 class="h3 mt-5 border-top pt-5" ><strong>${m.uname}</strong></h4>
			          <p >거리: ${m.distance}</p>
			          <p >나이: ${m.age}</p>
			          <p >성별: ${m.gender}</p>
			          <p >평점: ${m.uRating}</p>
			          <p >선택운동 : ${m.coincideExer}</p>
			           <button  onclick="addMate('${m.uid}')" class="btn-hover color-8 write-btn"  id="${m.uid}">친구신청</button>
			        </div>
			        <div class="col-12 col-lg-4 offset-lg-1 bg-gray-900 p-5 mt-5" >
			          <p class="text-secondary"><img src="/img/avatar_man.png" height="400px;" width="300px;" alt="abstract image" class="img-fluid rounded-5 no-bottom-radius" 
			          loading="lazy"></p>
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
	
	    /* console.log(scrollpos) */
	  })
	  function addMate(uid){
		  const mateuid = document.getElementById(uid);
		  if (mateuid.innerText =='친구신청'){
			  $.ajax({
				type:'GET',
				url: '/mate/addMate',
				data: {'receiveUser': uid},
				success: function(result){
					mateuid.innerText = result;
					console.log(result);
					mateuid.style.cssText = 'background-color:black; color:white;'
				}
			  });
		  }
		  else if (mateuid.innerText =='친구신청중'){
			  $.ajax({
				type:'GET',
				url: '/mate/mateCancle',
				data: {'receiveUser': uid},
				success: function(result){
					mateuid.innerText = result;
					console.log(result);
					mateuid.style.cssText = 'background-color:white; color:black;'
				}
			  });
		  }
	  }
	  
	</script>
</body>
</html>