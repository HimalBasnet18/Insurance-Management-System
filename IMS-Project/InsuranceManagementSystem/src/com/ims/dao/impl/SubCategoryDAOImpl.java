package com.ims.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.ims.dao.SubCategoryDAO;

import com.ims.pojo.*;



public class SubCategoryDAOImpl implements SubCategoryDAO {
	static List<SubCategory> Subcategories=new ArrayList<>();
	Scanner scn =new Scanner(System.in);
	@Override
	public void addSubCategory() {
		// TODO Auto-generated method stub
		System.out.println("Enter Sub-Category ID: ");
		int scid= scn.nextInt();
		System.out.println("Enter Sub-Category name: ");
		String scname=scn.next();
		SubCategory Subcategory =new SubCategory(scid, scname);
		Subcategories.add(Subcategory);
		
		System.out.println("Sub-Category Sucessfully Added");
	}

	@Override
	public List<SubCategory> viewAllSubCategory() {
		// TODO Auto-generated method stub
		return Subcategories;
	}

	@Override
	public SubCategory viewSubCategory(int scid) {
		for(SubCategory sc: Subcategories)
		{
			if(sc.getScid()==scid)
			{
				return sc;
			}
		}
		return null;
	}

	@Override
	public void updateSubCategory() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Sub-Category Id to update: ");
		int SubcategoryToUpdate =scn.nextInt();
		
		for(SubCategory sc: Subcategories ) {
			if(sc.getScid() == SubcategoryToUpdate) {
				System.out.println("Enter the new Sub-Category Name: ");
				String newSubCategoryName =scn.next();
				
			sc.setScname(newSubCategoryName);
			System.out.println("Sub-Category updated sucessfully");
			return;
			}
			
		}
	}

	@Override
	public boolean deleteSubCategory() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Sub-Category to ID to Remove: ");
		int SubcategoryToDelete =scn.nextInt();
		scn.nextLine();

        Iterator<SubCategory> iterator = Subcategories.iterator();

        while (iterator.hasNext()) {
            SubCategory subcategory = iterator.next();

            if (subcategory.getScid() == SubcategoryToDelete) {
                iterator.remove(); // Use iterator to safely remove the category
                System.out.println("Sub-Category deleted successfully");
                return true;
            }
        }

        System.out.println("Sub-Category not found");
        return false; // Return false if the category was not found and deleted
	}
}

