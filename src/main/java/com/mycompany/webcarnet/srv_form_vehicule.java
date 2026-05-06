/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.webcarnet;

import classes.Entretien;
import classes.EntretienDAO;
import classes.EntretienType;
import classes.EntretienTypeDAO;
import classes.Vehicule;
import classes.VehiculeDAO;
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
@WebServlet(name = "srv_form_vehicule", urlPatterns = {"/srv_form_vehicule"})
public class srv_form_vehicule extends HttpServlet {

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
            String immat = request.getParameter("immat");
            String km = request.getParameter("km");
            
            request.setAttribute("immat", immat);
            request.setAttribute("km", km);
            request.setAttribute("action", "update");
        }
        
        request.getRequestDispatcher("/WEB-INF/vues/form_vehicule.jsp").forward(request, response);
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
            String immat = request.getParameter("immat");
            int km = Integer.parseInt(request.getParameter("km"));
            
            VehiculeDAO vdao = new VehiculeDAO();
            
            if (vdao.get(immat) == null) { // Ci le vehicule n'existe pas le cree, sinon faire un update
                vdao.add(immat, km);
            } else {
                vdao.update(km, immat);
            }

            response.sendRedirect("/webcarnet/admin/srv_all_vehicule");
            
        } catch (SQLException | NamingException e) {

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
