/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.store;
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
import model.DAOStore;

/**
 *
 * @author Dell
 */
@WebServlet(name = "ControllerStore", urlPatterns = {"/ControllerStore"})
public class ControllerStore extends HttpServlet {

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
            service = "displayAllStore";
        }
        DAOStore dao = new DAOStore();
        try (PrintWriter out = response.getWriter()) {
            if (service.equals("insertStore")) {
                String id = request.getParameter("id");
                String sName = request.getParameter("sName");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");
                String street = request.getParameter("street");
                String city = request.getParameter("city");
                String state = request.getParameter("state");
                String zipCode = request.getParameter("zipCode");

                if (id == null || id.equals("")) {
                    out.println("id can not empty");
                } else if (sName == null || sName.equals("")) {
                    out.println("Store name can not empty");
                }

                int idNumber = Integer.parseInt(id);

//            out.println("<H2>"+idNumber+"<H2>");
//            out.println("<H2>"+sName+"<H2>");
//            out.println("<H2>"+phone+"<H2>");
//            out.println("<H2>"+email+"<H2>");
//            out.println("<H2>"+street+"<H2>");
//            out.println("<H2>"+city+"<H2>");
//            out.println("<H2>"+state+"<H2>");
//            out.println("<H2>"+zipCode+"<H2>");
                int n = dao.addStore(new store(idNumber, sName, phone, email, street, city, state, zipCode));
                response.sendRedirect("ControllerStore");
//             if(n>0){
//                 out.println("inserted");
//             }
            }
            if (service.equals("displayAllStore")) {
                Vector<store> vector = dao.ListAll("select * from stores");
                RequestDispatcher dispath = request.getRequestDispatcher("Store.jsp");

                request.setAttribute("storeList", vector);
                dispath.forward(request, response);
            }
            if (service.equals("updateStore")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String storeID = request.getParameter("storeID");
                    ResultSet rs = dao.getData("select * from stores where store_id = " + storeID);
                    ResultSet rs1 = dao.getData("select distinct zip_code from customers ");
                    ResultSet rs2 = dao.getData("select * from stores");
                    ResultSet rs3 = dao.getData("select distinct city from customers ");
                    
                    RequestDispatcher dispath = request.getRequestDispatcher("/JSP/updateStore.jsp");

                    request.setAttribute("rsStore", rs);
                    request.setAttribute("rsZipCode", rs1);
                    request.setAttribute("rsAllStore", rs2);
                    request.setAttribute("rsCity", rs3);
                    
                    dispath.forward(request, response);
                } else {
                    String id = request.getParameter("id");
                    String sName = request.getParameter("sName");
                    String phone = request.getParameter("phone");
                    String email = request.getParameter("email");
                    String street = request.getParameter("street");
                    String city = request.getParameter("city");
                    String state = request.getParameter("state");
                    String zipCode = request.getParameter("zipCode");

                    int idNumber = Integer.parseInt(id);

                    int n = dao.updateStore(new store(idNumber, sName, phone, email, street, city, state, zipCode));
                    response.sendRedirect("ControllerStore");
                }
            }
            if (service.equals("deleteStore")) {
                String storeID = request.getParameter("storeID");
                int n = dao.removeStore(storeID);
                response.sendRedirect("ControllerStore");
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
