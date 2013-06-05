/**
 * 
 */
package com.globaltech.soagovernance.persistence.dao;

import javax.ejb.Local;

/**
 * @author martin
 * 
 */
@Local
public interface IBasicDao<T> {

	public boolean persist(T t) throws Exception;

	public T update(T t) throws Exception;

	public boolean delete(T t) throws Exception;
	
	public T findById(String id) throws Exception;

}
