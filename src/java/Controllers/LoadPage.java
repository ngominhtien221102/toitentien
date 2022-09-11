/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAL.DAO;
import Model.PageInfor;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Lenovo
 */
public class LoadPage extends HttpServlet {

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
            out.println("<title>Servlet LoadPage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoadPage at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
//        processRequest(request, response);
        HttpSession ses = request.getSession();
        boolean reload = true;
        if (ses.getAttribute("reload") != null) {
            reload = (boolean) ses.getAttribute("reload");
        }
        if (reload) {
            dao.LoadStudent();
            dao.loadDepart();
            ses.setAttribute("reload", false);
        }

        request.setAttribute("dao", dao);
        int size = dao.getStdList().size();
        int cp = 0;
        int nrpp = 1;
        if (ses.getAttribute("nrpp") != null) {
            nrpp = (int) ses.getAttribute("nrpp");
        }

//        if(request.getParameter("nrpp")!= null)
//        {
//            nrpp = Integer.parseInt(request.getParameter("nrpp"));
//        }
//        int np = (size + nrpp - 1) / nrpp;
//        if (request.getParameter("currentPage") == null) {
//            cp = 0;
//        } else {
//            try {
//                cp = Integer.parseInt(request.getParameter("currentPage") + "");
//                cp = cp < 0 ? 0 : cp;
//                cp = cp > np - 1 ? np - 1 : cp;
//            } catch (Exception e) {
//
//            }
//        }
//        int begin = cp * nrpp;
//        int end = (cp + 1) * nrpp - 1;
//        request.setAttribute("CP", new PageInfor(cp, nrpp, size, np, begin, end));
        PageInfor page = new PageInfor(cp, nrpp, size);
        page.calc();
        request.setAttribute("CP", page);
        request.setAttribute("dao", dao);
        request.getRequestDispatcher("Views/LoadPage.jsp").forward(request, response);
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
//        processRequest(request, response);
        HttpSession ses = request.getSession();
        boolean reload = true;
        if (ses.getAttribute("reload") != null) {
            reload = (boolean) ses.getAttribute("reload");

        }
        int np = Integer.parseInt(request.getParameter("np"));
        int cp = Integer.parseInt(request.getParameter("cp"));
        int nrpp = 1;
        nrpp = Integer.parseInt(request.getParameter("nrpp"));
        ses.setAttribute("nrpp", nrpp);
        if (reload) {
            dao.loadDepart();
            dao.LoadStudent();
            ses.setAttribute("reload", false);
        }

//        if(ses.getAttribute("nrpp")!= null) nrpp =(int)ses.getAttribute("nrpp");
        if (request.getParameter("home") != null) {
            cp = 0;
        }
        if (request.getParameter("pre") != null) {
            cp = cp - 1;
        }
        if (request.getParameter("next") != null) {
            cp = cp + 1;
        }
        if (request.getParameter("end") != null) {
            cp = np - 1;
        }
        for (int i = 0; i < np; i++) {
            if (request.getParameter("btn" + i) != null) {
                cp = i;
            }
        }
        PageInfor page = new PageInfor(cp, nrpp, dao.getStdList().size());
        page.calc();
        request.setAttribute("dao", dao);
        request.setAttribute("CP", page);
        request.getRequestDispatcher("Views/LoadPage.jsp").forward(request, response);

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
