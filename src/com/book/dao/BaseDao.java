package com.book.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;


/**
 * 执行指定的带有占位符的SQL语句
 * @author 欧阳涛
 * @since 2015-11-4
 * 
 */
 

public class BaseDao {
	private static final String drivername="oracle.jdbc.driver.OracleDriver";
	private static final String url="jdbc:oracle:thin:@10.25.44.101:1521:orcl";
	private static final String uid="scott"; 
	private static final String pwd="tiger";
	/**
	 * 执行一个带有占位符的查询功能的SQL语句，返回Result对象（离线式数据集）
	 * @param sql
	 * @param args
	 * @return 影响记录的行数
	 */
	//加载驱动
	static{
		try {
			Class.forName(drivername);
		} catch (ClassNotFoundException e) {			
			System.out.println("加载驱动失败："+ e.getMessage());
		}
	}
	
	public Result query(String sql,String[] args){
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Result result = null;
		
		try {
			connection = DriverManager.getConnection(url,uid,pwd);
			ps = connection.prepareStatement(sql);
			if (args==null || args.length==0){
				//没有占位符
			}else{
				//为占位符赋值
				for (int j=0;j<args.length;j++){
					ps.setString(j+1,args[j]);
				}
			}
			rs = ps.executeQuery();//得到在线式数据集
			
			result = ResultSupport.toResult(rs);//批量读取数据到离线式数据集
		} catch (SQLException e) {
			System.out.println("执行SQL语句失败"+ e.getMessage());
		}finally{
			try {
				if(rs != null){
					rs.close();
				}				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if(ps != null){
					ps.close();
				}				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(connection != null){
					connection.close();
				}				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	/**
	 * 执行一个带有占位符的增删改功能的SQL语句，返回影响记录的行数
	 * 出现异常返回-1
	 * @param sql
	 * @param args
	 * @return 影响记录的行数
	 */
	public int update(String sql,String[] args){
		int i = -1;
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = DriverManager.getConnection(url,uid,pwd);
			ps = connection.prepareStatement(sql);
			if (args==null || args.length==0){
				//没有占位符
			}else{
				//为占位符赋值
				for (int j=0;j<args.length;j++){
					ps.setString(j+1,args[j]);
				}
			}
			i = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("执行SQL语句失败"+ e.getMessage());
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return i;
	}

}
