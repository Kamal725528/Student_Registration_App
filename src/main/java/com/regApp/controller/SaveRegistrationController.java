package com.regApp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.regApp.model.DAOservice;
import com.regApp.model.DAOserviceImpl;


@WebServlet("/savereg")
public class SaveRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SaveRegistrationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/new_registration.jsp");
		rd.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession(false);
		if(session.getAttribute("email")!=null) {
			
		 String name=request.getParameter("name");
         String email=request.getParameter("email");
         String city=request.getParameter("city");
         String mobile=request.getParameter("mobile");
         
         DAOservice service=new DAOserviceImpl();
         service.connectDB();
         service.saveRegistration(name, city, email, mobile);
         
         request.setAttribute("msg", "record saved");
         RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/new_registration.jsp");
         rd.forward(request, response);
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			  rd.forward(request, response);
		}

	}

}
