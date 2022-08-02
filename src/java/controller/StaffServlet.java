/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAOStaff;
import entity.staff;
import java.sql.ResultSet;
import java.util.Vector;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author buidu
 */
@WebServlet(name = "StaffServlet", urlPatterns = {"/StaffServlet"})
public class StaffServlet extends HttpServlet {

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
            service = "displayAllStaff";
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            DAOStaff dao = new DAOStaff();
            if (service.equals("insertStaff")) {
                String id = request.getParameter("sid");
                String fName = request.getParameter("fName");
                String lName = request.getParameter("lName");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String active = request.getParameter("active");
                String storeID = request.getParameter("storeID");
                String managerID = request.getParameter("managerID");
                //check

                if (id == null || id.equals("")) {
                    out.println("Staff ID is not empty");
                }
                if (fName == null || fName.equals("")) {
                    out.println("First name is not empty");
                }
                if (lName == null || lName.equals("")) {
                    out.println("Last name is not empty");
                }
                if (email == null || email.equals("")) {
                    out.println("Email is not empty");
                }
                if (active == null || active.equals("")) {
                    out.println("Active is not empty");
                }
                if (storeID == null || storeID.equals("")) {
                    out.println("Store ID is not empty");
                }
                //convert
                int staffID = Integer.parseInt(id);
                int activeint = Integer.parseInt(active);
                int StoreID = Integer.parseInt(storeID);
                int mID = Integer.parseInt(managerID);
                int n = dao.addStaff(new staff(staffID, activeint, StoreID, mID, fName, lName, email, phone));
                response.sendRedirect("StaffServlet");
//                if (n > 0) {
//                    out.println("inserted");
//                }
            }
            if (service.equals("displayAllStaff")) {
                //get data from model
                Vector<staff> vector = dao.listAll("Select * from staffs");
                String titlepage = "Saffs manager";
                String titleTable = "Staff List";
                // pre data for jsp
                request.setAttribute("staffList", vector);
                request.setAttribute("titlepage", titlepage);
                request.setAttribute("titleTable", titleTable);

                //select jsp to view
                RequestDispatcher dispath
                        = request.getRequestDispatcher("/JSP/displayStaff.jsp");
                // run
                dispath.forward(request, response);

            }
            if (service.equals("updateStaff")) {
                String submit = request.getParameter("submit");
                if (submit == null) { //chua submit
                    // step1 get data
                    String staffId = request.getParameter("staffID");
                    ResultSet rs = dao.getData("select * from staffs where staff_id=" + staffId);
                    ResultSet rs1 = dao.getData("select * from stores");
                    request.setAttribute("rsStaff", rs);
                    request.setAttribute("rsStore", rs1);
                    ResultSet rs2 = dao.getData("select staff_id, (first_name +' '+ last_name) from staffs s where s.staff_id in (select manager_id from staffs )");
                    request.setAttribute("rsManager", rs2);
                    dispath(request, response, "/JSP/updateStaff.jsp");

                }
            } else {
                //step2: update
                String id = request.getParameter("sid");
                String fName = request.getParameter("fName");
                String lName = request.getParameter("lName");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String active = request.getParameter("active");
                String storeID = request.getParameter("storeID");
                String managerID = request.getParameter("managerID");
                //convert
                int staffID = Integer.parseInt(id);
                int activeint = Integer.parseInt(active);
                int StoreID = Integer.parseInt(storeID);
                int mID = Integer.parseInt(managerID);
                int n = dao.updateStaff(new staff(staffID, activeint, StoreID, mID, fName, lName, email, phone));
                response.sendRedirect("StaffServlet");
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
