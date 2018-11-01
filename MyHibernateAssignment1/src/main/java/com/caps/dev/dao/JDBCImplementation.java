package com.caps.dev.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.caps.dev.beans.PersonDetails;

public class JDBCImplementation implements DaoImplementation {
	   public void create(PersonDetails persondetails) {
	    	Connection con = null;
			PreparedStatement pstmt = null;

			try {
				/*
				 * 1. Load the Driver
				 */
				Class.forName("com.mysql.jdbc.Driver");

				/*
				 * 2. Get the DB Connection via Driver
				 */
				
				String dbUrl="jdbc:mysql://localhost:3306/capsv4_db";

				//3rd version of getConnnecton()
				con = DriverManager.getConnection(dbUrl,"root","tiger"); //1st version of getConnection


				/*
				 * 3. Issue the SQL query via connection
				 */
				String sql = "insert into person_details values(?,?,?,?,?)";

				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, persondetails.getPersonId());
				pstmt.setString(2,persondetails.getPersonName());
				pstmt.setInt(3, persondetails.getPersonAge());
				pstmt.setString(4, persondetails.getPersonEmail());
				pstmt.setString(5, persondetails.getPersonAddress());
				
				int count = pstmt.executeUpdate();
				
				/*
				 * 4. Process the results
				 */

				if(count > 0) {
					System.out.println("Person details are saved");
				}else {
					System.out.println("Failed!!!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				if(con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}}}}
public void delete(PersonDetails persondetails) {
	Connection con = null;
	PreparedStatement pstmt = null;

	try {
		/*
		 * 1. Load the Driver
		 */
		Class.forName("com.mysql.jdbc.Driver");

		/*
		 * 2. Get the DB Connection via Driver
		 */
		
		String dbUrl="jdbc:mysql://localhost:3306/capsv4_db";

		//3rd version of getConnnecton()
		con = DriverManager.getConnection(dbUrl,"root","tiger"); //1st version of getConnection


		/*
		 * 3. Issue the SQL query via connection
		 */
		String sql = "delete from person_details where person_id=?";

		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, persondetails.getPersonId());
		//pstmt.setString(2,persondetails.getPersonName());
		//pstmt.setInt(3, persondetails.getPersonAge());
		//pstmt.setString(4, persondetails.getPersonEmail());
		//pstmt.setString(5, persondetails.getPersonAddress());
		
		int count = pstmt.executeUpdate();
		
		/*
		 * 4. Process the results
		 */

		if(count > 0) {
			System.out.println("Person details are deleted");
		}else {
			System.out.println("Failed!!!");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}}}
public void search(PersonDetails persondetails) {
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		/*
		 * 1. Load the Driver
		 */
		Class.forName("com.mysql.jdbc.Driver");
		
		/*
		 * 2. Get the DB Connection via Driver
		 */
		
		String dbUrl="jdbc:mysql://localhost:3306/capsv4_db";

		//3rd version of getConnnecton()
		connection = DriverManager.getConnection(dbUrl,"root","tiger"); //1st version of getConnection

		System.out.println("Connected...");
		
		/*
		 * 3. Issue the SQL query via connection
		 */
		String sql = "select * from person_details where person_id=?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1,persondetails.getPersonId());
		rs = pstmt.executeQuery();

		/*
		 * 4. Process the results
		 */

		while(rs.next()){
			System.out.println(rs.getInt("person_id"));
			System.out.println(rs.getString("person_name"));
			System.out.println(rs.getInt("person_age"));
			System.out.println(rs.getString("person_email"));
			System.out.println(rs.getString("person_add"));
		System.out.println("*********************");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}}}}}
	 public void update(PersonDetails persondetails){
		 Connection con = null;
			PreparedStatement pstmt = null;
			try {
				/*
				 * 1. Load the Driver
				 */
				Class.forName("com.mysql.jdbc.Driver");

				/*
				 * 2. Get the DB Connection via Driver
				 */
				
				String dbUrl="jdbc:mysql://localhost:3306/capsv4_db";

				//3rd version of getConnnecton()
				con = DriverManager.getConnection(dbUrl,"root","tiger"); //1st version of getConnection

				System.out.println("Connected...");

				/*
				 * 3. Issue the SQL query via connection
				 */
				String sql = "update person_details set person_email=? where person_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1,persondetails.getPersonId());
				pstmt.setString(2,persondetails.getPersonEmail());
				int count = pstmt.executeUpdate();	
				/*
				 * 4. Process the results
				 */

				if(count > 0) {
					System.out.println("Data updated");
				}else {
					System.out.println("Update Failed");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				if(con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}	
			}}}}




	