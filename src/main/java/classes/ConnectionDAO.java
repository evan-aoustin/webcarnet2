/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;


import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Corinne
 */
public final class ConnectionDAO {
    // private static InitialContext initialcontext;     --   Supprimé, car n’est utilisée que par une seule méthode (variable temporaire) : ce n’est pas un attribut légitime de la classe
    private static DataSource datasource;  
   
    private ConnectionDAO() { 
        // Éviter qu’on puisse l’instancier.
    }
    
    public static Connection getConnection() throws NamingException, SQLException{
        if (datasource == null) { // Éviter de récupérer systématiquement une information statique
            synchronized(ConnectionDAO.class) { // Éviter la ré-entrance (appels HTTP multiples) --> thread-safe
                // Récupére le contexte JNDI
                InitialContext initialcontext = new InitialContext();
                // Recherche la ressource DataSource configurée dans context.xml
                datasource = (DataSource) initialcontext.lookup("java:/comp/env/jdbc/SD2"); 
            }
        }
        // Effectue puis retourne la connexion à la base de données
        System.out.println("datasource dans connexion " + datasource.toString());
        return datasource.getConnection();   
    } 
    
//  Inutilisé et en plus dangereux, car ne ferme pas la connexion
    //    public static Statement getStatement() throws SQLException, NamingException{
    //        return (Statement) getConnection().createStatement();
    //    } 

}

