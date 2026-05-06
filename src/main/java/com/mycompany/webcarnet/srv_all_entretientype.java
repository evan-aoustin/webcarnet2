/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.webcarnet;

import classes.EntretienDAO;
import classes.EntretienType;
import classes.EntretienTypeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author Aoustin
 */
@WebServlet(name = "srv_all_entretientype", urlPatterns = {"/srv_all_entretientype"})
public class srv_all_entretientype extends HttpServlet {

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
        
        try {
      
            ArrayList<EntretienType> allEntretienTypes;
            EntretienTypeDAO etdao = new EntretienTypeDAO();

            allEntretienTypes = etdao.getAll();
            
            
            request.setAttribute("allEntretienTypes", allEntretienTypes);
            request.getRequestDispatcher("/WEB-INF/vues/all_entretientype.jsp").forward(request, response);
            
        } catch (SQLException | NamingException e) {
            try (PrintWriter out = response.getWriter()) {
                out.println(e);
            }
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
        
        try {
            
            EntretienTypeDAO etdao = new EntretienTypeDAO();

            boolean delete = Boolean.parseBoolean(request.getParameter("delete")); 

            if (delete) {
                int code = Integer.parseInt(request.getParameter("code")); 
                etdao.delete(code);
            }

            response.sendRedirect("srv_all_entretientype");

        } catch (SQLException | NamingException e) {
            try (PrintWriter out = response.getWriter()) {
                out.println(e);
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
