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
	 */
	public static boolean credencialesValidas(String nombre, String email, String pwd1, String pwd2) {
		if(email.length()<=extensionEmail.length())
			return false;
		String extension=email.substring(email.length()-extensionEmail.length(), email.length());
		if(!extension.equals(extensionEmail))
			return false;
		return pwd1.equals(pwd2);
	}
}
