package com.caps.dev.controller;
import java.util.Scanner;
import com.caps.dev.beans.PersonDetails;
import com.caps.dev.dao.DaoImplementation;
import com.caps.dev.dao.HibernateImplementation;
public class DeletePerson {
	 public static void main( String[] args )
	    {
	    	System.out.println("Enter Person Details");
	       System.out.println("-------------------");
	       PersonDetails persondetails = new PersonDetails();
	       Scanner in = new Scanner(System.in);
	       
	   	System.out.println("Enter person id to be deleted: ");
		persondetails.setPersonId(Integer.parseInt(in.nextLine()));
		DaoImplementation ref = new HibernateImplementation();
		ref.delete(persondetails);
		System.out.println("Person details are deleted");
}
}