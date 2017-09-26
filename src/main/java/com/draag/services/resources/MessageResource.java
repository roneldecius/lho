package com.draag.services.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
//import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.draag.services.model.Message;
import com.draag.services.resources.bean.MessageFilterBean;
import com.draag.services.service.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Message> getMessages(@QueryParam("year") int year,
//									@QueryParam("start") int start,
//									@QueryParam("size") int size) {
//		if (year > 0 ){
//			return messageService.getAllMessagesForYear(year);
//		}
//		if (start >= 0 && size >= 0){
//			return messageService.getAllMessagesPaginated(start, size);
//		}
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
		if (filterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if (filterBean.getStart() >= 0 && filterBean.getSize() > 0 ) {
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
//		System.out.println("we're here now " + messageService.getAllMessages().size());
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
//	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long messageId){
		
		return messageService.getMessage(messageId);
	}
	
	@POST
////	@Produces(MediaType.APPLICATION_JSON)
////	@Consumes(MediaType.APPLICATION_JSON)
//	public Message addMessage(Message message) {
//		return messageService.addMessage(message);
//		
	public Response addMessage(Message message, @Context UriInfo uriInfo) { //throws URISyntaxException{
		Message newMessage = messageService.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response //.status(Status.CREATED)
//				.created(new URI("/messenger/webapi/messaes/" + newMessage.getId()))
				
				.created(uri)
				.entity(newMessage)
				.build();
	}
	
	@PUT
	@Path("/{messageId}")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long messageId, Message message){
		message.setId(messageId);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
//	@Produces(MediaType.APPLICATION_JSON)
	public Message deleteMessage(@PathParam("messageId") long messageId){
		return messageService.deleteMessage(messageId);
	}
	
	/**
	 * Jaxrs sub-resource
	 * @return
	 */
	@Path("{messageId}/comments")
	public CommentResource getCommentResource(@PathParam("messageId") long messageId){
		return new CommentResource(messageId);
	}
	
}
