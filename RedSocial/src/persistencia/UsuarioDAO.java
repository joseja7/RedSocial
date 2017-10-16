package persistencia;

import modelo.Usuario;


public interface UsuarioDAO {
	
	public String show () throws Exception;
	public void insert (Usuario usuario);
	public void insert (Usuario usuario, String pwd);
	
	public Usuario select(String nombre, String pwd) throws Exception;
	public void delete (Usuario usuario) throws Exception;
	public void update(String nombre, String pwdAntigua, String pwdNueva) throws Exception;
	
	
}