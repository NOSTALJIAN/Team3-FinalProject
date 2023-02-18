<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <%@ include file="../common/heading.jsp" %>
      <meta charset="UTF-8">
      <link rel="stylesheet" href="/css/chatt.css" />
  </head>

  <body>
    <%@ include file="../common/top.jsp" %>
      <script src="https://code.jquery.com/jquery-3.5.1.js" ;></script>
      <c:forEach var="uid" items="${sessionUid}">
        <input type="hidden" id="uid" value="${uid}">
      </c:forEach>
      <div id="container" class="container" style="margin-top: 120px; padding-bottom: 300px;">
        <div class="container">
          <div class="col-6">
            <label><b>채팅방</b></label>
          </div>
          <div id="msgArea" class="col"></div>
          <div class="col-6">
            <div class="input-group mb-3">
              <input type="text" id="msg" class="form-control" aria-label="Recipient's username"
                aria-describedby="botton-addon2">
              <div class="input-group-append">
                <button class="btn btn-outline-secondary" type="button" id="button-send">전송</button>
              </div>
            </div>
          </div>
        </div>
      </div>
  </body>
  <script src="/js/chatt.js"></script>

  </html>