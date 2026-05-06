/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.naming.NamingException;

/**
 *
 * @author Aoustin
 */
public class EntretienDAO {
    Statement stmt;
    ResultSet rs;
     
    public EntretienDAO() throws SQLException, NamingException {

    } 
    
    public ArrayList<Entretien> getAll() { 
        String query = "SELECT * FROM Entretien;";
        ArrayList<Entretien> entretiens = new ArrayList<>();


        try (Connection conn = ConnectionDAO.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            VehiculeDAO vdao = new VehiculeDAO();
            EntretienTypeDAO etdao = new EntretienTypeDAO();

            while (rs.next()) {
                EntretienType entretienType = etdao.get(rs.getInt("codeEntretienType"));
                Vehicule vehicule = vdao.get(rs.getString("numImma"));
                LocalDate ldate = rs.getDate("dateEntretien").toLocalDate();

                Entretien unE = new Entretien(
                    rs.getInt("idEntretien"),
                    ldate,
                    rs.getString("commentaire"),
                    entretienType,
                    vehicule,
                    rs.getInt("nbKmCompteur")
                );

                entretiens.add(unE);
            }

            return entretiens;

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
            return null;
        }
    }

    
    
     public void delete(int id) {        
        String request = "DELETE FROM Entretien WHERE idEntretien = ?;";
        
        try {
            try (Connection conn = ConnectionDAO.getConnection(); 
                PreparedStatement pstmt = conn.prepareStatement(request);) {
                
                pstmt.setInt(1, id);

                pstmt.executeUpdate();
            }

        } catch (SQLException | NamingException e) {

        }
    }
     
     
    public void add(String dateEntretien, int nbKmCompteur, String commentaire, int entretienTypeID, String vehiculeImmat) {
       String request = "INSERT INTO Entretien (dateEntretien, nbKmCompteur, commentaire, codeEntretienType, numImma) VALUE (?,?,?,?,?);";

       try {
           try (Connection conn = ConnectionDAO.getConnection(); 
               PreparedStatement pstmt = conn.prepareStatement(request);) {

               pstmt.setString(1, dateEntretien);
               pstmt.setInt(2, nbKmCompteur);
               pstmt.setString(3, commentaire);
               pstmt.setInt(4, entretienTypeID);
               pstmt.setString(5, vehiculeImmat);

               pstmt.executeUpdate();
           }

       } catch (SQLException | NamingException e) {

       }
    }
     
  

}
