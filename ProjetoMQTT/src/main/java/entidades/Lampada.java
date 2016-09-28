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
public class Lampada {
    
    private boolean ligada;

    public Lampada() {
    }

    public Lampada(boolean ligada) {
        this.ligada = ligada;
    }

    public boolean isLigada() {
        return ligada;
    }

    public void setLigada(boolean ligada) {
        this.ligada = ligada;
    }

    @Override
    public String toString() {
        return "Lampada{" + "ligada=" + ligada + '}';
    }
    
    
    
}
