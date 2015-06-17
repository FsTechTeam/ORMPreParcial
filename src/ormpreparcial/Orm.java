/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ormpreparcial;
import Interfaces.*;
import java.util.List;

/**
 *
 * @author Geek
 */
public class Orm extends Sujeto{
    
    List<Observador> observadoresLista;
    private static Orm  instancia =null;
    protected Orm(){
    }
    public static Orm getInstance() {//Aqui se define singleton
        if (instancia==null) {
            instancia= new Orm();
        }
        return instancia;
    }

    @Override
    public void agregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notificar() {
        for (Observador observador : observadoresLista) {
            observador.actualizar();
        }
    }

    @Override
    public void agregarObservador(Observador observador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
