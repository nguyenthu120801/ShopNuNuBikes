/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Bill;
import entity.Customers;
import entity.Detail;
import entity.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAOOrder;
import model.DAOProducts;

/**
 *
 * @author PC
 */
@WebServlet(name = "BillServlet", urlPatterns = {"/BillServlet"})
public class BillServlet extends HttpServlet {

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
            service = "Bill";
        }
        DAOOrder dao = new DAOOrder();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (service.equals("Bill")) {
                ResultSet rs = dao.getData("select * from orders o join customers c on o.customer_id = c.customer_id order by o.order_id ");
                Vector<Bill> vector = new Vector<>();
                while (rs.next()) {
                    int oID = rs.getInt("order_id");
                    double total = 0;
                    String cusFirst = rs.getString("first_name");
                    String cusLast = rs.getString("last_name");
                    String CustomerName = cusFirst +" "+ cusLast;
                    String order_date = rs.getString("order_date");
                    ResultSet rs1 = dao.getData("select sum(quantity*list_price) from order_items where order_id="+ oID);
                    if(rs1.next()){
                        total = rs1.getDouble(1);
                    }
                    //ResultSet rs2 = dao.getData("select distinct o.order_status from orders o");
//                    Vector<Bill> vector1 =dao.ListStatus("select distinct o.order_status from orders o");
//                    request.setAttribute("Status", vector1);
                    int Status = rs.getInt("order_status");
                    vector.add(new Bill(oID, CustomerName, order_date, total, Status));
                }
                int count1 = 0;
                int count2 = 0;
                int count3 = 0;
                int count4 = 0;
                for (Bill b : vector) {
                    //b.getStatus();
                    if(b.getStatus()==1){
                        count1++;
                    }
                    if(b.getStatus()==2){
                        count2++;
                    } 
                    if(b.getStatus()==3){
                        count3++;
                    }
                    if(b.getStatus()==4){
                        count4++;
                    }
                    //request.setAttribute("count", count1);
                }
                request.setAttribute("count", count1);
                request.setAttribute("count1", count2);
                request.setAttribute("count3", count3);
                request.setAttribute("count4", count4);
                request.setAttribute("Bill", vector);
                request.getRequestDispatcher("BillManager.jsp").forward(request, response);
            }
            if (service.equals("detail")) {
                int orderID = Integer.parseInt(request.getParameter("OrderID"));
                Vector<Bill> vector = dao.ListBill("select*from orders o join customers c on o.customer_id=c.customer_id join order_items oi on o.order_id=oi.order_id where o.order_id =" + orderID);
                request.setAttribute("Bill", vector);
                Vector<Detail> vector1 = dao.BillDetail("select*from orders o join order_items oi on o.order_id = oi.order_id join products p on oi.product_id = p.product_id where o.order_id =" + orderID);
                ResultSet rs = dao.getData("select distinct o.order_status from orders o");
                request.setAttribute("status", rs);
                request.setAttribute("detail", vector1);
                request.getRequestDispatcher("BillDetail.jsp").forward(request, response);
            }
            if(service.equals("UpdateStatus")){
                int orderID = Integer.parseInt(request.getParameter("orderID"));
                int status = Integer.parseInt(request.getParameter("status"));
                dao.updateOrderStatus(status, orderID);
                Vector<Bill> vector = dao.ListBill("select*from orders o join customers c on o.customer_id=c.customer_id join order_items oi on o.order_id=oi.order_id where o.order_id =" + orderID);
                request.setAttribute("Bill", vector);
                Vector<Detail> vector1 = dao.BillDetail("select*from orders o join order_items oi on o.order_id = oi.order_id join products p on oi.product_id = p.product_id where o.order_id =" + orderID);
                ResultSet rs = dao.getData("select distinct o.order_status from orders o");
                request.setAttribute("status", rs);
                request.setAttribute("detail", vector1);
                request.getRequestDispatcher("BillDetail.jsp").forward(request, response);
            }
            if(service.equals("searchCustomerbyName")){
                String name = request.getParameter("nameCus");
                Vector<Bill> vector = dao.searchNameCustomer(name);
                request.setAttribute("Bill", vector);
                request.getRequestDispatcher("BillManager.jsp").forward(request, response);
            }if(service.equals("SearchBillID")){
                int id = Integer.parseInt(request.getParameter("ID"));
                Vector<Bill> vector = dao.searchBillID(id);
                request.setAttribute("Bill", vector);
                request.getRequestDispatcher("BillManager.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillServlet.class.getName()).log(Level.SEVERE, null, ex);
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
