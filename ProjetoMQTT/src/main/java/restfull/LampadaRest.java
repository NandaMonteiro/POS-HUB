/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restfull;

import entidades.Lampada;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import mqtt.MqttRecurso;
import org.json.JSONObject;

/**
 *
 * @author Luciana
 */
@Path("lampada")
public class LampadaRest {

    private MqttRecurso recurso;

    private Lampada lampada;

    public LampadaRest() {
        lampada = Lampada.getIntancia();
        recurso = MqttRecurso.getInstance();
    }

    @GET
    @Produces("application/json")
    @Path("estado")
    public Response getEstado() {
        JSONObject jsonObject = new JSONObject();
        boolean estado = lampada.isLigado();
        jsonObject.put("estado", estado);
        return Response.ok(200).entity("" + jsonObject).build();

    }

    @PUT
    @Path("ligar")
    @Produces("application/json")
    public Response ligarLampada() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", true);
        try {
            recurso.getLampadaMqtt().sendMessage("lampada/ligar", "liga");
            jsonObject.put("success", true);
        } catch (Throwable e) {
            jsonObject.put("erro", e.getMessage());
            return Response.ok(500).entity("" + jsonObject).build();
        }
        return Response.ok(200).entity("" + jsonObject).build();
    }

}
