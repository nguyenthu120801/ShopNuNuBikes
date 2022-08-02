/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Bill;
import entity.Customers;
import entity.Detail;
import entity.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class DAOOrder extends ConnectDB {

    public int addOrder(Order ord) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[orders]([customer_id],"
                + "[order_status],[order_date],[required_date],"
                + "[shipped_date],[store_id],[staff_id])\n"
                + " VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //set value for ?
            // index start 1
            //pre.setInt(1, ord.getOrderID()); //1 ~ customerID
            pre.setInt(1, ord.getCustomerID()); // 2 ~ firstname
            pre.setInt(2, ord.getOrderStatus());
            pre.setString(3, ord.getOrderDate());
            pre.setString(4, ord.getRequiredDate());
            pre.setString(5, ord.getShippedDate());
            pre.setInt(6, ord.getStoreID());
            pre.setInt(7, ord.getStaffID());
            // run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateOrder(Order ord) {
        int n = 0;
        String sql = "update orders set [customer_id]=?,"
                + "[order_status]=?,[order_date]=?,[required_date]=?,"
                + "[shipped_date]=?,[store_id]=?,[staff_id]=? where [order_id]=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, ord.getCustomerID());
            pre.setInt(2, ord.getOrderStatus());
            pre.setString(3, ord.getOrderDate());
            pre.setString(4, ord.getRequiredDate());
            pre.setString(5, ord.getShippedDate());
            pre.setInt(6, ord.getStoreID());
            pre.setInt(7, ord.getStaffID());
            pre.setInt(8, ord.getOrderID());

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int removeOrder(String id) {
        int n = 0;
        String sql = "delete from orders where [order_id]='" + id + "'";
        // check foreign key costain
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector<Order> ListAll(String sql) {
        Vector<Order> vector = new Vector();
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int oID = rs.getInt(1);
                int cID = rs.getInt(2);
                int oStatus = rs.getInt(3);
                String order_date = rs.getString(4);
                String required_date = rs.getString(5);
                String shipped_date = rs.getString(6);
                int store_id = rs.getInt(7);
                int staff_id = rs.getInt(8);

                Order ord = new Order(oID, cID, oStatus, order_date, required_date, shipped_date, store_id, staff_id);
                vector.add(ord);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public Vector<Bill> ListBill(String sql) {
        Vector<Bill> vector = new Vector();
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int oID = rs.getInt("order_id");
                String cusFirst = rs.getString("first_name");
                String cusLast = rs.getString("last_name");
                String CustomerName = cusFirst + cusLast;
                String order_date = rs.getString("order_date");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("list_price");
                double total = quantity * price;
                int Status = rs.getInt("order_status");
                Bill bill = new Bill(oID, CustomerName, order_date, total, Status);
                vector.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public Vector<Detail> BillDetail(String sql) {
        Vector<Detail> vector = new Vector();
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int productid = rs.getInt("product_id");
                String productName = rs.getString("product_name");
                int Quantity = rs.getInt("quantity");
                double listPrice = rs.getDouble("list_price");
                Detail d = new Detail(productid, productName, Quantity, listPrice);
                vector.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public int updateOrderStatus(int status, int id) {
        int n = 0;
        String sql = "update orders set [order_status]=? where [order_id]=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, status);
            pre.setInt(2, id);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector<Bill> searchNameCustomer(String name) {
        Vector<Bill> vector = new Vector<>();
        String sql = "select * from orders o join customers c on o.customer_id = c.customer_id where first_name +' '+ last_name like '%" + name + "%' order by o.order_id";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int oID = rs.getInt("order_id");
                double total = 0;
                String cusFirst = rs.getString("first_name");
                String cusLast = rs.getString("last_name");
                String CustomerName = cusFirst + " " + cusLast;
                String order_date = rs.getString("order_date");
                ResultSet rs1 = getData("select sum(quantity*list_price) from order_items where order_id=" + oID);
                if (rs1.next()) {
                    total = rs1.getDouble(1);
                }
                int Status = rs.getInt("order_status");
                vector.add(new Bill(oID, CustomerName, order_date, total, Status));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    
    public Vector<Bill> searchBillID(int id) {
        Vector<Bill> vector = new Vector<>();
        String sql = "select * from orders o join customers c on o.customer_id = c.customer_id where o.order_id = "+ id +" order by o.order_id";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int oID = rs.getInt("order_id");
                double total = 0;
                String cusFirst = rs.getString("first_name");
                String cusLast = rs.getString("last_name");
                String CustomerName = cusFirst + " " + cusLast;
                String order_date = rs.getString("order_date");
                ResultSet rs1 = getData("select sum(quantity*list_price) from order_items where order_id=" + oID);
                if (rs1.next()) {
                    total = rs1.getDouble(1);
                }
                int Status = rs.getInt("order_status");
                vector.add(new Bill(oID, CustomerName, order_date, total, Status));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    
    public Vector<Bill> ListStatus(String sql) {
        Vector<Bill> vector = new Vector();
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int Status = rs.getInt("order_status");
                Bill bill = new Bill(Status);
                vector.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    

    public static void main(String[] args) {
        DAOOrder dao = new DAOOrder();
//        int n = dao.addOrder(new Order(-1, 1, 5, "03-03-2022", "03-03-2022", "03-03-2022", 1, 1));
//        if(n == 0){
//            System.out.println("fail");
//        }else{
//            System.out.println("thanh cong");
//        }
//        dao.updateOrderStatus(2, 1);
    }

    public Customers getCustomer(String username) {
        ResultSet rs = getData("select*from customers where username = '" + username + "'");
        Customers cus = new Customers();
        try {
            if (rs.next()) {
                cus.setCustomerID(rs.getInt(1));
                cus.setFirstName(rs.getString(2));
                cus.setLastName(rs.getString(3));
                cus.setPhone(rs.getString(4));
                cus.setEmail(rs.getString(5));
                cus.setStreet(rs.getString(6));
                cus.setCity(rs.getString(7));
                cus.setState(rs.getString(8));
                cus.setZipCode(rs.getString(9));
                cus.setUsername(rs.getString(10));
                cus.setPassword(rs.getString(11));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cus;
    }
}
