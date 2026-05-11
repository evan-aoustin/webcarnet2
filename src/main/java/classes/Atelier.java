/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.naming.NamingException;

/**
 *
 * @author Aoustin
 */
public class Atelier {
    private ArrayList<Vehicule> lesVehicules = new ArrayList<>();
    private ArrayList<EntretienType> lesTypesExistants = new ArrayList<>();

    public Atelier() {
    }

    public void charger() throws SQLException, NamingException {
        VehiculeDAO vdao = new VehiculeDAO();
        EntretienTypeDAO etdao = new EntretienTypeDAO();
        EntretienDAO edao = new EntretienDAO();

        lesVehicules = vdao.getAll();
        lesTypesExistants = etdao.getAll();

        for (Vehicule v : lesVehicules) {
            ArrayList<Entretien> entretiens = edao.getByVehicule(v.getNumImma());
            v.setMesEntretiens(entretiens);
        }
    }

    // retourne le km du dernier entretien de ce type pour ce vehicule, ou 0 si aucun
    private int getDernierKmPourType(Vehicule v, EntretienType type) {
        int dernierKm = 0;
        for (Entretien e : v.getMesEntretiens()) {
            if (e.getType().getCode() == type.getCode()) {
                if (e.getNbKmCompteur() > dernierKm) {
                    dernierKm = e.getNbKmCompteur();
                }
            }
        }
        return dernierKm;
    }

    public boolean necessiteEntretien(Vehicule v) {
        for (EntretienType unType : lesTypesExistants) {
            int dernierKm = getDernierKmPourType(v, unType);
            int nbKmAComparer = v.getNbKmActuel() - dernierKm;
            int KmMin = unType.getNbKm() - unType.getNbKmTolere();
            int KmMax = unType.getNbKm() + unType.getNbKmTolere();
            if (nbKmAComparer >= KmMin && nbKmAComparer <= KmMax) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<EntretienType> getTypesNecessaires(Vehicule v) {
        ArrayList<EntretienType> types = new ArrayList<>();

        for (EntretienType unType : lesTypesExistants) {
            int dernierKm = getDernierKmPourType(v, unType);
            int nbKmAComparer = v.getNbKmActuel() - dernierKm;
            int KmMin = unType.getNbKm() - unType.getNbKmTolere();
            int KmMax = unType.getNbKm() + unType.getNbKmTolere();
            if (nbKmAComparer >= KmMin && nbKmAComparer <= KmMax) {
                types.add(unType);
            }
        }
        return types;
    }

    public ArrayList<Vehicule> vehiculesAEntretenir() {
        ArrayList<Vehicule> lesVaE = new ArrayList<>();
        for (Vehicule v : lesVehicules) {
            if (necessiteEntretien(v)) {
                lesVaE.add(v);
            }
        }
        return lesVaE;
    }

    // retourne une map : chaque vehicule a entretenir -> liste des types necessaires
    public LinkedHashMap<Vehicule, ArrayList<EntretienType>> vehiculesAvecTypesNecessaires() {
        LinkedHashMap<Vehicule, ArrayList<EntretienType>> result = new LinkedHashMap<>();
        for (Vehicule v : lesVehicules) {
            ArrayList<EntretienType> types = getTypesNecessaires(v);
            if (!types.isEmpty()) {
                result.put(v, types);
            }
        }
        return result;
    }
}
