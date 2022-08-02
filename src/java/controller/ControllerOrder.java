/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Customers;
import entity.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOOrder;

/**
 *
 * @author Dell
 */
@WebServlet(name = "ControllerOrder", urlPatterns = {"/ControllerOrder"})
public class ControllerOrder extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String service = request.getParameter("s");
        if (service == null) {
            service = "displayAllOrder";
        }
        DAOOrder dao = new DAOOrder();
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if(service.equals("insertOrder")){
                String orderID = request.getParameter("id");
                    String CustomerID = request.getParameter("CustomerID");
                    String OrderStatus = request.getParameter("OrderStatus");
                    String orderDate = request.getParameter("orderDate");
                    String requiredDate = request.getParameter("requiredDate");
                    String shippedDate = request.getParameter("shippedDate");
                    String storeID = request.getParameter("storeID");
                    String staffID = request.getParameter("staffID");

                    if (orderID == null || orderID.equals("")) {
                        out.print("id null");
                    } else if (CustomerID == null || orderID.equals("")) {
                        out.print("CustomerID null");
                    } else if (OrderStatus == null || OrderStatus.equals("")) {
                        out.print("OrderStatus null");
                    } else if (storeID == null || storeID.equals("")) {
                        out.print("storeID null");
                    } else if (staffID == null || staffID.equals("")) {
                        out.print("staffID null");
                    }

                    int orderIDNumber = Integer.parseInt(orderID);
                    int cusNumber = Integer.parseInt(CustomerID);
                    int storeNumber = Integer.parseInt(storeID);
                    int staffNumber = Integer.parseInt(staffID);
                    int orderNumber = Integer.parseInt(OrderStatus);

                    int n = dao.updateOrder(new Order(orderIDNumber, cusNumber, orderNumber, orderDate, requiredDate, shippedDate, storeNumber, staffNumber));
                    response.sendRedirect("ControllerOrder");
            }
            if (service.equals("displayAllOrder")) {
                Vector<Order> vector = dao.ListAll("select * from orders");
                String titlePage = "Order manager";
                String titleTable = "Order List";
                RequestDispatcher dispath = request.getRequestDispatcher("/JSP/displayOrder.jsp");

                request.setAttribute("OrderList", vector);
                request.setAttribute("titlePage", titlePage);
                request.setAttribute("titleTable", titleTable);
                dispath.forward(request, response);
            }
            if (service.equals("updateOrder")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String orderID = request.getParameter("orderID");
                    ResultSet rs = dao.getData("select * from orders where order_id=" + orderID);
                    request.setAttribute("rsOrder", rs);
                    ResultSet rs1 = dao.getData("select distinct order_status from orders" );
                    request.setAttribute("rsStatus", rs1);
                    ResultSet rsStaff = dao.getData("select*from staffs" );
                    request.setAttribute("rsStaff", rsStaff);
                    ResultSet rsStore = dao.getData("select*from stores" );
                    request.setAttribute("rsStore", rsStore);
                    ResultSet rsCus = dao.getData("select*from customers" );
                    request.setAttribute("rsCus", rsCus);
                    dispath(request, response, "/JSP/updateOrder.jsp");
                } else {
                    String orderID = request.getParameter("id");
                    String CustomerID = request.getParameter("CustomerID");
                    String OrderStatus = request.getParameter("OrderStatus");
                    String orderDate = request.getParameter("orderDate");
                    String requiredDate = request.getParameter("requiredDate");
                    String shippedDate = request.getParameter("shippedDate");
                    String storeID = request.getParameter("storeID");
                    String staffID = request.getParameter("staffID");

                    if (orderID == null || orderID.equals("")) {
                        out.print("id null");
                    } else if (CustomerID == null || orderID.equals("")) {
                        out.print("CustomerID null");
                    } else if (OrderStatus == null || OrderStatus.equals("")) {
                        out.print("OrderStatus null");
                    } else if (storeID == null || storeID.equals("")) {
                        out.print("storeID null");
                    } else if (staffID == null || staffID.equals("")) {
                        out.print("staffID null");
                    }

                    int orderIDNumber = Integer.parseInt(orderID);
                    int cusNumber = Integer.parseInt(CustomerID);
                    int storeNumber = Integer.parseInt(storeID);
                    int staffNumber = Integer.parseInt(staffID);
                    int orderNumber = Integer.parseInt(OrderStatus);

                    int n = dao.updateOrder(new Order(orderIDNumber, cusNumber, orderNumber, orderDate, requiredDate, shippedDate, storeNumber, staffNumber));
                    response.sendRedirect("JoinTableServlet");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (service.equals("deleteOrder")) {
            String orderID = request.getParameter("orderID");
            int n = dao.removeOrder(orderID);
            response.sendRedirect("ControllerOrder");
        }
    }
            
    public void dispath(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException{
            RequestDispatcher dispath = request.getRequestDispatcher(page);
            dispath.forward(request, response);
        }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
