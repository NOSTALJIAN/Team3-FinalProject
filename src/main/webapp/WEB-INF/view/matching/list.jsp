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

<body style="margin: 170px" >
	<%@ include file="../common/top.jsp" %>
	<h3><strong>1:1운동 게시판</strong></h3>
   	<div class=" content-list">
		<c:forEach var="m" items="${matchingList}">
   		<div class="content-list-col " >
	    	<div class="board-card " data-aos="zoom-in-up">
				<div class="bg-dark shadow rounded-5 p-0">
					<img src="/img/avatar_man.png" width="582" height="442" alt="abstract image" class="img-fluid rounded-5 no-bottom-radius" 
			          loading="lazy">
					<div class="mtc-info">
						<h2 style="color: white">${m.uid}</h2>
						<p class="" style="color: white;">거리: ${m.distance}</p>
			            <p class="" style="color: white;">나이: ${m.age}</p>
			            <p class="" style="color: white;">성별: ${m.gender}</p>
			            <p class="" style="color: white;">평점: ${m.uRating}</p>
			            <p class="" style="color: white;">공유하는 운동 목록 : ${m.coincideExer}</p>
			            <button onclick="addMate('${m.uid}')" style="background-color:white; color:black;" >친구추가</button>
			     	</div>
				</div>
			</div>
   		</div>
		</c:forEach>
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
		  console.log(uid);
		  $.ajax({
			type:'GET',
			url: '/matching/addMate',
			data: {'receiveUser': uid},
			success: function(result){
				console.log(result);
				
			}
		  });
	  }
	  
	</script>
</body>
</html>