package com.example.petMate.chat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class EchoHandler extends TextWebSocketHandler {

	//    // afterConnectionEstablished : 웹소켓이 연결되면 호출되는 함수
	//    // 웹소켓이 연결 되는 것 = 프론트에서 웹소켓이 정확한 경로를 잡아 생성 되는 것
	//    @Override
	//    public void afterConnectionEstablished(WebSocketSession session) 
	//            throws Exception {
	//        System.out.printf("%s 연결 됨\n", session.getId());
	//    }
	//
	//    // 웹소켓 클라이언트가 텍스트 메세지 전송시 호출되는 메소드
	//    // WebSocketSession session : 전송 주체 정보가 담긴 세션
	//    // TextMessage message : 전송 받은 메세지 정보
	//    @Override
	//    protected void handleTextMessage(
	//            WebSocketSession session, TextMessage message) throws Exception {
	//        System.out.printf("%s로부터 [%s] 받음\n", 
	//                session.getId(), message.getPayload());
	//        session.sendMessage(new TextMessage("echo: " + message.getPayload()));
	//    }
	//
	//    // afterConnectionClosed : 웹소켓이 연결이 종료되면 호출되는 함수
	//    // 웹소켓이 연결이 종료 = 세션 종료
	//    @Override
	//    public void afterConnectionClosed(
	//            WebSocketSession session, CloseStatus status) throws Exception {
	//        System.out.printf("%s 연결 끊김\n", session.getId());
	//    }

	private static List<WebSocketSession> list = new ArrayList<WebSocketSession>();
	//클라이언트가 접속 했을 때 호출되는 메소드 

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		list.add(session);
		System.out.println("하나의 클라이언트가 연결됨 ");
	}

	//클라이언트가 메시지를 보냈을 때 호출되는 메소드 
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// 전송된 메시지를 List의 모든 세션에 전송

		String msg = message.getPayload();
		for (WebSocketSession s : list) {
			s.sendMessage(new TextMessage(msg));
		}
	}
	
	// 클라이언트의 접속이 해제 되었을 때 호출되는 메소드]
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("클라이언트와 연결 해제됨");
		list.remove(session);

	}
}