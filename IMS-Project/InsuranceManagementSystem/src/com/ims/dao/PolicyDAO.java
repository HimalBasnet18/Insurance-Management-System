package com.ims.dao;

import java.util.List;

import com.ims.pojo.Policy;

public interface PolicyDAO {
	public void addPolicy();
	public List<Policy> viewAllPolicy();
	Policy viewPolicy(int pid);
	public boolean deletePolicy();
	public void updatePolicy();
	public void buyPolicy(int pid, String username);
	
	
	

}
