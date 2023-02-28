function getChattingList() {
  $.ajax({
    url: 'getChatList.ch',
    dataType: 'json',
    success: function (data) {
      console.log(data);

      $chatList = $('#wholeChatList');
      $chatList.html("<table id='tb'>");

      if (data.length > 0) {
        for (var i in data) {
          $li = $(
            [
              '<tr><td><div class="chat_list" onmouseover="chatMouseOver(this);" onmouseout="chatMouseLeave(this);" ondblclick="chatDeatilGo(' +
                data[i].chatNo +
                ', this)">',
              '<div class="chat_people">',
              '    <div class="chat_img"></div>',
              '        <div class="chat_ib">',
              '            <h5 class="innerh5">',
              '				<strong><div class="chatTitle"></div></strong><div class="joinMem"><img src="resource/img/personemo.png" style="height:15px; width:20px; margin-bottom:5px; margin-left:7px;"/> ' +
                data[i].joinMemCount +
                '</div>',
              '				<span class="chat_date"><div class="chat_dateDiv"></div><div class="unread"></div><a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"',
              '				role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">',
              '            		more',
              '					</a>',
              '        <span class="dropdown-menu dropdown-menu-right animated--fade-in" aria-labelledby="navbarDropdown">',
              '			<div class="outRoom"></div>',
              '			<div class="modifyRoom"></div>',
              '			<div class="deleteRoom"><div>',
              '    	</span></span></h5>',
              '		<p class="chatmeg"></p>',
              '</div></div></div></td></tr>',
            ].join('')
          );

          if (data[i].joinMember.length > 4) {
            var chatimghtml = '';
            var count = 0;

            for (var j in data[i].joinMember) {
              if ('${ loginUser.email }' != data[i].joinMember[j].chatMember) {
                if (data[i].joinMember[j].reProfile == null) {
                  if (count == 0) {
                    chatimghtml +=
                      '<img class="twoprofile" style="position:absolute; width:28px; height:28px;" src="resource/img/undraw_profile.svg" alt="sunil">';
                  } else if (count == 1) {
                    chatimghtml +=
                      '<img class="twoprofile" style="position:absolute; margin-left:30px; width:28px; height:28px;" src="resource/img/undraw_profile.svg" alt="sunil">';
                  } else if (count == 2) {
                    chatimghtml +=
                      '<img class="twoprofile" style="position:absolute; margin-top:30px; width:28px; height:28px;" src="resource/img/undraw_profile.svg" alt="sunil">';
                  } else {
                    chatimghtml +=
                      '<img class="twoprofile" style="position:absolute; margin-left:30px; margin-top:30px; width:28px; height:28px;" src="resource/img/undraw_profile.svg" alt="sunil">';
                    break;
                  }
                } else {
                  if (count == 0) {
                    chatimghtml +=
                      '<img class="twoprofile" style="position:absolute; width:28px; height:28px;" src="resource/profileFiles/' +
                      data[i].joinMember[j].reProfile +
                      '">';
                  } else if (count == 1) {
                    chatimghtml +=
                      '<img class="twoprofile" style="position:absolute;  margin-left:30px; width:28px; height:28px;" src="resource/profileFiles/' +
                      data[i].joinMember[j].reProfile +
                      '">';
                  } else if (count == 2) {
                    chatimghtml +=
                      '<img class="twoprofile" style="position:absolute; margin-top:30px; width:28px; height:28px;" src="resource/profileFiles/' +
                      data[i].joinMember[j].reProfile +
                      '">';
                  } else {
                    chatimghtml +=
                      '<img class="twoprofile" style="position:absolute;  margin-left:30px; margin-top:30px; width:28px; height:28px;" src="resource/profileFiles/' +
                      data[i].joinMember[j].reProfile +
                      '">';
                    break;
                  }
                }
                count++;
              }
            }

            $li.find('.chat_img').html(chatimghtml);
          }
          if (data[i].joinMember.length == 4) {
            var chatimghtml = '';
            var count = 0;

            for (var j in data[i].joinMember) {
              if ('${ loginUser.email }' != data[i].joinMember[j].chatMember) {
                if (data[i].joinMember[j].reProfile == null) {
                  if (count == 0) {
                    chatimghtml +=
                      '<img class="twoprofile" style="position:absolute; margin-left:12px; width:32px; height:32px;" src="resource/img/undraw_profile.svg" alt="sunil">';
                  } else if (count == 1) {
                    chatimghtml +=
                      '<img class="twoprofile" style="position:absolute; margin-top:25px; width:32px; height:32px;" src="resource/img/undraw_profile.svg" alt="sunil">';
                  } else {
                    chatimghtml +=
                      '<img class="twoprofile" style="position:absolute; margin-left:25px; margin-top:25px; width:32px; height:32px;" src="resource/img/undraw_profile.svg" alt="sunil">';
                  }
                } else {
                  if (count == 0) {
                    chatimghtml +=
                      '<img class="twoprofile" style="margin-left:12px; position:absolute; width:32px; height:32px;" src="resource/profileFiles/' +
                      data[i].joinMember[j].reProfile +
                      '">';
                  } else if (count == 1) {
                    chatimghtml +=
                      '<img class="twoprofile" style="position:absolute;  margin-top:25px; width:32px; height:32px;" src="resource/profileFiles/' +
                      data[i].joinMember[j].reProfile +
                      '">';
                  } else {
                    chatimghtml +=
                      '<img class="twoprofile" style="position:absolute; margin-left:25px; margin-top:25px; width:32px; height:32px;" src="resource/profileFiles/' +
                      data[i].joinMember[j].reProfile +
                      '">';
                  }
                }
                count++;
              }
            }

            $li.find('.chat_img').html(chatimghtml);
          }

          if (data[i].joinMember.length == 3) {
            var chatimghtml = '';
            var count = 0;

            for (var j in data[i].joinMember) {
              if ('${ loginUser.email }' != data[i].joinMember[j].chatMember) {
                if (data[i].joinMember[j].reProfile == null) {
                  if (count == 0) {
                    chatimghtml +=
                      '<img class="twoprofile" style="position:absolute; width:40px; height:40px;" src="resource/img/undraw_profile.svg" alt="sunil">';
                  } else {
                    chatimghtml +=
                      '<img class="twoprofile" style="position:absolute; margin-top:20px; margin-left:20px; width:40px; height:40px;" src="resource/img/undraw_profile.svg" alt="sunil">';
                  }
                } else {
                  if (count == 0) {
                    chatimghtml +=
                      '<img class="twoprofile" style=" position:absolute; width:40px; height:40px;" src="resource/profileFiles/' +
                      data[i].joinMember[j].reProfile +
                      '">';
                  } else {
                    chatimghtml +=
                      '<img class="twoprofile" style="position:absolute; margin-top:20px; margin-left:20px; width:40px; height:40px;" src="resource/profileFiles/' +
                      data[i].joinMember[j].reProfile +
                      '">';
                  }
                }
                count++;
              }
            }

            $li.find('.chat_img').html(chatimghtml);
          } else if (data[i].joinMember.length == 2) {
            for (var j in data[i].joinMember) {
              if ('${ loginUser.email }' != data[i].joinMember[j].chatMember) {
                if (data[i].joinMember[j].reProfile == null) {
                  $li
                    .find('.chat_img')
                    .html('<img class="twoprofile" src="resource/img/undraw_profile.svg" alt="sunil">');
                  break;
                } else {
                  $li
                    .find('.chat_img')
                    .html(
                      '<img class="img-profile rounded-circle twoprofile" alt="sunil" src="resource/profileFiles/' +
                        data[i].joinMember[j].reProfile +
                        '">'
                    );
                  break;
                }
              }
            }
          }

          var chatMemStr = '';
          if (data[i].chatTitle == null) {
            for (var j in data[i].joinMember) {
              if ('${ loginUser.email }' != data[i].joinMember[j].chatMember) {
                chatMemStr += data[i].joinMember[j].memberName + ' ';
                if (chatMemStr.length >= 20) {
                  chatMemStr = chatMemStr.substring(0, 20) + '...';
                  break;
                }
              }
            }

            if (data[i].joinMember.length == 1 && '${loginUser.email}' == data[i].joinMember[0].chatMember) {
              chatMemStr = '대화 상대 없음';
            }
            $li.find('.chatTitle').text(chatMemStr);
          } else {
            if (data[i].chatTitle.length > 20) {
              $li.find('.chatTitle').text(data[i].chatTitle.substring(0, 20) + '...');
            } else {
              $li.find('.chatTitle').text(data[i].chatTitle);
            }
          }

          if (data[i].unreadCount > 0) {
            $li.find('.unread').html('<div class="unreadMessage">' + data[i].unreadCount + '</div>');
          }

          if (data[i].sendDate >= '${ today }') {
            var timeFmV = '';
            var hours = 0;
            timeFmV += data[i].sendTime.substring(9, 11);
            timeFmV += ' ' + data[i].sendTime.substring(0, 2) + ':';
            timeFmV += data[i].sendTime.substring(3, 5);

            $li.find('.chat_dateDiv').text(timeFmV);
          } else {
            $li.find('.chat_dateDiv').text(data[i].sendDate);
          }

          $li
            .find('.outRoom')
            .html(
              '<a class="dropdown-item" id="chatExit" data-toggle="modal" data-target="#chatExitModal" onclick="outRoom(' +
                data[i].chatNo +
                ', `${ loginUser.email }`, `${ loginUser.nickName }`);">나가기</a>'
            );

          if (data[i].joinMember.length > 2 && '${ loginUser.email }' == data[i].chatCreator) {
            $li
              .find('.modifyRoom')
              .html(
                '<a class="dropdown-item" id="chatNameChange" data-toggle="modal" data-target="#chatNameChangeModal"  onclick="modifyRoomName(' +
                  data[i].chatNo +
                  ', `' +
                  data[i].chatTitle +
                  '`)"' +
                  '>이름수정</a>'
              );
          }

          if ('${ loginUser.email }' == data[i].chatCreator) {
            $li
              .find('.deleteRoom')
              .html(
                '<a class="dropdown-item" id="chatDelete" data-toggle="modal" data-target="#chatDeleteModal" onclick="deleteRoom(' +
                  data[i].chatNo +
                  ');">삭제</a>'
              );
          }

          $li.find('.chatmeg').text(data[i].chatMessage);

          $chatList.append($li);
          $chatList.append('</table>');
        }
      } else {
      }
    },
    error: function (data) {
      console.log(data);
    },
  });
}
var controlvar = 0;
$(function () {
  getChattingList();
  var isCreate = '${ isCreate }';
  if (isCreate == true) {
    document.getElementById('chatNumber').value = '${ chatRoomNum }';
    var newWindow = window.open(
      'chattingDetailForm.ch?chatNo=${chatRoomNum}',
      '채팅',
      'width=400, height=500, resizable=yes, scrollbars=yes, left=200, top=100'
    );
    newWindow.focus();
    frm.target = '채팅';

    frm.submit();
  }

  setInterval(function () {
    getChattingList();
    sendMessage();
  }, 5000);
});
function chatMouseOver(me) {
  me.style.backgroundColor = '#D2D6EB';
  me.childNodes[0].childNodes[3].lastChild.style.color = 'black';
}
function chatMouseLeave(me) {
  me.style.backgroundColor = '#F5F5F5';
  me.childNodes[0].childNodes[3].lastChild.style.color = 'gray';
}
function chatDeatilGo(num, me) {
  document.getElementById('chatNumber').value = num;
  var newWindow = window.open(
    'chattingDetailForm.ch?chatNo=${chatRoomNum}',
    '채팅',
    'width=380, height=500, resizable=yes, scrollbars=yes, left=200, top=100'
  );
  newWindow.focus();
  frm.target = '채팅';
  frm.submit();
}
function modifyRoomName(num, title) {
  if (title == 'undefined') {
    document.getElementById('exampleModalLabelchange').value = '새로운 채팅방 이름 입력';
  } else {
    document.getElementById('exampleModalLabelchange').value = title;
  }

  document.getElementById('chatNumber').value = num;
}
function updateChatName() {
  var chatNum = document.getElementById('chatNumber').value;
  var chatTitle = document.getElementById('exampleModalLabelchange').value;

  var yesorno = confirm(chatTitle + '로(으로) 채팅방 이름을 변경하시겠습니까?');
  if (yesorno == true) {
    location.href = 'updateChatTitle.ch?chatNo=' + chatNum + '&chatTitle=' + chatTitle;
  }
}
function outRoom(chatNo, userEmail, nickName) {
  document.getElementById('chatNumber').value = chatNo;
  document.getElementById('userEmail').value = userEmail;
  document.getElementById('userNick').value = nickName;
}
function outRoomClick() {
  var chatNo = document.getElementById('chatNumber').value;
  var email = document.getElementById('userEmail').value;
  var nickName = document.getElementById('userNick').value;

  location.href = 'chatRoomOut.ch?chatNo=' + chatNo + '&userEmail=' + email + '&nickName=' + nickName;
}
function deleteRoom(chatNo) {
  document.getElementById('chatNumber').value = chatNo;
}
function deleteRoomClick() {
  var chatNo = document.getElementById('chatNumber').value;

  location.href = 'deleteRoom.ch?chatNo=' + chatNo;
}

