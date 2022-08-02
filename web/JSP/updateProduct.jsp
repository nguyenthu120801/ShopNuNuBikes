<%-- 
    Document   : updateProduct
    Created on : Feb 20, 2022, 9:34:43 PM
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
            ResultSet rsProduct = (ResultSet)request.getAttribute("rsProduct");
        %>
        <%if(rsProduct.next()){%>
        <form action="ProductSevlet" method="Post">
            <p><input type="hidden" name="s" value="updateProduct"></p>
            <p>Product ID <input type="number" name="pid" value="<%=rsProduct.getString(1) %>"></p>
            <p>Product name <input type="text" name="pname" value="<%=rsProduct.getString(2) %>"></p>
            <p>Model year <input type="number" name="modelYear" value="<%=rsProduct.getString(3) %>"></p>
            <p>List price <input type="number" step="0.01" name="price" value="<%=rsProduct.getString(4) %>"></p>
            <p>Brand name <input type="text" name="brand" value="<%=rsProduct.getString(5) %>"></p>
            <p>Category name <input type="text" name="category" value="<%=rsProduct.getString(6) %>"></p>
            <input type="submit" value="submit" name="submit">
            <input type="reset" value="reset" name="reset">
        </form>
        <%}%>
    </body>
</html>
