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
public class Lampada implements Serializable {

    private boolean ligada;
    private static Lampada lampada;

    private Lampada() {
    }

    public static Lampada getIntancia() {
        if (lampada == null) {
            lampada = new Lampada();
        }
        return lampada;

    }

    public boolean isLigada() {
        return ligada;
    }

    public void setLigada(boolean ligada) {
        this.ligada = ligada;
    }

    public boolean isLigado() {
        return ligada;
    }

    public void setLigado(boolean ligado) {
        this.ligada = ligado;
    }

    @Override
    public String toString() {
        return "Lampada{" + "ligada=" + ligada + '}';
    }

}
