package com.board.ws.domain.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.ws.domain.dto.BoardDTO;
import com.board.ws.domain.dto.CriteriaDTO;
import com.board.ws.domain.vo.BoardVO;
@Repository
public class BoardDAO {

	@Autowired
	SqlSession sqlSession;
	
	public void insertBoard(BoardVO vo) {
		sqlSession.insert("board.insertBoard", vo);
	}
	
	public void insertBoard(BoardDTO dto) {
		sqlSession.insert("board.insertBoardDTO", dto);
	}
	
	
	public int selectBoardCount(CriteriaDTO cri) {
		return sqlSession.selectOne("board.selectBoardCount", cri);
	}
	
	public List<BoardVO> selectBoardList(CriteriaDTO cri) {
		return sqlSession.selectList("board.selectBoardList", cri);
	}
	
	public BoardVO selectBoardById(String id) {
		return sqlSession.selectOne("board.selectBoardById", id);
	}
	
	public void deleteBoardById(String id) {
		sqlSession.delete("board.deleteBoardById", id);
	}
	
	public void increaseView(String id) {
		sqlSession.update("board.increaseView", id);
	}
	
	public void updateBoard(BoardVO vo) {
		sqlSession.update("board.updateBoard", vo);
	}
	
	
	public List<BoardDTO> selectBoardDTOList(CriteriaDTO cri) {
		return sqlSession.selectList("board.selectBoardDTOList", cri);
	}
}
