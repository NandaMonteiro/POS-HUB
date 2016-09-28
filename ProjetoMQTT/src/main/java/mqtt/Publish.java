package mqtt;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nanda
 */
public class Publish {
    
    MqttClient sampleClient;
    String topic = "temperatura";
    String content = "23";
    int qos = 2;
    String broker = "tcp://0.0.0.0:1883";
    String clientId = "job";
    
    public MqttClient conectar() {        
       
        MemoryPersistence persistence = new MemoryPersistence();
        
        try {
            
            sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            sampleClient.connect(connOpts);
            
        return sampleClient;
        
        } catch (MqttException ex) {
            Logger.getLogger(Publish.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void desconectar(){
        try {
            
            sampleClient.disconnect();
            
        } catch (MqttException ex) {
            Logger.getLogger(Publish.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
    
    public void publicar(String men) {
        
        try {
            
            MqttMessage message = new MqttMessage(men.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
            
        } catch (MqttException ex) {
            Logger.getLogger(Publish.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
