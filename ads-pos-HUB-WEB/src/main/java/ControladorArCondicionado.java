
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nanda
 */
@Named
@SessionScoped
public class ControladorArCondicionado implements Serializable{
    
    private Cliente cliente;

    public ControladorArCondicionado() {
        this.cliente = cliente;
    }
    
   
    public void ligado(){
        cliente.ligarAr();
    }
    
    
    
    
    
}
