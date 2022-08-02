<%-- 
    Document   : updateStaff
    Created on : Feb 18, 2022, 7:58:35 AM
    Author     : PC
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="javax.naming.spi.DirStateFactory.Result"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ResultSet rsStaff = (ResultSet)request.getAttribute("rsStaff");
            ResultSet rsStore = (ResultSet)request.getAttribute("rsStore");
            ResultSet rsManager = (ResultSet)request.getAttribute("rsManager");
        %>
        <%if(rsStaff.next() ){%>
        <form action="StaffServlet" method="post">
            <p><input type="hidden" name="s" value="insertStaff"></p>
            <p>Staff ID <input type="number" name="sid" readonly="" value="<%=rsStaff.getString(1)%>"></p>
            <p>First name <input type="text" name="fName" value="<%=rsStaff.getString(2)%>"></p>
            <p>Last name <input type="text" name="lName" value="<%=rsStaff.getString(3)%>"></p>
            <p>Email <input type="text" name="email" value="<%=rsStaff.getString(4)%>"></p>
            <p>Phone <input type="text" name="phone" value="<%=rsStaff.getString(5)%>"></p>
            <p>Active 
                <input type="radio" name="active" value="1" <%=rsStaff.getInt(6)==1?"checked":"" %>>Active
                <input type="radio" name="active" value="0" <%=rsStaff.getInt(6)==0?"checked":"" %>>Deactive
            </p>
            <p>Store ID 
                <select name="storeID">
                    <%while(rsStore.next()){ %>
                    <option value="<%=rsStore.getInt(1)%>"><%=rsStore.getString(2)%></option>
                    <%}%>
                </select></p>
            <p>Manager ID
                <select name="managerID">
                    <%while(rsManager.next()){ %>
                    <option value="<%=rsManager.getInt(1) %>"><%=rsManager.getString(2) %></option>
                    <%}%>
                </select>
            </p>
            <input type="submit" value="submit" name="submit">
            <input type="reset" value="reset">
        </form>
        <%}%>
    </body>
</html>
