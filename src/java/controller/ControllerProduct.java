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
 * @author Dell
 */
@WebServlet(name = "ControllerProduct", urlPatterns = {"/ControllerProduct"})
public class ControllerProduct extends HttpServlet {

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
            service = "displayAllProduct";
        }
        DAOProducts dao = new DAOProducts();
        try (PrintWriter out = response.getWriter()) {
            if (service.equals("insertProduct")) {
                String id = request.getParameter("id");
                String pName = request.getParameter("pName");
                String modelYear = request.getParameter("modelYear");
                String listPrice = request.getParameter("listPrice");
                String brandName = request.getParameter("brandName");
                String categoryName = request.getParameter("categoryName");

                if (id == null || id.equals("")) {
                    out.print("id can not empty");
                } else if (pName == null || pName.equals("")) {
                    out.print("Product name can not empty");
                } else if (modelYear == null || modelYear.equals("")) {
                    out.print("year can not empty");
                } else if (listPrice == null || listPrice.equals("")) {
                    out.print("price can not empty");
                }

                int idNumber = Integer.parseInt(id);
                int yearNumber = Integer.parseInt(modelYear);
                double priceNumber = Double.parseDouble(listPrice);
                int n = dao.addProducts(new Products(idNumber, pName, yearNumber, priceNumber, brandName, categoryName));
                response.sendRedirect("ControllerProduct");
            }
            if (service.equals("displayAllProduct")) {
                Vector<Products> vector = dao.ListAll("select * from products");
                ResultSet rs = dao.getData("select distinct category_name from products");
                String titlePage = "Product manager";
                String titleTable = "Product List";
                RequestDispatcher dispath = request.getRequestDispatcher("index.jsp");
                request.setAttribute("category", rs);
                request.setAttribute("ProductList", vector);
                request.setAttribute("titlePage", titlePage);
                request.setAttribute("titleTable", titleTable);
                dispath.forward(request, response);
            }
//            if (service.equals("updateProduct")) {
//                String submit = request.getParameter("submit");
//                if (submit == null) {
//                    String productID = request.getParameter("productID");
//                    ResultSet rs = dao.getData("select * from products where product_id=" + productID);
//                    request.setAttribute("rsProduct", rs);
//                    dispath(request, response, "/JSP/updateProduct.jsp");
//                } else {
//                    String id = request.getParameter("pid");
//                    String pName = request.getParameter("pname");
//                    String modelYear = request.getParameter("modelYear");
//                    String listPrice = request.getParameter("price");
//                    String brandName = request.getParameter("brand");
//                    String categoryName = request.getParameter("category");
//
//                    int idNumber = Integer.parseInt(id);
//                    int yearNumber = Integer.parseInt(modelYear);
//                    double priceNumber = Double.parseDouble(listPrice);
//
//                    int n = dao.updateProduct(new Products(idNumber, pName, yearNumber, priceNumber, brandName, categoryName));
//                    response.sendRedirect("ControllerProduct");
//                }
//            }
//            if (service.equals("deleteProduct")) {
//                String productID = request.getParameter("productID");
//                int n = dao.removeProduct(productID);
//                //response.sendRedirect("ControllerProduct");
//            }
            if (service.equals("searchProductbyName")) {
                String name = request.getParameter("nameproduct");
                ResultSet rs = dao.getData("select distinct category_name from products");
                Vector<Products> vector = dao.searchByName(name);
                request.setAttribute("category", rs);
                request.setAttribute("ProductList", vector);
                dispath(request, response, "index.jsp");
            }
            if(service.equals("selectcategory")){
                String category = request.getParameter("categoryName");
                ResultSet rs = dao.getData("select distinct category_name from products");
                Vector<Products> vector = dao.ListAll("select*from products where category_name='"+category+"'");

                request.setAttribute("ProductList", vector);
                request.setAttribute("category", rs);
                dispath(request, response, "index.jsp");
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
