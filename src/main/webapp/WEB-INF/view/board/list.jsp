<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<meta charset="UTF-8">
</head>

<body style="margin: 200px" >
<%@ include file="../common/top.jsp" %>
	
	<h2>그룹운동 게시판</h2>
		<a href="/board/write" class="btn btn-outline-light" style="background-color: purple;">
        	<small>게시글 쓰기</small></a>

<div class="bg-white py-vh-3">
  <div class="container bg-white px-vw-5 py-vh-3 rounded-5 shadow">
  	<div class="row gx-5">
    <div class="col-12 col-md-6">
      
      <div class="card bg-transparent mb-5" data-aos="zoom-in-up">
        <div class="bg-dark shadow rounded-5 p-0">
          <img src="/img/webp/abstract3.webp" width="582" height="327" alt="abstract image" 
          class="img-fluid rounded-5 no-bottom-radius" loading="lazy" onclick="location.href='/board/detail/${b.bid}'">
         
          <div class="p-5" onclick="location.href='/board/detail/${b.bid}'">
            <h2 style="color: white">${b.title}</h2>
            <p class="pb-4 text-secondary">${b.location }</p>
            <a href="/board/detail/${b.bid}" class="link-fancy link-fancy-light">Gogo</a>
          </div>
        </div>
      </div>
	

      <div class="card bg-transparent" data-aos="zoom-in-up">
        <div class="bg-dark shadow rounded-5 p-0">
          <img src="/img/webp/abstract2.webp" width="582" height="442" alt="abstract image" class="img-fluid rounded-5 no-bottom-radius" loading="lazy">
          <div class="p-5">
           <h2 style="color: white">게시글 제목</h2>
            <p class="pb-4 text-secondary">Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat.</p>
            <a href="/board/detail/${b.bid}" class="link-fancy link-fancy-light">Read more</a>
          </div>
        </div>
      </div>
      
      <div class="card bg-transparent" data-aos="zoom-in-up">
        <div class="bg-dark shadow rounded-5 p-0">
          <img src="/img/webp/abstract2.webp" width="582" height="442" alt="abstract image" class="img-fluid rounded-5 no-bottom-radius" loading="lazy">
          <div class="p-5">
            <h2 style="color: white">게시글 제목</h2>
            <p class="pb-4 text-secondary">Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat.</p>
            <a href="/board/detail/${b.bid}" class="link-fancy link-fancy-light">Read more</a>
          </div>
        </div>
      </div>
    </div>
    <div class="col-12 col-md-6">
     
      <div class="card bg-transparent mb-5 mt-5" data-aos="zoom-in-up">
        <div class="bg-dark shadow rounded-5 p-0">
          <img src="/img/webp/abstract17.webp" width="582" height="390" alt="abstract image" class="img-fluid rounded-5 no-bottom-radius" loading="lazy">
          <div class="p-5">
            <h2 style="color: white">게시글 제목</h2>
            <p class="pb-4 text-secondary">Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat.</p>
            <a href="/board/detail/${b.bid}" class="link-fancy link-fancy-light">Read more</a>
          </div>
        </div>
      </div>

<div class="card bg-transparent mb-5" data-aos="zoom-in-up">
        <div class="bg-dark shadow rounded-5 p-0">
          <img src="/img/webp/abstract3.webp" width="582" height="327" alt="abstract image" 
          class="img-fluid rounded-5 no-bottom-radius" loading="lazy" onclick="location.href='/board/detail/${b.bid}'">
         
          <div class="p-5" onclick="location.href='/board/detail/${b.bid}'">
            <h2 style="color: white">${b.title}</h2>
            <p class="pb-4 text-secondary">${b.location }</p>
            <a href="/board/detail/${b.bid}" class="link-fancy link-fancy-light">Gogo</a>
          </div>
        </div>
      </div>
	

      <div class="card bg-transparent" data-aos="zoom-in-up">
        <div class="bg-dark shadow rounded-5 p-0">
          <img src="/img/webp/abstract2.webp" width="582" height="442" alt="abstract image" class="img-fluid rounded-5 no-bottom-radius" loading="lazy">
          <div class="p-5">
           <h2 style="color: white">게시글 제목</h2>
            <p class="pb-4 text-secondary">Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat.</p>
            <a href="/board/detail/${b.bid}" class="link-fancy link-fancy-light">Read more</a>
          </div>
        </div>
      </div>
      
      <div class="card bg-transparent" data-aos="zoom-in-up">
        <div class="bg-dark shadow rounded-5 p-0">
          <img src="/img/webp/abstract2.webp" width="582" height="442" alt="abstract image" class="img-fluid rounded-5 no-bottom-radius" loading="lazy">
          <div class="p-5">
            <h2 style="color: white">게시글 제목</h2>
            <p class="pb-4 text-secondary">Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat.</p>
            <a href="/board/detail/${b.bid}" class="link-fancy link-fancy-light">Read more</a>
          </div>
        </div>
      </div>
    </div>
    <div class="col-12 col-md-6">
     
      <div class="card bg-transparent mb-5 mt-5" data-aos="zoom-in-up">
        <div class="bg-dark shadow rounded-5 p-0">
          <img src="/img/webp/abstract17.webp" width="582" height="390" alt="abstract image" class="img-fluid rounded-5 no-bottom-radius" loading="lazy">
          <div class="p-5">
            <h2 style="color: white">게시글 제목</h2>
            <p class="pb-4 text-secondary">Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat.</p>
            <a href="/board/detail/${b.bid}" class="link-fancy link-fancy-light">Read more</a>
          </div>
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

    console.log(scrollpos)
  })
</script>
	
</body>
</html>