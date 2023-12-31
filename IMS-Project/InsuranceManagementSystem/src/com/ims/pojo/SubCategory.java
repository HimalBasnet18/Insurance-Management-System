package com.ims.pojo;

public class SubCategory {
	private int scid;
	private String scname;
	public int getScid() {
		return scid;
	}
	public void setScid(int scid) {
		this.scid = scid;
	}
	public String getScname() {
		return scname;
	}
	public void setScname(String scname) {
		this.scname = scname;
	}
	public SubCategory(int scid, String scname) {
		super();
		this.scid = scid;
		this.scname = scname;
	}
	public SubCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

}
