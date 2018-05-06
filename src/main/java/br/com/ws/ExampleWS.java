package br.com.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.model.Bidding;
import br.com.model.OfferProduct;

@Path("/offer-box") 
public class ExampleWS {

	// http://offer-box.mybluemix.net/api/offer-box/list-tags
	// http://offer-box.mybluemix.net/api/offer-box/match-tags
	// http://offer-box.mybluemix.net/api/offer-box/list-offer
	// http://offer-box.mybluemix.net/api/offer-box/list-bidding
	// http://offer-box.mybluemix.net/api/offer-box/info-offer
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list-tags")
	public Response getTags() {
		String[] tags = {"madeira", "metal", "estofado", "acento", "rodas", "apoio", "tela", "gabinete", "teclado", "monitor", "internet", "fonte", "CPU", "som"};
		return Response.status(200).entity(tags).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/match-tags")
	public Response matchTags(@QueryParam("textTag") String textTag) {

		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target("https://example-node-red-catossi.mybluemix.net/tag?text=" + textTag);
			
		return target.request(MediaType.APPLICATION_JSON)
				.header("Content-type", "application/json")
				.get();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list-offer")
	public Response getListOffer() {
		
		List<OfferProduct> offerProducts = new ArrayList<OfferProduct>();

        offerProducts.add(new OfferProduct(1.2, 1, "Empresa X", 1, "Product Y", "2km", 5, "SMALL" ));
        offerProducts.add(new OfferProduct(1.2, 1, "Empresa X1", 1, "Product Y2", "5km", 5, "SMALL" ));
        offerProducts.add(new OfferProduct(1.2, 1, "Empresa X2", 1, "Product Y3", "10km", 5, "SMALL" ));

		return Response.status(200).entity(offerProducts).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list-bidding")
	public Response getListProduct() {
		
		List<Bidding> biddings = new ArrayList<Bidding>();
        biddings.add(new Bidding("Produto 1", "10", 0, 0));
        biddings.add(new Bidding("Produto 2", "20", 0, 0 ));
        biddings.add(new Bidding("Produto 3", "30", 0, 0 ));

		return Response.status(200).entity(biddings).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/info-offer")
	public Response get() {
		OfferProduct offerProduct = new OfferProduct(1.2, 1, "Empresa X2", 1, "Product Y3", "10km", 5, "SMALL" );
		return Response.status(200).entity(offerProduct).build();
	}
}