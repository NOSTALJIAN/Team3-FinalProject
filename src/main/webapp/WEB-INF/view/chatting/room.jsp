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
            <div class="col-6">
              <h1>${room.uid}</h1>
            </div>
            <div>
              <div id="msgArea" class="col">
                <div class="input-group mb-3">
                  <input type="text" id="msg" class="form-control">
                  <div class="input-group-append">
                    <button class="btn btn-outline-secondary" type="button" id="button-send">전송</button>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-6"></div>

          </div>
      </body>

      </html>