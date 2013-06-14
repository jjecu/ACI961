/* 
 * GlobaltechPersistenceError.java 
 * 07/06/2013
 * Copyright 2013 TCS.
 * Todos los derechos reservados.
 */
package com.globaltech.soagovernance.persistence.error;

/**
 * <b> Excepcion personalizada para usar en la capa de persistencia. </b>
 * 
 * @author Martin Mena
 * @version $1.0$
 */
public class GlobaltechPersistenceError extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3444865401275567343L;

	/**
	 * @param message String que contiene el mensaje de error
	 * @param cause Error que causo que este error se lance
	 */
	public GlobaltechPersistenceError(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message String que contiene el mensaje de error
	 */
	public GlobaltechPersistenceError(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
