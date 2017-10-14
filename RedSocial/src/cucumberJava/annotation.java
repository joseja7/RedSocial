package cucumberJava;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import dominio.Usuario;

public class annotation {
	private Usuario user;
	@Given("^Usuario en pagina de login$")
	public void Usuario_en_pagina_de_login() {
		user=new Usuario();
	}

	@When("^Pone nombre de \"([^\"]*)\" y \"([^\"]*)\" validos$")
	public void Pone_nombre_de_y_validos(String nombre, String pwd) {
		nombre="Duki";
		pwd="1234";
		this.user.setNombre(nombre);
		this.user.setPwd(pwd);
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
}
