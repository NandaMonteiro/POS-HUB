/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mqtt;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 *
 * @author nanda
 */
public class publicador {

    public static void main(String[] args) {
        try {
            // criando cliente
            MqttClient client = new MqttClient("tcp://0.0.0.0:1883",
                    MqttClient.generateClientId(), new MemoryPersistence());

            // conectando
            client.connect();
            System.out.println(client.isConnected() ? "conectado" : "falha na conxao");
//            //conexao com versao do mqtt
//            MqttConnectOptions options = new MqttConnectOptions();
//            options.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1);
//            options.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1_1);
//            client.connect(options);
            client.publish("hub/sensor/ciadade", "cajazeiras e muito quente".getBytes(), 2, true);
            client.publish("hub/sensor/luminosidade", "145".getBytes(), 2, true);
            client.publish("hub/sensor/temperatura", "16".getBytes(), 2, true);

            client.setCallback(new MqttCallback() {

                @Override
                public void connectionLost(Throwable cause) { //Called when the client lost the connection to the broker 
                    System.out.println("lancou a exceção:" + cause.getMessage());
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    System.out.println(topic + ": " + Arrays.toString(message.getPayload()));
                    byte[] bytes = message.getPayload();
                    String string = new String(bytes);
                    System.out.println("array: " + Arrays.toString(bytes));
                    System.out.println("str: " + string);
                    //lendo o valor numérico
                    int sampleValue = (int) ((bytes[0] << 8) | (bytes[1] & 0x00FF));
                    System.out.println("msg: " + string + "-> " + sampleValue+"\n\n");
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {//Called when a outgoing publish is complete 
                }
            });

//            client.connect();
            client.subscribe("#", 1);
//            client.disconnect();
        } catch (MqttException ex) {
            Logger.getLogger(publicador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
