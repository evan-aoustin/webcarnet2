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
public class EntretienTypeDAO {
    Statement stmt;
    ResultSet rs;
     
    public EntretienTypeDAO() throws SQLException, NamingException {

    } 
    
    public ArrayList<EntretienType> getAll() { 
        String query = "SELECT * FROM EntretienType;";

        ArrayList<EntretienType> entretiens = new ArrayList<>();

        try (Connection conn = ConnectionDAO.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                EntretienType unE = new EntretienType(
                    rs.getInt("code"),
                    rs.getString("libelle"),
                    rs.getInt("nbKm"),
                    rs.getInt("nbKmTolere")
                );
                entretiens.add(unE);
            }

            return entretiens;

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public EntretienType get(int code) throws SQLException, NamingException {
        String request = "SELECT * FROM EntretienType WHERE code = ?";

        try (Connection conn = ConnectionDAO.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(request)) {

            pstmt.setInt(1, code);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new EntretienType(
                        rs.getInt("code"),
                        rs.getString("libelle"),
                        rs.getInt("nbKm"),
                        rs.getInt("nbKmTolere")
                    );
                } else {
                    return null;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); 
            return null;
        }
    }

    

    public void add(EntretienType et) {
        String request = "INSERT INTO EntretienType (nbKm, nbKmTolere) VALUE (?, ?);";
        
        try {
            try (Connection conn = ConnectionDAO.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(request);) {
                
                pstmt.setInt(1, et.getNbKm());
                pstmt.setInt(2, et.getNbKmTolere());
                
                pstmt.executeUpdate();
            }

        } catch (SQLException | NamingException e) {

        }
    }
    
    public void add(int nbKm, int nbKmTolere) {
        String request = "INSERT INTO EntretienType (nbKm, nbKmTolere) VALUES (?, ?)";
        
        try {
            try (Connection conn = ConnectionDAO.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(request);) {
                
                pstmt.setInt(1, nbKm);
                pstmt.setInt(2, nbKmTolere);
                
                pstmt.executeUpdate();
            }

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }

    public void add(String libelle, int nbKm, int nbKmTolere) {
        String request = "INSERT INTO EntretienType (libelle, nbKm, nbKmTolere) VALUES (?, ?, ?)";
        
        try {
            try (Connection conn = ConnectionDAO.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(request);) {
                
                pstmt.setString(1, libelle);
                pstmt.setInt(2, nbKm);
                pstmt.setInt(3, nbKmTolere);
                
                pstmt.executeUpdate();
            }

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(int code) {        
        String request = "DELETE FROM EntretienType WHERE code = ?;";
        
        try {
            try (Connection conn = ConnectionDAO.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(request);) {
                pstmt.setInt(1, code);
                
                pstmt.executeUpdate();
            }

        } catch (SQLException | NamingException e) {

        }
    }
    
    public void update(int newKm, int newKmTolere, int code) {
        String request = "update EntretienType set nbKm = ?, nbKmTolere = ?  WHERE code = ?;";
        
        try {
            try (Connection conn = ConnectionDAO.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(request);) {
                pstmt.setInt(1, newKm);
                pstmt.setInt(2, newKmTolere);
                pstmt.setInt(3, code);
                
                pstmt.executeUpdate();
            }

        } catch (SQLException | NamingException e) {

        }
    }

    public void update(String libelle, int newKm, int newKmTolere, int code) {
        String request = "UPDATE EntretienType SET libelle = ?, nbKm = ?, nbKmTolere = ? WHERE code = ?;";
        
        try {
            try (Connection conn = ConnectionDAO.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(request);) {
                pstmt.setString(1, libelle);
                pstmt.setInt(2, newKm);
                pstmt.setInt(3, newKmTolere);
                pstmt.setInt(4, code);
                
                pstmt.executeUpdate();
            }

        } catch (SQLException | NamingException e) {

        }
    }
}
