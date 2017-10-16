package com.intravita.proyectointranet.persistencia;

import java.util.LinkedList;

import org.apache.commons.codec.digest.DigestUtils;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.springframework.stereotype.Component;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import com.intravita.proyectointranet.modelo.Usuario;
import com.intravita.proyectointranet.persistencia.MongoBroker;
import com.intravita.proyectointranet.persistencia.UsuarioDAO;

@Component
public class UsuarioDAOImpl implements UsuarioDAO {
	
	public UsuarioDAOImpl() {
		super();
	}
	public void insert (Usuario usuario){
		BsonDocument bso = new BsonDocument();
		bso.append("nombre", new BsonString(usuario.getNombre()));
		bso.append("pwd", new BsonString(DigestUtils.md5Hex(usuario.getClave())));

		MongoBroker broker = MongoBroker.get();
		MongoCollection<BsonDocument> usuarios = broker.getCollection("Usuarios");
		FindIterable<BsonDocument> resultado=usuarios.find(bso);
		BsonDocument usuarioBso = resultado.first();
		if (usuarioBso==null) {
			usuarios.insertOne(bso);
		}
	}

	public Usuario select(Usuario generico) {
		MongoBroker broker = MongoBroker.get();
		MongoCollection<BsonDocument> usuarios = broker.getCollection("Usuarios");
		BsonDocument criterio = new BsonDocument();
		criterio.append("nombre", new BsonString(generico.getNombre()));
		criterio.append("pwd", new BsonString(DigestUtils.md5Hex(generico.getClave())));
		FindIterable<BsonDocument> resultado=usuarios.find(criterio);
		BsonDocument usuario = resultado.first();
		Usuario result;
		if (usuario==null) {
			result=new Usuario("-","-");
		}
		else {
			result = new Usuario(generico.getNombre(),generico.getClave());
		}
		return result;
	}
	
	public void delete (Usuario usuario){
		BsonDocument bso = new BsonDocument();
		bso.append("nombre", new BsonString(usuario.getNombre()));

		MongoBroker broker = MongoBroker.get();
		MongoCollection<BsonDocument> usuarios = broker.getCollection("Usuarios");
		usuarios.deleteOne(bso);

	}
	
	public void update(String nombre, String pwdAntigua, String pwdNueva){

		MongoBroker broker = MongoBroker.get();
		MongoCollection<BsonDocument> usuarios = broker.getCollection("Usuarios");
		BsonDocument criterio = new BsonDocument();
		criterio.append("nombre", new BsonString(nombre));
		criterio.append("pwd", new BsonString(pwdAntigua));
		FindIterable<BsonDocument> resultado=usuarios.find(criterio);
		BsonDocument usuario = resultado.first();
		BsonDocument actualizacion= new BsonDocument("$set", new BsonDocument("pwd", new BsonString(pwdNueva)));
		usuarios.findOneAndUpdate(usuario, actualizacion);
	}
	
	public String selectPwd(String nombre){
		
		BsonValue pwd;
		MongoBroker broker = MongoBroker.get();
		MongoCollection<BsonDocument> usuarios = broker.getCollection("Usuarios");
		BsonDocument criterio = new BsonDocument();
		criterio.append("nombre", new BsonString(nombre));
		FindIterable<BsonDocument> resultado=usuarios.find(criterio);
		BsonDocument usuario = resultado.first();
		pwd=usuario.get("pwd");
		BsonString password=pwd.asString();
		String pwdFinal=password.getValue();
		return pwdFinal;
	}
	
	/*public String show () throws Exception{//falta cerrar.... Este metodo equivale a un readAll
	MongoBroker broker = MongoBroker.get();
	MongoCollection<BsonDocument> usuarios = broker.getCollection("Usuarios");
	return usuarios.toString();
	/*FindIterable <BsonDocument> resultado=usuarios.find();
	String cadena ="";
    
    while (resultado!=null) {
    	cadena = cadena + resultado.first().toString()+"\n";
    }
    
	return cadena;
	
}*/
	
	
	
}

