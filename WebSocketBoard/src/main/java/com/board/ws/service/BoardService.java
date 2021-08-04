package com.board.ws.service;

import java.util.HashMap;
import java.util.List;

import com.board.ws.domain.dto.BoardDTO;
import com.board.ws.domain.dto.CriteriaDTO;
import com.board.ws.domain.vo.BoardVO;

public interface BoardService {
	
	void insertBoard(BoardVO vo);
	
	void insertBoard(BoardDTO dto);
	
	public int selectBoardCount(CriteriaDTO cri);

	public List<BoardVO> selectBoardList(CriteriaDTO cri);
	
	public List<BoardDTO> selectBoardDTOList(CriteriaDTO cri);
	
	public BoardVO selectBoardById(String id);
	
	public void deleteBoardById(String id);
	
	public void updateBoard(BoardVO vo);

	
}
