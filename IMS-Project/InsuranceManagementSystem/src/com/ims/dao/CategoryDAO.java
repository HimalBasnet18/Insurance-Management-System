package com.ims.dao;

import java.util.List;

import com.ims.pojo.Category;

public interface CategoryDAO {
	public void addCategory();
	public List<Category> viewAllCategory();
	Category viewCategory(int cid);
	void updateCategory();
	public boolean deleteCategory();
	public void managePolicy();
	
	
	
}
