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


<title>图书列表</title>
</head>
<body>
	<%
		SortedMap[][] sms =null;
		Object o = request.getAttribute("sms");
		
		if (o == null)
		{
					
		}else{
			sms = (SortedMap[][]) o;
			
	%>
	
	<header>
		<form action="book.servlet" method="post">
		<input type="hidden" name="action" value="getBooksByType">
		分类查询	：	
		<select name="selectType">
			<%
				for (int i=0;i<sms[1].length;i++){
				%>	
					<option value="<%=sms[1][i].get("typename") %>"><%=sms[1][i].get("typename") %></option>
					<% 
				}
			%>
			
		</select>			
		<input type="submit" value="查询">	
		
		<a href="../admin/dept.servlet?action=findall" >部门管理</a>
		
		<hr>
		</form>	
	</header>
	
	<table align="center" cellpadding="0" cellspacing="0" border="1" style="width: 800px">
	
			<% 
				for(int j=0;j<sms[0].length;j++){
					
				%>				
					<tr>
						<td>	
							<table  border="1" style="width:800px;height:200px">
								<tr>
									<td  rowspan="4" style="width:150px;height:200px">
										<img width="100%" height="100%" src="../BookCovers/<%=sms[0][j].get("isbn") %>.jpg">
									</td>
									<td align="center">
										<a href="book.servlet?action=getOne&bookid=<%=sms[0][j].get("bookid")%>" ><%=sms[0][j].get("title")%></a>
									</td>
								</tr>
								<tr>										
									<td>出版时间：<%=sms[0][j].get("pubtime") %></td>
								</tr>
								<tr>										
									<td>简介：</td>
								</tr>
								<tr>									
									<td>
										原价: <del>&#65509;<%=Double.parseDouble(sms[0][j].get("price").toString()) %></del>
										惊爆价：&#65509;
											<font size="+9" color="red">
												<em><%=new DecimalFormat("#.00").format(Double.parseDouble(sms[0][j].get("price").toString())*0.8)%></em>
											</font>
									</td>
								</tr>								
							</table>
						</td>
					</tr>
						<%
				}
		}
				%>
	</table>	
</body>
</html>