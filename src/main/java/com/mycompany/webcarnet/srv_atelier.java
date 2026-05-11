package com.mycompany.webcarnet;

import classes.Atelier;
import classes.EntretienType;
import classes.Vehicule;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.naming.NamingException;

/**
 *
 * @author Aoustin
 */
@WebServlet(name = "srv_atelier", urlPatterns = {"/srv_atelier"})
public class srv_atelier extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Atelier atelier = new Atelier();
            atelier.charger();

            LinkedHashMap<Vehicule, ArrayList<EntretienType>> vehiculesTypesMap = atelier.vehiculesAvecTypesNecessaires();

            request.setAttribute("vehiculesTypesMap", vehiculesTypesMap);
            request.getRequestDispatcher("/WEB-INF/vues/atelier.jsp").forward(request, response);

        } catch (SQLException | NamingException e) {
            try (PrintWriter out = response.getWriter()) {
                out.println(e);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
