/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.webcarnet;

import classes.User;
import classes.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Aoustin
 */
@WebServlet(name = "srv_form_login", urlPatterns = {"/srv_form_login"})
public class srv_form_login extends HttpServlet {

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
        request.getRequestDispatcher("/WEB-INF/vues/form_login.jsp").forward(request, response);
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
        
        String mail = request.getParameter("mail");
        String mdp = request.getParameter("mdp");
        
        UserDAO udao = new UserDAO();

        User user = udao.getByMail(mail);
        
        if (user == null) {
            request.setAttribute("loginStatus", 1);
            request.setAttribute("loginMessage", "Aucun compte avec ce mail, veuillez en crée un");
            request.getRequestDispatcher("/WEB-INF/vues/form_register.jsp").forward(request, response);
        }
        else {
            if (BCrypt.checkpw(mdp, user.getMdp())) {
                
                HttpSession session = request.getSession(true);
                
                session.setAttribute("user",user);
                
                response.sendRedirect("srv_index");
                
            } else {
                request.setAttribute("loginStatus", 1);
                request.setAttribute("loginMessage", "Mot de passe incorrect");
                request.getRequestDispatcher("/WEB-INF/vues/form_login.jsp").forward(request, response);
            }
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
