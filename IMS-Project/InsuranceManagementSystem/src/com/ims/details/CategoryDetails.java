package com.ims.details;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ims.client.UserClient;
import com.ims.dao.CategoryDAO;
import com.ims.dao.SubCategoryDAO;
import com.ims.dao.impl.CategoryDAOImpl;
import com.ims.dao.impl.SubCategoryDAOImpl;
import com.ims.dao.impl.UserDAOImpl;
import com.ims.pojo.Category;
import com.ims.pojo.Policy;
import com.ims.pojo.SubCategory;
import com.ims.pojo.Users;
import com.ims.dao.UserDAO;
import com.ims.dao.*;
import com.ims.dao.impl.*;

public class CategoryDetails {
	CategoryDAO catDao = new CategoryDAOImpl();
	SubCategoryDAO scatDao = new SubCategoryDAOImpl();
	PolicyDAO pcatDAO = new PolicyDAOImpl();
	UserDAO userDao = new UserDAOImpl();
	Scanner sc = new Scanner(System.in);

	public void adminMenu() {
		while (true) {
			System.out.println("-----------------------------------------------------");

			System.out.println("                 1)ViewUSerList                       ");
			System.out.println("                 2)CategoryMenu                   ");
			System.out.println("                 3)SubCategoryMenu                      ");
			System.out.println("                 4)PolicyMenu                       ");
			System.out.println("                 5)ManagePolicyRequest                    ");
			System.out.println("                 6)Back                              ");

			System.out.println("-----------------------------------------------------");

			System.out.println("Enter The choice");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				
				List<Users> allUsers = userDao.viewAllUsers();
				for (Users u : allUsers) {
					System.out.println(u.getUid() + "\t" + u.getFirstName() + "\t" + u.getLastName() + "\t"
							+ u.getEmail() + "\t" + u.getRoleName());
				}

				break;
			case 2:
				adminMenuCat();
				break;
			case 3:
				adminMenuSubCat();
				break;
			case 4:

				adminMenuPolicy();

				break;
			case 5:
				catDao.managePolicy();

				adminMenuCat();
				break;
			case 6:
				UserClient.main(null);

			default:
				System.out.println("Choose from 1 to 6");

			}

		}

	}

	public void adminMenuCat() {
		while (true) {
			System.out.println("-----------------------------------------------------");

			System.out.println("                 1)AddCategory                       ");
			System.out.println("                 2)ViewAllCategory                   ");
			System.out.println("                 3)ViewCategory                      ");
			System.out.println("                 4)UpdateCategory                    ");
			System.out.println("                 5)DeleteCategory                    ");
			System.out.println("                 6)Back                              ");

			System.out.println("-----------------------------------------------------");

			System.out.println("Enter The choice");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				catDao.addCategory();
				adminMenuCat();
				break;
			case 2:
				List<Category> viewAllCategory = catDao.viewAllCategory();
				System.out.println("ID" + "\t" + "Category");
				for (Category c : viewAllCategory) {
					System.out.println(c.getCid() + "\t" + c.getCname());
				}
				adminMenuCat();
				break;
			case 3:
				System.out.println("Enter Category ID");
				Category c = catDao.viewCategory(sc.nextInt());
				System.out.println("ID" + "\t" + "Category");
				if (c != null) {
					System.out.println(c.getCid() + "\t" + c.getCname());
				} else {
					System.out.println("Category Doesnot Exists");
				}
				adminMenuCat();
				break;
			case 4:

				catDao.updateCategory();

				break;
			case 5:
				catDao.deleteCategory();

				adminMenuCat();
				break;
			case 6:
				adminMenu();

			default:
				System.out.println("Choose from 1 to 6");

			}

		}

	}

	public void ClientMenu(String username) {
		System.out.println("-----------------------------------------------------");
		System.out.println("                 1)ViewAllCategory                   ");
		System.out.println("                 2)ViewCategory                      ");
		System.out.println("                 3)ViewAllSubCategory                      ");
		System.out.println("                 4)ViewSubCategory                      ");
		System.out.println("                 5)ViewAllPolicy                      ");
		System.out.println("                 6)ViewPolicy                      ");
		System.out.println("                 7)ApplyforPolicy                      ");
		System.out.println("                 8)View my policies                      ");
		System.out.println("                 9)back                              ");
		System.out.println("-----------------------------------------------------");
		System.out.println("Enter your Choice");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			List<Category> viewAllCategory = catDao.viewAllCategory();
			System.out.println("ID" + "\t" + "Category");
			for (Category c : viewAllCategory) {
				System.out.println(c.getCid() + "\t" + c.getCname());
			}
			ClientMenu(username);
			break;
		case 2:
			System.out.println("Enter Category ID");
			Category c = catDao.viewCategory(sc.nextInt());
			System.out.println("ID" + "\t" + "Category");
			if (c != null) {
				System.out.println(c.getCid() + "\t" + c.getCname());
			} else {
				System.out.println("Category Doesnot Exists");
			}
			ClientMenu(username);
			break;
		case 3:
			List<SubCategory> viewAllSubCategory = scatDao.viewAllSubCategory();
			System.out.println("ID" + "\t" + "Sub-Category");
			for (SubCategory c1 : viewAllSubCategory) {
				System.out.println(c1.getScid() + "\t" + c1.getScname());
			}
			ClientMenu(username);
			break;
		case 4:
			System.out.println("Enter Sub-Category ID");
			SubCategory c1 = scatDao.viewSubCategory(sc.nextInt());
			System.out.println("ID" + "\t" + "Sub-Category");
			if (c1 != null) {
				System.out.println(c1.getScid() + "\t" + c1.getScname());
			} else {
				System.out.println("SubCategory Doesnot Exists");
			}
			ClientMenu(username);
			break;
		case 5:
			List<Policy> viewAllPolicy = pcatDAO.viewAllPolicy();
			System.out.println("ID" + "\t" + "Policy" + "\t" + "PolicyPrice");
			for (Policy p : viewAllPolicy) {
				System.out.println(p.getPid() + "\t" + p.getPname() + "\t" + p.getPrice());
			}
			ClientMenu(username);
			break;
		case 6:
			System.out.println("Enter Policy ID");
			Policy p = pcatDAO.viewPolicy(sc.nextInt());
			System.out.println("ID" + "\t" + "Policy" + "\t" + "PolicyPrice");
			if (p != null) {
				System.out.println(p.getPid() + "\t" + p.getPname());
			} else {
				System.out.println("Policy Doesnot Exists");
			}
			ClientMenu(username);
			break;
		case 7:
			System.out.println("Enter the Policy you want to Apply");
			pcatDAO.buyPolicy(sc.nextInt(), username);
			break;
		case 8:

			
			List<Users> users = userDao.viewAllUsers();
			
			for(Users u: users )
			{
				if(u.getUserName().equals(username))
				{
					List<Policy> policies = u.getPolicy();
					for(Policy p1: policies) {
						System.out.println("My current Policies");
						System.out.println(p1.getHolder()+"\t"+p1.getPid()+"\t"+p1.getPname()+"\t"+p1.getPrice());
					}
				}
			}
		case 9:
			UserClient.main(null);
			break;
		default:
			System.out.println("Choose from 1 to 3");
		}
	}

	public void adminMenuSubCat() {
		while (true) {
			System.out.println("-----------------------------------------------------");

			System.out.println("                 1)AddSubCategory                       ");
			System.out.println("                 2)ViewAllSubCategory                   ");
			System.out.println("                 3)ViewSubCategory                      ");
			System.out.println("                 4)UpdateSubCategory                    ");
			System.out.println("                 5)DeleteSubCategory                    ");
			System.out.println("                 6)Back                              ");

			System.out.println("-----------------------------------------------------");

			System.out.println("Enter The choice");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				scatDao.addSubCategory();
				adminMenuSubCat();
				break;
			case 2:

				List<SubCategory> viewAllSubCategory = scatDao.viewAllSubCategory();
				System.out.println("ID" + "\t" + "Sub-Category");
				for (SubCategory c : viewAllSubCategory) {
					System.out.println(c.getScid() + "\t" + c.getScname());
				}
				adminMenuSubCat();
				break;
			case 3:
				System.out.println("Enter Sub-Category ID");
				SubCategory c = scatDao.viewSubCategory(sc.nextInt());
				System.out.println("ID" + "\t" + "Sub-Category");
				if (c != null) {
					System.out.println(c.getScid() + "\t" + c.getScname());
				} else {
					System.out.println("SubCategory Doesnot Exists");
				}
				adminMenuSubCat();
				break;
			case 4:
				scatDao.updateSubCategory();
				break;
			case 5:
				scatDao.deleteSubCategory();

				adminMenuSubCat();
				break;
			case 6:
				UserClient.main(null);

			default:
				System.out.println("Choose from 1 to 6");

			}

		}
	}

	public void adminMenuPolicy() {
		while (true) {
			System.out.println("-----------------------------------------------------");

			System.out.println("                 1)AddPolicy                       ");
			System.out.println("                 2)ViewAllPolicy                   ");
			System.out.println("                 3)ViewPolicy                     ");
			System.out.println("                 4)UpdatePolicy                   ");
			System.out.println("                 5)DeletePolicy                    ");
			System.out.println("                 6)Back                              ");

			System.out.println("-----------------------------------------------------");

			System.out.println("Enter The choice");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				pcatDAO.addPolicy();
				adminMenuPolicy();
				break;
			case 2:

				List<Policy> viewAllPolicy = pcatDAO.viewAllPolicy();
				System.out.println("ID" + "\t" + "Policy" + "\t" + "PolicyPrice");
				for (Policy p : viewAllPolicy) {
					System.out.println(p.getPid() + "\t" + p.getPname() + "\t" + p.getPrice());
				}
				adminMenuPolicy();
				break;
			case 3:
				System.out.println("Enter Policy ID");
				Policy p = pcatDAO.viewPolicy(sc.nextInt());
				System.out.println("ID" + "\t" + "Policy" + "\t" + "PolicyPrice");
				if (p != null) {
					System.out.println(p.getPid() + "\t" + p.getPname()+ "\t" + p.getPrice());
				} else {
					System.out.println("Policy Doesnot Exists");
				}
				adminMenuPolicy();
				break;
			case 4:
				pcatDAO.updatePolicy();
				break;
			case 5:
				pcatDAO.deletePolicy();

				adminMenuPolicy();
				break;

			case 6:
				UserClient.main(null);

			default:
				System.out.println("Choose from 1 to 6");

			}

		}
	}
}
