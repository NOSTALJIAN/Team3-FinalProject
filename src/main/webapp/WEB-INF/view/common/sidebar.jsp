<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    

    <div class="flex-shrink-0 p-3 border-radius-xl sidebar-border">
      <a href="/" class="text-color d-flex align-items-center pb-3 mb-3 text-decoration-none border-bottom">
        <svg class="bi pe-none me-2" width="30" height="24"><use xlink:href="#bootstrap"/></svg>
        <span class="fs-5 fw-semibold" onclick="'/user/mypage'">마이페이지</span>
      </a>
      <ul class="list-unstyled ps-0 " >
        <li class="mb-1">
          <button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" data-bs-toggle="collapse" data-bs-target="#home-collapse" aria-expanded="false">
            개인정보
          </button>
          <div class="collapse" id="home-collapse">
            <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
              <li><a href="/user/profile" class="text-color d-inline-flex text-decoration-none rounded">프로필 수정</a></li>
              <li><a href="/user/pwdUpdate" class="text-color d-inline-flex text-decoration-none rounded">비밀번호 변경</a></li>
              <li><a href="/user/update" class="text-color d-inline-flex text-decoration-none rounded">개인정보 변경</a></li>
            </ul>
          </div>
        </li>
        <li class="mb-1">
          <button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" data-bs-toggle="collapse" data-bs-target="#match-collapse" aria-expanded="false">
            매칭조건 
          </button>
          <div class="collapse" id="match-collapse">
            <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
              <li><a href="/matching/condition" class="text-color d-inline-flex text-decoration-none rounded">매칭조건 설정</a></li>
              <li><a href="/user/update" class="text-color d-inline-flex text-decoration-none rounded">관심운동 변경</a></li>
            </ul>
          </div>
        </li>
        <li class="mb-1">
          <button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" data-bs-toggle="collapse" data-bs-target="#dashboard-collapse" aria-expanded="false">
            친구관리
          </button>
          <div class="collapse" id="dashboard-collapse">
            <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
              <li><a href="/mate/addMateForm" class="text-color d-inline-flex text-decoration-none rounded">보낸 신청</a></li>
              <li><a href="/mate/receiveMateForm" class=" text-color d-inline-flex text-decoration-none rounded">받은 신청</a></li>
              <li><a href="/mate/mateForm" class=" text-color d-inline-flex text-decoration-none rounded">친구목록</a></li>
            </ul>
          </div>
        </li>
        <li class="mb-1">
          <button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" data-bs-toggle="collapse" data-bs-target="#orders-collapse" aria-expanded="false">
            그룹운동
          </button>
          <div class="collapse" id="orders-collapse">
            <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
              <li><a href="/group/myWrite" class="text-color d-inline-flex text-decoration-none rounded">내가쓴 게시글</a></li>
              <li><a href="/group/applyList" class="text-color d-inline-flex text-decoration-none rounded">신청현황</a></li>
              <li><a href="/group/applyDone" class=" text-color d-inline-flex text-decoration-none rounded">신청완료</a></li>
            </ul>
          </div>
        </li>
        <li class="mb-1">
          <button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" data-bs-toggle="collapse" data-bs-target="#schedule-collapse" aria-expanded="false">
            운동일정
          </button>
          <div class="collapse" id="schedule-collapse">
            <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
              <li><a href="/schedule/calendar" class="text-color d-inline-flex text-decoration-none rounded">일정표</a></li>
            </ul>
          </div>
        </li>
        <li class="border-top my-3"></li>
        <li class="mb-1">
          <button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" data-bs-toggle="collapse" data-bs-target="#account-collapse" aria-expanded="false">
            계정
          </button>
          <div class="collapse" id="account-collapse">
            <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
              <li><a href="/user/logout" class=" text-color d-inline-flex text-decoration-none rounded">로그아웃</a></li>
              <li><a href="#" class=" text-color d-inline-flex text-decoration-none rounded">회원탈퇴</a></li>
            </ul>
          </div>
        </li>
      </ul>
    </div>
