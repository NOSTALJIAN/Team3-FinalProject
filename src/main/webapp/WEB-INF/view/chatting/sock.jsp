<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <%@ include file="../common/heading.jsp" %>
      <meta charset="UTF-8">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
      <link rel="stylesheet" href="/css/sock.css" />
  </head>

  <body>
    <%@ include file="../common/top.jsp" %>
      <div id="container" class="container" style="margin-top: 120px; padding-bottom: 300px;">
        <div id="uname-page">
          <div class="uname-page-container">
            <h1 class="title">uname을 입력하세요.</h1>
            <form id="unameForm" name="unameForm">
              <div class="form-group">
                <input type="text" id="name" placeholder="User Name" autocomplete="off" class="form-control" />
              </div>
              <div class="form-group">
                <button type="submit" class="accent uname-submit">채팅 시작</button>
              </div>
            </form>
          </div>
        </div>

        <div id="chat-page" class="hidden">
          <div class="chat-container">
            <div class="chat-header">
              <h2>Spring WebSocket Chat Demo</h2>
            </div>
            <div class="connecting">
              연결중...
            </div>
            <ul id="messageArea">

            </ul>
            <form id="messageForm" name="messageForm">
              <div class="form-group">
                <div class="input-group clearfix">
                  <input type="text" id="message" placeholder="Type a message..." autocomplete="off"
                    class="form-control" />
                  <button type="submit" class="primary">보내기</button>
                </div>
              </div>
            </form>
          </div>
        </div>

      </div>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.min.js"></script>
      <script src="/js/sock.js"></script>
  </body>

  </html>