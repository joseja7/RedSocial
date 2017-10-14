package cucumberJava;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import dominio.Usuario;

public class annotation {
	/***
	 * 
	 * Tarea de creacion de usuario
	 * 
	 */
	
	private Usuario user2;
	
	@Given("^Usuario en pagina de creacion$")
	public void Usuario_en_pagina_de_creacion() {
		user2=new Usuario();
	}

	@When("^\"([^\"]*)\" correcto$")
	public void correcto(String nombre) {
		nombre="CreacionCuenta";
		user2.setNombre(nombre);
	}

	@When("^\"([^\"]*)\" y \"([^\"]*)\" coinciden$")
	public void y_coinciden(String pwd1, String pwd2) {
		pwd1="1234";
		pwd2="1234";
		assertTrue(pwd1==pwd2);
		user2.setPwd(pwd1);

	}

	@Then("^Mensaje de validacion y usuario insertado$")
	public void Mensaje_de_validacion_y_usuario_insertado() {
		user2.insert();
		assertTrue(user2.login());
	}

	@When("^\"([^\"]*)\" y \"([^\"]*)\" no coinciden$")
	public void y_no_coinciden(String pwd1, String pwd2) {
		pwd1="1234";
		pwd2="1235";
		assertFalse(pwd1==pwd2);
		user2.setNombre("Userdeprueba");
		user2.setPwd(pwd2);
	}
	@Then("^Mensaje de error(\\d+)$")
	public void Mensaje_de_error(int arg1) {
		assertFalse(user2.login());
	}
	/***
	 * 
	 * Tarea de entrada al sistema
	 * 
	 */
	private Usuario user;
	@Given("^Usuario en pagina de login$")
	public void Usuario_en_pagina_de_login() {
		user=new Usuario();
	}

	@When("^Pone nombre de \"([^\"]*)\" y \"([^\"]*)\" validos$")
	public void Pone_nombre_de_y_validos(String nombre, String pwd) {
		nombre="EntradaCuenta";
		pwd="1234";
		this.user.setNombre(nombre);
		this.user.setPwd(pwd);
		user.insert();
	}
	@Then("^llegamos a la pagina inicial y un mensaje de bienvenida$")
	public void llegamos_a_la_pagina_inicial_y_un_mensaje_de_bienvenida() {
		assertTrue(user.login());
	}

	@When("^Pone nombre de \"([^\"]*)\" y/o \"([^\"]*)\" invalidos$")
	public void Pone_nombre_de_y_o_invalidos(String nombreNO, String pwdNO) {
		nombreNO="NOEXISTE";
		pwdNO="NOEXISTE";
		this.user.setNombre(nombreNO);
		this.user.setPwd(pwdNO);
	}

	@Then("^Mensaje de error$")
	public void Mensaje_de_error() {
		assertFalse(user.login());
	}
	


	/***
	 * 
	 * Borrado de cuenta
	 * 
	 */
	private Usuario user3;
	@Given("^Usuario en pagina de borrado$")
	public void Usuario_en_pagina_de_borrado() {
		user3=new Usuario();
		user3.setNombre("BorradoCuenta");
	}
	
	@When("^\"([^\"]*)\" y \"([^\"]*)\" coinciden y son validos$")
	public void y_coinciden_y_son_validos(String pwd1, String pwd2) {
		pwd1="1234";
		pwd2="1234";
		assertTrue(pwd1==pwd2);
		user3.setPwd(pwd1);
		user3.insert();
		assertTrue(user3.login());
	}	

	@Then("^Mensaje de exito y delete del usuario$")
	public void Mensaje_de_exito_y_delete_del_usuario() {
		user3.delete();
		assertFalse(user3.login());
	}

	@Given("^Usuario en pagina de$")
	public void Usuario_en_pagina_de() {
		user3=new Usuario();
		user3.setNombre("BorradoCuenta");
	}
	@When("^\"([^\"]*)\" y \"([^\"]*)\" no coinciden o son invalidos$")
	public void y_no_coinciden_o_son_invalidos(String pwd1, String pwd2) {
		pwd1="1234";
		pwd2="12345";
		assertFalse(pwd1==pwd2);
		pwd1="12345";
		user3.setPwd(pwd1);
		assertFalse(user3.login());
	}

	@Then("^Mensaje de error y cancelacion del borrado$")
	public void Mensaje_de_error_y_cancelacion_del_borrado() {
	}
}
