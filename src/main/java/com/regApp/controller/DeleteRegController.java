package com.regApp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.regApp.model.DAOservice;
import com.regApp.model.DAOserviceImpl;


@WebServlet("/deleteReg")
public class DeleteRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DeleteRegController() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		
		DAOservice service=new DAOserviceImpl();
		service.connectDB();
		service.deleteRegistration(email);
		
		ResultSet result = service.listAllRegistration();
		request.setAttribute("result", result);
		
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/listAllReg.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
