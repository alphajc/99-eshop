package com.book.controller;

import java.io.IOException;
import java.util.SortedMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.dao.BookDao;

public class BookServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		if(action.equals("findAll")){
			doFindAll(request,response);
		}else if(action.equals("getOne")){
			doGetOne(request,response);
		}else if(action.equals("getBooksByType")){
			showBooksByType(request,response);
		}
	}
	private void showBooksByType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			BookDao bd = new BookDao();
			String typename = request.getParameter("selectType");
			SortedMap[][] sms = null;
			sms = bd.findBooksByType(typename);	
			request.setAttribute("sms", sms);
			request.getRequestDispatcher("bl.jsp").forward(request, response);
	}
	private void doGetOne(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		BookDao bd = new BookDao();		
		String bkid = request.getParameter("bookid");
		SortedMap sm = bd.getOne(bkid);
		request.setAttribute("sm", sm);
		request.getRequestDispatcher("bi.jsp").forward(request, response);
	}
	private void doFindAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		BookDao bd = new BookDao();
		SortedMap[][] sms = null;
		sms = bd.findall();		
		request.setAttribute("sms", sms);
		request.getRequestDispatcher("bl.jsp").forward(request, response);		
	}
}
