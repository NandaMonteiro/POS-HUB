/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mqtt;

/**
 *
 * @author nanda
 */
public class MqttRecurso {
    
    private static MqttRecurso recurso;
    
    private MqttRecurso(){
        arMqtt = new ArCondicionadoMqtt();
        lampadaMqtt = new LampadaMqtt();
       
    }
    
    private final ArCondicionadoMqtt arMqtt;
    private final LampadaMqtt lampadaMqtt;
    
    
    public static MqttRecurso getInstance(){
        if((recurso == null)){
            recurso = new MqttRecurso();
        }
        return recurso;
    }
    
    public ArCondicionadoMqtt getArCondicionadoMqtt(){
        return arMqtt;
    }

    public LampadaMqtt getLampadaMqtt(){
        return lampadaMqtt;
    }
    
    
    
    
}
