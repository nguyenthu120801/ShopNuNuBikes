/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.staff;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author buidu
 */
public class DAOStaff extends ConnectDB {

    public int addStaff(staff st) {
        int n = 0;
        String sql = "INSERT INTO [staffs]([staff_id],[first_name],[last_name],[email],[phone],[active],[store_id],[manager_id])"
                + "               VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, st.getStaffID());
            ps.setString(2, st.getFirstName());
            ps.setString(3, st.getLastName());
            ps.setString(4, st.getEmail());
            ps.setString(5, st.getPhone());
            ps.setInt(6, st.getActive());
            ps.setInt(7, st.getStoreID());
            ps.setInt(8, st.getManagerID());
            n = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }
    public Vector<staff> listAll(String sql){
        Vector<staff> vector=new Vector<staff>();
       // String sql="Select * from staffs";
        try {
            Statement st = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
//                rs.getDataType(filedName|index=1);
                int staffID=rs.getInt(1);
                String firstName=rs.getString(2);
                String lastName=rs.getString(3);
                String email=rs.getString(4);
                String phone=rs.getString(5);
                int active =rs.getInt(6);
                int storeID=rs.getInt(7);
                int managerID=rs.getInt(8);
                staff staff = new staff(staffID, active, storeID, managerID, firstName, lastName, email, phone);
                vector.add(staff);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
    public int updateStaff(staff staff){
        int n=0;
        String sql="update staffs set [first_name]=?,"
                + "[last_name]=?,"
                + "[email]=?,"
                + "[phone]=?,"
                + "[active]=?,"
                + "[store_id]=?,"
                + "[manager_id]=?"
                + " where [staff_id]=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(8, staff.getStaffID());
            ps.setString(1, staff.getFirstName());
            ps.setString(2, staff.getLastName());
            ps.setString(3, staff.getEmail());
            ps.setString(4, staff.getPhone());
            ps.setInt(5, staff.getActive());
            ps.setInt(6, staff.getStoreID());
            ps.setInt(7, staff.getManagerID());
            n = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
        
    }
    
    public staff getStaff(String username) {
        ResultSet rs = getData("select*from staffs where username = '" + username + "'");
        staff st = new staff();
        try {
            if (rs.next()) {
                st.setStaffID(rs.getInt(1));
                st.setFirstName(rs.getString(2));
                st.setLastName(rs.getString(3));
                st.setEmail(rs.getString(4));
                st.setPhone(rs.getString(5));
                st.setActive(rs.getInt(6));
                st.setStoreID(rs.getInt(7));
                st.setManagerID(rs.getInt(8));
                st.setUsername(rs.getString(10));
                st.setPassword(rs.getString(11));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return st;
    }
    public static void main(String[] args) {
        DAOStaff st = new DAOStaff();
//        int n = st.addStaff(new staff(11, 1, 3, 7, "Naryok", "Steve", "naryoksteve@bikes.shop", "(972)973-3278"));
//        if (n > 0) {
//            System.out.println("inserted");
//        }
     //   st.listAll();
    }
}
