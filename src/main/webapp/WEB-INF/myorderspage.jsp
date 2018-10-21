<%-- 
    Document   : myorderspage
    Created on : 21-10-2018, 20:30:41
    Author     : porse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ORDERS</title>
    </head>
    <body>
        <h1>Your orders</h1>
        <%=request.getAttribute("orders")%>
    </body>
</html>
