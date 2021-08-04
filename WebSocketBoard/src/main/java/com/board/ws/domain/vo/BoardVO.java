package com.board.ws.domain.vo;

public class BoardVO {

	private int id = -1;
	private String title = "";
	private String content = "";
	private int view = 0;
	private String sdate = "";
	private String udate = "";
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public int getView() {
		return view;
	}

	public String getSdate() {
		return sdate;
	}

	public String getUdate() {
		return udate;
	}

	protected void setId(int id) {
		this.id = id;
	}

	protected void setTitle(String title) {
		this.title = title;
	}

	protected void setContent(String content) {
		this.content = content;
	}

	protected void setView(int view) {
		this.view = view;
	}

	protected void setSdate(String sdate) {
		this.sdate = sdate;
	}

	protected void setUdate(String udate) {
		this.udate = udate;
	}

	@Override
	public String toString() {
		return "BoardVO [id=" + id + ", title=" + title + ", content=" + content + ", view=" + view + ", sdate=" + sdate
				+ ", udate=" + udate + "]";
	}
	
	
}
