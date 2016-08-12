package com.book.shopping;

import com.book.vo.Dept;

public class ShoppingItem {
	private Dept dept;
	private int num;
	public void add(int i) {
		num++;
		
	}
	public void setNum(int i) {
		this.num = i;
		
	}
	public void setDept(Dept dept) {
		this.dept = dept;
		
	}
	public Dept getDept() {
		return dept;
	}
	public int getNum() {
		return num;
	}
}
