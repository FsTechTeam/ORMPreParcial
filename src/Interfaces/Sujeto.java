/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.ArrayList;
import java.util.List;
import ormpreparcial.Observador;

/**
 *
 * @author Geek
 */
public interface Sujeto {
    public List<Observador> observadoresList = new ArrayList<>();
    public abstract void agregar();
    public abstract void eliminar();
    public  abstract void notificar();
    public abstract  void agregarObservador(Observador observador);
    
}
