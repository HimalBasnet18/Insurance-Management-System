package com.ims.client;

import java.util.Scanner;

import com.ims.dao.impl.UserDAOImpl;
import com.ims.details.*;

public class UserClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		UserDAOImpl uImpl = new UserDAOImpl();
		CategoryDetails details = new CategoryDetails(); 
	

		while (true) {
			System.out.println("-------------------------------------------------------");
			System.out.println("             1)Register                                ");
			System.out.println("             2)Login                                ");
			System.out.println("             3)ForGotPassword                       ");
			System.out.println("             4)Exit                                ");
			System.out.println("-------------------------------------------------------");

			System.out.println("Enter The Choice");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				uImpl.addUsers();
				break;
			case 2:

				System.out.println("Enter the UserName");
				String uname = sc.next();
				System.out.println("Enter the Password");
				String pass = sc.next();

				String msg = uImpl.verifyUnameAndPassword(uname, pass);

				
				if (msg != null) {
					if (msg == "admin") {
						
					 details.adminMenu();
					 

					} else {
						//System.out.println("Under construction client menu");
						 details.ClientMenu(uname);
					}
				} // end of if
				else
					System.out.println("In Valid User");
				break;
			case 3:
				System.out.println("Enter Email");
				String email = sc.next();
				String password = uImpl.forgotPassword(email);
				if (password != null)
					System.out.println("PassWord :   " + password);
				else
					System.out.println("Email doest not Exist");
				break;

			case 4:
				System.out.println("Thx for Using App!");
				System.exit(0);
			default:
				System.out.println("Choose 1 to 4 Between");

			}

		} // end of while

	}

}
