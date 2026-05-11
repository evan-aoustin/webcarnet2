/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author Aoustin
 */
public class Vehicule {
    private String numImma;
    private int nbKmActuel;
    private ArrayList<Entretien> mesEntretiens = new ArrayList<>();

    public Vehicule(String numImma, int nbKmActuel) {
        this.numImma = numImma;
        this.nbKmActuel = nbKmActuel;
    }

    public String getNumImma() {
        return numImma;
    }

    public int getNbKmActuel() {
        return nbKmActuel;
    }

    public void setNumImma(String numImma) {
        this.numImma = numImma;
    }

    public void setNbKmActuel(int nbKmActuel) {
        this.nbKmActuel = nbKmActuel;
    }

    public ArrayList<Entretien> getMesEntretiens() {
        return mesEntretiens;
    }

    public void setMesEntretiens(ArrayList<Entretien> mesEntretiens) {
        this.mesEntretiens = mesEntretiens;
    }

    public void ajouteEntretien(Entretien e) {
        mesEntretiens.add(e);
    }

    public int getNbEntretiens() {
        return mesEntretiens.size();
    }

    // retourne l'entretien avec le plus grand km compteur (le dernier physiquement)
    public Entretien getDernierEntretien() {
        if (mesEntretiens.isEmpty()) {
            return null;
        }
        Entretien dernier = mesEntretiens.get(0);
        for (Entretien e : mesEntretiens) {
            if (e.getNbKmCompteur() > dernier.getNbKmCompteur()) {
                dernier = e;
            }
        }
        return dernier;
    }

    @Override
    public String toString() {
        return "Vehicule{" + "numImma=" + numImma + ", nbKmActuel=" + nbKmActuel + '}';
    }
}
