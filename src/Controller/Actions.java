/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. */



package Controller;

import Model.Producto;
import Model.Querys;
import View.Interface;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author junior
 */
public class Actions implements ActionListener {

    private Interface view;
    private Querys query;
    private Producto prod;

    public Actions(Interface view, Querys query, Producto prod) {
        this.query = query;
        this.view = view;
        this.prod = prod;
        this.view.add.addActionListener(this);
        this.view.search.addActionListener(this);
        this.view.update.addActionListener(this);
        this.view.delete.addActionListener(this);
        this.view.clean.addActionListener(this);

    }

    public void start() {
        this.view.id.setVisible(false);
        this.view.setTitle("CRUD - JUNIOR RUMICHE");
        this.view.update.setEnabled(false);
        this.view.delete.setEnabled(false);
        this.view.setVisible(true);
    }

    /*++++++++++++++++++++++++++++++++++
              ACTIONS
    ***********************************/
    public void cleanData() {
        System.out.println("limpiando");
        this.view.id.setText("");
        this.view.code.setText("");
        this.view.name.setText("");
        this.view.price.setText("");
        this.view.quantity.setText("");
    }

    public void actionSearch() {
        
        
        if (query.read(this.prod)) {
            this.view.update.setEnabled(true);
            this.view.delete.setEnabled(true);
            this.view.id.setText(String.valueOf(this.prod.getId()));
            this.view.name.setText(this.prod.getNombre());
            this.view.code.setText(this.prod.getCodigo());
            this.view.price.setText(String.valueOf(this.prod.getPrecio()));
            this.view.quantity.setText(String.valueOf(this.prod.getCantidad()));
            
        }
    }

    public void actionInsert() {
        this.prod.setCantidad(Integer.parseInt(this.view.quantity.getText()));
        this.prod.setPrecio(Double.parseDouble(this.view.price.getText()));
        if (query.create(this.prod)) {
            JOptionPane.showMessageDialog(null, "Agregado con exitó");
            this.cleanData();

        }

    }

    public void actionUpdate() {
        this.prod.setCantidad(Integer.parseInt(this.view.quantity.getText()));
        this.prod.setPrecio(Double.parseDouble(this.view.price.getText()));
        this.prod.setId(Integer.parseInt(this.view.id.getText()));
        if (query.update(this.prod)) {
            JOptionPane.showMessageDialog(null, "Registro actualizado con exitó");
            this.cleanData();
        } else {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
        }
    }
    
    public void actionDelete(){
        
        this.prod.setCodigo(this.view.code.getText());
        if (query.delete(this.prod)) {
            JOptionPane.showMessageDialog(null, "Registro eliminado con exitó");
            this.cleanData();
        } else {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
        }
    }
    
    public boolean verifyLen(){
        if (this.view.code.getText().length() > 0){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Complete el campo codigo");
            return false;
        }
    }
    
    public boolean verifyAllLen(){
        if(this.view.name.getText().length() > 0 && this.view.price.getText().length() > 0 && this.view.code.getText().length() > 0 && this.verifyLen()){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Complete los campos");
            return false;
        }
    }


/*++++++++++++++++++++++++++++++++++
              FIN ACTIONS
***********************************/
    
    
   
    @Override
    public void actionPerformed(ActionEvent e) {
        this.prod.setCodigo(this.view.code.getText());
        this.prod.setNombre(this.view.name.getText());
        if (e.getSource() == this.view.add && this.verifyAllLen()) {
            this.view.update.setEnabled(false);
            this.view.delete.setEnabled(false);
            this.actionInsert();

        } else if (e.getSource() == this.view.search && this.verifyLen()) {          
            this.actionSearch();

        } else if (e.getSource() == this.view.update && verifyAllLen()) {
            this.view.update.setEnabled(false);
            this.view.delete.setEnabled(false);
            this.actionUpdate();
            
            
        }else if (e.getSource() == this.view.delete && verifyLen()) {
            this.view.update.setEnabled(false);
            this.view.delete.setEnabled(false);
            this.actionDelete();
            
        }else if(e.getSource() == this.view.clean){
            this.cleanData();
        }

    }
}

