package br.com.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/location") 
public class LocationWS {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/all")
	public Response get() {
		
		
//		https://maps.googleapis.com/maps/api/distancematrix/json?origins=-23.565993,-46.4041249&destinations=-23.5771831,-46.5454778
		
Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target("https://maps.googleapis.com/maps/api/distancematrix/json?origins=-23.565993,-46.4041249&destinations=-23.5771831,-46.5454778");
			
//		JSONObject json = new JSONObject(callRcms);
//		System.out.println(json.toString());

		return target.request(MediaType.APPLICATION_JSON)
//				.header(auth, token)
				.header("Content-type", "application/json")
				.get();
//				.get(Entity.entity(json.toString(), "application/json"));
		
//		return Response.status(200).entity("result").build();
	}
}
