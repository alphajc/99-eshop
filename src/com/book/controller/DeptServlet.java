package com.book.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.SortedMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.dao.DeptDao;
import com.book.shopping.ShoppingItem;
import com.book.vo.Dept;

public class DeptServlet extends HttpServlet {
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
		if ("findall".equals(action)) {
			doFindAll(request,response);
		}else if("edit".equals(action)){
			doEdit(request,response);
		}else if("update".equals(action)){
			doUpdate(request,response);
		}else if("del".equals(action)){
			doDel(request,response);
		}else if("add".equals(action)){
			doAdd(request,response);
		}else if("shopping".equals(action)){
			doShopping(request,response);
		}else if("carnum".equals(action)){
			doCarnum(request,response);
		}
	}
	private void doCarnum(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获得session对象
		HttpSession session = request.getSession();
		//从session中获得购物车map
		Object o = session.getAttribute("shoppingcar");
		HashMap<String, ShoppingItem> shoppingcar = null;
		if (o == null){
			return;
		}else{
			shoppingcar = (HashMap<String, ShoppingItem>)o;
		}
		//处理购物车项
		String deptno = request.getParameter("deptno");
		o = shoppingcar.get(deptno);
		ShoppingItem item = null;
		if (o == null){
			System.out.println("weikong");
		}else{
//			item = (ShoppingItem) o;
			String num = request.getParameter("num");
//			item.setNum(Integer.parseInt(num));
			(shoppingcar.get(deptno)).setNum(Integer.parseInt(num));
		}
		
		request.getRequestDispatcher("shoppingcar.jsp").forward(request, response);
	}
	private void doShopping(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获得session对象
		HttpSession session = request.getSession();
		//从session中获得购物车map
		Object o = session.getAttribute("shoppingcar");
		HashMap<String, ShoppingItem> shoppingcar = null;
		if (o == null){
			shoppingcar = new HashMap<String,ShoppingItem>();
			session.setAttribute("shoppingcar", shoppingcar);
		}else{
			shoppingcar = (HashMap<String, ShoppingItem>) o;
		}
		//处理购物车项
		String deptno = request.getParameter("deptno");
		o = shoppingcar.get(deptno);
		ShoppingItem item = null;
		if (o == null){
			//购物车中无产品，则添加
			item = new ShoppingItem();
			DeptDao dd = new DeptDao();
			SortedMap sm = dd.findone(deptno);//
			Dept dept = new Dept(sm);
			item.setDept(dept);
			item.setNum(1);
			shoppingcar.put(item.getDept().getDeptno()+"", item);
		}else{
			item = (ShoppingItem) o;
			item.add(1);
		}
		doFindAll(request,response);
//		request.getRequestDispatcher("shoppingcar.jsp").forward(request, response);
	}
	
	
	private void doAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String deptno = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		DeptDao dd = new DeptDao();
		int i = dd.add(deptno,dname,loc);
		if(i < 0){
			response.sendRedirect("error.jsp");
			return;
		}else{
			doFindAll(request,response);
		}
	}
	private void doDel(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String deptno = request.getParameter("deptno");
		DeptDao dd = new DeptDao();
		int i = dd.del(deptno);
		if(i < 0){
			response.sendRedirect("error.jsp");
			return;
		}else{
			doFindAll(request,response);
		}
		
	}
	private void doUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String deptno = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		DeptDao dd = new DeptDao();
		int i = dd.update(deptno, dname,loc);
		if(i < 0){		//servlet --> javascript
			response.sendRedirect("error.jsp");			
		}else{
			doFindAll(request,response);
		}
		
		
	}
	private void doEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptno = request.getParameter("deptno");
		DeptDao dd = new DeptDao();
		SortedMap sm = dd.findone(deptno);
		request.setAttribute("sm", sm);
		request.getRequestDispatcher("de.jsp").forward(request, response);
		
	}
	private void doFindAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DeptDao dd = new DeptDao();
		SortedMap[] sms = dd.findall();
		request.setAttribute("sms", sms);
		request.getRequestDispatcher("dl.jsp").forward(request, response);
		
	}
}
