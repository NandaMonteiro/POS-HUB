/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restfull;

import entidades.ArCondicionado;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.json.JSONObject;


/**
 *
 * @author nanda
 */
@Path("arcondicionado")
public class ArcondicionadoRest {
    
    MqttClient sampleClient;
    String topic = "sensor/temperatura";
    String content = "23";
    int qos = 2;
    String broker = "tcp://0.0.0.0:1883";
    String clientId = "fernanda";

    /**
     * This is a sample web service operation
     * @param men
     */
    
    private ArCondicionado arCondicionado;
    
    public ArcondicionadoRest(){
        arCondicionado = ArCondicionado.getInstacia();
    }
            
    @GET
    @Produces("application/json")
    @Path("estado")
    public Response getEstado() {
        JSONObject jsonObject = new JSONObject();
       boolean estado = arCondicionado.isLigado();
       jsonObject.put("estado", estado); 
       return Response.ok(200).entity(""+jsonObject).build();
       
    }
}
