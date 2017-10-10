package controlador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import modelo.Manager;
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
			response.getOutputStream().println("Error al registrar al usuario "+usuario.getNombre());
			
		else {
			usuario.setClave(pwd);
			try {
				usuarioDao.select(usuario.getNombre());
				response.getOutputStream().println("Error al registrar al usuario "+usuario.getNombre());
			}catch(Exception e) {
				usuarioDao.insert(usuario);
				response.getOutputStream().println("El usuario "+usuario.getNombre()+" ha sido añadido a su lista.");
			}
		}
	}
	
	@RequestMapping("login.do")
	public void login(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		//operacionesDao.connect();
		Usuario usuario = new Usuario();
		usuario.setNombre(request.getParameter("txtUserAdd"));
		String pwd=request.getParameter("txtUserPWD");
		usuario.setClave(pwd);
		try {
			if (!DigestUtils.md5Hex(pwd).equals(usuarioDao.selectPwd(usuario.getNombre()))) {
				response.getOutputStream().println("Nombre o password incorrectos");
			}	
			else {
				Manager.get().login(usuario);
				response.getOutputStream().println("Bienvenido "+usuario.getNombre()+" .");
			}
		}catch (Exception e) {
			response.getOutputStream().println("Nombre o password incorrectos");
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
