/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.*;
import Model.*;
import java.sql.*;

/**
 *
 * @author Lenovo
 */
public class DAO {

    private ArrayList<Student> stdList;
    private HashMap<String, Department> departHm;
    private String status;
    private Connection con;
    
    
    public ArrayList<Users> getUsers()
    {
        ArrayList<Users> us = new ArrayList<>();
        String sql = "Select * from Users";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                us.add(new Users(rs.getString(1), rs.getString(2),rs.getByte(3)));
            } 
        } catch (SQLException e) {
            status = "Error at read Users" + e.getMessage();
        }
        return us ;
    }
    
    
        public ArrayList<Menu> getMenu()
        {
            ArrayList<Menu> m = new ArrayList<>();
            String sql = "Select * from Menu";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {                    
                    m.add(new Menu(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
                }
                
            } catch (SQLException e) {
                status = "Error at read Menu" + e.getMessage();
            }
            return m;
        }
    

    public void setStdList(ArrayList<Student> stdList) {
        this.stdList = stdList;
    }

    public void setDepartHm(HashMap<String, Department> departHm) {
        this.departHm = departHm;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Student> getStdList() {
        return stdList;
    }

    public HashMap<String, Department> getDepartHm() {
        return departHm;
    }

    public String getStatus() {
        return status;
    }


    public DAO(String u, String p) {
        try {
            con = new DBContext(u,p).getConnection();
        } catch (Exception e) {
            status = "Error connection" + e.getMessage();
        }
    }

    public void LoadStudent() {
        stdList = new ArrayList<>();
        String sql = "Select * from Student";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String departId = rs.getString(3);
                boolean gender = rs.getBoolean(4);
                float GPA = rs.getFloat(5);
                String add = rs.getString(6);
                stdList.add(new Student(id, name, departId, gender, GPA, add));

            }
        } catch (SQLException e) {
            status = "Error Student" + e.getMessage();
        }
    }

    public void loadDepart() {
        String sql = "Select * from Department";
        departHm = new HashMap<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String infor = rs.getString(3);

                departHm.put(id, new Department(id, name, infor));

            }
        } catch (Exception e) {
            status = "Error Department" + e.getMessage();
        }
    }

    public void Insert(String id, String name, String departId, boolean gender, float gpa, String add) {
        String sql = "insert into Student values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, departId);
            ps.setBoolean(4, gender);
            ps.setFloat(5, gpa);
            ps.setString(6, add);
            ps.execute();
        } catch (Exception e) {
            status = "Error at insert Student " + e.getMessage();
        }
    }

    public void Update(String id, String name, String departId, boolean gender, float gpa, String add) {
       String sql = "Update Student set Name=?, DepartmentID =?, Gender =?,  "
               + "GPA =? , [add] =? where ID =?";
               try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(6, id);
            ps.setString(1, name);
            ps.setString(2, departId);
            ps.setBoolean(3, gender);
            ps.setFloat(4, gpa);
            ps.setString(5, add);
            ps.execute();
        } catch (Exception e) {
            status = "Error at Update student" + e.getMessage();
        }
    }

    public void del(String id) {
        String sql = "delete from Student where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
        } catch (Exception e) {
            status = "Error at delete Student" + e.getMessage();
        }
    }

    
    
//    public static void main(String[] args) {
//        DAO dao =new DAO();
//        for (Users obj : dao.getUsers()) {
//            System.out.println(obj.getRole());
//        }
//    }

}
