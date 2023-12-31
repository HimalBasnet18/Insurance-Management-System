package com.ims.pojo;

public class Policy {
	private int pid;
	private String pname;
	private int pqnty;
	private int price;
	private boolean status;
	private String holder;
	
	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPqnty() {
		return pqnty;
	}
	public void setPqnty(int pqnty) {
		this.pqnty = pqnty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Policy(int pid, String pname, int pqnty, int price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pqnty = pqnty;
		this.price = price;
	}
	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
