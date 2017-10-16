package com.intravita.proyectointranet.controlador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.intravita.proyectointranet.modelo.Administrador;
import com.intravita.proyectointranet.modelo.Usuario;
import com.intravita.proyectointranet.persistencia.AdministradorDAOImpl;
import com.intravita.proyectointranet.persistencia.UsuarioDAOImpl;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;




@Controller
@RequestMapping({"/usuario","/"})
public class UsuarioServlet {
	@Autowired
	UsuarioDAOImpl usuarioDao;
	
	@Autowired
	AdministradorDAOImpl administradorDao;
	private static final Logger logger = LoggerFactory.getLogger(UsuarioServlet.class);
	
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "usuario/login";
	}
	
	
	@RequestMapping(value="/irLogin",method = RequestMethod.GET)
	public ModelAndView irLogin(HttpServletResponse response,HttpServletRequest request){
		return cambiarVista("usuario/login");
	}
	
	@RequestMapping(value="/irRegistrar",method = RequestMethod.GET)
	public ModelAndView irRegistrar(HttpServletResponse response,HttpServletRequest request){
		
		return cambiarVista("usuario/registrar");
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String iniciarSesion(HttpServletResponse response, HttpServletRequest request) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setNombre(request.getParameter("txtUsuarioNombre"));
		usuario.setClave(request.getParameter("txtUsuarioClave"));
		

		String cadenaUrl="usuario/";
		
		Usuario existe =new Usuario();
		existe=usuarioDao.select(usuario);
				
		if(existe.getNombre().equals(usuario.getNombre())&& existe.getClave().equals(usuario.getClave())) {
			System.out.println("Credenciales correctos,iniciando sesion");

			cadenaUrl+="bienvenido";
		}else {
			Administrador admin=new Administrador();
			admin.setNombre(request.getParameter("txtUsuarioNombre"));
			admin.setClave(request.getParameter("txtUsuarioClave"));
			
			Administrador existeAdmin=new Administrador();
			existeAdmin=administradorDao.select(admin);
			if(existeAdmin.getNombre().equals(admin.getNombre())&& existeAdmin.getClave().equals(admin.getClave())) {
				System.out.println("Credenciales correctos, iniciando sesion de administrador");
				cadenaUrl+="inicioAdmin";
			}else {
				System.out.println("Credenciales incorrectos");
				cadenaUrl+="login";
			}

		}
		return cadenaUrl;
	} 
	
	@RequestMapping(value="/registrar", method = RequestMethod.POST)
	public String registrar(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		Usuario usuario = new Usuario();
		Usuario existe =new Usuario();
		usuario.setNombre(request.getParameter("txtUsuarioNombre"));
		usuario.setEmail(request.getParameter("txtEmail"));
		String pwd=request.getParameter("txtUsuarioClave");
		String pwd1=request.getParameter("txtUsuarioClave1");
		
		String cadenaUrl="usuario/";
		
		if(pwd.equals(pwd1)) {
			usuario.setClave(pwd);
			existe=usuarioDao.select(usuario);
			if(existe.getNombre().equals(usuario.getNombre())) {
				System.out.println("Error en las credenciales");
				cadenaUrl+="registrar";
			}else {
				usuarioDao.insert(usuario);
				cadenaUrl+="login";
			}
		}else {
			cadenaUrl+="registrar";
		}
		
		
		return cadenaUrl;
	}
	
	@RequestMapping(value="/eliminar", method = RequestMethod.GET)
	public void eliminar(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		Usuario usuario = new Usuario();
		usuario.setNombre(request.getParameter("txtUserDel"));
		usuario.getClave();
		
		if (usuarioDao.select(usuario).getNombre()=="") {
			response.getOutputStream().println("El usuario "+usuario.getNombre()+" no esta en la lista.");
			//y hacemos para quedarnos en el mismo .jsp y modificar la pagina mediante sus acciones
		}
		
		else {
			usuarioDao.delete(usuario);
			response.getOutputStream().println("El usuario "+usuario.getNombre()+" ha sido eliminado a su lista.");
		}
		
	}
	
	@RequestMapping(value="/bienvenido", method = RequestMethod.GET)
	public String bienvenido(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		return "usuario/bienvenido";
	}
	
	
	
	/*Este metodo sirve para controlar los cambios de vista por nombre(sting)*/
	public ModelAndView cambiarVista(String nombreVista) {
		ModelAndView vista =new ModelAndView(nombreVista);
		return vista;
	}
}