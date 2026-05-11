/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.webcarnet;


import classes.EntretienType;
import classes.EntretienTypeDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

/**
 *
 * @author Aoustin
 */
@WebServlet(name = "srv_form_entretientype", urlPatterns = {"/srv_form_entretientype"})
public class srv_form_entretientype extends HttpServlet {

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
        
        String action = request.getParameter("action");

        if ("update".equals(action)) {
            int code = Integer.parseInt(request.getParameter("code"));
            String libelle = request.getParameter("libelle");
            int nbKm = Integer.parseInt(request.getParameter("nbKm"));
            int nbKmTolere = Integer.parseInt(request.getParameter("nbKmTolere")); 

            request.setAttribute("code", code);
            request.setAttribute("libelle", libelle);
            request.setAttribute("nbKm", nbKm);
            request.setAttribute("nbKmTolere", nbKmTolere);
        }

        request.getRequestDispatcher("/WEB-INF/vues/form_entretientype.jsp").forward(request, response);

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
            String codeParam = request.getParameter("code");
            String libelle = request.getParameter("libelle");
            if (libelle == null) libelle = "";
            int km = Integer.parseInt(request.getParameter("km"));
            int kmTolere = Integer.parseInt(request.getParameter("kmTolere"));

            EntretienTypeDAO etdao = new EntretienTypeDAO();

            if (codeParam == null || codeParam.isEmpty()) {
                etdao.add(libelle, km, kmTolere);
            } else {
                int code = Integer.parseInt(codeParam);
                etdao.update(libelle, km, kmTolere, code);
            }

            response.sendRedirect("/webcarnet/srv_all_entretientype");
            
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
            throw new ServletException(e);
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
