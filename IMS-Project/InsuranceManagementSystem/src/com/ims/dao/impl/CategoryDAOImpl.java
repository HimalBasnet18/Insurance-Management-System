package com.ims.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.ims.dao.CategoryDAO;
import com.ims.pojo.*;

public class CategoryDAOImpl implements CategoryDAO {
	static List<Category> categories = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addCategory() {
		// TODO Auto-generated method stub
		System.out.println("Enter Category ID: ");
		int cid = sc.nextInt();
		System.out.println("Enter Category name: ");
		String cname = sc.next();
		Category icategory = new Category(cid, cname);
		categories.add(icategory);

		System.out.println("Category Sucessfully Added");

	}

	@Override
	public List<Category> viewAllCategory() {
		return categories;
	}

	@Override
	public Category viewCategory(int cid) {
		for (Category c : categories) {
			if (c.getCid() == cid) {
				return c;
			}
		}
		return null;
	}

	@Override
	public void updateCategory() {
		// TODO Auto-generated method stub

		System.out.println("Enter the Category Id to update: ");
		int categoryToUpdate = sc.nextInt();

		for (Category c : categories) {
			if (c.getCid() == categoryToUpdate) {
				System.out.println("Enter the new Category Name: ");
				String newCategoryName = sc.next();

				c.setCname(newCategoryName);
				System.out.println("Category updated sucessfully");

			}

		}
	}

	@Override
	public boolean deleteCategory() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Category to ID to Remove: ");
		int categoryToDelete = sc.nextInt();
		sc.nextLine();

        Iterator<Category> iterator = categories.iterator();

        while (iterator.hasNext()) {
            Category category = iterator.next();

            if (category.getCid() == categoryToDelete) {
                iterator.remove(); // Use iterator to safely remove the category
                System.out.println("Category "+category.getCname()+ " deleted successfully");
                return true;
            }
        }

        System.out.println("Category not found");
        return false; // Return false if the category was not found and deleted
    }

    

	public void managePolicy() {
		List<Users> user = new UserDAOImpl().viewAllUsers();
		for (Users u : user) {
			List<Policy> upolicy = u.getPolicy();

			for (Policy p : upolicy) {
				System.out.println(p.getHolder() + "\t" + p.getPid() + "\t" + p.getPname() + "\t" + p.getPrice() + "\t"
						+ p.isStatus());
			}

		}
		System.out.println("Select username to manage policy");
		String uname = sc.next();
		System.out.println("Select policy ID to manage");
		int pid = sc.nextInt();
		for (Users u : user) {
			if (uname == u.getUserName()) {
				List<Policy> upolicy = u.getPolicy();

				for (Policy p : upolicy) {
					if (pid == p.getPid()) {
						System.out.println("1. Activate  2. Dactivate");
						int option = sc.nextInt();
						switch (option) {
						case 1:
							p.setStatus(true);
							System.out.println("Policy Activated");
							break;
						case 2:
							p.setStatus(false);
							System.out.println("Policy Dactivated");
							break;
						default:
							System.out.println("Select 1 or 2");
						}
					}
				}
			}

		}

	}

}
