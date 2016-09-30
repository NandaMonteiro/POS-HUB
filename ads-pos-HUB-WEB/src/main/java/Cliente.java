
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nanda
 */
public class Cliente implements Serializable{
    
    public Response ligarAr(){
        String uri = "http://localhost:8080/ProjetoMQTT/api";
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(uri);
        Response get = webTarget.path("arcondicionado/estado")
                    .request(MediaType.APPLICATION_JSON)
                    .get();
     
        return get;
    }
    
}
