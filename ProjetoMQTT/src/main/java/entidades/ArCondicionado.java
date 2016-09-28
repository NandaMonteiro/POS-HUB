/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author nanda
 */
public class ArCondicionado {
    
    private int temperatura;

    public ArCondicionado() {
    }

    public ArCondicionado(int temperatura) {
        this.temperatura = temperatura;
    }


    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return "ArCondicionado{" +" temperatura= " + temperatura + '}';
    }
    
    
    
}
