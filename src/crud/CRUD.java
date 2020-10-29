/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import Controller.Actions;
import Model.Producto;
import Model.Querys;
import View.Interface;

/**
 *
 * @author junior
 */
public class CRUD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Querys query = new Querys();
        Interface view = new Interface();
        Producto product = new Producto();
        Actions action = new Actions(view, query, product);
        action.start();
    }
    
}
