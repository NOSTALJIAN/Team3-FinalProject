package com.mulcam.SpringProject.chatting.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.mulcam.SpringProject.chatting.entity.ChatRoomVO;
import com.mulcam.SpringProject.chatting.entity.ChatSession;
import com.mulcam.SpringProject.chatting.entity.MessageVO;
import com.mulcam.SpringProject.chatting.service.ChatService;
import com.mulcam.SpringProject.chatting.service.LoginService;
import com.mulcam.SpringProject.entity.User;
import com.mulcam.SpringProject.service.UserService;
import com.mulcam.SpringProject.session.UserSession;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
public class ChatController {
	
	   @Autowired ChatService cService;
	   
	   @Autowired private ChatSession cSession;
	   @Autowired private UserSession uSession;
	   
		@GetMapping("/chat")
		public String chat() {
			return "chat/chatForm";
		}
	   
	   /**
	    * 해당 채팅방의 채팅 메세지 불러오기
	    * @param roomId
	    * @param model
	    * @param response
	    * @throws JsonIOException
	    * @throws IOException
	    */
	   @GetMapping("{room_id}.do")
	   public void messageList(@PathVariable String room_id, String user_id, Model model, HttpServletResponse response) throws JsonIOException, IOException {
	       
	       List<MessageVO> mList = cService.messageList(room_id);
	       response.setContentType("application/json; charset=utf-8");

	       // 안읽은 메세지의 숫자 0으로 바뀌기
	       MessageVO message = new MessageVO();
	       message.setUser_id(user_id);
	       message.setRoom_id(room_id);
	       cService.updateCount(message);
	       
	       Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	       gson.toJson(mList,response.getWriter());
	   }
	   
	   /**
	    * 채팅 방이 없을 때 생성
	    * @param room
	    * @param userEmail
	    * @param masterNickname
	    * @return
	    */
	 
	   @PostMapping("/createChat.do")
	   public String createChat(ChatRoomVO room, @RequestParam String user_nickname, @RequestParam String user_id, HttpSession session){
	       
			/* UserMaster m = pService.getProductDetail(masterNickname); */
	       
//	       room.setUser_id(user_id);
	       room.setUser_id(uSession.getUid());
	       room.setUser_nickname(uSession.getNickname());
//	       room.setUser_nickname(user_nickname);
			/*
			 * room.setMasterEmail(m.getEmail()); room.setMasterName(m.getmNickname());
			 * room.setMasterPic(m.getmProPicRe());
			 */

	       ChatRoomVO exist  = cService.searchChatRoom(room);
	       
	       // DB에 방이 없을 때
	       if(exist == null) {
	           System.out.println("방이 없다!!");
	           int result = cService.createChat(room);
	           if(result == 1) {
	               System.out.println("방 만들었다!! =>새로운 채팅방으로");
	               return "mypage/chat/chatForm";
	           }else {
	               return "redirect:/";
	           }
	       }
	       // DB에 방이 있을 때
	       else{
	           System.out.println("방이 있다!! =>기존 채팅방으로");
	           return "chat/chatForm";
	       }
	   }
	   
	   /**
	    * 채팅 방 목록 불러오기
	    * @param room
	    * @param userEmail
	    * @param response
	    * @throws JsonIOException
	    * @throws IOException
	    */
	   @GetMapping("chatRoomList.do")
	   public void createChat(ChatRoomVO room, MessageVO message, String user_id, HttpServletResponse response, Model model) throws JsonIOException, IOException{
	       List<ChatRoomVO> cList = cService.chatRoomList(user_id);
	       
	       for(int i = 0; i < cList.size(); i++) {
	           message.setRoom_id(cList.get(i).getRoom_id());
	           message.setUser_id(user_id);
	           int count = cService.selectUnReadCount(message);
	           cList.get(i).setUnReadCount(count);
	       }
	       System.out.println("방목록:" +cList);
	       model.addAttribute("cList", cList);
	       response.setContentType("application/json; charset=utf-8");

	       Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	       gson.toJson(cList,response.getWriter());
	   }
	   
	   @GetMapping("chatSession.do")
	   public void chatSession( HttpServletResponse response) throws JsonIOException, IOException{
	       
	       ArrayList<String> chatSessionList = cSession.getAuthUser();
	       
	       response.setContentType("application/json; charset=utf-8");

	       Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	       gson.toJson(chatSessionList,response.getWriter());
	   }
	   
