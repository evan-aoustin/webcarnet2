package com.mycompany.webcarnet;

import classes.Entretien;
import classes.EntretienDAO;
import classes.EntretienType;
import classes.EntretienTypeDAO;
import classes.Vehicule;
import classes.VehiculeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "srv_vehicule", urlPatterns = {"/srv_vehicule"})
public class srv_vehicule extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String immat = request.getParameter("immat");

            VehiculeDAO vdao = new VehiculeDAO();
            EntretienDAO edao = new EntretienDAO();
            EntretienTypeDAO etdao = new EntretienTypeDAO();

            Vehicule vehicule = vdao.get(immat);
            ArrayList<Entretien> mesEntretiens = edao.getByVehicule(immat);
            vehicule.setMesEntretiens(mesEntretiens);

            ArrayList<EntretienType> tousLesTypes = etdao.getAll();
            ArrayList<EntretienType> typesNecessaires = new ArrayList<>();

            for (EntretienType unType : tousLesTypes) {
                // km depuis le dernier entretien de CE type specifiquement
                int dernierKm = 0;
                for (Entretien e : mesEntretiens) {
                    if (e.getType().getCode() == unType.getCode() && e.getNbKmCompteur() > dernierKm) {
                        dernierKm = e.getNbKmCompteur();
                    }
                }
                int nbKmAComparer = vehicule.getNbKmActuel() - dernierKm;
                int kmMin = unType.getNbKm() - unType.getNbKmTolere();
                int kmMax = unType.getNbKm() + unType.getNbKmTolere();
                if (nbKmAComparer >= kmMin && nbKmAComparer <= kmMax) {
                    typesNecessaires.add(unType);
                }
            }

            request.setAttribute("vehicule", vehicule);
            request.setAttribute("mesEntretiens", mesEntretiens);
            request.setAttribute("typesNecessaires", typesNecessaires);
            request.getRequestDispatcher("/WEB-INF/vues/vehicule.jsp").forward(request, response);

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
