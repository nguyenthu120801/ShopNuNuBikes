<%-- 
    Document   : displayStaff
    Created on : Feb 11, 2022, 8:33:50 AM
    Author     : DELL
--%>

<%@page import="entity.staff"%>
<%@page import="java.util.Vector"%>
<%@page import="model.DAOStaff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%String titlePage=(String)request.getAttribute("titlepage");%>
        <title><%=titlePage%></title>
    </head>
    <body>
        <%
            Vector<staff> vector=
                    (Vector<staff>)request.getAttribute("staffList");
          String titleTable=(String)request.getAttribute("titleTable");
        %>
        <table border="1">
            <caption><%=titleTable%></caption>
            <thead>
                <tr>
                    <th>staff_id</th>
                    <th>first_name</th>
                    <th>last_name</th>
                    <th>email</th>
                    <th>phone</th>
                    <th>active</th>
                    <th>store_id</th>
                    <th>manager_id</th>
                    <th>update</th>
                    <th>delete</th>
                </tr>
            </thead>
            <tbody>
                <% for (staff temp : vector) { %>
                <tr>
                    <td><%=temp.getStaffID() %></td>
                    <td><%=temp.getFirstName() %></td>
                    <td><%=temp.getLastName() %></td>
                    <td><%=temp.getEmail() %></td>
                    <td><%=temp.getPhone() %></td>
                    <td><%=temp.getActive() %></td>
                    <td><%=temp.getStoreID() %></td>
                    <td><%=temp.getManagerID() %></td>
                    <td><a href="StaffServlet?s=updateStaff&staffID=<%=temp.getStaffID()%>">update</a></td>
                    <td><a href="StaffServlet?s=deleteStaff&staffID=<%=temp.getStaffID()%>">delete</a></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
