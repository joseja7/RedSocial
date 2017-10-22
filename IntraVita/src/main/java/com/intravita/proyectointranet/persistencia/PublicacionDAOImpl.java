package com.intravita.proyectointranet.persistencia;

import org.apache.commons.codec.digest.DigestUtils;
import org.bson.BsonDocument;
import org.bson.BsonString;

import com.intravita.proyectointranet.modelo.Publicacion;
import com.intravita.proyectointranet.modelo.Usuario;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

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
	
	public void insert(Publicacion publicacion) {
		BsonDocument bso = new BsonDocument();
		bso.append("autor", new BsonString(publicacion.getUsuario().getNombre()));
		bso.append("texto", new BsonString(publicacion.getTexto()));
		MongoBroker broker = MongoBroker.get();
		MongoCollection<BsonDocument> publicaciones = broker.getCollection("Publicaciones");
		publicaciones.insertOne(bso);
	}
}
