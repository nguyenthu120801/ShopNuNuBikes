<%-- 
    Document   : displayStore
    Created on : Feb 12, 2022, 7:11:41 PM
    Author     : Dell
--%>

<%@page import="entity.store"%>
<%@page import="java.util.Vector"%>
<%@page import="model.DAOStore"%>
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
           //DAOStore dao = new DAOStore();
           Vector<store> vector = (Vector<store>)request.getAttribute("storeList");
           String titleTable = (String)request.getAttribute("titleTable");
        %>
         <table border="1">
             <caption><%=titleTable%></caption>
            <thead>
                <tr>
                    <th>store_id</th>
                    <th>store_name</th>
                    <th>phone</th>
                    <th>email</th>
                    <th>street</th>
                    <th>city</th>
                    <th>state</th>
                    <th>zip_code</th>
                    <th>update</th>
                    <th>delete</th>
                </tr>
            </thead>
            <tbody>
                <% for (store s : vector) { %>
                <tr>
                    <td><%=s.getStoreID() %></td>
                    <td><%=s.getStoreName() %></td>
                    <td><%=s.getPhone() %></td>
                    <td><%=s.getEmail() %></td>
                    <td><%=s.getStreet() %></td>
                    <td><%=s.getCity() %></td>
                    <td><%=s.getState() %></td>
                    <td><%=s.getZipCode() %></td>
                    <td><a href="ControllerStore?s=updateStore&storeID=<%=s.getStoreID() %>">update</a></td>
                    <td><a href="ControllerStore?s=deleteStore&storeID=<%=s.getStoreID() %>">delete</a></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
