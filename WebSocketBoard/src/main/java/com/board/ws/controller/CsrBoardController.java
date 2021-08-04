package com.board.ws.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.board.ws.domain.dto.CriteriaDTO;
import com.board.ws.domain.dto.PageMakerDTO;
import com.board.ws.domain.vo.BoardVO;
import com.board.ws.service.BoardService;

@RestController
public class CsrBoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/api/board/list/{page}", method = RequestMethod.GET)
	public HashMap list(Locale locale, Model model
			, @PathVariable(name = "page") int page) {
		CriteriaDTO cri = new CriteriaDTO();
		cri.setPage(page);
	    PageMakerDTO pageMaker = new PageMakerDTO();
	    pageMaker.setCri(cri);
	    pageMaker.setTotalCount(boardService.selectBoardCount(cri));
	    List<BoardVO> voList = boardService.selectBoardList(cri);
	    HashMap result = new HashMap();
	    result.put("list", voList);
	    result.put("pageMaker", pageMaker);
		return result;
	}
	
	@RequestMapping(value = "/api/board/view/{id}", method = RequestMethod.GET)
	public HashMap view(Locale locale, Model model,
			@PathVariable(name = "id") String id) {
		BoardVO vo = boardService.selectBoardById(id);
		HashMap result = new HashMap();
		result.put("data", vo);
		return result;
	}
	
	@RequestMapping(value = "/api/board", method = RequestMethod.POST)
	public String createPost(@RequestBody BoardVO vo) {
		boardService.insertBoard(vo);
		
		return "OK";
	}
}
