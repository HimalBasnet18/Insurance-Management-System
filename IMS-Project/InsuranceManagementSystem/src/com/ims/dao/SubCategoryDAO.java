package com.ims.dao;

import java.util.List;

import com.ims.pojo.SubCategory;

public interface SubCategoryDAO {
	public void addSubCategory();
	public List<SubCategory> viewAllSubCategory();
	SubCategory viewSubCategory(int scid);
	void updateSubCategory();
	public boolean deleteSubCategory();
	
	
	
}
