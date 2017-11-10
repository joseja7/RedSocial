package com.intravita.proyectointranet.persistencia;

import com.intravita.proyectointranet.modelo.Publicacion;

public interface PublicacionDAO { /*interfaz publicacionDao*/

	public boolean insert (Publicacion pulicacion);
	public boolean existe(Publicacion publicacion) ;
	public void delete (Publicacion publicacion);	
}
