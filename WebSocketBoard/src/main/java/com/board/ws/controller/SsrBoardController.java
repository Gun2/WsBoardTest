package com.board.ws.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.ws.domain.dto.BoardDTO;
import com.board.ws.domain.dto.CriteriaDTO;
import com.board.ws.domain.dto.PageMakerDTO;
import com.board.ws.domain.vo.BoardVO;
import com.board.ws.service.BoardService;

@Controller
public class SsrBoardController {
	private static final Logger LOG = LoggerFactory.getLogger(SsrBoardController.class);
	
	private final BoardService boardService;
	
	@Autowired
	public SsrBoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	

	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String list(Locale locale, Model model
			, @ModelAttribute CriteriaDTO cri) {
	    PageMakerDTO pageMaker = new PageMakerDTO();
	    pageMaker.setCri(cri);
	    pageMaker.setTotalCount(boardService.selectBoardCount(cri));
	    List<BoardVO> voList = boardService.selectBoardList(cri);
	    model.addAttribute("list", voList);
	    model.addAttribute("pageMaker", pageMaker);
	    model.addAttribute("tab", "1");
		return "/board/list";
	}
	
	@RequestMapping(value = "/board/view/{id}", method = RequestMethod.GET)
	public String view(Locale locale, Model model,
			@PathVariable(name = "id") String id) {
		BoardVO vo = boardService.selectBoardById(id);
		model.addAttribute("boardVO", vo);
		model.addAttribute("tab", "1");
		return "/board/view";
	}
	
	@RequestMapping(value = "/board/delete/{id}", method = RequestMethod.GET)
	public String delete(Locale locale, Model model,
			@PathVariable(name = "id") String id) {
		boardService.deleteBoardById(id);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/board/create", method = RequestMethod.GET)
	public String create(Locale locale, Model model) {
		model.addAttribute("form", "create");
		model.addAttribute("tab", "1");
		return "/board/modify";
	}
	
	@RequestMapping(value = "/board/create", method = RequestMethod.POST)
	public String createPost(@ModelAttribute BoardDTO dto) {
		boardService.insertBoard(dto);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/board/modify/{id}", method = RequestMethod.GET)
	public String c(Locale locale, Model model,
			@PathVariable(name = "id") String id) {
		BoardVO vo = boardService.selectBoardById(id);
		model.addAttribute("boardVO", vo);
		model.addAttribute("form", "modify");
		model.addAttribute("tab", "1");
		return "/board/modify";
	}
	
	@RequestMapping(value = "/board/modify", method = RequestMethod.POST)
	public String modifyPost(@ModelAttribute BoardVO vo) {
		LOG.info(vo.toString());
		boardService.updateBoard(vo);
		return "redirect:/board/view/" + vo.getId();
	}
	
	@RequestMapping(value = "/spa/board/view", method = RequestMethod.GET)
	public String spaBoard(Model model) {
		model.addAttribute("tab", "2");
		return "/spaBoard/board";
	}
	
	@RequestMapping(value = "/spa/wsBoard/view", method = RequestMethod.GET)
	public String wsBoard(Model model) {
		model.addAttribute("tab", "3");
		return "/wsBoard/wsBoard";
	}
}
