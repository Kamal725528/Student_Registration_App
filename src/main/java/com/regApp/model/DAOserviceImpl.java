package com.regApp.model;


import java.sql.*;

public class DAOserviceImpl implements DAOservice {
     
	Connection con;
	Statement st;
	
	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentregapp","root","######");
			st= con.createStatement();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
        
	}

	@Override
	public boolean verifyCreditential(String email, String password) {
		
		 try {
			ResultSet result= st.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
			return result.next();
			
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		
		return false;
	}

	@Override
	public void saveRegistration(String name, String city, String email, String mobile) {
		try {
			st.executeUpdate("insert into registration(name, city, email, mobile) values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
			
			
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		

	}

	@Override
	public void deleteRegistration(String email) {
		try {
			st.executeUpdate("delete from registration where email='"+email+"'");
			
			
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		

	}

	@Override
	public void updateRegistration(String email, String mobile) {
		
		try {
			st.executeUpdate("update registration SET mobile='"+mobile+"' where email='"+email+"'");
			
			
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	}

	@Override
	public ResultSet listAllRegistration() {
		
		try {
			ResultSet result= st.executeQuery("select * from registration");
			return result;
			
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		return null;
	}

}
