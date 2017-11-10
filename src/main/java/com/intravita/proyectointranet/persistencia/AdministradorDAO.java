package com.intravita.proyectointranet.persistencia;

import com.intravita.proyectointranet.modelo.Administrador;

public interface AdministradorDAO { /*interfaz adm*/
	 public String list() ; 
	 public void insert (Administrador administrador);
	 public Administrador select(Administrador generico) ;
	 public void delete (Administrador administrador);
	 public void update(String nombre, String pwdAntigua, String pwdNueva);
}