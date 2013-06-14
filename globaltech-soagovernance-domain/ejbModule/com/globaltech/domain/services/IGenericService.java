/**
 * 
 */
package com.globaltech.domain.services;

import java.util.List;

import javax.ejb.Local;

import com.globaltech.soagovernance.persistence.error.GlobaltechPersistenceError;

/**
 * <b> Contrato generico para la capa de presentacion para poder realizar operaciones sobre las entidades de la BDD.
 * </b>
 * 
 * @author Martin Mena
 * @param <T> Clase que va a ser usada en este contrato
 * @version $1.0$
 */
@Local
public interface IGenericService<T> {

	/**
	 * <b> Metodo que se conecta con la capa de persistencia para guardar registros en la bdd. </b>
	 * <p>
	 * [Author Martin Mena, 12/06/2013]
	 * </p>
	 * 
	 * @param t Objeto a guardar en la bdd
	 * @return True si la operacion fue exitosa
	 * @throws GlobaltechPersistenceError En caso de haber algun error
	 */
	boolean guardar(T t) throws GlobaltechPersistenceError;

	/**
	 * <b> Metodo que se conecta con la capa de persistencia para actualizar registros en la bdd. </b>
	 * <p>
	 * [Author Martin Mena, 12/06/2013]
	 * </p>
	 * 
	 * @param t Objeto a actualizar
	 * @return El objeto actualizado
	 * @throws GlobaltechPersistenceError En caso de haber algun error
	 */
	T actualizar(T t) throws GlobaltechPersistenceError;

	/**
	 * <b> Metodo que se conecta con la capa de persistencia para eliminar registros en la bdd. </b>
	 * <p>
	 * [Author Martin Mena, 12/06/2013]
	 * </p>
	 * 
	 * @param t Objeto a eliminar
	 * @return true si la operacion se realizo con exito
	 * @throws GlobaltechPersistenceError En caso de haber algun error
	 */
	boolean eliminar(T t) throws GlobaltechPersistenceError;

}
