/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;

/**
 *
 * @author nanda
 */

public class ArCondicionado implements Serializable{
    
    public static final int TEMPERATURA_MINIMA = 16;
    public static final int TEMPERATURA_MAXIMA = 25;
    public static final int TEMPERATURA_INICIAL = TEMPERATURA_MAXIMA;
    
    private int temperatura;
    private static ArCondicionado arCondicionado;
    private boolean ligado;

    private ArCondicionado() {
        this.init();
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

    private void init() {
        this.setTemperatura(TEMPERATURA_INICIAL);
    }
    
}
