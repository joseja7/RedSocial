package com.intravita.proyectointranet.controlador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.intravita.proyectointranet.modelo.Administrador;
import com.intravita.proyectointranet.modelo.Publicacion;
import com.intravita.proyectointranet.modelo.Usuario;
import com.intravita.proyectointranet.persistencia.AdministradorDAOImpl;
import com.intravita.proyectointranet.persistencia.PublicacionDAOImpl;
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
	PublicacionDAOImpl publicacionDao=new PublicacionDAOImpl();
	
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
	
	@RequestMapping(value="/irCrearPublicacion",method = RequestMethod.GET)
	public ModelAndView irCrearPublicacion(HttpServletResponse response,HttpServletRequest request){
		return cambiarVista("usuario/crearPublicacion");
	}
	
	@RequestMapping(value="/irVerPublicaciones",method = RequestMethod.GET)
	public ModelAndView irVerPublicaciones(HttpServletResponse response,HttpServletRequest request){
		
		return cambiarVista("usuario/verPublicaciones");
	}
	
	/***
	 * 
	 *@method ejecucion cuando pulsamos el boton login
	 *
	 */
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String iniciarSesion(HttpServletResponse response, HttpServletRequest request, Model model) throws Exception {
		String cadenaUrl="usuario/";
		String nombre=request.getParameter("txtUsuarioNombre");
		String clave=request.getParameter("txtUsuarioClave");
		if(clave=="" || nombre=="") {
			model.addAttribute("alerta", "Por favor rellene los campos" );
			return cadenaUrl+="login";
		}
		Administrador administrador= new Administrador();
		administrador.setNombre(nombre);
		administrador.setClave(clave);
		if(administradorDao.login(administrador) && request.getSession().getAttribute("administradorConectado")==null) {
			request.getSession().setAttribute("administradorConectado", administrador);
			return cadenaUrl+="inicioAdmin";
		}
			
		
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setClave(clave);
		if(usuarioDao.login(usuario) && request.getSession().getAttribute("usuarioConectado")==null) {
			request.getSession().setAttribute("usuarioConectado", usuario);
			return cadenaUrl+="bienvenido";
		}
			
		model.addAttribute("alerta", "Error en las credenciales" );
		return cadenaUrl+="login";
	} 
	/***
	 * 
	 *@method ejecucion cuando pulsamos el boton logout
	 *
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public ModelAndView cerrarSesion(HttpServletResponse response, HttpServletRequest request) throws Exception {
		HttpSession sesion = request.getSession();
		System.out.println("-----------------------------");
		System.out.println("Sesion antes de invalidar: "+sesion);
		sesion.invalidate();
		System.out.println("Invalidamos la sesion: "+sesion);
		System.out.println("-----------------------------");
		return cambiarVista("usuario/login");
	}
	/***
	 * 
	 *@method ejecucion cuando pulsamos el boton de registro
	 *
	 */
	@RequestMapping(value="/registrar", method = RequestMethod.POST)
	public String registrar(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception  {
		String cadenaUrl="usuario/";
		String nombre=request.getParameter("txtUsuarioNombre");
		String email=request.getParameter("txtEmail");
		String pwd1=request.getParameter("txtUsuarioClave");
		String pwd2=request.getParameter("txtUsuarioClave1");
		
		try {
			utilidades.credencialesValidas(nombre, email, pwd1, pwd2);
		}catch(Exception e) {
			model.addAttribute("alerta", e.getMessage());
			return cadenaUrl+="registrar";
		}
		
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setEmail(email);
		usuario.setClave(pwd1);
		
		if(!usuarioDao.insert(usuario)) {
			model.addAttribute("alerta", "Nombre de usuario no disponible");
			return cadenaUrl+="registrar";
		}
		return cadenaUrl+="login";
	}
	/***
	 * 
	 *@method metodo de borrado de un usuario desde el administrador
	 *
	 */
	@RequestMapping(value="/borrar", method = RequestMethod.POST)
	public String borrar(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception  {
		String cadenaUrl="usuario/";
		String nombre=request.getParameter("txtUsuarioBorrar");
		Usuario usuario;
		if(nombre.equals("admin")) {
			model.addAttribute("alerta", "<t><h2><b> No puedes borrar al superadmin</b></h2>");
		}else {
			usuario=usuarioDao.selectNombre(nombre);
			if(usuario==null) {
				model.addAttribute("alerta", "<t><h2><b> No existe el usuario "+nombre+"</b></h2>");
			}else {
				usuarioDao.delete(usuario);
				administradorDao.delete(new Administrador(nombre));
			}

		}
		listarUsuario(request, response, model);
		cadenaUrl+="inicioAdmin";		
		return cadenaUrl;
	}
	
	/***
	 * 
	 *@method funcion del administrador de promover un usuario a admin
	 *
	 */
	@RequestMapping(value="/promover", method = RequestMethod.POST)
	public String promover(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception  {
		String cadenaUrl="usuario/";
		String nombre=request.getParameter("txtUsuarioPromover");
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);	
		usuario=usuarioDao.selectNombre(nombre);
		if(usuario!=null) {
			Administrador admin=new Administrador(usuario.getNombre(), usuario.getClave(), usuario.getEmail());
			administradorDao.insertSinEncrypt(admin);
		}else{
			model.addAttribute("alerta", "<t><h2><b>El usuario que intentas promover no existe</b></h2>");
		}
		listarUsuario(request, response, model);
		cadenaUrl+="inicioAdmin";		
		return cadenaUrl;
	}
	/***
	 * 
	 *@method funcion del administrador de degradar un admin a usuario
	 *
	 */
	@RequestMapping(value="/degradar", method = RequestMethod.POST)
	public String degradar(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception  {
		String cadenaUrl="usuario/";
		String nombre=request.getParameter("txtAdminDegradar");
		Administrador admin;
		if(nombre.equals("admin")) {
			model.addAttribute("alerta", "<t><h2><b>No puedes degradar al superadmin</b></h2>");
		}else {
			admin=administradorDao.selectNombre(nombre);
			if(admin==null)
				model.addAttribute("alerta", "<t><h2><b>El administrador que intentas degradar no existe</b></h2>");
			else {
				administradorDao.delete(admin);
			}
		}
		listarUsuario(request, response, model);
		cadenaUrl+="inicioAdmin";		
		return cadenaUrl;
	}
	
	//@RequestMapping(value="/eliminar", method = RequestMethod.GET)
	/***
	 * 
	 * @method actualiza la ventana de administrador para ver sus usuarios/administradores
	 * 
	 */
	@RequestMapping(value="/listarUsuario", method = RequestMethod.POST)
	public String listarUsuario(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception  {
		String cadenaUrl="usuario/";
		model.addAttribute("usuarios", usuarioDao.list());
		model.addAttribute("administradores", administradorDao.list());
		cadenaUrl+="inicioAdmin";		
		return cadenaUrl;
	}
	
	/***
	 * 
	 * @method permite crear una publicación por parte de un usuario
	 * 
	 */
	@RequestMapping(value="/crearPublicacion", method = RequestMethod.POST)
	public String crearPublicacion(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception  {
		String cadenaUrl="usuario/";
		//String nombre=request.getSession().getAttribute("usuarioConectado");
		Usuario usuario;
		usuario=(Usuario) request.getSession().getAttribute("usuarioConectado");
		
		
		String nombre=usuario.getNombre();
		
		model.addAttribute("usuario", usuarioDao.selectNombre(nombre));
		String texto=request.getParameter("txtIntroducirTexto");

		try {
			utilidades.publicacionValida(nombre, texto);
		}catch(Exception e) {
			model.addAttribute("alerta", e.getMessage());
			return cadenaUrl+="crearPublicacion";
		}
		
		Publicacion publicacion= new Publicacion();
		
		publicacion.setUsuario(usuario);
		publicacion.setTexto(texto);
		
		if(publicacionDao.existe(publicacion)) {
			model.addAttribute("alerta", "Nombre de usuario no disponible");
			return cadenaUrl+="crearPublicacion";
		}
		publicacionDao.insert(publicacion);
		return cadenaUrl+="bienvenido";
	}
	/***
	 * 
	 * @method permite ver las publicaciones realizadas por un usuario(de momento, luego cambiar a según la visibilidad y amigos)
	 * 
	 */
	@RequestMapping(value="/listarPublicacion", method = RequestMethod.POST)
	public String listarPublicacion(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception  {
		String cadenaUrl="usuario/";
		model.addAttribute("usuarios", usuarioDao.list());
		model.addAttribute("administradores", administradorDao.list());
		cadenaUrl+="inicioAdmin";		
		return cadenaUrl;
	}
	
	/***
	 * 
	 *@method cambiar a la ventana "bienvenido" desde la vista de usuario
	 *
	 */
	@RequestMapping(value="/bienvenido", method = RequestMethod.GET)
	public String bienvenido(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		return "usuario/bienvenido";
	}
	
	
	
	
	
	
	
	
	/***
	 * 
	 *@method Esta función sirve para controlar los cambios de vista por nombre(string)
	 *
	 */
	public ModelAndView cambiarVista(String nombreVista) {
		ModelAndView vista =new ModelAndView(nombreVista);
		return vista;
	}
}