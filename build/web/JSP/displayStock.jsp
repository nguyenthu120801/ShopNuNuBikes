<%-- 
    Document   : displayStock
    Created on : Feb 12, 2022, 10:27:17 PM
    Author     : Dell
--%>

<%@page import="entity.Stock"%>
<%@page import="java.util.Vector"%>
<%@page import="model.DAOStock"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%String titlePage = (String)request.getAttribute("titlepage");%>
        <title><%=titlePage%></title>
    </head>
    <body>
        <% 
          /// DAOStock dao = new DAOStock();
           Vector<Stock> vector = (Vector<Stock>)request.getAttribute("stockList");
           String titleTable = (String)request.getAttribute("titleTable");
        %>
         <table border="1">
            <caption><%=titleTable%></caption>
            <thead>
                <tr>
                    <th>store_id</th>
                    <th>product_id</th>
                    <th>quantity</th>
                    <th>update</th>
                    <th>delete</th>
                </tr>
            </thead>
            <tbody>
                <% for (Stock st : vector) { %>
                <tr>
                    <td><%=st.getStoreID() %></td>
                    <td><%=st.getProductID() %></td>
                    <td><%=st.getQuantity() %></td>
                    <td><a href="ControllerStocks?s=updateStock&storeID=<%=st.getStoreID()%>&productID=<%=st.getProductID()%>" >update</a></td>
                    <td><a href="ControllerStocks?s=deleteStock&storeID=<%=st.getStoreID()%>&productID=<%=st.getProductID()%>" >delete</a></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
