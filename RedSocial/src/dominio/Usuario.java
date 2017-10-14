package dominio;

import persistencia.usuarioDAO;

public class Usuario {
	private String nombre;
	private String pwd;
	
	public Usuario () {}
	public Usuario (String name, String pass) {
		this.nombre=name;
		this.pwd=pass;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public boolean login() {
		return usuarioDAO.login(this);
	}
}
