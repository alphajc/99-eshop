package com.book.dao;

import java.util.SortedMap;

import javax.servlet.jsp.jstl.sql.Result;

/**
 * result.getRowCount();//记录的行数
		result.getColumnNames();//返回结果集的列名
		result.getRows();//sortedmap[]数据
 * @author ttc
 *
 */
public class BookDao extends BaseDao {
	public SortedMap[][] findall(){
		SortedMap[][] sms = new SortedMap[2][];
		Result resultAllBooks = null;
		Result resultBookTypes = null;
		String sql_1 = "select bookid, title, pubtime,"
				+" isbn, price, pubid,typeid from book";
		resultAllBooks = query(sql_1, null);
		String sql_2 = "select typename from booktypes";
		resultBookTypes = query(sql_2, null);
		if (resultAllBooks == null || resultAllBooks.getRowCount()==0){//条件不能颠倒
			
		}else{
			sms[0] = resultAllBooks.getRows();//读取结果数据
		}
		if (resultBookTypes == null || resultBookTypes.getRowCount()==0){//条件不能颠倒
			
		}else{
			sms[1] = resultBookTypes.getRows();//读取结果数据
		}
		
		return sms;
	}

	public SortedMap getOne(String bookid) {
		SortedMap sm = null;
		Result result = null;
		String args[]= {bookid};
		
		String sql = "select b.bookid,b.title,b.pubtime,b.isbn,b.price,b.pubid,d.dname,d.loc"
				+ " from book b"
				+ " inner join dept d"
				+ " on b.pubid=d.deptno"
				+" where b.bookid=?";
		result = query(sql, args);
		if (result == null || result.getRowCount() == 0){
			
		}else{
			sm = result.getRows()[0];
		}
		return sm;
	}
	
	public SortedMap[][] findBooksByType(String typename) {
		SortedMap[][] sms = new SortedMap[2][];
		Result resultTypeBooks = null;
		Result resultBookTypes = null;
		String args[]= {typename};
		
		String sql_1 = "select b.bookid,b.title,b.pubtime,b.isbn,b.price,b.pubid,b.typeid,bt.typename"
				+" from book b"
				+" inner join booktypes bt"
				+" on b.typeid = bt.typeid"
				+" where bt.typename = ?";
		String sql_2 = "select typename from booktypes";
		
		resultTypeBooks = query(sql_1, args);
		resultBookTypes = query(sql_2, null);
		if (resultTypeBooks == null || resultTypeBooks.getRowCount()==0){//条件不能颠倒
			
		}else{
			sms[0] = resultTypeBooks.getRows();//读取结果数据
		}
		if (resultBookTypes == null || resultBookTypes.getRowCount()==0){//条件不能颠倒
			
		}else{
			sms[1] = resultBookTypes.getRows();//读取结果数据
		}
		return sms;
	}

}
