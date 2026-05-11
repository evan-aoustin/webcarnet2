/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Aoustin
 */
public class EntretienType {
    private int code;
    private String libelle;
    private int nbKm;
    private int nbKmTolere;

    public EntretienType(int code, String libelle, int nbKm, int nbKmTolere){
        this.code= code;
        this.libelle= libelle;
        this.nbKm= nbKm;
        this.nbKmTolere= nbKmTolere;
    }

    public EntretienType(int code, int nbKm, int nbKmTolere){
        this.code= code;
        this.libelle= "";
        this.nbKm= nbKm;
        this.nbKmTolere= nbKmTolere;
    }

    public EntretienType(int nbKm, int nbKmTolere){
        this.libelle= "";
        this.nbKm= nbKm;
        this.nbKmTolere= nbKmTolere;
    }
        
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getNbKm(){
        return nbKm;
    }
    
    public int getNbKmTolere(){
        return nbKmTolere;
    }
 
    public String toString(){
        return "Code" + code + " - " + libelle + ", Intervalle :" + nbKm + "km, Tolérance: + -" + nbKmTolere + "km";
    }
}