	   @ResponseBody
	   @GetMapping("/deleteRoom")
	   public String deleteRoom(String room_id) {
		   cService.deleteRoom(room_id);
		   System.out.println(room_id + "번의방삭제");
		   
		  return "redirect:/";

	   }
	
//	@Autowired private ChatSession cSession;
//	@Autowired private ChatService chatService;
//	@Autowired private LoginService loginService;
//	
//    /**
//     * 해당 채팅방의 채팅 메세지 불러오기
//     * @param roomId
//     * @param userId
//     * @param model
//     * @param response
//     * @throws JsonIOException
//     * @throws IOException
//     */
//    @GetMapping("{roomId}.do")
//    public void messageList(@PathVariable String roomId, String userId, Model model, HttpServletResponse response) throws JsonIOException, IOException {
//        
//        List<MessageVO> mList = chatService.messageList(roomId);
//        response.setContentType("application/json; charset=utf-8");
// 
//        // 안읽은 메세지의 숫자 0으로 바뀌기
//        MessageVO message = new MessageVO();
//        message.setMid(Integer.parseInt(userId));
//        message.setRoomId(Integer.parseInt(roomId));
//        chatService.updateCount(message);
//        
//        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
//        gson.toJson(mList,response.getWriter());
//    }
//    
//    /**
//     * 채팅 방이 없을 때 생성
//     * @param room
//     * @param userName
//     * @param userId
//     * @param receiverId
//     * @return
//     */
//    @ResponseBody
//    @GetMapping("createChat.do")
//    public String createChat(ChatRoomVO room, String uname, String uid) throws Exception{
//        
////    	User m = loginService.getUserInfo(Integer.parseInt(receiver)); //쪽지 받는 사람의 정보 가져오기
//        
//        room.setSender(uname);
////        room.setReceiver(m.getUid());
// 
//        ChatRoomVO exist  = chatService.searchChatRoom(room);
//        
//        // DB에 방이 없을 때
//        if(exist == null) {
//            System.out.println("방이 없다!!");
//            int result = chatService.createChat(room);
//            if(result == 1) {
//                System.out.println("방 만들었다!!");
//                return "new";
//            }else {
//                return "fail";
//            }
//        }
//        // DB에 방이 있을 때
//        else{
//            System.out.println("방이 있다!!");
//            return "exist";
//        }
//    }
//    
//    /**
//     * 채팅 방 목록 불러오기
//     * @param room
//     * @param userId
//     * @param response
//     * @throws JsonIOException
//     * @throws IOException
//     */
//    @GetMapping("chatRoomList.do")
//    public void createChat(ChatRoomVO room, MessageVO message, String userId, HttpServletResponse response) throws JsonIOException, IOException{
//        List<ChatRoomVO> cList = chatService.chatRoomList(userId);
//        
//        for(int i = 0; i < cList.size(); i++) {
//            message.setRoomId(cList.get(i).getId());
//            message.setMid(Integer.parseInt(userId));
//            int count = chatService.selectUnReadCount(message);
//            cList.get(i).setUnReadCount(count);
//        }
//        
//        response.setContentType("application/json; charset=utf-8");
// 
//        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
//        gson.toJson(cList,response.getWriter());
//    }
//    
//    @GetMapping("chatSession.do")
//	public void chatSession( HttpServletResponse response) throws JsonIOException, IOException{
//		
//		ArrayList<Integer> chatSessionList = cSession.getLoginUser();
//		System.out.println(chatSessionList);
//		response.setContentType("application/json; charset=utf-8");
//
//		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
//		gson.toJson(chatSessionList,response.getWriter());
//	}
	
//	@GetMapping("/ChatRoom/{memberId}")
//	public String myChat(@PathVariable ("memberId") String memberId, Model model) {
//		model.addAttribute("rooms", cs.findAllRooms());
//		
//		return "/chat/ChatRoom";
//	}
//	
//	@PostMapping("/room")
//	public String create(@RequestParam String name, HttpSession session, Model model) {
//		String memberId = (String) session.getAttribute("sessionUid");
//		String memberNick = (String) session.getAttribute("sessionNickname");
//		log.info("# Create Chat Room !! name : " + name);
//		
//		cs.createChatRoomDTO(name, memberNick);
//		
//		return "redirect:/chat/ChatRoom/" + memberId;
//	}
//	
//	@GetMapping("/room")
//	public void getRoom(@RequestParam String roomId, Model model, HttpSession session) {
//		roomId = (String) session.getAttribute("sessionUid");
//		String memberProfileName = us.getUname(roomId);
//		model.addAttribute("memberProfileName", memberProfileName);
//		
//		log.info(" # Get Chat Room !! roomID : " + roomId);
//		
//		model.addAttribute("room", cs.findRoomById(roomId));
//	}
//
//	@GetMapping("/chatroom")
//	public String test(Model model, HttpSession session) {
//		String memberId = (String) session.getAttribute("sessionUid");
//		String memberNick = (String) session.getAttribute("sessionNickname");
//		model.addAttribute("memberId", memberId);
//		model.addAttribute("memberNick", memberNick);
//		System.out.println(memberId);
//		System.out.println(memberNick);
//		return "chat/chatroom";
//	}
}
