/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import services.UserService;

/**
 *
 * @author tsepe
 */
public class LoginController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet2</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet2 at " + request.getContextPath() + "</h1>");
            out.println("<form name=\"login\" action=\"login\" method='POST'>\n"
                    + "            <input type=\"text\" name=\"fName\" value=\"ANONYMOUS\" size=\"25\" />\n"
                    + "            <input type=\"text\" name=\"lName\" value=\"ANONYMOUS\" />\n"
                    + "            <input type=\"submit\" value=\"Login\" name=\"submit\" />\n"
                    + "        </form>");
            out.println("</body>");
            out.println("</html>");
        }
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
        RequestDispatcher rd;
        User ul = new User();
        UserService ulService = new UserService();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet2</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet2 at " + request.getContextPath() + "</h1>");
            out.println("Well done you've made it!");
            out.println("<p>" + request.getMethod() + "</p>");
            ul.setfName(request.getParameter("fName"));
            ul.setlName(request.getParameter("lName"));

            boolean validation = ulService.validateLogin(ul.getfName(),ul.getlName());
            // redirect the request to a secure page!!!!!!!!
            // if(validateLogin) sendRedirect("secure.jsp");
            if (validation) {
                // 2nd /login, method = POST (1st /login is the method = GET)
                // correct credentials
                User user = ulService.getByUnUp(ul.getfName(),ul.getlName());
                request.setAttribute("user", user);
                rd = request.getRequestDispatcher("products");
                rd.forward(request, response);
            } else {
                // 2nd /login, method = POST (1st /login is the method = GET)
                // wrong credentials SOOOOOOOOO
                
                // CREATE A NEW REQUEST with EMPTY data and REDIRECT to / login method = GET
                // this is the 3rd /login (GET)
                response.sendRedirect("login"); // NEW REQUEST "login" <---- /login GET
            }

//            out.println("<p>Username = " + ul.getUsername() + "</p>");
//            out.println("<p>Password = " + ul.getPassword() + "</p>");
            out.println("<p>Validation = " + validation + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
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
