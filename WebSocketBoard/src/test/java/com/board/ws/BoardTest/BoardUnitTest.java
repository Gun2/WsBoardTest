package com.board.ws.BoardTest;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.board.ws.TestConfig;
import com.board.ws.domain.dao.BoardDAO;
import com.board.ws.domain.dto.BoardDTO;
import com.board.ws.domain.dto.CriteriaDTO;
import com.board.ws.domain.dto.PageMakerDTO;
import com.board.ws.domain.vo.BoardVO;


public class BoardUnitTest extends TestConfig{
	private static final Logger LOG = LoggerFactory.getLogger(BoardUnitTest.class);
	
	public static void main(String[] args) {
		BoardDTO dto = new BoardDTO();
		dto.setId(1);
		System.out.println(dto.toString());
		
	}
	
	@Test
	public void test() {
		BoardDAO boardDAO = ctx.getBean(BoardDAO.class);
		BoardDTO dto = new BoardDTO();
		dto.setTitle("test");
		boardDAO.insertBoard(dto);
		CriteriaDTO cri = new CriteriaDTO();
	    PageMakerDTO pageMaker = new PageMakerDTO();
	    pageMaker.setCri(cri);
	    
	    try {
	    	pageMaker.setTotalCount(boardDAO.selectBoardCount(cri));
			List<BoardVO> result = boardDAO.selectBoardList(cri);
			
			LOG.info(result.toString());
			
			BoardVO vo = boardDAO.selectBoardById("2");
			LOG.info(vo.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
