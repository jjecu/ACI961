/* 
 * GenericServiceImpl.java 
 * 06/06/2013
 * Copyright 2013 TCS.
 * Todos los derechos reservados.
 */
package com.globaltech.domain.services.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.globaltech.domain.services.IGenericService;
import com.globaltech.soagovernance.persistence.dao.IBasicDao;
import com.globaltech.soagovernance.persistence.error.GlobaltechPersistenceError;

/**
 * <b> Implementacion del contrato generico. </b>
 * 
 * @author Martin Mena
 * @version $1.0$
 */
@Stateless
public class GenericServiceImpl<T> implements IGenericService<T> {
	
	private static final Logger LOG = Logger.getLogger(GenericServiceImpl.class);

	@EJB(mappedName = "IBasicDaoImpl/local")
	protected IBasicDao<T> basicDao;

	/* (non-Javadoc)
	 * @see com.globaltech.domain.test.services.IGenericService#guardar(java.lang.Object)
	 */
	public boolean guardar(T t) throws GlobaltechPersistenceError {
		return basicDao.persist(t);
	}

	/* (non-Javadoc)
	 * @see com.globaltech.domain.test.services.IGenericService#actualizar(java.lang.Object)
	 */
	public T actualizar(T t) throws GlobaltechPersistenceError {
		return basicDao.update(t);
	}

	/* (non-Javadoc)
	 * @see com.globaltech.domain.test.services.IGenericService#eliminar(java.lang.Object)
	 */
	public boolean eliminar(T t) throws GlobaltechPersistenceError {
		return basicDao.delete(t);
	}
}
