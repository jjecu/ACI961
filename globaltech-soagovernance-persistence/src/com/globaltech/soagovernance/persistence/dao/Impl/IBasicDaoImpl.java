/**
 * 
 */
package com.globaltech.soagovernance.persistence.dao.Impl;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.globaltech.soagovernance.persistence.dao.IBasicDao;

/**
 * @author martin
 * @param <T>
 */
@Stateless
public class IBasicDaoImpl<T> implements IBasicDao<T> {

	@PersistenceContext
	private EntityManager entityManager;
	

	public boolean persist(T t) throws Exception {

		try {
			entityManager.persist(t);
			return true;
		} catch (EntityExistsException e) {
			throw new EntityExistsException("La entidad ya existe");
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("La entidad no es valida");
		} catch (NullPointerException e) {
			throw new NullPointerException("Entidad nula");
		} catch (Exception e) {
			throw new Exception("Excepcion no controlada");
		}
	}

	public T update(T t) throws Exception {
		try {
			return entityManager.merge(t);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("La entidad no es valida");
		} catch (NullPointerException e) {
			throw new NullPointerException("Entidad nula");
		} catch (Exception e) {
			throw new Exception("Excepcion no controlada");
		}
	}

	public boolean delete(T t) throws Exception{
		// TODO Auto-generated method stub
		return false;
	}

	public T findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
