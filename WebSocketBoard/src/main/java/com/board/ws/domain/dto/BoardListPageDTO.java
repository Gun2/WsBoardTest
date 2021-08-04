package com.board.ws.domain.dto;

import java.util.List;

public class BoardListPageDTO {
	private List<BoardDTO> data;	//row data 
	private int numOfRows = 30;	//한 페이지 결과 수 
	private int pageNo = 0;	//페이지 넘버 
	private int totalCount = 0;	//전체 결과 수

	public List<BoardDTO> getData() {
		return data;
	}
	public void setData(List<BoardDTO> data) {
		this.data = data;
	}
	public int getNumOfRows() {
		return numOfRows;
	}
	public void setNumOfRows(int numOfRows) {
		this.numOfRows = numOfRows;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


}
