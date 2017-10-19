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
import com.intravita.proyectointranet.utlidades.utilidades;

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
	AdministradorDAOImpl administradorDao=new AdministradorDAOImpl();
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioServlet.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "usuario/login";
	}
	
	/***
	 * @method metodos de navegacion entre jsp's
	 */
	@RequestMapping(value="/irLogin",method = RequestMethod.GET)
	public ModelAndView irLogin(HttpServletResponse response,HttpServletRequest request){
		return cambiarVista("usuario/login");
	}
	
	@RequestMapping(value="/irRegistrar",method = RequestMethod.GET)
	public ModelAndView irRegistrar(HttpServletResponse response,HttpServletRequest request){
		
		return cambiarVista("usuario/registrar");
	}
	
	/***
	 * 
	 *@method ejecucion cuando pulsamos el boton login
	 *
	 */
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String iniciarSesion(HttpServletResponse response, HttpServletRequest request) throws Exception {
		String cadenaUrl="usuario/";
		String nombre=request.getParameter("txtUsuarioNombre");
		String clave=request.getParameter("txtUsuarioClave");
		if(clave=="" || nombre=="")
			return cadenaUrl+="login";
		Administrador administrador= new Administrador();
		administrador.setNombre(nombre);
		administrador.setClave(clave);
		if(administradorDao.login(administrador))
			return cadenaUrl+="inicioAdmin";
		
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setClave(clave);
		if(usuarioDao.login(usuario))
			return cadenaUrl+="bienvenido";
		return cadenaUrl+="login";
	} 
	/***
	 * 
	 *@method ejecucion cuando pulsamos el boton de registro
	 *
	 */
	@RequestMapping(value="/registrar", method = RequestMethod.POST)
	public String registrar(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		String cadenaUrl="usuario/";
		String nombre=request.getParameter("txtUsuarioNombre");
		String email=request.getParameter("txtEmail");
		String pwd1=request.getParameter("txtUsuarioClave");
		String pwd2=request.getParameter("txtUsuarioClave1");
		
		if(!utilidades.credencialesValidas(nombre, email, pwd1, pwd2))
			return cadenaUrl+="registrar";
		
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setEmail(email);
		usuario.setClave(pwd1);
		
		if(!usuarioDao.insert(usuario))
			return cadenaUrl+="registrar";
		return cadenaUrl+="login";
	}
	/***
	 * 
	 *@method metodo de borrado de un usuario desde el administrador
	 *
	 */
	@RequestMapping(value="/borrar", method = RequestMethod.POST)
	public String borrar(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		String cadenaUrl="usuario/";
		String nombre=request.getParameter("txtUsuarioBorrar");
		usuarioDao.delete(new Usuario(nombre));
		cadenaUrl+="inicioAdmin";		
		return cadenaUrl;
	}
	
	/***
	 * 
	 *@method funcion del administrador de promover un usuario a admin
	 *
	 */
	@RequestMapping(value="/promover", method = RequestMethod.POST)
	public String promover(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		String cadenaUrl="usuario/";
		String nombre=request.getParameter("txtUsuarioPromover");
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);	
		usuario=usuarioDao.selectNombre(nombre);
		if(usuario!=null) {
			Administrador admin=new Administrador(usuario.getNombre(), usuario.getClave(), usuario.getEmail());
			administradorDao.insertSinEncrypt(admin);
		}
		cadenaUrl+="inicioAdmin";		
		return cadenaUrl;
	}
	/***
	 * 
	 *@method funcion del administrador de degradar un admin a usuario
	 *
	 */
	@RequestMapping(value="/degradar", method = RequestMethod.POST)
	public String degradar(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		String cadenaUrl="usuario/";
		String nombre=request.getParameter("txtAdminDegradar");
		Administrador admin=new Administrador();
		admin.setNombre(nombre);
		administradorDao.delete(admin);
		cadenaUrl+="inicioAdmin";		
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