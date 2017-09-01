package org.ronel.tutorial.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;

import org.ronel.tutorial.messenger.model.Comment;
import org.ronel.tutorial.messenger.service.CommentService;

//@Path("/")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)

public class CommentResource {
	
	private CommentService commentService = new CommentService();
	private long messageId;
	

	public CommentResource(long messageId) {
		this.messageId = messageId;
	}

	@GET
	public String getComments() {
		return commentService.getAllComments(messageId);
	}
	
	@POST
	public Comment addComment(Comment comment){
		return commentService.addComment(messageId, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("commentId") long commentId, Comment comment){
		comment.setId(commentId);
		return commentService.updateComment(messageId, comment);
	}
	
//	@GET
//	@Path("/{commentId}")
//	public String getComment(@PathParam("commentId") long commentId){
//		return "The comment Id is set to: " + commentId + "\nThe message id is set to: " + messageId;
//	}

	
}
