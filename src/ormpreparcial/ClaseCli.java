/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ormpreparcial;

import Persistence.*;
import controladores.PersonaJpaController;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Interfaces.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Geek
 */
public class ClaseCli extends Sujeto{
    
    
    private static ClaseCli instancia=null;
    public static ClaseCli getInstance() {//Aqui se define singleton
        if (instancia==null) {
            instancia= new ClaseCli();
        }
        return instancia;
    }
    
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ORMPreParcialU");
    EntityManager em = emf.createEntityManager();
    PersonaJpaController controlador = new PersonaJpaController(emf);
    Persona nuevaPersona = new Persona();
    String nombre, apellido;
    int edad;
    
    public void agregar(Persona objeto){
        controlador.create(objeto);
    }

    @Override
    public void agregar() {
        try {
            System.out.println("Ingrese el nombre de la nueva persona:");
            nombre = in.readLine();
            System.out.println("Ingrese el Apellido de la nueva persona:");
            apellido = in.readLine();
            System.out.println("Ingrese la edad de la nueva persona:");
            edad = Integer.parseInt(in.readLine());
            nuevaPersona.setNombre(nombre);
            nuevaPersona.setApellido(apellido);
            nuevaPersona.setEdad(edad);
            nuevaPersona.setConectado(true);
            for(Observador i: this.observadoresList)
                i.actualizar();
        } catch (IOException ex) {
            Logger.getLogger(ClaseCli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar() {
        for(Observador i: this.observadoresList)
            i.actualizar();
    }

    @Override
    public void notificar() {
        for(Observador i: this.observadoresList)
            i.actualizar();
    }

    @Override
    public void agregarObservador(Observador observador) {
        this.observadoresList.add(observador);
    }
    
    
}
