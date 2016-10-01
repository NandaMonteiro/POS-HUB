/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mqtt;

import entidades.ArCondicionado;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
/**
 *
 * @author nanda
 */

public class ArCondicionadoMqtt implements MqttCallback {
    
    private final String brokerUrl = "tcp://192.168.99.100:1883";
    private final String myId = "arcondicionadomqtt";
    private MqttClient client;
    private Throwable e;
    
    
    
    public ArCondicionadoMqtt(  ){
        connect();
    }
    
    private void connect(){
        try{
            client = new MqttClient(brokerUrl, myId);
            client.connect();
            client.setCallback(this);
            client.subscribe("arcondicionado/#");
            
        }
        catch(MqttException e){
            System.out.println(e.getMessage());
            this.e = e;
        }
        
    }
    
    public void sendMessage(String topic, String msg) throws Throwable{
        if(e != null){
            throw e;
        }
       
        MqttMessage message = new MqttMessage();
        message.setPayload(msg.getBytes());
        client.publish(topic, message);
        //client.disconnect();
    }

    @Override
    public void connectionLost(Throwable thrwbl) {
        e = thrwbl;
        connect();
    }

    @Override
    public void messageArrived(String topic, MqttMessage mm) throws Exception {
        
        String msg = topic + "::" + new String(mm.getPayload());
        String valor = mm.toString();
        
        System.out.println("enviar para o cliente por meio de websocket");
        System.out.println("mensagem:" + new String(mm.getPayload()));
        System.out.println("topico: " + topic);
        ArCondicionado ar = ArCondicionado.getInstacia();
        if(topic.equals("arcondicionado/ligar")){
                System.out.println("mandar ligar o ar");
                if(!ar.isLigado())
                    ar.setLigado(true);
                else{
                    ar.setLigado(false);
            }
        }
            
        else if(topic.equals("arcondicionado/mudarTemperatura")){
            System.out.println("mudando temperatura");
            System.out.println("TEMP = " + ar.getTemperatura());
            int temp;
            temp = Integer.parseInt(valor);
            System.out.println("temp = " + temp);
            ar.setTemperatura(temp);
            System.out.println("temperatura = " + ar.getTemperatura());
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        System.out.println("deliveryComplete");
    }
    
}






// public void messageArrived(String topic, MqttMessage mm) throws Exception {
//        
//        String msg = topic + "::" + new String(mm.getPayload());
//        
//        System.out.println("enviar para o cliente por meio de websocket");
//        System.out.println("mensagem:" + new String(mm.getPayload()));
//        System.out.println("topico: " + topic);
//        ArCondicionado ar = ArCondicionado.getInstacia();
//        if(topic.equals("arcondicionado/ligar")){
//                System.out.println("mandar ligar o ar");
//                ar.setLigado(true);
//            }
//            else{
//                ar.setLigado(false);
//            }
//        