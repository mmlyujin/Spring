package com.yj.app;

public class MemberDTO {
private int idx;
private String id;
private String pw;
private String name;
public MemberDTO(int idx, String id, String pw, String name) {
	super();
	this.idx = idx;
	this.id = id;
	this.pw = pw;
	this.name = name;
}

public MemberDTO() {
	// TODO Auto-generated constructor stub
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

public String getPw() {
	return pw;
}

public void setPw(String pw) {
	this.pw = pw;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}


}
