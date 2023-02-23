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
          <style>
            .chats {
              display: flex;
              flex-direction: column;

              gap: 10px;
            }

            .mine {
              background: #e9e9e9;
              border-radius: 5px;
            }

            .yours {
              background: #efef87;
              border-radius: 5px;
            }

            .nickname {
              font-size: 16px;
              font-weight: bold;
            }

            .message {
              font-size: 14px;
            }
          </style>
      </head>

      <body>
        <script src="/js/rooms.js"></script>
        <%@ include file="../common/top.jsp" %>
          <div id="container" class="container" style="margin-top: 120px; padding-bottom: 300px;">

            <!-- START -->
            <h1>CHAT ROOM</h1>
            <!-- <h2 th:text="'Room No. ' + ${chatRoomId}"></h2> -->
            <!-- <h2 th:text="'Nickname = ' + ${nickname}"></h2> -->
            <h2>
              <c:out value="'Room No. ' + ${chatRoomId}" />
            </h2>
            <h2>
              <c:out value="'Nickname = ' + ${nickname}" />
            </h2>

            <form>
              <input type="text" id="message">
              <input type="submit" value="전송" class="btn-send">
            </form>

            <div class="chats">
              <div class="mine">

              </div>
            </div>

          </div>
          <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
          <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>

      </body>

      </html>