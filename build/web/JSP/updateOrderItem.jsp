<%-- 
    Document   : updateOrderItem
    Created on : Feb 19, 2022, 2:00:59 AM
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
            ResultSet rsOrderItem = (ResultSet) request.getAttribute("rsOrderItem");
            ResultSet rsItem = (ResultSet) request.getAttribute("rsItem");
            ResultSet rsProduct = (ResultSet) request.getAttribute("rsProduct");
        %>
        <%if (rsOrderItem.next()) {%>
        <form action="ControllerOrderItem" method="POST">
            <p><input type="hidden" name="s" value="updateOrderItem"></p>
            <table>
                <tr>
                    <td>orderID</td>
                    <td><input type="text" name="orderID" value="<%=rsOrderItem.getString(1)%>"></td>
                </tr>
                <tr>
                    <td>itemID</td>
                    <td><select name="itemid">
                            <%while (rsItem.next()) {%>
                            <option value="<%=rsItem.getInt(1)%>"><%=rsItem.getString(1)%></option>
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>productID</td>
                    <td><select name="productID">
                            <%while (rsProduct.next()) {%>
                            <option value="<%=rsProduct.getInt(1)%>"><%=rsProduct.getString(2)%></option>
                            <%}%>
                        </select></td>
                </tr>
                <tr>
                    <td>quantity</td>
                    <td><input type="number"  name="quantity" value="<%=rsOrderItem.getString(4)%>"</td>
                </tr>
                <tr>
                    <td>ListPrice</td>
                    <td><input type="number"  name="ListPrice" value="<%=rsOrderItem.getString(5)%>" step="0.01"></td>
                </tr>
                <tr>
                    <td>Discount</td>
                    <td><input type="number"  name="Discount" value="<%=rsOrderItem.getString(6)%>" step="0.01"></td>
                </tr>

            </table>
            <input type="submit" name="submit" >
        </form>
        <%}%>
    </body>
</html>
