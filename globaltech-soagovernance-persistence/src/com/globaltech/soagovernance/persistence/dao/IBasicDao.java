/**
 * 
 */
package com.globaltech.soagovernance.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import com.globaltech.soagovernance.persistence.error.GlobaltechPersistenceError;

/**
 * @author martin
 * 
 */
@Local
public interface IBasicDao<T> {

	/**
	 * <b> Metodo que inserta registros en la BDD. </b>
	 * <p>
	 * [Author Martin Mena, 12/06/2013]
	 * </p>
	 *
	 * @param t Objeto a ser insertado
	 * @return True si se inserto con exito
	 * @throws GlobaltechPersistenceError Por si sucedio algun error al insertar
	 */
	boolean persist(T t) throws GlobaltechPersistenceError;

	/**
	 * <b> Metodo que actualiza registros en la BDD. </b>
	 * <p>
	 * [Author Martin Mena, 12/06/2013]
	 * </p>
	 *
	 * @param t Objeto a ser actualizado
	 * @return Objeto actualizado
	 * @throws GlobaltechPersistenceError Por si sucedio algun error al actualizar
	 */
	T update(T t) throws GlobaltechPersistenceError;

	/**
	 * <b> Metodo que elimina registros de la BDD. </b>
	 * <p>
	 * [Author Martin Mena, 12/06/2013]
	 * </p>
	 *
	 * @param t Objeto a ser eliminado
	 * @return True si la eliminacion se realizo con exito
	 * @throws GlobaltechPersistenceError Por si sucedio algun error al eliminar
	 */
	boolean delete(T t) throws GlobaltechPersistenceError;
	
	/**
	 * <b> Metodo que busca un objeto por su clave primaria. </b>
	 * <p>
	 * [Author Martin Mena, 12/06/2013]
	 * </p>
	 *
	 * @param id String que contiene la clave primaria del objeto a buscar
	 * @return El objeto encontrado
	 * @throws GlobaltechPersistenceError Por si sucedio algun error al buscar
	 */
	T findById(String id) throws GlobaltechPersistenceError;
	
	/**
	 * <b> Metodo que devuelve todos los registros de una tabla. </b>
	 * <p>
	 * [Author Martin Mena, 12/06/2013]
	 * </p>
	 *
	 * @return Lista de los objetos encontrados
	 * @throws GlobaltechPersistenceError Por si sucedio algun error al buscar
	 */
	List<T> findAll() throws GlobaltechPersistenceError;

}
