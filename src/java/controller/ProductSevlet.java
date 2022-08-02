/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Products;
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
import model.DAOProducts;

/**
 *
 * @author PC
 */
@WebServlet(name = "ProductSevlet", urlPatterns = {"/ProductSevlet"})
public class ProductSevlet extends HttpServlet {

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
        
        DAOProducts dao = new DAOProducts();
        String service = request.getParameter("s");
            if (service == null) {
                service = "displayAllProduct";
            }
        try (PrintWriter out = response.getWriter()) {
            
            if (service.equals("displayAllProduct")) {
                Vector<Products> vector = dao.ListAll("select * from products");
                RequestDispatcher dispath = request.getRequestDispatcher("ManagerProduct.jsp");
                request.setAttribute("ProductList", vector);
                dispath.forward(request, response);
            }
            if (service.equals("updateProduct")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String productID = request.getParameter("productID");
                    ResultSet rs = dao.getData("select * from products where product_id=" + productID);
                    request.setAttribute("rsProduct", rs);
                    dispath(request, response, "/JSP/updateProduct.jsp");
                } else {
                    String id = request.getParameter("pid");
                    String pName = request.getParameter("pname");
                    String modelYear = request.getParameter("modelYear");
                    String listPrice = request.getParameter("price");
                    String brandName = request.getParameter("brand");
                    String categoryName = request.getParameter("category");

                    int idNumber = Integer.parseInt(id);
                    int yearNumber = Integer.parseInt(modelYear);
                    double priceNumber = Double.parseDouble(listPrice);

                    int n = dao.updateProduct(new Products(idNumber, pName, yearNumber, priceNumber, brandName, categoryName));
                    response.sendRedirect("ProductSevlet");
                }
            }
            if (service.equals("deleteProduct")) {
                String productID = request.getParameter("productID");
                int n = dao.removeProduct(productID);
                if(n==0){
                    request.setAttribute("error", "Exception error cannot remove!");
                }
                Vector<Products> vector = dao.ListAll("select * from products");
                RequestDispatcher dispath = request.getRequestDispatcher("ManagerProduct.jsp");
                request.setAttribute("ProductList", vector);
                dispath.forward(request, response);
            }
            if (service.equals("searchProductbyName")) {
                String name = request.getParameter("nameP");
                Vector<Products> vector = dao.searchByName(name);
                RequestDispatcher dispath = request.getRequestDispatcher("ManagerProduct.jsp");
                request.setAttribute("ProductList", vector);
                dispath.forward(request, response);
            }if(service.equals("SearchID")){
                String id = request.getParameter("ID");
                Vector<Products> vector = dao.searchByID(id);
                RequestDispatcher dispath = request.getRequestDispatcher("ManagerProduct.jsp");
                request.setAttribute("ProductList", vector);
                dispath.forward(request, response);
            }
            if (service.equals("searchProductbyPrice")) {
                String from = request.getParameter("from");
                String to = request.getParameter("to");

                double priceFrom = Double.parseDouble(from);
                double priceTo = Double.parseDouble(to);
                Vector<Products> vector = dao.searchByPrice(priceFrom, priceTo);
                RequestDispatcher dispath = request.getRequestDispatcher("ManagerProduct.jsp");
                request.setAttribute("ProductList", vector);
                dispath.forward(request, response);
            }
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
