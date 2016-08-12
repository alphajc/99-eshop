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
	书名：<%=sms[0][0].get("title") %>
	类型：<%=sms[1][0].get("typename") %>
	<%
		}
	%>
</body>
</html>