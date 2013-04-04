package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.bson.types.ObjectId;

import play.Logger;
import play.data.format.Formats.DateTime;
//import org.joda.time.DateTime;
import play.data.validation.Constraints.Required;

import com.avaje.ebean.Query;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.query.UpdateOperations;

import controllers.MorphiaObject;

@Entity
public class Edge {

	@Id
	public ObjectId id;
	
	public String name;
	
	@Required
	public float weight;
	
	public int mtype;
	
	public String fullName;
	
	public Edge() {
		this.mtype = 0;
		recalculate();
	}
	
	@play.data.format.Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
	public DateTime created;
	
	public void recalculate() {
		float newW = 0;
		//this.fullName = Integer.toString(zoom) + "-" + Float.toString(lon) +";"+ Float.toString(lat)+";"+Float.toString(alt)+
		//		"("+name+")";
		if (newW != this.weight) updateNow(this);
		this.weight = newW;
	}

	public static List<Edge> all() {
		if (MorphiaObject.datastore != null) {
			List<Edge> edge = MorphiaObject.datastore.find(Edge.class).asList();
			return edge;
		} else {
			return new ArrayList<Edge>();
		}
	}

	public static void create(Edge edge) {
		edge.recalculate();
		MorphiaObject.datastore.save(edge);
	}
	
	public static void delete(String idToDelete) {
		Edge toDelete = MorphiaObject.datastore.find(Edge.class).field("_id").equal(new ObjectId(idToDelete)).get();
		if (toDelete != null) {
			Logger.info("toDelete: " + toDelete);
			MorphiaObject.datastore.delete(toDelete);
		} else {
			Logger.debug("ID No Found: " + idToDelete);
		}
	}
	
	public static Edge findById(String vid) {
		return MorphiaObject.datastore.find(Edge.class).field("_id").equal(new ObjectId(vid)).get();
	}
	
	public static void update(Edge edge) {
		edge.recalculate();
		create(edge);
	}
	
	public static void updateNow(Edge edge) {
		create(edge);
	}
	
	@Override
	public String toString() {
		return this.id + ": " + this.name + "(" + this.weight + ")";
	}
}
