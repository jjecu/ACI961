/**
 * 
 */
package com.globaltech.soagovernance.persistence.dao.Impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.globaltech.soagovernance.persistence.dao.IBasicDao;

/**
 * @author martin
 * @param <T>
 *
 */
@Stateless
public class IBasicDaoImpl<T> implements IBasicDao<T>{
	
	@PersistenceContext
	private EntityManager entityManager;

	public boolean persist(T t) {
		
		try {
			entityManager.persist(t);
			return true;
		} catch (Exception e) {
			//reemplazar con log4j
			e.printStackTrace();
			return false;
		}
	}

	public T update(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(T t) {
		// TODO Auto-generated method stub
		return false;
	}

}
