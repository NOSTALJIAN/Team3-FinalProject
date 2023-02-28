<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

      <!DOCTYPE html>
      <html class="h-100" lang="ko">

      <head>
        <!--   <title>WebSocket Chat</title> -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.min.js"></script>
        <%@ include file="../common/heading.jsp" %>
          <link rel="stylesheet" href="/css/room.css">
      </head>

      <body>
        <script type="module" src="/js/chatting/rooms.js"></script>
        <%@ include file="../common/top.jsp" %>
          <div id="container" class="container" style="margin-top: 120px; padding-bottom: 300px;">

            <!-- START -->
            <!-- 이름:<input type="text" id="nickname">
            <input type="button" id="enterBtn" value="입장">
            <input type="button" id="exitBtn" value="나가기">

            <h1>대화 영역</h1>
            <div id="chatArea">
              <div id="chatMessageArea"></div>
            </div>
            <br />
            <input type="text" id="message"> -->

            <!-- test 2 -->
            <form action="chattingDetailForm.ch" method="post" name="frm">
              <input type="hidden" id="chatNumber" name="chatNo">
            </form>
            <input type="hidden" id="userEmail" name="userEmail">
            <input type="hidden" id="userNick" name="userNick">
            <input type="hidden" id="chk_id" name="chk_id">
            <div class="inbox_people">
              <div class="headind_srch">
                <div class="recent_heading">
                  <b>${ projectName }</b> 채팅
                </div>
                <div class="srch_bar">
                  <div class="stylish-input-group">
                    <!-- 			 <input type="text" class="search-bar"  placeholder="Search" > -->
                    <div class="chatadd">
                      <div class="my-2"></div>
                      <a href="#" class="btn btn-primary btn-icon-split">
                        <span class="icon text-white-50">
                          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                            class="bi bi-plus-lg" viewBox="0 0 16 16">
                            <path
                              d="M8 0a1 1 0 0 1 1 1v6h6a1 1 0 1 1 0 2H9v6a1 1 0 1 1-2 0V9H1a1 1 0 0 1 0-2h6V1a1 1 0 0 1 1-1z" />
                          </svg>
                        </span>
                        <span class="text" id="chatAdd" data-toggle="modal" data-target="#chatAddModal">채팅방 만들기</span>
                      </a>
                    </div>
                  </div>
                </div>
              </div>
              <div id="wholeChatList">
              </div>
            </div>




            <!-- Scroll to Top Button-->
            <a class="scroll-to-top rounded" href="#page-top">
              <i class="fas fa-angle-up"></i>
            </a>

            <!-- Logout Modal-->
            <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
              aria-hidden="true">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">×</span>
                    </button>
                  </div>
                  <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                  <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                  </div>
                </div>
              </div>
            </div>
            <!-- chatAdd Modal-->
            <div class="modal fade" id="chatAddModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
              aria-hidden="true">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">채팅방 만들기</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close" id="clbutton">
                      <span aria-hidden="true" id="clspan">×</span>
                    </button>
                  </div>
                  <div class="modal-body">
                    <div class="input-group">
                      <input type="text" id="chatRoomName" class="form-control bg-light border-0 small"
                        placeholder="채팅방 이름 ..." aria-label="Search" aria-describedby="basic-addon2">
                    </div>

                    <div class="dropdown-divider"></div>
                    <c:forEach var="m" items="${ mArr }">
                      <c:if test="${ loginUser.email ne m.email}">

                        <div class="PMNicks">

                          <input type="checkbox" name="checkChat" value="${ m.email }" class="projectmem">
                          <input type="hidden" value="${ m.nickName }" name="memname">
                          <c:if test="${ m.reProfile ne null}">
                            <img class="twoprofile" style="margin-left:5px; width:36px; height:36px;"
                              src="resource/profileFiles/${ m.reProfile }">
                          </c:if>
                          <c:if test="${ m.reProfile eq null}">
                            <img class="twoprofile" style="margin-left:5px; width:36px; height:36px;"
                              src="resource/img/undraw_profile.svg" alt="sunil">
                          </c:if>
                          ${ m.nickName }<div class="dropdown-divider"></div>
                        </div>
                      </c:if>

                    </c:forEach>

                    <div class="chatBottom" align="right"><input class="chatAllBottom" type="checkbox"
                        name="allCheck">전체선택 </div>
                    <script type="text/javascript">
                      $('.chatAllBottom').click(function () {

                        if ($('.chatAllBottom').prop("checked")) {
                          $('input[type=checkbox]').prop('checked', true);
                        } else {
                          $('input[type=checkbox]').prop('checked', false);
                        }
                      });	
                    </script>

                  </div>
                  <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" onclick="invite();">초대하기</a>
                  </div>

                  <script>
                    function invite() {
                      var chk_id = [];
                      var memberName = [];

                      $(".projectmem:checked").each(function () {
                        var id = $(this).val();
                        var name = $(this).next().val();
                        memberName.push(name);
                        chk_id.push(id);
                      });

                      memberName.push('${loginUser.nickName}');
                      chk_id.push('${loginUser.email}');

                      var roomName = document.getElementById("chatRoomName").value;
                      document.getElementById("chk_id").value = chk_id;

                      var yesorno = confirm("입력한 정보로 채팅방을 생성하시겠습니까?");
                      if (yesorno == true) {
                        controlvar = 1;
                        sendMessage();
                        setTimeout(function () {
                          location.href = "chattingInvite.ch?emails=" + chk_id + "&roomName=" + roomName + "&memberNames=" + memberName;
                          alert("채팅방이 생성되었습니다.");
                        }, 1500);
                        controlvar = 0;
                      }
                    }

                    var sock = new SockJS("http://localhost:9580/pieceworks/alarm");
                    sock.onmessage = onMessage;
                    sock.onclose = onClose;
                    sock.onopen = onOpen;

                    function sendMessage() {
                      // 내 메시지 서버로 보내기
                      var message = '${ loginUser.nickName }님이 회원님을 채팅방에 초대했습니다.';
                      var emails = document.getElementById("chk_id").value;

                      if (controlvar == 0) {
                        var data = {
                          "alarmContent": '연결이 풀리지않게',
                          "alarmType": 1,
                          "projectNo": '${loginUser.currPno}'
                        };
                      } else {
                        var data = {
                          "alarmContent": message,
                          "recipient": emails,
                          "alarmType": 1,
                          "projectNo": '${loginUser.currPno}'
                        };
                      }
                      var jsonData = JSON.stringify(data);
                      console.log(jsonData);

                      sock.send(jsonData);
                    }


                    function onMessage(msg) {
                    }


                    function onClose(evt) {
                      console.log('나감');
                    }


                    function onOpen(evt) {
                      console.log('들어옴');
                    }

                  </script>
                </div>
              </div>
            </div>

            <!-- 나가기 Model -->
            <div class="modal fade" id="chatExitModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
              aria-hidden="true">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">채팅방을 나가시겠습니까?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">×</span>
                    </button>
                  </div>
                  <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" onclick="outRoomClick();">나가기</a>
                  </div>

                </div>
              </div>
            </div>

            <!-- 채팅방 이름수정 Model -->
            <div class="modal fade" id="chatNameChangeModal" tabindex="-1" role="dialog"
              aria-labelledby="exampleModalLabel" aria-hidden="true">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">채팅방 이름 수정</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">×</span>
                    </button>
                  </div>
                  <div class="input-group">
                    <input type="text" class="form-control bg-light border-0 small" placeholder="채팅방 이름..."
                      aria-label="Search" aria-describedby="basic-addon2" value="채팅방 이름" id="exampleModalLabelchange">
                  </div>
                  <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>
                    <a class="btn btn-primary" onclick="updateChatName();">수정</a>
                  </div>

                </div>
              </div>
            </div>

            <!-- 채팅 삭제 Model -->
            <div class="modal fade" id="chatDeleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
              aria-hidden="true">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">채팅방을 삭제하시겠습니까?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">×</span>
                    </button>
                  </div>
                  <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" onclick="deleteRoomClick();">삭제하기</a>
                  </div>

                </div>
              </div>
            </div>

          </div>
      </body>

      </html>