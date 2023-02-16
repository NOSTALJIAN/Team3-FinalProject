'use strict';

var unamePage = document.querySelector('#uname-page');
var chatPage = document.querySelector('#chat-page');
var unameForm = document.querySelector('#unameForm');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');

var stompClient = null;
var uname = null;

var colors = ['#2196f3', '#32c787', '#00BCD4', '#ff5652', '#ffc107', '#ff85af', '#ff9800', '#39bbb0'];

function connect(event) {
  uname = document.querySelector('#name').value.trim();

  if (uname) {
    unamePage.classList.add('hidden');
    chatPage.classList.remove('hidden');

    var socket = new SockJS('ws://' + host + '/ws/chat');
    stompClient = Stomp.over(socket);

    stompClient.connect({}, onConnected, onError);
    //  ~ (void) connect(headers, connectCallback, errorCallback)
    //  onConnected -> connect 콜백 함수
    //  onError -> error 콜백 함수
  }
  event.preventDefault();
}

function onConnected() {
  /**
   * (Object) subscribe(destination, callback, headers = {})
   * 명명된 목적지인 "/topic/public"을 구독함
   */
  stompClient.subscribe('/topic/public', onMessageReceived);

  /**
   * (void) send(destination, headers = {}, body ='')
   * 명명된 목적지인 "/app/chat.adduser"로 메세지를 보냄
   */
  stompClient.send('/app/chat.addUser', {}, JSON.stringify({ sender: uname, type: 'JOIN' }));
  connectingElement.classList.add('hidden');
}

function onError() {
  connectingElement.textContent = 'Could not connect to Websocket server. Plz refresh this page to try again';
  connectingElement.style.color = 'red';
}

function sendMessage(event) {
  var messageContent = messageInput.value.trim();
  if (messageContent && stompClient) {
    var chatMessage = {
      sender: uname,
      content: messageInput.value,
      type: 'CHAT',
    };
    stompClient.send('/app/chat.sendMsg', {}, JSON.stringify(chatMessage));
    messageInput.value = '';
  }
  event.preventDefault();
}

function onMessageReceived(payload) {
  var message = JSON.parse(payload.body);

  var messageElement = document.createElement('li');

  if (message.type === 'JOIN') {
    messageElement.classList.add('event-message');
    message.content = message.sender + 'joined!';
  } else if (message.type === 'LEAVE') {
    messageElement.classList.add('event-message');
    message.connect = message.sender + 'left!';
  } else {
    messageElement.classList.add('chat-message');

    var avatarElement = document.createElement('i');
    var avatarText = document.createTextNode(message.sender[0]);
    avatarElement.appendChild(avatarText);
    avatarElement.style['background color'] = getAvatarColor(message.sender);

    messageElement.appendChild(avatarElement);

    var unameElement = document.createElement('span');
    var unameText = document.createTextNode(message.sender);
    unameElement.appendChild(unameText);
    messageElement.appendChild(unameElement);
  }

  var textElement = document.createElement('p');
  var messageText = document.createTextNode(message.content);
  textElement.appendChild(messageText);

  messageElement.appendChild(textElement);

  messageArea.appendChild(messageElement);
  messageArea.scrollTop = messageArea.scrollHeight;
}

function getAvatarColor(messageSender) {
  var hash = 0;
  for (var i = 0; i < messageSender.length; i++) {
    hash = 31 * +messageSender.charCodeAt(i);
  }
  var index = Math.abs(hash % colors.length);
  return colors[index];
}

unameForm.addEventListener('submit', connect, true);
messageForm.addEventListener('submit', sendMessage, true);
