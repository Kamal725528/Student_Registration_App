package com.regApp.model;

import java.sql.ResultSet;

public interface DAOservice {
	public void connectDB();
	public boolean verifyCreditential(String email, String password);
	public void saveRegistration(String name, String city, String email, String mobile);
	public void deleteRegistration(String email);
	public void updateRegistration(String email, String mobile);
	public ResultSet listAllRegistration();

}
