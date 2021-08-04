package com.board.ws.domain.dto;

import com.board.ws.domain.vo.BoardVO;

public class BoardDTO extends BoardVO{

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		super.setTitle(title);
	}

	@Override
	public void setContent(String content) {
		// TODO Auto-generated method stub
		super.setContent(content);
	}

	@Override
	public void setView(int view) {
		// TODO Auto-generated method stub
		super.setView(view);
	}

	@Override
	public void setSdate(String sdate) {
		// TODO Auto-generated method stub
		super.setSdate(sdate);
	}

	@Override
	public void setUdate(String udate) {
		// TODO Auto-generated method stub
		super.setUdate(udate);
	}
	
}
