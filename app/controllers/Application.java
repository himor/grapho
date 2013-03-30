package controllers;

import models.Vertex;
import play.data.*;
import static play.data.Form.*;
import play.*;

import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {
	static Form<Vertex> vertexForm = form(Vertex.class);

	public static Result index() throws Exception {
		// redirect to the "group Result
		return redirect(routes.Application.list());
	}

	public static Result list() {
		return ok(views.html.index.render(Vertex.all(), vertexForm));
	}

	public static Result addVertex() {
		Form<Vertex> filledForm = vertexForm.bindFromRequest();
		if(filledForm.hasErrors()) {
			return badRequest(views.html.index.render(Vertex.all(), filledForm));
		} else {
			Vertex.create(filledForm.get());
			return redirect(routes.Application.list());  
		}
	}
	
	public static Result deleteVertex(String id) {
		Vertex.delete(id);
		return redirect(routes.Application.list());
	}
	
	public static Result updateVertex(String id) {
		 Vertex vert = Vertex.findById(id);
		 Logger.info("updating: " + vert.toString());
		 Form<Vertex> updateForm = form(Vertex.class).fill(vert);
		 if (vert == null) {
			 return badRequest("No such vertex");
		 } else {
			 return ok(views.html.edit.render(vert, updateForm));
		 }		 
	}
	
	public static Result doUpdateVertex(String id) {
		Form<Vertex> filledForm = vertexForm.bindFromRequest();
		if(filledForm.hasErrors()) {
			return badRequest(views.html.edit.render(filledForm.get(), filledForm));
		} else {
			Vertex.update(filledForm.get());
			return redirect(routes.Application.list());  
		}
	}

}