<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<meta charset="UTF-8">
	<style>
	p {
		text-align: center;
	}
	.btn-hover.color-9 {
    background-image: linear-gradient(to right, #25aae1, #4481eb, #04befe, #3f86ed);
    box-shadow: 0 4px 15px 0 rgba(65, 132, 234, 0.75);
	}
	.img-size{
	    max-width: 300px;
    height: 300px;
    border-radius: 70%;
    margin-left: 800px;
    margin-top: -50px;
	}
	</style>
</head>

<body class="bg-black text-white mt-0" data-bs-spy="scroll" data-bs-target="#navScroll">
<%@ include file="../common/top.jsp" %>
	<div class="container" style=" padding-bottom: 300px; margin-top: 50px;">
        <div class="row" style="justify-content: space-evenly">
            <!-- =================== main =================== -->
            <div class="col-sm-9" style="margin-top: ;" >
				<h3 style="color: white; margin-left: 90px;"><strong>운동친구 매칭</strong></h3>
					<button type="button" class="btn-hover color-9 postion" onclick="location.href='/matching/condition'" style="margin-left: 200px;">
					매칭조건
					</button>
							
				<div class="container" style="margin-top: -80px">
			    	<div class="row d-flex justify-content-center py-vh-5 pb-0">
			        	<div class="col-12 col-lg-10 col-xl-8">
			        		<c:forEach var="m" items="${matchingList}">
					      		<div class="row d-flex align-items-start" data-aos="fade-right">
					        		<div class="col-12 col-lg-7">
							        	<h4 class="h3 mt-5 border-top pt-5" ><strong>${m.nickname}</strong></h4>
							        	<p>거리: ${m.distance}</p>
							        	<p>나이: ${m.age}</p>
							          	<p>성별: ${m.gender}</p>
							          	<p>선택운동 : ${m.coincideExer}</p>
							         	<button onclick="addMate('${m.uid}')" class="btn-hover color-8 write-btn"  id="${m.uid}">친구신청</button>
					        		</div>
					        		<c:if test="${empty m.uImage}">
							        	<div class="col-12 col-lg-4 offset-lg-1 bg-black p-5 mt-5" >
											<p class="text-dark">
											<img src="/img/basicProfile.png" alt="abstract image" class="img-size"></p>
							        	</div>
						        	</c:if>
						        	<c:if test="${not empty m.uImage}">
							        	<div class="col-12 col-lg-4 offset-lg-1 bg-black p-5 mt-5" >
											<p class="text-dark">
											<img src="/board/download?file=${m.uImage}" alt="abstract image" class="img-size"></p>
							        	</div>
						        	</c:if>
					      		</div>
			        		</c:forEach>
						</div>
					</div>
				</div>			
				
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