<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.SortedMap,java.text.DecimalFormat" %>
    <%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>部门管理</title>

<script>
	function del(deptno){
		var b = confirm("是否删除？");
		if(b){
			window.location.href="dept.servlet?action=del&deptno="+deptno;
		}
	}

</script>

</head>
<body>
	<a href="da.jsp">添加</a>
	<hr>
	<a href="shoppingcar.jsp">----我的购物车-----</a>
	<table border="1" cellspcing="0">
	<thead>
		<tr>
			<th>部门编号</th>
			<th>部门名称</th>
			<th>部门地址</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
	<%
		Object o = request.getAttribute("sms");
		if (o == null){
			%>
			<tr>
				<th colsplan="4">结束</th>
			</tr>
			<%
		}else{
			SortedMap[] sms = (SortedMap[])o;
			for (SortedMap sm : sms){
				%>
					<tr>
						<td><%=sm.get("deptno") %></td>
						<td><%=sm.get("dname") %></td>
						<td><%=sm.get("loc") %></td>
						<td>
						<a href="dept.servlet?action=shopping&deptno=<%=sm.get("deptno") %>">
						<img alt="放入购物车" src="../img/shoppingcar.jpg"></a>
						<a href="dept.servlet?action=edit&deptno=<%=sm.get("deptno") %>">编辑</a>
						<a href="javascript:del(<%=sm.get("deptno")%>)">删除</a>
						</td>
						
					</tr>
				<%
			}			
		}
	%>
	</tbody>
	
	</table>
</body>
</html>