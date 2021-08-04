package com.board.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.ws.domain.dao.BoardDAO;
import com.board.ws.domain.dto.BoardDTO;
import com.board.ws.domain.dto.CriteriaDTO;
import com.board.ws.domain.vo.BoardVO;
import com.board.ws.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService{


	@Autowired
	private BoardDAO boardDAO;
	
	
	@Override
	public void insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.insertBoard(vo);
	}


	@Override
	public int selectBoardCount(CriteriaDTO cri) {
		// TODO Auto-generated method stub
		return boardDAO.selectBoardCount(cri);
	}


	@Override
	public List<BoardVO> selectBoardList(CriteriaDTO cri) {
		return boardDAO.selectBoardList(cri);
	}


	@Override
	public BoardVO selectBoardById(String id) {
		// TODO Auto-generated method stub
		boardDAO.increaseView(id);
		return boardDAO.selectBoardById(id);
	}


	@Override
	public void deleteBoardById(String id) {
		// TODO Auto-generated method stub
		boardDAO.deleteBoardById(id);
	}


	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.updateBoard(vo);
	}
	
	@Override
	public List<BoardDTO> selectBoardDTOList(CriteriaDTO cri) {
		// TODO Auto-generated method stub
		return boardDAO.selectBoardDTOList(cri);
	}


	@Override
	public void insertBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		boardDAO.insertBoard(dto);
	}
	
	
}
