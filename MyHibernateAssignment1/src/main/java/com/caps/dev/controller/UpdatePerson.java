package com.caps.dev.controller;

import java.util.Scanner;
import com.caps.dev.beans.PersonDetails;
import com.caps.dev.dao.DaoImplementation;
import com.caps.dev.dao.HibernateImplementation;
public class UpdatePerson {
	 public static void main( String[] args )
	    {
	    	System.out.println("Enter Person Details");
	       System.out.println("-------------------");
	       PersonDetails persondetails = new PersonDetails();
	       Scanner in = new Scanner(System.in);
	       System.out.println("Enter the Person id: ");
			persondetails.setPersonId(Integer.parseInt(in.nextLine()));
			
			System.out.println("Enter the new email id to be updated: ");
			persondetails.setPersonEmail(in.nextLine());
	   	DaoImplementation ref = new HibernateImplementation();
		ref.update(persondetails);
		System.out.println("Person details are updated");
}
}
