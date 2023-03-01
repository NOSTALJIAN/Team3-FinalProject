<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

      <nav id="navScroll"
        class="bg-black text-white navbar navbar-main navbar-expand-lg px-0 mx-4 shadow-none border-radius-xl mt-3 mx-3 "
        tabindex="0" style="height: 65px; padding-top: 8px; color: white;">
        <div class="container">
         <a class="navbar-brand pe-md-4 fs-4 col-12 col-md-auto text-center" href="/board/index">
             <i class="fa-solid fa-person-running" onclick="location.href='/board/index'" style="color: white;"></i>
              <span class="ms-md-1 mt-1 fw-bolder me-md-5" style="color: white;">GOgo</span>
            </a>

          <ul class="navbar-nav mx-auto mb-2 mb-lg-0 list-group list-group-horizontal">
            <li class="nav-item">
              <a class="nav-link nav-size text-white" href="/board/index" aria-label="A sample content page">
               <strong>Home</strong> 
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link nav-size text-white" href="/matching/list" aria-label="A sample content page">
                <strong>운동친구</strong> 
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link nav-size text-white" href="/board/list" aria-label="A system message page">
                <strong>그룹운동</strong> 
              </a>
            </li>
            <c:choose>
              <c:when test="${!empty sessionUid}">
                <!-- <li class="nav-item">
                  <a class="nav-link nav-size text-white" href="/chat/test" aria-label="A system message page">
                    1:1 채팅
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link nav-size text-white" href="/chat/room" aria-label="A system message page">
                    그룹 채팅
                  </a>
                </li> -->
                <li class="nav-item">
                  <a class="nav-link nav-size text-white" href="/user/mypage" aria-label="A system message page">
                    <strong>마이페이지</strong> 
                  </a>
                </li>
              </c:when>
            </c:choose>

            <c:choose>
              <c:when test="${sessionUid eq 'admin'}">
                <li class="nav-item">
                  <a class=" text-white nav-link nav-size ${menu eq 'user' ? 'active' : ''}" href="/user/admin"
                    aria-label="A system message page">
                   <strong>사용자관리</strong>  
                  </a>
                </li>
              </c:when>
            </c:choose>
          </ul>

          <c:choose>
            <c:when test="${empty sessionUid}">
              <a href="/user/login" aria-label="Download this template"
                class="btn btn-outline-light ${menu eq 'login' ? 'active' : ''}">
                <small>로그인</small>
              </a>
              <a href="/user/register" aria-label="Download this template"
               class="btn btn-outline-light ${menu eq 'reg' ? 'active' : ''}">
               <small>회원가입</small>
               </a> 
            </c:when>
            <c:otherwise>
              <a href="/user/logout" aria-label="Download this template" class="btn btn-outline-light ">
                <small>로그아웃</small>
              </a>
            </c:otherwise>
          </c:choose>
          
           <c:choose>
              <c:when test="${!empty sessionUid}">
			<span class="nav-link nav-size text-gray me-3" style="margin-left: 20px;">${sessionNickname}님 환영합니다.</span>
			</c:when>
		</c:choose>
        </div>
      </nav>