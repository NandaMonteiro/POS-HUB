/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restfull;

import mqtt.Cliente;
import mqtt.Publicador;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author nanda
 */
public class app {
    public static void main(String[] args) throws MqttException {
        
//        Publicador p = new Publicador();
        Cliente c = new Cliente();
//        String m = "2";
        
        c.subscribe();
//        System.out.println("kkk");
//        p.conectar();
//        System.out.println("kjhkjhkjhjkhk");
//        p.publicar(m);
//        System.out.println("111111");
//        p.desconectar();
    }
    
}
