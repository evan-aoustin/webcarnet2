/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.time.LocalDate;

/**
 *
 * @author Aoustin
 */
public class Entretien {
    private int idEntretien;
    private LocalDate date;
    private String commentaire;
    private EntretienType type;
    private Vehicule vehicule;
    private int nbKmCompteur;
    
    public Entretien(int idEntretien, LocalDate date, String commentaire, EntretienType type, Vehicule vehicule, int km) {
        this.idEntretien = idEntretien;
        this.date = date;
        this.commentaire = commentaire;
        this.type = type;
        this.vehicule = vehicule;
        this.nbKmCompteur=km;
    }
    public int getnbKmCompteur(){
        return nbKmCompteur;
    }

    public int getIdEntretien() {
        return idEntretien;
    }

    public void setIdEntretien(int idEntretien) {
        this.idEntretien = idEntretien;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public EntretienType getType() {
        return type;
    }

    public void setType(EntretienType type) {
        this.type = type;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public int getNbKmCompteur() {
        return nbKmCompteur;
    }

    public void setNbKmCompteur(int nbKmCompteur) {
        this.nbKmCompteur = nbKmCompteur;
    }

    @Override
    public String toString() {
        return "Entretien{" + "date=" + date + ", commentaire=" + commentaire + ", type=" + type + '}';
    }
   
}
