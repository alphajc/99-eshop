package com.book.vo;

import java.util.SortedMap;

public class Dept {
	private int deptno;
	private String dname;
	private String loc;
	public Dept(SortedMap sm) {
		this.dname = sm.get("dname").toString();
		this.deptno = Integer.parseInt(sm.get("deptno").toString());
		this.loc = sm.get("loc").toString();
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
