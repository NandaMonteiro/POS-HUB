/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mqtt;

import entidades.Lampada;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author Luciana
 */
public class LampadaMqtt implements MqttCallback {

    private final String brokerUrl = "tcp://192.168.99.100:1883";
    private final String myId = "lampadamqtt";
    private MqttClient client;
    private Throwable e;

    public LampadaMqtt() {
        connect();
    }

    private void connect() {
        try {
            client = new MqttClient(brokerUrl, myId);
            client.connect();
            client.setCallback(this);
            client.subscribe("lampada/#");

        } catch (MqttException e) {
            System.out.println(e.getMessage());
            this.e = e;
        }

    }

    public void sendMessage(String topic, String msg) throws Throwable {
        if (e != null) {
            throw e;
        }
        MqttMessage message = new MqttMessage();
        message.setPayload(msg.getBytes());
        client.publish(topic, message);

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
        Lampada lampada = Lampada.getIntancia();
        if (topic.equals("lampada/ligar")) {
            System.out.println("mandar ligar a lampada");
            if (!lampada.isLigado()) {
                lampada.setLigado(true);
            } else {
                lampada.setLigado(false);
            }
        }

    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        System.out.println("deliveryComplete");
    }

}
