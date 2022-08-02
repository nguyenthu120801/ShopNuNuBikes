/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Customers;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOCustomers;

/**
 *
 * @author Dell
 */
@WebServlet(name = "ControllerCustomer", urlPatterns = {"/ControllerCustomer"})
public class ControllerCustomer extends HttpServlet {

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
            service = "displayAllCustomer";
        }
        DAOCustomers dao = new DAOCustomers();
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (service.equals("insertCustomer")) {
                //int id = Integer.parseInt(request.getParameter("id"));
                String fName = request.getParameter("fName");
                String lName = request.getParameter("lName");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");
                String street = request.getParameter("street");
                String city = request.getParameter("city");
                String state = request.getParameter("state");
                String zipCode = request.getParameter("zipCode");
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                if (fName == null || fName.trim().isEmpty()
                        || lName == null || lName.trim().isEmpty()
                        || email == null || email.trim().isEmpty()
                        || username == null || email.trim().isEmpty()
                        || password == null || password.trim().isEmpty()) {
                    request.setAttribute("error", "You must be input all field!!!");
                    request.getRequestDispatcher("Signin.jsp").forward(request, response);
                } else {
                    dao.addCustomers(new Customers(-1, fName, lName, phone, email, street, city, state, zipCode, username, password));
                    //request.setAttribute("Sign", "Register successful!");
                    ResultSet rs = dao.getData("select * from customers where username = '" + username + "' and password='" + password + "'");
                    if (rs.next()) { //login customer
                        Customers cus = dao.getCustomer(username);
                        session.setAttribute("username", cus);
                        response.sendRedirect("ControllerProduct");
                    }
                    //request.getRequestDispatcher("Signin.jsp").forward(request, response);
                }

            }
            if (service.equals("displayAllCustomer")) {

                Vector<Customers> vector = dao.ListAll("select * from customers");
                RequestDispatcher dispath = request.getRequestDispatcher("ManagerCustomer.jsp");
                request.setAttribute("CustomerList", vector);
                dispath.forward(request, response);
            }
            if (service.equals("updateCustomer")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String customerID = request.getParameter("customerID");
                    ResultSet rs = dao.getData("select * from customers where customer_id=" + customerID);
                    request.setAttribute("rsCus", rs);
                    ResultSet rs2 = dao.getData("select distinct state from customers");
                    request.setAttribute("rsStatus", rs2);
                    dispath(request, response, "/JSP/updateCustomer.jsp");
                } else {
                    int id = Integer.parseInt(request.getParameter("cid"));
                    String fName = request.getParameter("fname");
                    String lName = request.getParameter("lname");
                    String phone = request.getParameter("phone");
                    String email = request.getParameter("email");
                    String street = request.getParameter("street");
                    String city = request.getParameter("city");
                    String state = request.getParameter("state");
                    String zipCode = request.getParameter("zipCode");
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");

                    Customers customer = new Customers(id, fName, lName, phone, email, street, city, state, zipCode, username, password);
                    int n = dao.updateCustomer(customer);
                    response.sendRedirect("ControllerCustomer");
                }
            }
            if (service.equals("deleteCustomer")) {
                String customerID = request.getParameter("customerID");
                int n = dao.removeCustomer(customerID);
                if (n == 0) {
                    request.setAttribute("error", "Exception error cannot remove!");
                }
                Vector<Customers> vector = dao.ListAll("select * from customers");
                RequestDispatcher dispath = request.getRequestDispatcher("ManagerCustomer.jsp");
                request.setAttribute("CustomerList", vector);
                dispath.forward(request, response);

            }
            if (service.equals("SearchNameCustomer")) {
                String nameCus = request.getParameter("nameCus");
                Vector<Customers> vector = dao.searchNameCustomer(nameCus);
                RequestDispatcher dispath = request.getRequestDispatcher("ManagerCustomer.jsp");
                request.setAttribute("CustomerList", vector);
                dispath.forward(request, response);
            }
            if (service.equals("SearchID")) {
                String ID = request.getParameter("ID");
                Vector<Customers> vector = dao.searchIDCustomer(ID);
                RequestDispatcher dispath = request.getRequestDispatcher("ManagerCustomer.jsp");
                request.setAttribute("CustomerList", vector);
                dispath.forward(request, response);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void dispath(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
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
