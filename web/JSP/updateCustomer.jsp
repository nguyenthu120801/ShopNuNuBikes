<%-- 
    Document   : updateCustomer
    Created on : Feb 20, 2022, 5:02:28 PM
    Author     : PC
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ResultSet rsCus = (ResultSet)request.getAttribute("rsCus");
            ResultSet rsStatus = (ResultSet)request.getAttribute("rsStatus");
        %>
        <%if(rsCus.next()){ %>
        <form action="ControllerCustomer" method="get">
            <p><input type="hidden" name="s" value="updateCustomer"></p>
            <p>Customer ID <input type="number" name="cid" value="<%=rsCus.getString(1) %>"></p>
            <p>First name <input type="text" name="fname" value="<%=rsCus.getString(2) %>"></p>
            <p>Last name <input type="text" name="lname" value="<%=rsCus.getString(3) %>"></p>
            <p>Phone <input type="text" name="phone" value="<%=rsCus.getString(4) %>"></p>
            <p>Email <input type="text" name="email" value="<%=rsCus.getString(5) %>"></p>
            <p>Street <input type="text" name="street" value="<%=rsCus.getString(6) %>"></p>
            <p>City <input type="text" name="city" value="<%=rsCus.getString(7) %>"></p>
            <p>State 
                <select name="state">
                <%while(rsStatus.next()){ %>
                    <option value="<%=rsStatus.getString(1)%>"><%=rsStatus.getString(1)%></option>
                    <%}%>
                </select>
            </p>
            <p>Zip code <input type="text" name="zipCode" value="<%=rsCus.getString(9) %>"></p>
            <input type="submit" value="Submit" name="submit">
            <input type="reset" value="Reset" name="Reset">
        </form>
        <%}%>
    </body>
</html>
