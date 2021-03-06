/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restfull;

import entidades.ArCondicionado;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import mqtt.MqttRecurso;
import org.json.JSONObject;


/**
 *
 * @author nanda
 */
@Path("arcondicionado")
public class ArcondicionadoRest {
    
    private MqttRecurso recurso;

    /**
     * This is a sample web service operation
     * @param men
     */
    private ArCondicionado arCondicionado;
    
    public ArcondicionadoRest(){
        arCondicionado = ArCondicionado.getInstacia();
        recurso = MqttRecurso.getInstance();
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
    
    @GET
    @Produces("application/json")
    @Path("temperatura")
    public Response getTemperatura(){
        JSONObject jsonObject = new JSONObject();
        int temperatura = arCondicionado.getTemperatura();
        jsonObject.put("temperatura", temperatura);
        return Response.ok(200).entity(""+jsonObject).build();
    }
    
    
    
    @POST
    @Path("ligar")
    @Produces("application/json")
    public Response ligarArCondicionado(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", true);
        try{
            recurso.getArCondicionadoMqtt().sendMessage("arcondicionado/ligar", "liga");
             jsonObject.put("success", true);
        }
        catch(Throwable e){
             jsonObject.put("erro", e.getMessage());
            return Response.ok(500).entity(""+jsonObject).build();
        }
        return Response.ok(200).entity(""+jsonObject).build();
    }
    
    
    @POST
    @Path("mudarTemperatura/{valor}")
    @Produces("application/json")
    public Response mudarTemperatura(@PathParam("valor")int valor){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", true);

        try{
            recurso.getArCondicionadoMqtt().sendMessage("arcondicionado/mudarTemperatura", Integer.toString(valor));
            jsonObject.put("succeess", true);
        }
        catch(Throwable e){
            jsonObject.put("Erro", e.getMessage());
        }
        return Response.ok(200).entity("" + jsonObject).build();
    }
}
