//package com.iSpanProject.GoodByeletter.controller.Lillian;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@MultipartConfig
//@WebServlet(urlPatterns="/login")
//public class loginController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//    
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		switch(request.getServletPath()) {
//			case "/login":
//				login(request, response);
//				break;
//			default:
//				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
//		}		
//	}
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		switch(request.getServletPath()) {
//			case "/login":
//				login(request, response);
//				break;
//			default:
//				response.sendError(HttpServletResponse.SC_BAD_REQUEST);			
//		}
//	}
//	
//	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/plain; charset=utf-8");
//		PrintWriter out = response.getWriter();
//		
//		String account = request.getParameter("account");
//		String password = request.getParameter("password");
//		if ("".equals(account) && "".equals(password))
//		   out.print("pass");
//		else
//		   out.print("fail"); 
//	}
//}
