package com.ims.details;

import java.util.List;
import java.util.Scanner;

import com.ims.client.UserClient;
import com.ims.dao.SubCategoryDAO;
import com.ims.dao.UserDAO;
import com.ims.dao.impl.SubCategoryDAOImpl;
import com.ims.dao.impl.UserDAOImpl;
import com.ims.pojo.Category;
import com.ims.pojo.SubCategory;

public class SubCategoryDetails {
	SubCategoryDAO scatDao = new SubCategoryDAOImpl();
	UserDAO userDao =new UserDAOImpl();
	Scanner sc =new Scanner(System.in);

	public void AdminMenuSubCat()
	{
		while(true)
		{
			System.out.println("-----------------------------------------------------");	
			
			System.out.println("                 1)AddSubCategory                       ");
			System.out.println("                 2)ViewAllSubCategory                   ");
			System.out.println("                 3)ViewSubCategory                      ");
			System.out.println("                 4)UpdateSubCategory                    ");
			System.out.println("                 5)DeleteSubCategory                    ");
			System.out.println("                 6)Back                              ");		
					
					
			System.out.println("-----------------------------------------------------");		

			System.out.println("Enter The choice");
			int choice =sc.nextInt();
			
			switch(choice)
			{
			case 1:
				scatDao.addSubCategory();
				AdminMenuSubCat();
				break;
			case 2:
				List<SubCategory> viewAllSubCategory=scatDao.viewAllSubCategory();
				for(SubCategory c: viewAllSubCategory)
				{
					System.out.println(c.getScid()+"\t"+c.getScname());
				}
				AdminMenuSubCat();
				break;
			case 3:
				System.out.println("Enter Sub-Category ID");
				SubCategory c =scatDao.viewSubCategory(sc.nextInt());
				if(c!=null)
				{
					System.out.println(c.getScid()+"\t"+c.getScname());
				}
				else
				{
					System.out.println("SubCategory Doesnot Exists");
				}
				AdminMenuSubCat();
				break;
			case 4:
				scatDao.updateSubCategory();
				break;
			case 5:
				scatDao.deleteSubCategory();
				

				AdminMenuSubCat();
				break;
			case 6:
				UserClient.main(null);
				
			default:
				System.out.println("Choose from 1 to 6");
				
				
			}

}
	}
	public void ClientMenuSubCat()
	{
		System.out.println("                 1)ViewAllSubCategory                   ");
		System.out.println("                 2)ViewSubCategory                      ");
		System.out.println("                 3)back                    ");
		
		System.out.println("Enter your Choice");
		int choice =sc.nextInt();
		
		switch(choice)
		{
		case 1:
			List<SubCategory> viewAllSubCategory=scatDao.viewAllSubCategory();
			for(SubCategory c: viewAllSubCategory)
			{
				System.out.println(c.getScid()+"\t"+c.getScname());
			}
			ClientMenuSubCat();
			break;
		case 2:
			System.out.println("Enter Sub-Category ID");
			SubCategory c =scatDao.viewSubCategory(sc.nextInt());
			if(c!=null)
			{
				System.out.println(c.getScid()+"\t"+c.getScname());
			}
			else
			{
				System.out.println("SubCategory Doesnot Exists");
			}
			ClientMenuSubCat();
			break;
		case 3:
			System.exit(0);
			break;
		default:
			System.out.println("Choose from 1 to 3");
		}
	}
}

