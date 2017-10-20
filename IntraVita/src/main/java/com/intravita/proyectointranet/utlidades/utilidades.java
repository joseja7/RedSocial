package com.intravita.proyectointranet.utlidades;

public class utilidades {
	public static String extensionEmail="@alu.uclm.es";
	/**
	 * @method comprobacion de credenciales validas para el registro
	 * @param nombre
	 * @param email
	 * @param pwd1
	 * @param pwd2
	 * @return 
	 * @throws Exception 
	 */
	public static void credencialesValidas(String nombre, String email, String pwd1, String pwd2) throws Exception {
		if(!nombre.contains("."))
			throw new Exception("Formato nombre invalido");	
		
		if(nombre.equals("") ||email.equals("")|| pwd1.equals("")|| pwd2.equals(""))
			throw new Exception ("Por favor rellene todos los campos");
		
		if(email.length()<=extensionEmail.length())
			throw new Exception("Email invalido");
		String extension=email.substring(email.length()-extensionEmail.length(), email.length());
		
		if(!extension.equals(extensionEmail))
			throw new Exception("Email invalido");
		
		if(!pwd1.equals(pwd2))
			throw new Exception("No coinciden las password");
	}
}
