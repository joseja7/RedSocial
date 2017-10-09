package controlador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import modelo.Usuario;
import persistencia.UsuarioDAOImpl;

@Controller
public class UsuarioServlet {
	@Autowired
	UsuarioDAOImpl usuarioDao;
	
	
	@RequestMapping("mostrar.do")
	public void mostrar(HttpServletResponse response) throws Exception {
		String result="";
		result = usuarioDao.show();
		response.getOutputStream().println("LISTA DE USUARIOS\n------------------\n"+result);
		
	}

	@RequestMapping("anadir.do")
	public void anadir(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		//operacionesDao.connect();
		Usuario usuario = new Usuario();
		usuario.setNombre(request.getParameter("txtUserAdd"));
		String pwd=request.getParameter("txtUserPWD");
		String pwd1=request.getParameter("txtUserPWD1");
		
		if(!pwd.equals(pwd1))
			response.getOutputStream().println("El usuario "+usuario.getNombre()+" ya se encuentra en la lista.");
			
		else {
			usuario.setClave(pwd);
			String listaUsuario="";
			listaUsuario = usuarioDao.show();
			if (listaUsuario.contains(usuario.getNombre())) {
				response.getOutputStream().println("El usuario "+usuario.getNombre()+" ya se encuentra en la lista.");
			}
			
			else {
				usuarioDao.insert(usuario);
				response.getOutputStream().println("El usuario "+usuario.getNombre()+" ha sido añadido a su lista.");
			}
		}
	}
	
	@RequestMapping("eliminar.do")
	public void eliminar(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		Usuario usuario = new Usuario();
		usuario.setNombre(request.getParameter("txtUserDel"));
		usuario.getClave();
		String listaUsuario="";
		listaUsuario = usuarioDao.show();
		
		if (!listaUsuario.contains(usuario.getNombre())) {
			response.getOutputStream().println("El usuario "+usuario.getNombre()+" no esta en la lista.");
		}
		
		else {
			usuarioDao.delete(usuario);
			response.getOutputStream().println("El usuario "+usuario.getNombre()+" ha sido eliminado a su lista.");
		}
		
	}
}
