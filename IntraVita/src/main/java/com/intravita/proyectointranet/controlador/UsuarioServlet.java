package com.intravita.proyectointranet.controlador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.intravita.proyectointranet.modelo.Usuario;
import com.intravita.proyectointranet.persistencia.UsuarioDAOImpl;

import java.io.IOException;
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
	private static final Logger logger = LoggerFactory.getLogger(UsuarioServlet.class);
	
	//Selecciona la vista home para render devolviendo su nombre.
	
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "usuario/inicio";
	}
	@RequestMapping(value="/irLogin",method = RequestMethod.GET)
	public String irLogin(Model model,HttpServletResponse response){
		return "redirect:login";
	}
	
	@RequestMapping(value="/irRegistrar",method = RequestMethod.GET)
	public String irRegistrar(Model model){
		return "redirect:registrar";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String iniciarSesion(HttpServletResponse response, HttpServletRequest request) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setNombre(request.getParameter("txtUsuarioNombre"));
		usuario.setClave(request.getParameter("txtUsuarioClave"));
		
		//Usuario seleccionar = usuarioDao.select(usuario.getNombre(), usuario.getClave());
		
		/*if(seleccionar!=null) {
			response.getOutputStream().println("El usuario "+usuario.getNombre()+"iniciará sesión CUANDO ESTÉ IMPLEMENTADO");
			cambiarVista("home");
		}
		
		else {
			response.getOutputStream().println("El usuario "+usuario.getNombre()+" no está inscrito.");
		}
		*/
		return "usuario/login";
	} 
	
	/*@RequestMapping(value="/registrar", method = RequestMethod.GET)
	public String registrar(HttpServletResponse response, HttpServletRequest request, Model model) throws Exception {
			Usuario usuario = new Usuario();
			usuario.setNombre(request.getParameter("txtUsuarioNombre"));
			usuario.setClave(request.getParameter("txtUsuarioClave"));
			
			
			//Usuario seleccionar = usuarioDao.select(usuario.getNombre(), usuario.getClave());
			/*if(seleccionar!=null) {
				response.getOutputStream().println("El usuario "+usuario.getNombre()+"iniciará sesión CUANDO ESTÉ IMPLEMENTADO");
				//cambiarVista("home"); para cambiar vista suponidamente
			}
			
			else {
				response.getOutputStream().println("El usuario "+usuario.getNombre()+" no está inscrito.");
			}*/
			
			//return "usuario/registrar";
			
	//}
	

	@RequestMapping(value="/registrar", method = RequestMethod.GET)
	public String registrar(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		Usuario usuario = new Usuario();
		usuario.setNombre(request.getParameter("txtUserAdd"));
		String pwd=request.getParameter("txtUsuarioClave");
		String pwd1=request.getParameter("txtUsuarioClave1");
		
		if(!pwd.equals(pwd1))
			System.out.println("A TOMAR POR CULO");
			
		else {
			String listaUsuario="";
			listaUsuario = usuarioDao.show();
			
			if (listaUsuario.contains(usuario.getNombre())) {
				response.getOutputStream().println("El usuario "+usuario.getNombre()+" ya se encuentra en la lista.");
			}
			
			else {
				usuario.setClave(pwd);
				usuarioDao.insert(usuario);
				response.getOutputStream().println("El usuario "+usuario.getNombre()+" ha sido añadido a su lista.");
			}
		}
		return "usuario/registrar";
	}
	
	@RequestMapping(value="/eliminar", method = RequestMethod.GET)
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
	
	@RequestMapping(value="/bienvenido", method = RequestMethod.GET)
	public String bienvenido(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		/*Usuario usuario = new Usuario();
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
		}*/
		return "usuario/bienvenido";
		
	}
	
	
	
	/*Este metodo sirve para controlar los cambios de vista por nombre(sting)*/
	public ModelAndView cambiarVista(String nombreVista) {
		ModelAndView vista =new ModelAndView(nombreVista);
		return vista;
	}
	
	/*@RequestMapping(value="/registrar", method = RequestMethod.GET)
	public String anadir(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		Usuario usuario = new Usuario();
		usuario.setNombre(request.getParameter("txtUserAdd"));
		String pwd=request.getParameter("txtUserPWD");
		String pwd1=request.getParameter("txtUserPWD1");
		
		if(!pwd.equals(pwd1))
			System.out.println("A TOMAR POR CULO");
			
		else {
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
	*/
}