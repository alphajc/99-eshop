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
<title>图书详情</title>
</head>
<body>
	<table align="center" cellpadding="0" cellspacing="0" border="1" 
	style=" width: 800px ">
				
			
				<%
				Object o = request.getAttribute("sm");
				if (o != null)
				{
					SortedMap sm = (SortedMap) o;
						%>
					
								<tr>
									<td  rowspan="8" style="width:350px;height:550px">
										<img width="100%" height="100%" src="../BookCovers/<%=sm.get("isbn") %>.jpg">
									</td>
									<td align="center"><b><%=sm.get("title") %></b></td></a>
								</tr>
								<tr>										
									<td>出版时间：<%=sm.get("pubtime") %></td>
								</tr>							
								<tr>									
									<td>
										定价: &#65509;<%=Double.parseDouble(sm.get("price").toString()) %>										
									</td>
								</tr>
								<tr>										
									<td>ISBN：<%=sm.get("isbn") %></td>
								</tr>
								<tr>										
									<td>书ID：<%=sm.get("bookid") %></td>
								</tr>
								<tr>										
									<td>出版社：<%=sm.get("dname") %></td>
								</tr>
								<tr>										
									<td>出版社ID：<%=sm.get("pubid") %></td>
								</tr>								
								<tr>										
									<td>出版社地址：<%=sm.get("loc") %></td>
								</tr>
								<tr>
									<td colspan="2">简介：</td>
								</tr>
						<%	
					
				}
				%>
			
		
	</table>
</body>
</html>