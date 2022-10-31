package com.hs.app;

public class BDto {
	private int  idx;
	private String id;
	private String title;
	private String content;
	private String regdate;
	
	public BDto() {}
	
	
	public BDto(int idx, String id, String title, String content, String regdate) {
		super();
		this.idx = idx;
		this.id = id;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}


	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}


}
