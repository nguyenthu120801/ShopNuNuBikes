<%-- 
    Document   : updateOrder
    Created on : Feb 18, 2022, 11:31:05 PM
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
            ResultSet rsOrder = (ResultSet) request.getAttribute("rsOrder");
            ResultSet rsCus = (ResultSet) request.getAttribute("rsCus");
            ResultSet rsStatus = (ResultSet) request.getAttribute("rsStatus");
            ResultSet rsStore = (ResultSet) request.getAttribute("rsStore");
            ResultSet rsStaff = (ResultSet) request.getAttribute("rsStaff");
        %>
        <%if (rsOrder.next()) {%>
        <form action="ControllerOrder" method="POST">
            <p><input type="hidden" name="s" value="updateOrder"></p>
            <table>
                <tr>
                    <td>orderID</td>
                    <td><input type="number"  name="id" value="<%=rsOrder.getString(1)%>"></td>
                </tr>
                <tr>
                    <td>CustomerID</td>
                    <td><select name="CustomerID">
                            <%while (rsCus.next()) {%>
                            <option value="<%=rsCus.getInt(1)%>"><%=rsCus.getString(2)%> <%=rsCus.getString(3)%></option>
                            <%}%>
                        </select></td>
                </tr>
                <tr>
                    <td>OrderStatus</td>
                    <td><select name="OrderStatus">
                            <%while (rsStatus.next()) {%>
                            <option value="<%=rsStatus.getInt(1)%>"><%=rsStatus.getString(1)%> </option>
                            <%}%>
                        </select></td>
                </tr>
                <tr>
                    <td><label for="orderDate">orderDate</label></td>
                    <td><input type="date" name="orderDate" value="<%=rsOrder.getString(4)%>"></td>
                </tr>
                <tr>
                    <td><label for="requiredDate">requiredDate</label></td>
                    <td><input type="date" name="requiredDate" value="<%=rsOrder.getString(5)%>"></td>
                </tr>
                <tr>
                    <td><label for="shippedDate">shippedDate</label></td>
                    <td><input type="date" name="shippedDate" value="<%=rsOrder.getString(6)%>"></td>
                </tr>
                <tr>
                    <td>storeID</td>
                    <td><select name="storeID">
                            <%while (rsStore.next()) {%>
                            <option value="<%=rsStore.getInt(1)%>"><%=rsStore.getString(2)%> <%=rsStore.getString(3)%> </option>
                            <%}%>
                        </select></td>
                </tr>
                <tr>
                    <td>staffID</td>
                    <td><select name="staffID">
                            <%while (rsStaff.next()) {%>
                            <option value="<%=rsStaff.getInt(1)%>"><%=rsStaff.getString(2)%> <%=rsStaff.getString(3)%> </option>
                            <%}%>
                        </select></td>
                </tr>
            </table>
            <input type="submit" name="submit" value="submit">
        </form>
        <%}%>

    </body>
</html>
