<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <%@ include file="../common/heading.jsp" %>
      <meta charset="UTF-8">
      <link rel="stylesheet" href="/css/chatting/chat.css" />
      <!-- <link rel="stylesheet" href="/css/chatting/normalize.min.css" /> -->
      <link rel="stylesheet prefetch" href="/css/chatting/jquery.mCustomScrollbar.min.css" />
      <link rel="stylesheet prefetch" href="https://fonts.googleapis.com/css?family=Open+Sans" />
  </head>

  <body>
    <%@ include file="../common/top.jsp" %>
      <script src="https://code.jquery.com/jquery-3.5.1.js" ;></script>
      <c:forEach var="uid" items="${sessionUid}">
        <input type="hidden" id="uid" value="${uid}">
      </c:forEach>
      <div id="container" class="container" style="margin-top: 120px; padding-bottom: 300px;">

        <div class="chat">
          <div class="chat-title">
            <h1 id="full-name"></h1>
            <h2 id="nick-name"></h2>
            <figure class="avatar">
              <img id="user-img" src="" />
            </figure>
          </div>
          <div class="messages">
            <div class="messages-content"></div>
          </div>
          <div class="message-box">
            <textarea type="text" class="message-input" placeholder="Type message..."></textarea>
            <button type="submit" class="message-submit">Send</button>
            <button type="submit" class="message-file" onclick="getFile();">file</button>
          </div>
          <div style='height: 0px;width: 0px; overflow:hidden;'><input id="upfile" type="file" onchange="sub()" /></div>
        </div>

        <div class="bg"></div>

      </div>
  </body>

  <script src="/js/chatting/chat.js"></script>
  <!-- <script src="/js/chatting/jquery.min.js"></script> -->
  <script src="/js/chatting/jquery.mCustomScrollbar.concat.min.js"></script>

  <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>

  </html>