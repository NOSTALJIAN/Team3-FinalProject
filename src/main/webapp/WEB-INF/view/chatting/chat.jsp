<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>웹소켓 테스트 페이지</title>
        <script type="text/javascript">
            var g_webSocket = null;

            window.onload = function () {
                // host = "49.50.173.221:8090";  /* 배포시에 호스트 주소로 변경 */
                host = "localhost:8080";
                g_webSocket = new WebSocket("ws://" + host + "/ws/chat");
                /** 웹소켓 접속 성공시 실행 */
                g_webSocket.onopen = function (message) {
                    addLineToChatBox("Server is connected...");
                };
                /** 웹소켓 서버로부터 메세지 수신시 실행 */
                g_webSocket.onmessage = function (message) {
                    addLineToChatBox(message.data);
                };
                /** 웹소켓 이용자가 연결을 해제하는 경우 실행 */
                g_webSocket.onclose = function (message) {
                    addLineToChatBox("Server is disconnected...");
                };
                /** 웹소켓 에러 발생시 실행 */
                g_webSocket.onerror = function (message) {
                    addLineToChatBox("Error!");
                };
            };

            /** 채팅 메세지를 화면에 표시 */
            function addLineToChatBox(_line) {
                if (_line == null) {
                    _line = "";
                }
                var chatBoxArea = document.getElementById("chatBoxArea");
                chatBoxArea.value += _line + "\n";
                chatBoxArea.scrollTop = chatBoxArea.scrollHeight;
            }

            /** Send 버튼 클릭시 서버로 메세지 전송 */
            function sendButton_onClick() {
                var inputMsgBox = document.getElementById("inputMsgBox");
                if (inputMsgBox == null || inputMsgBox.value == null || inputMsgBox.value.length == 0) {
                    return false;
                }
                var chatBoxArea = document.getElementById("chatBoxArea");
                if (g_webSocket == null || g_webSocket.readyState == 3) {
                    chatBoxArea.value += "Server is disconnected... \n";
                    return false;
                }
                //  서버로 메세지 전송
                g_webSocket.send(inputMsgBox.value);
                inputMsgBox.value = "";
                inputMsgBox.focus();
                return true;
            }

            /** Disconnect 버튼 클릭시 호출 */
            function disconnectButton_onClick() {
                if (g_webSocket != null) {
                    g_webSocket.close();
                }
            }

            /** inputMsgBox 키 입력시 호출 */
            function inputMsgBox_onkeypress() {
                if (event == null) {
                    return false;
                }
                //  엔터키 누를 경우 서버로 메세지 전송
                var keyCode = event.keyCode || event.which;
                if (keyCode == 13) {
                    sendButton_onClick();
                }
            }
        </script>
    </head>

    <body>
        <input id="inputMsgBox" style="width: 250px;" type="text" onkeypress="inputMsgBox_onkeypress()">
        <input id="sendButton" value="Send" type="button" onclick="sendButton_onClick()">
        <input id="disconnectButton" value="Disconnect" type="button" onclick="disconnectButton_onClick()">
        <br />
        <textarea id="chatBoxArea" style="width: 100%;" rows="10" cols="50" readonly="readonly"></textarea>
    </body>

    </html>