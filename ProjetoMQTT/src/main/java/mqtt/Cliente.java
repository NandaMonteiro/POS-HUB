/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mqtt;

import java.util.Arrays;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;

/**
 *
 * @author nanda
 */
public class Cliente {
    
    
    public void ligarAr(){
        
    } 
//    MqttClient client;
//    String topic = "sensor/temperatura/#";
//    int qos = 2;
//    String broker = "tcp://192.168.99.100:1883";
//    String clientId = "nanda";
//    
//    public void subscribe(){
//        
//        try {
//            
//            client = new MqttClient(broker, clientId);
//            client.setCallback(new ClienteCall());
//            client.connect();
//            client.subscribe(topic, qos);
//
//        } catch (MqttException me) {
//            me.printStackTrace();
//        }
//    }
//    
//    static class ClienteCall implements MqttCallback {
//
//        @Override
//        public void connectionLost(Throwable thrwbl) {
//            
//            System.out.println("thrwbl = " + thrwbl);
//            
//        }
//
//        @Override
//        public void messageArrived(String string, MqttMessage mm) throws Exception {
//            
//            byte[] bytes = mm.getPayload();
//            System.out.println("str: "+new String(bytes));
//            //lendo o valor numérico
//            //int sampleValue = (int) ((bytes[0] << 8) | (bytes[1] & 0x00FF));            
//            //System.out.println("msg: " + string + "-> " + sampleValue);
//        }
//
//        @Override
//        public void deliveryComplete(IMqttDeliveryToken imdt) {
//
//        }
//    }
}
