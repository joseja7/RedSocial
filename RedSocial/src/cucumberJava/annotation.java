package cucumberJava;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import junit.framework.Assert;

public class annotation {

	@Given("^Usuario en pagina de \"([^\"]*)\"$")
	public void Usuario_en_pagina_de(String arg1) {
		
	}

	@When("^\"([^\"]*)\" y \"([^\"]*)\" coinciden$")
	public void y_coinciden(String pwd1, String pwd2) {
		Assert.assertEquals(pwd1, pwd2);
	}

	@Then("^Mensaje de \"([^\"]*)\"$")
	public void Mensaje_de(String arg1) {
		System.out.println(arg1);
	}

	@Then("^Envio a la pagina de \"([^\"]*)\"$")
	public void Envio_a_la_pagina_de(String arg1) {
		
	}

	@When("^\"([^\"]*)\" y \"([^\"]*)\" no coinciden$")
	public void y_no_coinciden(String pwd1, String pwd2) {
		Assert.assertFalse(pwd1==pwd2);
	}

	@When("^\"([^\"]*)\" correcto$")
	public void correcto(String arg1) {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@When("^Usuario selecciona \"([^\"]*)\"$")
	public void Usuario_selecciona(String arg1) {

	}

	@When("^Pone nombre de \"([^\"]*)\" y \"([^\"]*)\" validos$")
	public void Pone_nombre_de_y_validos(String user, String pwd) {
		Assert.assertNotNull(UserDAO.select(user,pwd));
	}

	@Then("^llegamos a la pagina inicial y un \"([^\"]*)\" de bienvenida$")
	public void llegamos_a_la_pagina_inicial_y_un_de_bienvenida(String arg1) {
		System.out.println(arg1);
	}

	@When("^Pone nombre de \"([^\"]*)\" y/o \"([^\"]*)\" invalidos$")
	public void Pone_nombre_de_y_o_invalidos(String user, String pwd) {
		Assert.assertNull(UserDAO.select(user,pwd));
	}

	
}
