/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mqtt;

import entidades.ArCondicionado;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author nanda
 */
public class ArCondicionadoMqtt implements MqttCallback{

    @Override
    public void connectionLost(Throwable thrwbl) {
        System.out.println("Erro: " + thrwbl.getMessage());}

    @Override
    public void messageArrived(String topic, MqttMessage mm) throws Exception {
        ArCondicionado ar = ArCondicionado.getInstacia();
            if(topic.equals("sensor/ArCondicionado/ligar")){
            ar.setLigado(true);
            }
            else{
            ar.setLigado(false);
            }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
