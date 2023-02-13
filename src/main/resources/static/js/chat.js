var ws = null;

window.onload = wsOpen();

/** 채팅 메세지를 화면에 표시 */
function addLineToChatBox(_line) {
  if (_line == null) {
    _line = '';
  }
  var chatBoxArea = document.getElementById('chatBoxArea');
  chatBoxArea.value += _line + '\n';
  chatBoxArea.scrollTop = chatBoxArea.scrollHeight;
}

function wsOpen() {
  host = 'localhost:8080';
  ws = new WebSocket('ws://' + host + '/websocket');
  /** 웹소켓 접속 성공시 실행 */
  ws.onopen = function (message) {
    addLineToChatBox('서버 연결 성공 🥳');
  };
  ws.onmessage = function (message) {
    addLineToChatBox(message.data);
  };
  document.addEventListener('keypress', function (e) {
    if (e.keyCode == 13) {
      //  enter press
      send();
    }
  });
}

function chatName() {
  var userName = $('#userName').val();
  if (userName == null || userName.trim() == '') {
    alert('사용자 이름을 입력해주십시오.');
    $('#userName').focus();
  } else {
    $('#yourName').hide();
    $('#yourMsg').show();
  }
}

function send() {
  var uN = $('#userName').val();
  var msg = $('#inputMsgBox').val();
  if (msg != '' && uN != '') {
    ws.send(uN + ' : ' + msg);
    $('#inputMsgBox').val('');
  }
}
