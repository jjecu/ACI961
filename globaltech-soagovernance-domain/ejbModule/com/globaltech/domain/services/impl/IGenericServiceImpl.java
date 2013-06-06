/* 
 * IGenericServiceImpl.java 
 * 06/06/2013
 * Copyright 2013 TCS.
 * Todos los derechos reservados.
 */
package com.globaltech.domain.services.impl;

import java.util.List;

import javax.ejb.EJB;

import com.globaltech.domain.services.IGenericService;
import com.globaltech.soagovernance.persistence.dao.IBasicDao;

/**
 * <b> Descripcion de la clase, interface o enumeracion. </b>
 * @author smmenam
 *
 * @version $1.0$
 */
public class IGenericServiceImpl<T> implements IGenericService<T> {
	
	@EJB(mappedName = "IBasicDaoImpl/local")
	private IBasicDao<T> basicDao;

	public boolean guardar(T t) {
		try {
			basicDao.persist(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public T actualizar(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean eliminar(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<T> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public T buscarPorId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
