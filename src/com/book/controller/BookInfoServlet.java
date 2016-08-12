package com.book.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookInfoServlet extends HttpServlet {
	private int index;
	@Override
	public void init() throws ServletException {
		String abc = getInitParameter("abc");
		if (abc != null && abc.length()>0){
			index = Integer.parseInt(abc);
			System.out.println(index);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("doPost()");
	}
}
