/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author junior
 */
public class Conexion {
    
    private final String db = "producto";
    private final String url = "jdbc:sqlite:database.sqlite";
    private Connection conexion = null;
    
    
    
       public Connection getConexion(){
        try{
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection(url);
            return conexion;        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    
}
