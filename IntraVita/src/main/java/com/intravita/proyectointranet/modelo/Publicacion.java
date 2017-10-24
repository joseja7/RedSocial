package com.intravita.proyectointranet.modelo;

public class Publicacion {

	private Usuario usuario;
	private String texto;
	
	public Publicacion(Usuario usuario, String texto) {
		this.usuario = usuario;
		this.texto = texto;
	}
	
	public Publicacion() {
		super();
	}
	
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
