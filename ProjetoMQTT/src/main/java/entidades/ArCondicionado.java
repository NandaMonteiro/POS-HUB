/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.ejb.Singleton;
import javax.ws.rs.Path;

/**
 *
 * @author nanda
 */

public class ArCondicionado implements Serializable{
    
    private int temperatura;
    private static ArCondicionado arCondicionado;
    private boolean ligado;

    private ArCondicionado() {
    }
    
    public static ArCondicionado getInstacia(){
        if(arCondicionado == null){
            arCondicionado = new ArCondicionado();
        }
        return arCondicionado;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    @Override
    public String toString() {
        return "ArCondicionado{" + "temperatura=" + temperatura + ", ligado=" + ligado + '}';
    }
 
    
}
