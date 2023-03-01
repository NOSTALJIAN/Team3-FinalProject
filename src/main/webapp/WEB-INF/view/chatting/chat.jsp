<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Your First WebSocket!</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.2/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
      integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
  </head>

  <body>
    <script type="text/javascript">
      // var wsUri = "";
      var wsUri = "http://localhost:8080/websocket";
      var stompClient;
      var output;
      var textMessge;
      var textUser;
      var textRoom;
      connect();

      function init() {
        output = document.getElementById("output");
        textMessge = document.getElementById("textMessge");
        textUser = document.getElementById("textUser");
        textRoom = document.getElementById("textRoom");

        if (getParam("user") !== "") document.getElementById("textUser").value = getParam("user");
        if (getParam("user") !== "") document.getElementById("textRoom").value = getParam("room");
      }
      function connect() {
        var socket = new SockJS(wsUri);
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
          onOpen();
          console.log('Connected: ' + frame);
          stompClient.subscribe('/topic/greetings', function (greeting) {
            onMessage(JSON.parse(greeting.body).content);
          });
          stompClient.subscribe('/subscribe/notice' + document.getElementById("textRoom").value, function (message) {
            onMessage(message.body);
          });
        });
      }

      function disconnect() {
        if (stompClient !== null) {
          stompClient.disconnect();
        }
        onClose();
        console.log("Disconnected");
      }

      function send_message() {
        var message = textMessge.value;
        var user = textUser.value;
        var room = textRoom.value;
        // writeToScreen("Message Sent: " + message);
        stompClient.send("/app/message", {}, JSON.stringify({ 'message': message, 'user': user, 'room': room }));
      }

      function onOpen() {
        writeToScreen("Connected to Endpoint!");
      }

      function onClose() {
        writeToScreen("Close from Endpoint!");
      }

      function onMessage(message) {
        writeToScreen("Message Received: " + message);
      }

      function writeToScreen(message) {
        var pre = document.createElement("p");
        pre.style.wordWrap = "break-word";
        pre.innerHTML = message;
        output.appendChild(pre);
      }

      function getParam(sname) {

        var params = location.search.substr(location.search.indexOf("?") + 1);
        var sval = "";
        params = params.split("&");
        for (var i = 0; i < params.length; i++) {
          temp = params[i].split("=");
          if ([temp[0]] == sname) { sval = temp[1]; }
        }
        return sval;

      }

      window.addEventListener("load", init, false);


    </script>
    <h1 style="text-align: center;">Hello World WebSocket Client</h1>
    <br>
    <div style="text-align: center;">
      <form action="">
        <input onclick="connect()" value="Connect" type="button">
        <input onclick="send_message()" value="Send" type="button">
        <input id="msgIdx" type="hidden" />
        <input id="prevBtn" value="prev" type="button">
        <input id="textMessge" name="message" value="Hello WebSocket!" type="text">
        <input id="textUser" name="user" value="aaa" type="hidden">
        <input id="textRoom" name="room" value="1" type="hidden">
        <br>
      </form>
    </div>
    <div id="output"></div>
  </body>

  </html>
  <script>
    $(function () {


      var url = "/data/lastidx?room=" + getParam("room");
      $.ajax({
        type: "GET",            // HTTP method type(GET, POST) 형식이다.
        url: url,      // 컨트롤러에서 대기중인 URL 주소이다.
        success: function (res) { // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
          // 응답코드 > 0000
          $("#msgIdx").val(res.data);

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) { // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
          console.log("통신 실패.");
        }
      });

      $("#prevBtn").on("click", function () {

        var url = "/data?room=" + getParam("room");
        var idx = $("#msgIdx").val();
        if (idx !== "") {
          url += "&idx=" + idx;
        }
        $.ajax({
          type: "GET",            // HTTP method type(GET, POST) 형식이다.
          url: url,      // 컨트롤러에서 대기중인 URL 주소이다.
          success: function (res) { // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
            // 응답코드 > 0000
            for (var key in res.data) {
              console.log(res.data[key]);
              $("#msgIdx").val(res.data[key].idx);
              $("#output").prepend("<p style=\"overflow-wrap: break-word;\">prev data : "
                + res.data[key].user + "|"
                + res.data[key].room + ":"
                + res.data[key].message + "/"
                + res.data[key].timestamp
                + "</p>");
            }

          },
          error: function (XMLHttpRequest, textStatus, errorThrown) { // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
            console.log("통신 실패.");
          }
        });
      });
    });
  </script>