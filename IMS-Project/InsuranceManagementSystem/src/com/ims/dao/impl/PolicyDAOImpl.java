package com.ims.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ims.dao.PolicyDAO;
import com.ims.pojo.Category;
import com.ims.pojo.Policy;
import com.ims.pojo.Users;

public class PolicyDAOImpl implements PolicyDAO {
	static List<Policy> policies = new ArrayList<>();
	Scanner sc = new Scanner (System.in);

	@Override
	public void addPolicy() {
		// TODO Auto-generated method stub
		System.out.println("Enter Policy ID");
		int pid = sc.nextInt();
		System.out.println("Enter Policy Name");
		String pname = sc.next();
		System.out.println("Enter Policy Qantity");
		int pqnty = sc.nextInt();
		System.out.println("Enter Policy Price");
		int price = sc.nextInt();
		
		Policy policy = new Policy( pid, pname, pqnty, price);
		policies.add(policy);

		
	}

	@Override
	public List<Policy> viewAllPolicy() {
		// TODO Auto-generated method stub
		return policies;
		
	}

	@Override
	public Policy viewPolicy(int pid) {
		// TODO Auto-generated method stub
		for (Policy p : policies)
		{
			if(p.getPid()==pid)
			{
				return p;
			}
		}
		return null;
	}

	@Override
	public boolean deletePolicy() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Policy ID to delete");
		int policyToRemove = sc.nextInt();
		sc.nextLine();
		
		for(Policy p : policies)
		{
			if(p.getPid()==policyToRemove)
			{
				policies.remove(p);
				System.out.println("Policy deleted sucessfully");
				return true;
			}
		}
		
		return true;
	}
	public void updatePolicy()
	{
		System.out.println("Enter the Policy Id to update: ");
		int PolicyToUpdate =sc.nextInt();
		
		for(Policy p: policies ) {
			if(p.getPid() == PolicyToUpdate) {
				System.out.println("Enter the new Policy Name: ");
				String newPolicyName =sc.next();
				
			p.setPname(newPolicyName);
			System.out.println("Category updated sucessfully");
			
			}
			
		}	
	}

	@Override
	public void buyPolicy(int pid, String username) {
		// TODO Auto-generated method stub
		
		int k=0;
		for(Policy p: policies)
		{
			if(p.getPid()==pid)
			{
				List<Users> user = new UserDAOImpl().viewAllUsers();
				for(Users u : user ) {
					if (u.getUserName().equals(username))
					{
						List<Policy> upolicy = u.getPolicy();
						Policy newpolicy = new Policy(pid, p.getPname(),p.getPqnty(), p.getPrice() );
						newpolicy.setHolder(username);
						upolicy.add(newpolicy);
						u.setPolicy(upolicy);
					}
				}
				System.out.println("Thanks for buying this policy");
				++k;
			}
		}
		if(k==0)
			System.out.println("No policies in stock");

	}

}
