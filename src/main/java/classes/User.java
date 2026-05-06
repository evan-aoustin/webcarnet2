/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Aoustin
 */
public class User {
    private int id;
    private String mail;
    private String mdp;
    private String role;
    

    public User(String mail, String mdp, String role) {
        this.mail = mail;
        this.mdp = mdp;
        this.role = role;
    }   
    
    public User(int id, String mail, String mdp, String role) {
        this.id = id;
        this.mail = mail;
        this.mdp = mdp;
        this.role = role;
    }   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public boolean isAdmin() {
        return "ADMIN".equals(this.getRole());
    }
    
     
}
