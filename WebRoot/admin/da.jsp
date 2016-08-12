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
</head>
<body>
	<table>
				<form action="dept.servlet" method="post">
					<tr>
						<td>部门编号</td>
						<input type="hidden" name="action" value="add">
						<td><input name="deptno" value=""></td>
					</tr>
					<tr>
						<td>部门名称</td>
						<td><input name="dname" value=""></td>
					</tr>
					<tr>
						<td>部门地址</td>
						<td><input name="loc" value=""></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="保存"></td>
					
					</tr>
					
				</form>	
	</table>
</body>
</html>