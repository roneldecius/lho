package com.draag.services.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bson.types.ObjectId;

import com.draag.services.model.President;
import com.draag.services.service.PresidentService;

@Path("/presidents")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PresidentResource {
	private PresidentService service = new PresidentService();

	@GET
	public List<President> getDepartements(){
		return service.getAllPresidents();
	}
	
	@GET
	@Path("{presidentId}")
	public President getPresident(@PathParam("presidentId") String presidentId){
		ObjectId id = new ObjectId(presidentId);
		return service.getPresident(id);
	}
}
