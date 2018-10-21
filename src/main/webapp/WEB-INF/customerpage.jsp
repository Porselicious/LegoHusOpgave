<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>
    <body>
        <h1>Hello <%=request.getParameter("email")%> </h1>
        You are now logged in as a customer of our wonderful site.
        <form name="createLegohouse" action="FrontController" method="POST">
            <input type="hidden" name="command" value="createLegohouse">
            Length:<br>
            <input type="number" step="1" name="length" placeholder="min 4 long" min="4">
            <br>
            Width:<br>
            <input type="number" step="1" name="width" placeholder="min 4 broad" min="4">
            <br>
            Height:<br>
            <input type="number" step="1" name="height" placeholder="1 brick tall" min="1">
            <br>
            <input type="submit" value="Submit">
        </form>
        <form name="seeMyOrders" action="FrontController" method="POST">
            <input type="hidden" name="command" value="seeMyOrders">
            <input type="submit" value="SeeMyOrders">
        </form>
    </body>
</html>
