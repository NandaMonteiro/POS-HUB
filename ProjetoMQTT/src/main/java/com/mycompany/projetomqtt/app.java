/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetomqtt;

import mqtt.Cliente;
import mqtt.Publish;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author nanda
 */
public class app {
    public static void main(String[] args) throws MqttException {
        
        Publish p = new Publish();
        Cliente c = new Cliente();
        String m = "2";
        
                c.subscribe();

        p.conectar();
        p.publicar(m);
        p.desconectar();
    }
    
}
