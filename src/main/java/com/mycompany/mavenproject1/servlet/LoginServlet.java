package com.mycompany.mavenproject1.servlet;

import com.mycompany.mavenproject1.Dao.UserDao;
import com.mycompany.mavenproject1.FactoryProvider;
import com.mycompany.mavenproject1.entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sun.font.FontStrikeDesc;


public class LoginServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
             String email= request.getParameter("email");
            // System.out.println(email);
              String pass= request.getParameter("password");
             // System.out.println(pass);
            UserDao dao= new UserDao(FactoryProvider.getFactory());
                  User u=  dao.getUserByEmailPassword(email, pass);
                    System.out.println(u);
                    HttpSession hs = request.getSession();
                            
                     if (u==null) {
               // out.println("<h1>Invalid details!!</h1>");
               hs.setAttribute("message", "Invalid details!! Try with another");
               response.sendRedirect("login.jsp");
               return;
            }else{
                     out.println("<h1>Welcome "+u.getUsername()+"</h1>");
                     
                     hs.setAttribute("current-user", u);
                     
                         if (u.getUserType().equalsIgnoreCase("admin")) {
                             response.sendRedirect("admin.jsp");
                         }else if(u.getUserType().equalsIgnoreCase("normal")){
                         response.sendRedirect("normal.jsp");
                         }
                         else{
                         out.println("We have not identified user type");
                         }
                     
                     
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
