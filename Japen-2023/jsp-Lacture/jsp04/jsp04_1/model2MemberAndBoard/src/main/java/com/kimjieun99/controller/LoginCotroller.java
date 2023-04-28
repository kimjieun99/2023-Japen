package com.kimjieun99.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member/login")
public class LoginCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginCotroller() {
        super();
    
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/login.jsp");
	    dispatcher.forward(request, response);
	}

}
