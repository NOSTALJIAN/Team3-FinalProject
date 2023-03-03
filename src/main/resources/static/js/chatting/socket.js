// var wsocket = new SockJS('/chat');
// var client = Stomp.over(wsocket);
// client.connect({}, function (frame) {
//   client.subscribe('/topic/messages', function (message) {
//     showMessage(JSON.parse(message.body));
//   });
// });

// client.send(
//   '/app/chat/' + topic,
//   {},
//   JSON.stringify({
//     sender: $('#sender').val(),
//     content: $('#content').val(),
//   })
// );

var stompClient = null;
var cid = $('cid').val();
var chatList = $('chatList').val();

function setConnected(connected) {
  $('#connect').prop('disabled', connected);
  $('#disconnected').prop('disabled', !connected);
  if (connected) {
    $('#conversation').show();
  } else {
    $('#conversation').hide();
  }
  $('#chatting').html('');
}

function connect() {
  var socket = new SockJS('/ws/chat');
  stompClient = Stomp.over(socket);
  stompClient.connect({}, function (frame) {
    setConnected(true);
    console.log('연결 성공! ' + frame);
    loadChat(chatList); //  저장된 채팅 불러오기

    //  room/{cid}를 구독
    stompClient.subscribe('/room' + cid, function (chatMsg) {
      showChat(JSON.parse(chatMsg.body));
    });
  });
}

function disconnect() {
  if (stompClient !== null) {
    stompClient.disconnect();
  }
  setConnected(false);
  console.log('연결 해제!');
}

function sendChat() {
  stompClient.send(
    '/send/' + cid,
    {},
    JSON.stringify({
      sender: $('#sender').val(),
      message: $('#message').val(),
    })
  );
}

function showChat(chatMsg) {
  $('#chatting').append('<tr><td>' + '[' + chatMsg.sender + ']' + chatMsg.message + '</td></tr>');
}

function loadChat(chatList) {
  if (chatList != null) {
    for (chat in chatList) {
      $('#chatting').append('<tr><td>' + '[' + chatList[chat].sender + ']' + chatList[chat].message + '</td></tr>');
    }
  }
}

$(function () {
  $('form').on('submit', function (e) {
    e.preventDefault();
  });
  $('#connect').click(function () {
    connect();
  });
  $('#disconnect').click(function () {
    disconnect();
  });
  $('#send').click(function () {
    sendChat();
  });
});

window.onload = function () {
  connect();
};

window.BeforeUnloadEvent = function () {
  disconnect();
};
