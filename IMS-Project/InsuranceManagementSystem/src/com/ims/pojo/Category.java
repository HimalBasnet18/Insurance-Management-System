package com.ims.pojo;

import java.util.Iterator;

public class Category {
	private int cid;
	private String cname;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Category(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static Iterator<Category> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
