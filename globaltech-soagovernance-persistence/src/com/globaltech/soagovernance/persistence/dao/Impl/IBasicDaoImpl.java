/**
 * 
 */
package com.globaltech.soagovernance.persistence.dao.Impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.globaltech.soagovernance.persistence.dao.IBasicDao;
import com.globaltech.soagovernance.persistence.error.GlobaltechPersistenceError;

/**
 * @author martin
 * @param <T>
 */
@Stateless
public class IBasicDaoImpl<T> implements IBasicDao<T> {
	
	private static final Logger LOG = Logger.getLogger(IBasicDaoImpl.class);

	@PersistenceContext(unitName = "globaltech-soagovernance-persistence")
	protected EntityManager entityManager;
	protected Class<T> entityClass;

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public IBasicDaoImpl() {
		Type type = getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			this.entityClass = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
		} else {
			this.entityClass = (Class<T>) type;
		}
		// ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		// entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}

	/*
	 * (non-Javadoc)
	 * @see com.globaltech.soagovernance.persistence.dao.IBasicDao#persist(java.lang.Object)
	 */
	public boolean persist(T t) throws GlobaltechPersistenceError {

		try {
			entityManager.persist(t);
			return true;
		} catch (EntityExistsException e) {
			throw new GlobaltechPersistenceError("La entidad ya existe", e);
		} catch (IllegalArgumentException e) {
			throw new GlobaltechPersistenceError("La entidad no es valida: " + t.getClass().getName(), e);
		} catch (NullPointerException e) {
			throw new GlobaltechPersistenceError("Entidad nula", e);
		} catch (Exception e) {
			throw new GlobaltechPersistenceError("Excepcion no controlada", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.globaltech.soagovernance.persistence.dao.IBasicDao#update(java.lang.Object)
	 */
	public T update(T t) throws GlobaltechPersistenceError {
		try {
			return entityManager.merge(t);
		} catch (IllegalArgumentException e) {
			throw new GlobaltechPersistenceError("La entidad no es valida", e);
		} catch (NullPointerException e) {
			throw new GlobaltechPersistenceError("Entidad nula", e);
		} catch (Exception e) {
			throw new GlobaltechPersistenceError("Excepcion no controlada", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.globaltech.soagovernance.persistence.dao.IBasicDao#delete(java.lang.Object)
	 */
	public boolean delete(T t) throws GlobaltechPersistenceError {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see com.globaltech.soagovernance.persistence.dao.IBasicDao#findById(java.lang.String)
	 */
	public T findById(String id) throws GlobaltechPersistenceError {
		if (id == null || id.equals("")) {
			throw new GlobaltechPersistenceError("El id a buscar no puede ser nulo o vacio");
		}
		LOG.info("entityClass: " + getClass());
		try {
			return entityManager.find(entityClass, id);
		} catch (IllegalStateException e) {
			throw new GlobaltechPersistenceError("El EntityManager se cerro antes de cumplir la busqueda", e);
		} catch (IllegalArgumentException e) {
			throw new GlobaltechPersistenceError("La clase enviada: " + entityClass.getName()
					+ ", y/o la clave primaria: " + id + " no son validas", e);
		} catch (Exception e) {
			throw new GlobaltechPersistenceError("Excepcion no controlada", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.globaltech.soagovernance.persistence.dao.IBasicDao#findAll()
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll() throws GlobaltechPersistenceError {
		try {
			Query query = entityManager.createQuery("select e from " + entityClass.getSimpleName());
			return query.getResultList();
		} catch (IllegalStateException e) {
			throw new GlobaltechPersistenceError("El EntityManager se cerro antes de cumplir la busqueda", e);
		} catch (Exception e) {
			throw new GlobaltechPersistenceError("Excepcion no controlada", e);
		}
	}

}
