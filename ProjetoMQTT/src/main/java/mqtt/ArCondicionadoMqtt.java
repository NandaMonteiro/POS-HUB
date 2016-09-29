/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mqtt;

import entidades.ArCondicionado;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
/**
 *
 * @author nanda
 */
/*
@ApplicationScoped
public class ArCondicionadoMqtt implements MqttCallback{

     String broker = "tcp://0.0.0.0:1883";
    private final String myId = "arcondicionadoMqtt";
    private MqttClient client;

    
    @PostConstruct
    private void init( @Observes @Initialized(ApplicationScoped.class) Object init ){
        try{
            connect();
        }catch(MqttException e){
            System.out.println("erro ao inicializar ArCondicionadoMqtt");
        }
    }
    
    
    
    private void connect() throws MqttException{
         client = new MqttClient(broker, myId);
            client.connect();
            client.setCallback(this);
            client.subscribe("arcondicionado/#");
    }
    
    public void publicar(String topic, String men ) {
        System.out.println("publicar mensagem " + men+ "para topico: " + topic);
        try {
            
            MqttMessage message = new MqttMessage(men.getBytes());
            client.publish(topic, message);
            System.out.println("enviou");
            
        } catch (MqttException ex) {
            System.out.println("erro ao publicar");
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void connectionLost(Throwable thrwbl) {
        System.out.println("Erro: " + thrwbl.getMessage());}

    @Override
    public void messageArrived(String topic, MqttMessage mm) throws Exception {
        System.out.println("chegou mensagem");
        ArCondicionado ar = ArCondicionado.getInstacia();
        System.out.println("recebeu mensagem:" + new String(mm.getPayload()));
            if(topic.equals("arcondicionado/ligar")){
                System.out.println("mandar ligar o ar");
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
*/


public class ArCondicionadoMqtt implements MqttCallback {
    
    private final String brokerUrl = "tcp://0.0.0.0:1883";
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
        
        System.out.println("enviar para o cliente por meio de websocket");
        System.out.println("mensagem:" + new String(mm.getPayload()));
        System.out.println("topico: " + topic);
        ArCondicionado ar = ArCondicionado.getInstacia();
        if(topic.equals("arcondicionado/ligar")){
                System.out.println("mandar ligar o ar");
                ar.setLigado(true);
            }
            else{
                ar.setLigado(false);
            }
        
        
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        System.out.println("deliveryComplete");
    }
    
}