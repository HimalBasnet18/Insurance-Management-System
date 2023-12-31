package com.ims.dao;

import java.util.List;
import com.ims.pojo.*;

public interface UserDAO {
	public void addUsers();
	
	String verifyUnameAndPassword(String uname,String password); 
	String forgotPassword(String email);
	public List<Users>viewAllUsers();

	boolean deleteUser(int uid);

}
