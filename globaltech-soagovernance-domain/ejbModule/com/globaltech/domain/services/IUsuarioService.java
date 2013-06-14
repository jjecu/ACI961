/* 
 * IUsuarioServiceRemote.java 
 * 12/06/2013
 * Copyright 2013 TCS.
 * Todos los derechos reservados.
 */
package com.globaltech.domain.services;

import java.util.List;

import javax.ejb.Local;

import com.globaltech.domain.entities.Usuario;
import com.globaltech.soagovernance.persistence.error.GlobaltechPersistenceError;

/**
 * <b> Contrato que extiende del servicio generico para trabajr con la tabla de Usuario. </b>
 * 
 * @author Martin Mena
 * @version $1.0$
 */
@Local
public interface IUsuarioService extends IGenericService<Usuario> {
	/**
	 * <b> Metodo que se conecta con la capa de persistencia para obtener todos los registros de la tabla USUARIO. </b>
	 * <p>
	 * [Author Martin Mena, 12/06/2013]
	 * </p>
	 * 
	 * @return Lista de los usuarios encontrados
	 * @throws GlobaltechPersistenceError En caso de haber algun error
	 */
	List<Usuario> buscarTodos() throws GlobaltechPersistenceError;

	/**
	 * <b> Metodo que se conecta con la capa de persistencia para obtener usuarios mediante la clave primaria (cedula). </b>
	 * <p>
	 * [Author Martin Mena, 12/06/2013]
	 * </p>
	 * 
	 * @param id Clave primaria (cedula) del usuario a buscar
	 * @return El usuario encontrado
	 * @throws GlobaltechPersistenceError En caso de haber algun error
	 */
	Usuario buscarPorId(String id) throws GlobaltechPersistenceError;
}
