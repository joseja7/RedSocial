package com.intravita.proyectointranet.persistencia;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.codec.digest.DigestUtils;
import org.bson.BsonDateTime;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.conversions.Bson;

import com.intravita.proyectointranet.modelo.Publicacion;
import com.intravita.proyectointranet.modelo.Usuario;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Sorts;

public class PublicacionDAOImpl {


	public boolean existe(Publicacion publicacion) {
		MongoBroker broker = MongoBroker.get();
		MongoCollection<BsonDocument> usuarios = broker.getCollection("Publicaciones");
		BsonDocument criterio = new BsonDocument();
		criterio.append("autor", new BsonString(publicacion.getUsuario().getNombre()));
		criterio.append("texto", new BsonString(publicacion.getTexto()));
		FindIterable<BsonDocument> resultado=usuarios.find(criterio);
		BsonDocument usuarioBson = resultado.first();
		if (usuarioBson==null) {
			return false;
		}
		return true;
	}
	/***
	 * 
	 * @method insertar una publicacion en la base de datos
	 * 
	 */
	public void insert(Publicacion publicacion) {
		BsonDocument bso = new BsonDocument();
		bso.append("autor", new BsonString(publicacion.getUsuario().getNombre()));
		bso.append("texto", new BsonString(publicacion.getTexto()));
		bso.append("privacidad", new BsonString(publicacion.getPrivacidad()));
		bso.append("fecha", new BsonDateTime(publicacion.getFecha()));
		
		MongoBroker broker = MongoBroker.get();
		MongoCollection<BsonDocument> publicaciones = broker.getCollection("Publicaciones");
		publicaciones.insertOne(bso);
	}
	/***
	 * 
	 * @method actualizar una publicacion en la base de datos
	 * 
	 */
	public void update(Publicacion publicacion, String textoNuevo){		
		BsonDocument bso = new BsonDocument();
		bso.append("autor", new BsonString(publicacion.getUsuario().getNombre()));
		bso.append("texto", new BsonString(publicacion.getTexto()));
		bso.append("fecha", new BsonDateTime(publicacion.getFecha()));
		MongoBroker broker = MongoBroker.get();
		MongoCollection<BsonDocument> publicaciones = broker.getCollection("Publicaciones");
		BsonDocument actualizacion= new BsonDocument("$set", new BsonDocument("texto", new BsonString(textoNuevo)));
		publicaciones.updateOne(bso,actualizacion);
	}
	/***
	 * 
	 * @method eliminar una publicacion en la base de datos
	 * 
	 */
	public void remove(Publicacion publicacion){
		MongoBroker broker = MongoBroker.get();
		MongoCollection<BsonDocument> publicaciones = broker.getCollection("Publicaciones");
		BsonDocument bso = new BsonDocument();
		bso.append("autor", new BsonString(publicacion.getUsuario().getNombre()));
		bso.append("texto", new BsonString(publicacion.getTexto()));
		bso.append("fecha", new BsonDateTime(publicacion.getFecha()));
		FindIterable<BsonDocument> resultado=publicaciones.find(bso);
		BsonDocument publicacionBson = resultado.first();		
		publicaciones.deleteOne(publicacionBson);
	}
	/**
	 * 
	 * @param usuario del que queremos obtener publicaciones publicas
	 * @return lista de publicaciones
	 */
	public ArrayList<Publicacion> selectPublicas(Usuario usuario) {
		MongoBroker broker = MongoBroker.get();
		MongoCollection<BsonDocument> publicaciones = broker.getCollection("Publicaciones");
		BsonDocument criterio = new BsonDocument();
		criterio.append("autor", new BsonString(usuario.getNombre()));
		criterio.append("privacidad",  new BsonString("Publica"));
		Bson sort = Sorts.descending("fecha");
		FindIterable<BsonDocument> resultado=publicaciones.find(criterio).sort(sort);
		Iterator <BsonDocument> bucle= resultado.iterator();
		ArrayList<Publicacion> lista= new ArrayList<Publicacion>();
		BsonDocument aux;
		String autor;
		String texto;
		String privacidad;
		long fecha;
		Publicacion publicacion;
		while(bucle.hasNext()) {
			aux=bucle.next();
			autor=aux.getString("autor").getValue();
			texto=aux.getString("texto").getValue();
			privacidad=aux.getString("privacidad").getValue();
			fecha=aux.getDateTime("fecha").getValue();
			publicacion=new Publicacion(new Usuario(autor), texto, privacidad, fecha);
			lista.add(publicacion);
		}
		return lista;
	}
	/**
	 * 
	 * @param usuario del que queremos obtener publicaciones privadas
	 * @return lista de publicaciones
	 */
	public ArrayList<Publicacion> selectPrivadas(Usuario usuario) {
		MongoBroker broker = MongoBroker.get();
		MongoCollection<BsonDocument> publicaciones = broker.getCollection("Publicaciones");
		BsonDocument criterio = new BsonDocument();
		criterio.append("autor", new BsonString(usuario.getNombre()));
		criterio.append("privacidad",  new BsonString("Privada"));
		Bson sort = Sorts.descending("fecha");
		FindIterable<BsonDocument> resultado=publicaciones.find(criterio).sort(sort);
		Iterator <BsonDocument> bucle= resultado.iterator();
		ArrayList<Publicacion> lista= new ArrayList<Publicacion>();
		BsonDocument aux;
		String autor;
		String texto;
		String privacidad;
		long fecha;
		Publicacion publicacion;
		while(bucle.hasNext()) {
			aux=bucle.next();
			autor=aux.getString("autor").getValue();
			texto=aux.getString("texto").getValue();
			privacidad=aux.getString("privacidad").getValue();
			fecha=aux.getDateTime("fecha").getValue();
			publicacion=new Publicacion(new Usuario(autor), texto, privacidad, fecha);
			lista.add(publicacion);
		}
		return lista;
	}
}