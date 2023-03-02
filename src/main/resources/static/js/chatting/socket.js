var wsocket = new SockJS('/chat');
var client = Stomp.over(wsocket);
client.connect({}, function (frame) {
  client.subscribe('/topic/messages', function (message) {
    showMessage(JSON.parse(message.body));
  });
});

client.send(
  '/app/chat/' + topic,
  {},
  JSON.stringify({
    sender: $('#sender').val(),
    content: $('#content').val(),
  })
);
