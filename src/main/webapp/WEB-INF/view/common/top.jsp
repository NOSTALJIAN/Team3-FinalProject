<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  <nav id="navScroll" class="navbar navbar-dark bg-black fixed-top px-vw-5" tabindex="0">
  <div class="container">
    <a class="navbar-brand pe-md-4 fs-4 col-12 col-md-auto text-center" href="/board/index">
  <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-stack" viewBox="0 0 16 16">
    <path d="m14.12 10.163 1.715.858c.22.11.22.424 0 .534L8.267 15.34a.598.598 0 0 1-.534 0L.165 11.555a.299.299 0 0 1 0-.534l1.716-.858 5.317 2.659c.505.252 1.1.252 1.604 0l5.317-2.66zM7.733.063a.598.598 0 0 1 .534 0l7.568 3.784a.3.3 0 0 1 0 .535L8.267 8.165a.598.598 0 0 1-.534 0L.165 4.382a.299.299 0 0 1 0-.535L7.733.063z"/>
    <path d="m14.12 6.576 1.715.858c.22.11.22.424 0 .534l-7.568 3.784a.598.598 0 0 1-.534 0L.165 7.968a.299.299 0 0 1 0-.534l1.716-.858 5.317 2.659c.505.252 1.1.252 1.604 0l5.317-2.659z"/>
  </svg>
  <span class="ms-md-1 mt-1 fw-bolder me-md-5">GOgo</span>
</a>

      <ul class="navbar-nav mx-auto mb-2 mb-lg-0 list-group list-group-horizontal">
      <li class="nav-item">
  <a class="nav-link fs-5" href="/board/index" aria-label="Homepage">
    Home
  </a>
</li>
<li class="nav-item">
  <a class="nav-link fs-5" href="#" aria-label="A sample content page">
    Find
  </a>
</li>
<li class="nav-item">
  <a class="nav-link fs-5" href="/board/list" aria-label="A system message page">
    Group
  </a>
</li>
<li class="nav-item">
  <a class="nav-link fs-5" href="#" aria-label="A system message page">
    MyPage
  </a>
</li>

	<c:choose>
		<c:when test="${sessionUid eq 'admin'}">
	<li class="nav-item">
	  <a class="nav-link fs-5 ${menu eq 'user' ? 'active' : ''}" href="/user/list" aria-label="A system message page">
	    사용자
	  </a>
	</li>
		</c:when>
	</c:choose>
</ul>
    
    <c:choose>
		<c:when test="${empty sessionUid}">
      <a href="/user/login" aria-label="Download this template" class="btn btn-outline-light ${menu eq 'login' ? 'active' : ''}">
        <small>Login</small>
      </a>
      <a href="/user/register" aria-label="Download this template" class="btn btn-outline-light ${menu eq 'reg' ? 'active' : ''}">
        <small>Join</small>
      </a>
      </c:when>
      <c:otherwise>
      	<a href="/user/logout" aria-label="Download this template" class="btn btn-outline-light ">
        	<small>Logout</small>
      </a>
      </c:otherwise>
      </c:choose>
      
</div>
</nav>