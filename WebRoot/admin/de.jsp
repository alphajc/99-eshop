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
	<tbody>
	<%
		Object o = request.getAttribute("sm");
		if (o == null){
			%>
			<tr>
				<th colsplan="4">结束</th>
			</tr>
			<%
		}else{
			SortedMap sm = (SortedMap)o;			
				%>
				<form action="dept.servlet" method="post">
					<tr>
						<td>部门编号</td>
						<input type="hidden" name="action" value="update">
						<td><input readonly name="deptno" value="<%=sm.get("deptno") %>"></td>
					</tr>
					<tr>
						<td>部门名称</td>
						<td><input name="dname" value="<%=sm.get("dname") %>"></td>
					</tr>
					<tr>
						<td>部门地址</td>
						<td><input name="loc" value="<%=sm.get("loc") %>"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="保存"></td>
					
					</tr>
					
				</form>	
				<%						
		}
	%>
	</tbody>
	
	</table>
</body>
</html>