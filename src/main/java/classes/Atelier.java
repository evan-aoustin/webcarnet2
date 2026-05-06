/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author Aoustin
 */
public class Atelier {
    private ArrayList<Vehicule> lesVehicules = new ArrayList<Vehicule>();
    private ArrayList<EntretienType> lesTypesExistants = new ArrayList<EntretienType>();

    public Atelier() {

    }
//    
//   
//    public boolean necessiteEntretien(Vehicule v) {
//        
//        int nbEntretiens = v.getNbEntretiens();
//        if(nbEntretiens>0) {
//            Entretien dernierEntretien = v.getDernierEntretien();
//            int nbKmEntretien = dernierEntretien.getnbKmCompteur();
//            int nbKmParcouru = v.getNbKmActuel() - nbKmEntretien;
//            for (EntretienType unType : lesTypesExistants){
//                int KmMin = unType.getNbKm() - unType.getNbKmTolere();
//                int KmMax = unType.getNbKm() + unType.getNbKmTolere();
//                
//                if (nbKmParcouru >= KmMin && nbKmParcouru <= KmMax){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//    
//    public ArrayList<Vehicule> vehiculesAEntretenir() throws SQLException, NamingException {
//        
//        VehiculeCtrl vCtrl = new VehiculeCtrl();
//        
//        ArrayList<Vehicule> lesVaE = new ArrayList<Vehicule>();
//        for (Vehicule v : vCtrl.getAllVehiculesCtrl()){
//            if (necessiteEntretien(v)){
//                lesVaE.add(v);
//            }
//        }
//        return lesVaE;
//    }
//    
//    public void affVehiculesAEntretenir() throws SQLException, NamingException {
////        ArrayList<Vehicule> lesVaE = new ArrayList<Vehicule>();
//    
//        for (Vehicule v : vehiculesAEntretenir()){
//            
//                System.out.println(v.toString());
//            }
//    } 
}
