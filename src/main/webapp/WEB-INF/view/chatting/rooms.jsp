<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

      <!DOCTYPE html>
      <html class="h-100" lang="ko">

      <head>
        <!--   <title>WebSocket Chat</title> -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <%@ include file="../common/heading.jsp" %>
          <link rel="stylesheet" href="/css/room.css">
      </head>

      <body>
        <script src="/js/rooms.js"></script>
        <%@ include file="../common/top.jsp" %>
          <div id="container" class="container" style="margin-top: 120px; padding-bottom: 300px;">

            <!-- START -->
            <div>
              <ul c:each="room : ${list}">
                <li><a href="@{/chat/room(cid=${room.cid})}">${room.uid}</a></li>
              </ul>
            </div>
            <form action="@{/chat/room}" method="post">
              <input type="text" name="name" class="form-control">
              <button class="btn btn-secondary">개설하기</button>
            </form>

          </div>
      </body>

      </html>