package com.draag.services.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.types.ObjectId;

import com.draag.services.service.PresidentService;

@Path("/presidents")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PresidentResource {
	private PresidentService service = new PresidentService();

	@GET
	public Response getPresidents(){
		return Response.ok()
//				.encoding("UTF-8")
				.header("Access-Control-Allow-Origin", "*")
				.header("Content-Type", "application/json;charset=utf-8")
				.entity(service.getAllPresidents())
				.build();
	}
	
	@GET
	@Path("{presidentId}")
	public Response getPresident(@PathParam("presidentId") String presidentId){
		ObjectId id = new ObjectId(presidentId);
		return Response
				.ok()
//				.encoding("UTF-8")
				.header("Content-Type", "application/json;charset=utf-8")
				.header("Access-Control-Allow-Origin", "*")
				.entity(service.getPresident(id))
				.build();
	}
}
