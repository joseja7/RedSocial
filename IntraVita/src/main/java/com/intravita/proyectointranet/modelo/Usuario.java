package com.intravita.proyectointranet.modelo;

public class Usuario {
	private String nombre;
	private String clave;
	
	//Constructor de pass
	public Usuario(String nombre, String clave) {
		this.nombre=nombre;
		this.clave=clave;
	}
	
	//Constructor sin pass
	public Usuario(String nombre) {
		this.nombre=nombre;
	}
	
	//Constructor vacio
	public Usuario() {
		super();
	}	
	
	//Get atributos
	public String getNombre() {
		return this.nombre;
	}
	public String getClave() {
		return this.clave;
	}
	//Set atributos
	public void setNombre(String nuevoNombre) {
		this.nombre=nuevoNombre;
	}
	public void setClave(String nuevaClave) {
		this.clave=nuevaClave;
	}
}