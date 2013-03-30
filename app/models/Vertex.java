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
public class Vertex {

	@Id
	public ObjectId id;
	
	@Required
	public String name;
	
	@Required
	public int zoom;
	
	@Required
	public float lon;
	
	@Required
	public float lat;
	
	public float alt;
	
	public float size;
	
	public int mtype;
	
	public String fullName;
	
	public Vertex(int zoom, float lon, float lat, float alt) {
		this.zoom = zoom;
		this.lon = lon;
		this.lat = lat;
		this.alt = alt;
		this.size = 0;
		this.mtype = 0;
		genFullName();
	}
	
	public Vertex(String name, int zoom, float lon, float lat, float alt) {
		this(zoom, lon, lat, alt);
		this.name = name;
	}
	
	public Vertex(String name) {
		this(name, 0, 0, 0, 0);
	}
	
	public Vertex() {
		this("vertex");
	}
	
	public String genFullName() {
		this.fullName = Integer.toString(zoom) + "-" + Float.toString(lon) +";"+ Float.toString(lat)+";"+Float.toString(alt)+
				"("+name+")";
		return this.fullName;
	}
	
	public void updateCoords(float lon, float lat, float alt) {
		this.lon = lon;
		this.lat = lat;
		this.alt = alt;
		genFullName();
	}
	
	public void updateZoom(int zoom) {
		this.zoom = zoom;
		genFullName();
	}
		
	@play.data.format.Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
	public DateTime created;

	public static List<Vertex> all() {
		if (MorphiaObject.datastore != null) {
			List<Vertex> vert = MorphiaObject.datastore.find(Vertex.class).asList();
			return vert;
		} else {
			return new ArrayList<Vertex>();
		}
	}

	public static void create(Vertex vertex) {
		vertex.genFullName();
		MorphiaObject.datastore.save(vertex);
	}
	
	public static void delete(String idToDelete) {
		Vertex toDelete = MorphiaObject.datastore.find(Vertex.class).field("_id").equal(new ObjectId(idToDelete)).get();
		if (toDelete != null) {
			Logger.info("toDelete: " + toDelete);
			MorphiaObject.datastore.delete(toDelete);
		} else {
			Logger.debug("ID No Found: " + idToDelete);
		}
	}
	
	public static Vertex findById(String vid) {
		return MorphiaObject.datastore.find(Vertex.class).field("_id").equal(new ObjectId(vid)).get();
	}
	
	public static void update(Vertex vertex) {
		vertex.genFullName();
		create(vertex);
	}
	
	@Override
	public String toString() {
		return this.id + ": " + genFullName();
	}
}
