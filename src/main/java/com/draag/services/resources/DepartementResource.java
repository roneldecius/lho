package com.draag.services.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.draag.services.model.Departement;
import com.draag.services.service.DepartementService;

@Path("/departements")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepartementResource {
	private DepartementService service = new DepartementService();

	@GET
	public List<Departement> getDepartements(){
		return service.getAllDepartement();
	}
}
