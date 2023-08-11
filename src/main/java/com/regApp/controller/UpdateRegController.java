package com.regApp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.regApp.model.DAOservice;
import com.regApp.model.DAOserviceImpl;


@WebServlet("/updateReg")
public class UpdateRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateRegController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		request.setAttribute("email",email);
		request.setAttribute("mobile",mobile);
		
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/updateRegistration.jsp");
		rd.forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  HttpSession session=request.getSession(false);
	  if(session.getAttribute("email")!=null) {
		  
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		
		DAOservice service=new DAOserviceImpl();
		service.connectDB();
		
		service.updateRegistration(email, mobile);
		
		ResultSet result = service.listAllRegistration();
		request.setAttribute("result", result);
		
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/listAllReg.jsp");
		rd.forward(request, response);
		
	  }
	  else {
		  RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			  rd.forward(request, response);
	  }
	}

}
