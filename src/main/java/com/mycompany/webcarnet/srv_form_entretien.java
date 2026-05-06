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
@WebServlet(name = "srv_form_entretien", urlPatterns = {"/srv_form_entretien"})
public class srv_form_entretien extends HttpServlet {

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

            ArrayList<Vehicule> allVehicules;
            VehiculeDAO vdao = new VehiculeDAO();

            allVehicules = vdao.getAll();

            String action = request.getParameter("action");

            if ("update".equals(action)) {
                int idEntretien = Integer.parseInt(request.getParameter("idEntretien"));
                String date = request.getParameter("date");
                int nbKmCompteur = Integer.parseInt(request.getParameter("nbKmCompteur"));
                String commentaire = request.getParameter("commentaire");
                String vehiImmat = request.getParameter("vehiImmat");
                int entretientypeCode = Integer.parseInt(request.getParameter("entretientypeCode"));

                request.setAttribute("idEntretien", idEntretien);
                request.setAttribute("date", date);
                request.setAttribute("nbKmCompteur", nbKmCompteur);
                request.setAttribute("commentaire", commentaire);
                request.setAttribute("vehiImmat", vehiImmat);
                request.setAttribute("entretientypeCode", entretientypeCode);
                request.setAttribute("action", "update");
            }
            
            request.setAttribute("allVehicules", allVehicules);
            request.setAttribute("allEntretienTypes", allEntretienTypes);
            request.getRequestDispatcher("/WEB-INF/vues/form_entretien.jsp").forward(request, response);
            
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
            String dateEntretien = request.getParameter("dateEntretien");
            int nbKmCompteur = Integer.parseInt(request.getParameter("nbKmCompteur"));
            String commentaire = request.getParameter("commentaire");
            int entretienTypeID = Integer.parseInt(request.getParameter("entretienTypeID"));
            String vehiculeImmat = request.getParameter("vehiculeImmat");
            String action = request.getParameter("action");

            EntretienDAO edao = new EntretienDAO();
                        
            if ("update".equals(action)) {
                
            } else {
                
            }
            
            edao.add(dateEntretien, nbKmCompteur, commentaire, entretienTypeID, vehiculeImmat);

            response.sendRedirect("/webcarnet/srv_all_entretien");
            
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
