/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.webcarnet;

import classes.UserDAO;
import java.io.IOException;
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
@WebServlet(name = "srv_form_register", urlPatterns = {"/srv_form_register"})
public class srv_form_register extends HttpServlet {

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
        request.getRequestDispatcher("/WEB-INF/vues/form_register.jsp").forward(request, response);
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

        if (udao.getByMail(mail) != null) {
            request.setAttribute("registerStatus", 1);
            request.setAttribute("registerMessage", "Un compte avec ce mail existe déjà");
            request.getRequestDispatcher("/WEB-INF/vues/form_register.jsp").forward(request, response);
            return;
        }
        
        String hashMdp = BCrypt.hashpw(mdp, BCrypt.gensalt(12));
        boolean created = udao.createUser(mail, hashMdp);
        
        if (created) {
            HttpSession session = request.getSession(true);
            session.setAttribute("registerSuccessMsg", "Compte créé avec succès, vous pouvez vous connecter");
            response.sendRedirect(request.getContextPath() + "/srv_form_login");
        } else {
            request.setAttribute("registerStatus", 1);
            request.setAttribute("registerMessage", "Erreur lors de la création du compte, veuillez réessayer");
            request.getRequestDispatcher("/WEB-INF/vues/form_register.jsp").forward(request, response);
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
