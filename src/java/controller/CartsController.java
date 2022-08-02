/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Cart;
import entity.Customers;
import entity.Order;
import entity.OrderItems;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOCustomers;
import model.DAOOrder;
import model.DAOOrderItem;

/**
 *
 * @author PC
 */
@WebServlet(name = "CartsController", urlPatterns = {"/CartsController"})
public class CartsController extends HttpServlet {

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
            service = "Cart";
        }
        try (PrintWriter out = response.getWriter()) {
            if (service.equals("Cart")) {
                HttpSession session = request.getSession();
                Map<Integer, Cart> carts = (Map<Integer, Cart>) session.getAttribute("carts");
                if (carts == null) {
                    carts = new LinkedHashMap<>();
                }

                request.setAttribute("carts", carts);
                request.getRequestDispatcher("ShowCart.jsp").forward(request, response);
            }
            if (service.equals("CheckoutCart")) {
                HttpSession session = request.getSession();
                Map<Integer, Cart> carts = (Map<Integer, Cart>) session.getAttribute("carts");
                if (carts == null) {
                    carts = new LinkedHashMap<>();
                }
                Customers cus = (Customers) session.getAttribute("username");
                DAOCustomers dao = new DAOCustomers();
                ResultSet rs = dao.getData("select*from customers where customer_id= " + cus.getCustomerID());
                request.setAttribute("customerID", rs);

                request.setAttribute("carts", carts);
                request.getRequestDispatcher("Checkout.jsp").forward(request, response);

            }
            if (service.equals("AddCartDB")) {
                try {
                    HttpSession session = request.getSession();
                    //luu Order
                    DAOOrder dao = new DAOOrder();
                    Customers cus = (Customers) session.getAttribute("username");
                    System.out.println(cus.getCustomerID());
                    int n = dao.addOrder(new Order(-1, cus.getCustomerID(), 3, "03-03-2022", "03-03-2022", "03-03-2022", 1, 1));
                    //luu Order_item
                    DAOOrderItem dao1 = new DAOOrderItem();
                    ResultSet rs = dao.getData("select MAX(order_id) from orders");
                    int orderIDTail = 0;
                    if (rs.next()) {
                        orderIDTail = rs.getInt(1);
                    }
                    Map<Integer, Cart> carts = (Map<Integer, Cart>) session.getAttribute("carts");
                    int itemID = 1;
                    for (Map.Entry<Integer, Cart> entry : carts.entrySet()) {
                        Integer key = entry.getKey();
                        Cart value = entry.getValue();

                        int m = dao1.addOrderItem(new OrderItems(orderIDTail, itemID, carts.get(key).getP().getProductID(), carts.get(key).getQuantity(), carts.get(key).getP().getListPrice(), 0.2));
                        itemID++;
                    }
                    session.invalidate();
                    response.sendRedirect("Thank.jsp");
                    

                } catch (SQLException ex) {
                    Logger.getLogger(CartsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

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
