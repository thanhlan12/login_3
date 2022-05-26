package com.ngockhuong.webmvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ngockhuong.webmvc.model.User;
import com.ngockhuong.webmvc.service.UserService;

/**
 * LoginController
 * Servlet xử lý đăng nhập và điều hướng
 * @author ngockhuong.com
 *
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserService service = new UserService();
		User user = new User(username, password); 
		if (service.checkLogin(user)) {
			response.sendRedirect("welcome");
		} else {
			response.sendRedirect("login?err=1");
		}
	}

}