// var wsocket;

// function connect() {
//   wsocket = new SockJS('/chat-ws.ch');
//   wsocket.onopen = onOpen;
//   wsocket.onmessage = onMessage;
//   wsocket.onclose = onClose;
// }
// function disconnect() {
//   wsocket.close();
// }
// function onOpen(evt) {
//   appendMessage('연결되었습니다.');
// }
// function onMessage(evt) {
//   var data = evt.data;
//   if (data.substring(0, 4) == 'msg:') {
//     appendMessage(data.substring(4));
//   }
// }
// function onClose(evt) {
//   appendMessage('연결을 끊었습니다.');
// }

// function send() {
//   var nickname = $('#nickname').val();
//   var msg = $('#message').val();
//   wsocket.send('msg:' + nickname + ':' + msg);
//   $('#message').val('');
// }
// function appendMessage(msg) {
//   $('#chatMessageArea').append(msg + '<br>');
//   var chatAreaHeight = $('#chatArea').height();
//   var maxScroll = $('#chatMessageArea').height() - chatAreaHeight;
//   $('#chatArea').scrollTop(maxScroll);
// }
// $(document).ready(function () {
//   $('#message').keypress(function (event) {
//     var keycode = event.keyCode ? event.keyCode : event.which;
//     if (keycode == '13') {
//       send();
//     }
//     event.stopPropagation();
//   });
//   $('#sendBtn').click(function () {
//     send();
//   });
//   $('#enterBtn').click(function () {
//     connect();
//   });
//   $('#exitBtn').click(function () {
//     disconnect();
//   });
// });
