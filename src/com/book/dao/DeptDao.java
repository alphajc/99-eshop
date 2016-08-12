package com.book.dao;

import java.util.SortedMap;

import javax.servlet.jsp.jstl.sql.Result;

public class DeptDao extends BaseDao {
	public SortedMap[] findall(){
		SortedMap[] sms = null;
		String sql = "select deptno, dname, loc from dept";
		Result result = query(sql,null);
		if (result == null || result.getRowCount() == 0){
			
		}else{
			sms = result.getRows();
		}
		return sms;
	}

	public SortedMap findone(String deptno) {
		SortedMap sm = null;
		String sql = "select deptno, dname, loc from dept"
				+ " where deptno = ?";
		String[] args = { deptno };
		Result result = query(sql,args);
		if (result == null || result.getRowCount() == 0){
			
		}else{
			sm = result.getRows()[0];
		}
		return sm;
	}

	public int update(String deptno, String dname, String loc) {
		int i = -1;
		String sql = "update dept set dname = ? "
				+ " ,loc = ? where deptno = ? ";
		String[] args = { dname, loc, deptno };
		i = update(sql,args);
		return i;
	}

	public int del(String deptno) {
		int i = -1;
		String sql = "delete dept where deptno = ? ";
		String[] args = { deptno };
		i = update(sql,args);
		return i;
	}

	public int add(String deptno, String dname, String loc) {
		int i = -1;
		String[] args = { deptno, dname, loc };
		String sql = "insert into dept(deptno, dname, loc) values(?, ?, ?)";
		i = update(sql,args);
		return i;
	}
}
