package com.intravita.proyectointranet.persistencia;

import com.intravita.proyectointranet.modelo.Usuario;

public interface UsuarioDAO {
	
	public void insert (Usuario usuario) throws Exception;
	public Usuario select(Usuario generico) throws Exception;
	public void delete (Usuario usuario) throws Exception;
	public void update(String nombre, String pwdAntigua, String pwdNueva) throws Exception;
	
	
}