/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Aoustin
 */
public class Vehicule {
    private String numImma;
    private int nbKmActuel;

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



    @Override
    public String toString() {
        return "Vehicule{" + "numImma=" + numImma + ", nbKmActuel=" + nbKmActuel + '}';
    }
}
