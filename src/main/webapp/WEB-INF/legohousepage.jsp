<%-- 
    Document   : legohousepage
    Created on : 21-10-2018, 20:25:08
    Author     : porse
--%>

<%@page import="FunctionLayer.Legohouse"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
               <title>JSP Page</title>
    </head>
    <body>
        <h1>Part list</h1>
        <%= request.getAttribute("pcelist")%>

        <table>
            <tr>
                <td>
                    <form name="createOrder" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="createOrder">
                        <input type="submit" value="Complete order">
                    </form>
                </td>
                <td>
                    <form name="login" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="login">
                        <input type="submit" value="Construct a new house">
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>