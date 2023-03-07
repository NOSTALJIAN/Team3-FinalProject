<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <!-- <%@ include file="../common/heading.jsp" %> -->
    <meta charset="UTF-8">
    <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
    <!-- <link rel="stylesheet" href="/css/chat.css"> -->
  </head>

  <body>
    <!-- <%@ include file="../common/top.jsp" %> -->
    <!-- <script src="/js/chat.js"></script> -->
    <div id="container" class="container" style="margin-top: 120px; padding-bottom: 300px;">

      <a href="/chat/roomForm">방 만들기</a><br>

      <c:forEach items="${roomList}" var="room">
        <tr>
          <td><a href="/" + ${cid}>
              <c:out value="${room.getUid()}" />
              <c:out value="${room.getName()}" />
            </a></td>
        </tr>
      </c:forEach>
      <tr>

      </tr>

    </div>
  </body>

  </html>