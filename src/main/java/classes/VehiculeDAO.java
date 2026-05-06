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
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author Aoustin
 */
public class VehiculeDAO {
    Statement stmt;
    ResultSet rs;
    
    public VehiculeDAO() throws SQLException, NamingException {

    } 
    
    public ArrayList<Vehicule> getAll() { 
        String query = "SELECT * FROM Vehicule;";

        ArrayList<Vehicule> vehicules = new ArrayList<>();

        try (Connection conn = ConnectionDAO.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Vehicule unV = new Vehicule(rs.getString("numImma"), rs.getInt("nbKmActuel"));
                vehicules.add(unV);
            }

            return vehicules;

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public Vehicule get(String immat) throws SQLException, NamingException {
        
        String request = "SELECT * FROM Vehicule WHERE numImma = ?";
        
        try (Connection conn = ConnectionDAO.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(request)) {

            pstmt.setString(1, immat);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Vehicule(rs.getString("numImma"), rs.getInt("nbKmActuel"));
                } else {
                    return null; 
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public void add(Vehicule v) {
        String request = "INSERT INTO Vehicule (numImma, nbKmActuel) VALUE (?, ?);";
        
        try {
            try (Connection conn = ConnectionDAO.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(request);) {
                pstmt.setString(1, v.getNumImma());
                pstmt.setInt(2, v.getNbKmActuel());
                
                pstmt.executeUpdate();
            }

        } catch (SQLException | NamingException e) {

        }
    }
    
    public void add(String numImma, int nbKmActuel) {
        String request = "INSERT INTO Vehicule (numImma, nbKmActuel) VALUE (?, ?);";
        
        try {
            try (Connection conn = ConnectionDAO.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(request);) {
                pstmt.setString(1, numImma);
                pstmt.setInt(2, nbKmActuel);
                
                pstmt.executeUpdate();
            }

        } catch (SQLException | NamingException e) {

        }
    }
    
    public void delete(String numImma) {        
        String request = "DELETE FROM Vehicule WHERE numImma = ?;";
        
        try {
            try (Connection conn = ConnectionDAO.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(request);) {
                pstmt.setString(1, numImma);
                
                pstmt.executeUpdate();
            }

        } catch (SQLException | NamingException e) {

        }
    }
    
    public void update(int newNbKmActuel, String numImma) {
        String request = "UPDATE Vehicule SET nbKmActuel = ? WHERE numImma = ?;";
        
        try {
            try (Connection conn = ConnectionDAO.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(request);) {
                pstmt.setInt(1, newNbKmActuel);
                pstmt.setString(2, numImma);
                
                pstmt.executeUpdate();
            }

        } catch (SQLException | NamingException e) {

        }
    }
        
//    public ResultSet getmesEntretiens(int immat) throws SQLException, NamingException { 
//        String request = "SELECT * FROM Entretien WHERE numImma = ?;";
//        Connection conn = ConnectionDAO.getConnection();
//
//        try {
//            PreparedStatement pstmt = conn.prepareStatement(request, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//            pstmt.setInt(1, immat);
//            
//            return pstmt.executeQuery();
//
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    
//    public ResultSet getNbEntretiens(int immat) throws SQLException, NamingException { 
//        String request = "SELECT COUNT(idEntretien) FROM Entretien WHERE numImma = ?;";
//        Connection conn = ConnectionDAO.getConnection();
//
//        try {
//            PreparedStatement pstmt = conn.prepareStatement(request, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//            pstmt.setInt(1, immat);
//            
//            return pstmt.executeQuery();
//
//        } catch (Exception e) {
//            return null;
//        }
//    }
//    
//    public ResultSet getDernierEntretien(String immat) throws SQLException, NamingException { 
//        String request = "SELECT * FROM Entretien WHERE numImma = ? ORDER BY dateEntretien DESC LIMIT 1;";
//        Connection conn = ConnectionDAO.getConnection();
//
//        try {
//            PreparedStatement pstmt = conn.prepareStatement(request, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//            pstmt.setString(1, immat);
//            
//            return pstmt.executeQuery();
//
//        } catch (Exception e) {
//            return null;
//        }
//    }
}
