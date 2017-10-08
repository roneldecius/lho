package com.draag.services.resources;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.draag.services.service.DepartementService;

@Path("/departements")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepartementResource {
	private DepartementService service = new DepartementService();

	@GET
	public Response getDepartements(){
		return Response.ok().header("Access-Control-Allow-Origin", "*")
				.encoding("UTF-8")
				.entity(service.getAllDepartement())
				.build();
	}
}
