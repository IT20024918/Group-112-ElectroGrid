package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserModel {
	
	//creating connection
		public Connection connect()
		{
			Connection con = null;

			try
			{
			 Class.forName("com.mysql.jdbc.Driver");
			 con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/electrogrid","root", "");
			 //For testing
			 System.out.print("Successfully connected");
		 	}
			catch(Exception e)
		 	{
		 		e.printStackTrace();
			 }

		return con;
		}
		
		
		public String AddNewUser(String accountNo,String name,String address, String contactNo, String NIC,String userType,String userEmail, String userName, String password) {
		   	
			String output = "";
					try
					 { Connection con = connect();
					 if (con == null)
					 {
					 return "Error while connecting to the database";
					 }
			    		
			    	    String sql = "insert into users(`userID`,`accountNo`,`name`,`address`,`contactNo`,`NIC`,`userType`,`userEmail`,`userName`,`password`)"+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
			    	    PreparedStatement preparedStmt = con.prepareStatement(sql);
						 // binding values
						 preparedStmt.setInt(1, 0);
						 preparedStmt.setString(2,accountNo );
						 preparedStmt.setString(3, name);
						 preparedStmt.setString(4, address);
						 preparedStmt.setString(5, contactNo); 
						 preparedStmt.setString(6, NIC);
						 preparedStmt.setString(7, userType);
						 preparedStmt.setString(8, userName); 
						 preparedStmt.setString(9, password); 
						//execute the statement
						 preparedStmt.execute();
						 con.close();
						 output = "Inserted successfully";
			    		
			    	}
				catch (Exception e)
				{
				output = "Error while inserting";
				System.err.println(e.getMessage());
				}
		return output;
		}

}
