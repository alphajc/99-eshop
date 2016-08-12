<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.SortedMap,java.text.DecimalFormat,java.util.HashMap" %>
<%@ page import="com.book.vo.Dept,com.book.shopping.ShoppingItem" %>
    <%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>购物车管理</title>


</head>
<body>
	
	<table border="1" cellspacing="0">
	<thead>
		<tr>
			<th>部门编号</th>
			<th>部门名称</th>
			<th>部门地址</th>
			<th>购买数量</th>
		</tr>
	</thead>
	<tbody>
	<%
		Object o = session.getAttribute("shoppingcar");
		if(o == null){
			out.print("weikong");
		}else{
			HashMap<String,ShoppingItem> items = 
					(HashMap<String, ShoppingItem>) o;
			for(ShoppingItem item : items.values()){
				Dept dept = item.getDept();
				int num = item.getNum();
				%>
			<tr>
				<th><%=dept.getDeptno() %></th>
				<th><%=dept.getDname() %></th>
				<th><%=dept.getLoc() %></th>
				<th>
					<table>
						<tr>
							<td><form action="dept.servlet">
								<input type="hidden" name="action" value="carnum">
								<input type="hidden" name="deptno" value="<%=dept.getDeptno()%>">
								<input type="hidden" name="num" value="<%=(num+1)%>">
								<input type="submit" value="+">
								</form>
							</td>
							<td><%=num %></td>
							<td>
								<form action="dept.servlet">
								<input type="hidden" name="action" value="carnum">
								<input type="hidden" name="deptno" value="<%=dept.getDeptno()%>">
								<input type="hidden" name="num" value="<%=(num-1)%>">
								<input type="submit" value="-">
								</form>
							</td>
						</tr>
					</table>
				</th>
			</tr>
				<%
			}
		}
	%>
	</tbody>
	
	</table>
</body>
</html>