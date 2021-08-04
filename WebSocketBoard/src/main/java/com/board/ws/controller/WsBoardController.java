package com.board.ws.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;

import com.board.ws.domain.dto.BoardDTO;
import com.board.ws.domain.vo.BoardVO;
import com.board.ws.service.BoardService;

@Controller
@ServerEndpoint(value = "/ws/board")
public class WsBoardController {
	private static final List<Session> sessionList = new ArrayList<Session>();
	private static final Logger logger = LoggerFactory.getLogger(WsBoardController.class);

	public static BoardService boardService;

	@Autowired
	public void setBoardService(BoardService boardService) {
		WsBoardController.boardService = boardService;
	}

	public JSONObject getView(String id) {
		BoardVO vo = boardService.selectBoardById(id);
		JSONObject jo = new JSONObject();
		jo.put("title", vo.getTitle());
		jo.put("content", vo.getContent());
		jo.put("view", vo.getView());
		
		return jo;
	}

	@OnOpen
	public void onOpen(Session session) {
		logger.info("Open session id:" + session.getId());
		try {
			final Basic basic = session.getBasicRemote();
			JSONObject jo = new JSONObject();
			jo.put("type", "init");
			jo.put("data", "success");
			basic.sendText(jo.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		sessionList.add(session);
	}

	/*
	 * @param self
	 * 
	 * @param sender
	 * 
	 * @param message
	 */
	/*
	 * private void sendAllSessionToMessage(Session self, JSONObject object) {
	 * 
	 * try { for(Session session : WsBoardController.sessionList) {
	 * if(!self.getId().equals(session.getId())) {
	 * session.getBasicRemote().sendText(object.toString()); } } }catch (Exception
	 * e) { // TODO: handle exception e.printStackTrace();
	 * //System.out.println(e.getMessage()); } }
	 */

	/*
	 * @param message
	 * 
	 * @param session
	 */
	@OnMessage
	public void onMessage(String message, Session session) {

		try {
			final Basic basic = session.getBasicRemote();
			// sender, message
			JSONObject jo = new JSONObject(message);
			String path = jo.getString("path");
			String seq = jo.getString("seq");
			JSONObject response = new JSONObject();
			response.put("seq", seq);
			if (path.equals("/ws/board/view")) {
				try {
					JSONObject data = jo.getJSONObject("data");
					
					response.put("data", getView(data.getString("id")));
					response.put("result", "ok");
					basic.sendText(response.toString());
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}else if(path.equals("/ws/board/write")) {
				JSONObject data = jo.getJSONObject("data");
				BoardDTO dto = new BoardDTO();
				dto.setTitle(data.getString("title"));
				dto.setContent(data.getString("content"));
				boardService.insertBoard(dto);
				response.put("result", "ok");
				basic.sendText(response.toString());
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@OnError
	public void onError(Throwable e, Session session) {

	}

	@OnClose
	public void onClose(Session session) {
		logger.info("Session " + session.getId() + " has ended");
		sessionList.remove(session);
	}

}
