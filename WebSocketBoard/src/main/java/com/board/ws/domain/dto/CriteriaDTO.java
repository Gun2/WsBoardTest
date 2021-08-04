package com.board.ws.domain.dto;

public class CriteriaDTO {
	private int page;
	private int perPageNum;
	private String searchKeyword;

	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}

	public CriteriaDTO() {
		this.page = 1;
		this.perPageNum = 20;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
		} else {
			this.page = page;
		}
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int pageCount) {
		int cnt = this.perPageNum;
		if (pageCount != cnt) {
			this.perPageNum = cnt;
		} else {
			this.perPageNum = pageCount;
		}
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

}
