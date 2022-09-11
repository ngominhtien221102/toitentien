/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAL.DAO;
import Model.Department;
import Model.Menu;
import Model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
public class loadDB_SE1625 extends HttpServlet {

    DAO dao;

    public void init() {
         String u = getServletContext().getInitParameter("userContext");
        String p = getServletContext().getInitParameter("passContext");
        dao = new DAO(u,p);
    }

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loadDbSe1625</title>");
            out.println("<link href ='CSS/myStyle.css' rel = 'stylesheet' >");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loadDbSe1625 at " + request.getContextPath() + "</h1>");

            if (request.getAttribute("DeleteId") != null) {
                String id = (String) request.getAttribute("DeleteId" + "");
                if (id.trim().length() != 0) {
                    dao.del(id);
                }
            }
            dao.LoadStudent();
            dao.loadDepart();
            String s = "<table>";
            for (Student obj : dao.getStdList()) {
//                s += obj.toRow();
                String id = obj.getDepartId();
                Department de = dao.getDepartHm().get(id);
                String departName = de.getName();
                s += obj.toRow(departName);
            }
            s += "</table>";
            out.println(s);

            if (request.getAttribute("UpdateId") == null) {
                out.println(getForm());
            } else {
                String id = (String) request.getAttribute("UpdateId");
                String name = "";
                String departId = "SE";
                boolean gender = true;
                String gpa = "";
                String add = "";
                boolean update = false;
                if (id.trim().length() != 0) {
                    for (Student st : dao.getStdList()) {
                        if (st.getId().equals(id)) {
                            name = st.getName();
                            departId = st.getDepartId();
                            gender = st.isGender();
                            gpa = st.getGPA() + "";
                            add = st.getAdd();
                            update = true;
                            break;

                        }
                    }
                    if (update) {
                        out.println(getForm(id, name, departId, gender, gpa, add));
                    } else {
                        out.println(getForm());
                    }

                } else {
                    out.println(getForm());
                }
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    private String getForm() {
        String f = "<form action= 'loadDbSe1625' method = 'post'>";
        f += "ID: <input type = 'text' name ='id'><br/>";
        f += "Name: <input type = 'text' name ='name'><br/>";
        f += "Department: <select name ='departId'>";
        for (Map.Entry<String, Department> en : dao.getDepartHm().entrySet()) {
            String key = en.getKey();
            Department value = en.getValue();
            f += "<option value = '" + key + "'>" + value.getName() + "</option>";
        }
        f += "</select> <br/>";
        f += "Gender: <input type = 'radio' name = 'gender' value = 'm' checked> Male";
        f += "<input type = 'radio' name = 'gender' value = 'f' checked> Female<br/>";
        f += "GPA: <input type = 'text' name= 'gpa'> <br/>";
        f += "Address: <input type ='text' name='add'> <br/>";
        f += "<input type ='submit' value ='insert'> <br/> ";
        f += "</form>";
        return f;
    }

    private String getForm(String id, String name, String departId, boolean gender, String gpa, String add) {
        String f = "<form action= 'loadDbSe1625' method = 'post'>";
        f += "ID: <input type = 'text' name ='id' value='" + id + "'><br/>";
        f += "Name: <input type = 'text' name ='name' value= '" + name + "'><br/>";
        f += "Department: <select name ='departId'>";
        for (Map.Entry<String, Department> en : dao.getDepartHm().entrySet()) {
            String key = en.getKey();
            Department value = en.getValue();
            f += "<option value = '" + key + "' " + (key.equals(departId) ? "selected" : "") + ">" + value.getName() + "</option>";
        }
        f += "</select> <br/>";
        f += "Gender: <input type = 'radio' name = 'gender' value = 'm' " + (gender ? "checked" : "") + "> Male";
        f += "<input type = 'radio' name = 'gender' value = 'f' " + (gender ? "" : "checked") + "> female<br/>";
        f += "GPA: <input type = 'text' name= 'gpa' value ='" + gpa + "'><br/>";
        f += "Address: <input type ='text' name='add' value= '" + add + "'><br/>";
        f += "<input type ='submit' value ='insert/update'> <br/> ";
        f += "</form>";
        return f;
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
        String u = getServletContext().getInitParameter("userContext");
        String p = getServletContext().getInitParameter("passContext");
        dao = new DAO(u,p);
        Object obj = request.getAttribute("DeleteId");
        if (obj != null) {
            String id = (obj + "").trim();
            if (id.length() != 0) {
                dao.del(id);
            }
        }
        dao.LoadStudent();
        dao.loadDepart();
        request.setAttribute("DAO", dao);
        request.setAttribute("Menu", getMenu(dao.getMenu(), 0));
        request.getRequestDispatcher("Views/Load.jsp").forward(request, response);
//        processRequest(request, response);

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
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String departId = request.getParameter("departId");
        boolean gender = request.getParameter("gender").equals("m");
        float gpa = Float.parseFloat(request.getParameter("gpa"));
        String add = request.getParameter("add");
        boolean update = false;
        for (Student st : dao.getStdList()) {
            if (st.getId().equals(id)) {
                update = true;
                break;
            }

        }
        if (update) {
            dao.Update(id, name, departId, gender, gpa, add);
        } else if (id.trim().length() != 0) {
            dao.Insert(id, name, departId, gender, gpa, add);
        }
        doGet(request, response);
//        processRequest(request, response);
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

    private String getMenu(ArrayList<Menu> menu, int pid) {
        boolean check = true;
        for (Menu m : menu) {
            if (m.getPid() == pid) {
                check = false;
                break;

            }
        }
        if (check) {
            return "";
        }
        String s = "<ul>";
        for (Menu m: menu) {
            if (m.getPid() == pid) {
                s += "<li>";
                if (m.getLink() != null) {
                    s += "<a href = '" + m.getLink()+"' title = '"+ m.getTitle()+ "'>" + m.getName() + "</a>";
                } else 
                s += m.getName();
                s += getMenu(menu, m.getId());
                s += "</li>";
            }
        }
        s += "</ul>";
        return s;
    }
}
