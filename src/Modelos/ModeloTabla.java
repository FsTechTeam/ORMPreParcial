/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import javax.swing.table.AbstractTableModel;
import Interfaces.*;
import Persistence.Persona;
import java.util.List;
import ormpreparcial.Observador;
/**
 *
 * @author Vader33
 */

public class ModeloTabla extends  AbstractTableModel {
    private List<Persona> personas;
    private String columnas[] = {"Nombre", "Apellido", "Edad"};
    @Override
    public int getRowCount() {//Le devuleve a la interfaz grafica cuantos elementos tiene en la lista
        return  personas.size();
    }
    @Override
    public int getColumnCount() {
        return columnas.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {// saca cada uno d elos valores de las columnas
        Persona usr = this.personas.get(rowIndex);
        switch(columnIndex){
            case 0:
                return usr.getNombre();
            case 1:
                return usr.getApellido();
            case 2: 
                return usr.getEdad();
        }
        return null;
    }
    public ModeloTabla(List<Persona> usuarios) {
        this.personas = usuarios;
    }
    @Override
    public String getColumnName(int column) {
        
        
        return null;
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnsIndex){
        
        return true;
    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: 
                personas.get(rowIndex).setNombre((String)aValue);
            case 1: 
                personas.get(rowIndex).setApellido((String)aValue);
            case 2: 
                personas.get(rowIndex).setEdad(Integer.parseInt(aValue.toString()));
        
        }
    }
}
