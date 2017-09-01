package org.ronel.tutorial.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	/**
	 * Annotation param will be passed in the url like this: 
	 * {@code /injectdemo/annotation;param=toto}
	 * @param matrixParam
	 * @param header
	 * @param cookie
	 * @return
	 */
	@GET
	@Path("annotations")
	public String getAnnotation(@MatrixParam("param") String matrixParam,
								@HeaderParam("authSessionId") String header,
								@CookieParam("name") String cookie) {
		return "MatrixParam: " + matrixParam + "\nHeader Param: " + header + "\nCookie param: " + cookie;
	}
	
	@GET
	@Path("context")
	public String getParamUsingContext(@Context UriInfo uriInfo,
										@Context HttpHeaders headers){
		
		
		return "Path: " + uriInfo.getAbsolutePath().toString();
	}
}
