/* 
 * IUsuarioServiceRemote.java 
 * 06/06/2013
 * Copyright 2013 TCS.
 * Todos los derechos reservados.
 */
package com.globaltech.domain.services.remote;

import javax.ejb.Remote;

import com.globaltech.domain.entities.Usuario;

/**
 * <b> Descripcion de la clase, interface o enumeracion. </b>
 * @author smmenam
 *
 * @version $1.0$
 */
@Remote
public interface IUsuarioServiceRemote {
	public void guardar(Usuario usuario);
}
