/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import jakarta.servlet.http.HttpSession;
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
public class UserDAO {
    Statement stmt;
    ResultSet rs;

    public UserDAO() {
        
    }
    
    public ArrayList<User> getAll() {
        String query = "SELECT * FROM `user`;";

        ArrayList<User> users = new ArrayList<>();

        try (Connection conn = ConnectionDAO.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                User u = new User(rs.getInt("id"), rs.getString("mail"), rs.getString("mdp"), rs.getString("role"));
                users.add(u);
            }

            return users;

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public User get(int id) {
        
        String request = "SELECT * FROM `user` WHERE id = ?";
        
        try (Connection conn = ConnectionDAO.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(request)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getInt("id"), rs.getString("mail"), rs.getString("mdp"), rs.getString("role"));
                } else {
                    return null; 
                }
            }

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public User getByMail(String mail) {
        
        String request = "SELECT * FROM `user` WHERE mail = ?";
        
        try (Connection conn = ConnectionDAO.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(request)) {

            pstmt.setString(1, mail);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getInt("id"), rs.getString("mail"), rs.getString("mdp"), rs.getString("role"));
                } else {
                    return null; 
                }
            }

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean createUser(String mail, String mdp) {
        String request = "INSERT INTO `user` (mail, mdp, role) VALUES (?, ?, 'MECANICIEN');";

        try (Connection conn = ConnectionDAO.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(request)) {

            pstmt.setString(1, mail);
            pstmt.setString(2, mdp);
            pstmt.executeUpdate();
            return true;

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
            return false;
        }
    }
    

}
