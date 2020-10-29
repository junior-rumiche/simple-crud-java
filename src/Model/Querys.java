/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author junior
 */
public class Querys extends Conexion{
    
    //*******************************************************
    //*******************************************************
    public boolean create(Producto product){
        Connection conexion = null;
        String query = "INSERT INTO producto(codigo, nombre, precio, cantidad) VALUES(?,?,?,?)";
        try{
            conexion = this.getConexion();
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setString(1, product.getCodigo());
            sql.setString(2, product.getNombre());
            sql.setDouble(3, product.getPrecio());
            sql.setInt(4, product.getCantidad());
            sql.execute();  
            return true;
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null, e);
            
        }finally{
            try{
                conexion.close();
            }catch(SQLException e){
                System.out.println(e);
            }
        }
        return false;
        
        
        
    }
    //*******************************************************
    //*******************************************************
    
    
    
    //*************************************************
    //+++++++++++++++++++++++++++++++++++++++++++*****
    public boolean read(Producto product){
        Connection conexion = null;
        String query = "SELECT * FROM producto where codigo=?";
        try{
            conexion = this.getConexion();
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setString(1, product.getCodigo());
             ResultSet result = sql.executeQuery();  
             if (result.next()){
                 product.setId(result.getInt("id"));
                 product.setCodigo(result.getString("codigo"));
                 product.setNombre(result.getString("nombre"));
                 product.setPrecio(result.getDouble("precio"));
                 product.setCantidad(result.getInt("cantidad"));
                 return true;
                 
                 
             }else{
                 JOptionPane.showMessageDialog(null, "Registro no encontrado");
                 return false;
             }
             
            
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null, e);
            
        }finally{
            try{
                conexion.close();
            }catch(SQLException e){
                System.out.println(e);
            }
        }
        return false;
       
        
        
    }
    //************************************************************
    //***********************************************************
    
    
    //***********************************************************
    //*******************************************************+++*
    public boolean update(Producto product){
        Connection conexion = null;
        String query = "UPDATE producto set codigo=?, nombre=?, precio=?, cantidad=? WHERE id=?";
        try{
            conexion = this.getConexion();
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setString(1, product.getCodigo());
            sql.setString(2, product.getNombre());
            sql.setDouble(3, product.getPrecio());
            sql.setInt(4, product.getCantidad());
            sql.setInt(5, product.getId());
            sql.execute();  
            return true;
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null, e);
            
        }finally{
            try{
                conexion.close();
            }catch(SQLException e){
                System.out.println(e);
            }
        }
        return false;
            
    }
    //***************************************************************
    //***************************************************************
    
    
   //***********************************************************
    //*******************************************************+++*
    public boolean delete(Producto product){
        Connection conexion = null;
        String query = "DELETE FROM producto WHERE codigo=?";
        try{
            conexion = this.getConexion();
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setString(1, product.getCodigo());
            sql.execute();  
            return true;
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null, e);
            
            
        }finally{
            try{
                conexion.close();
            }catch(SQLException e){
                System.out.println(e);
            }
        }        
        return false;
        
        
    }
    //***************************************************************
    //***************************************************************
    
}
