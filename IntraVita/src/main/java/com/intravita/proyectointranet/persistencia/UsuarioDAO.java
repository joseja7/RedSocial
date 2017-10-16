package com.intravita.proyectointranet.persistencia;

import com.intravita.proyectointranet.modelo.Usuario;

public interface UsuarioDAO {
	
	public void insert (Usuario usuario);
	public Usuario select(Usuario generico) ;
	public void delete (Usuario usuario);
	public void update(String nombre, String pwdAntigua, String pwdNueva);
	
	
}