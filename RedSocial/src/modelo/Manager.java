package modelo;

import java.util.Hashtable;

import persistencia.UsuarioDAOImpl;

public class Manager {
	private Hashtable<String, Usuario> activos;
	
	private Manager(){
		this.activos=new Hashtable<String, Usuario>();	
	}
    public static class SingletonHolder{
		static Manager singleton=new Manager();
	}
	
	public static Manager get(){
		return SingletonHolder.singleton;
	}
	
	public void login(Usuario usuario) {
		this.activos.put(usuario.getNombre(), usuario);
		System.out.println(activos.toString());
	}
	public void logout(Usuario usuario) {
	    this.activos.remove(usuario.getNombre(), usuario);
	    System.out.println(activos.toString());
	}
}
