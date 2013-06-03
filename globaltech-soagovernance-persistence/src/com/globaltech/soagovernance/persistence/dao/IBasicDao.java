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

	public boolean persist(T t);

	public T update(T t);

	public boolean delete(T t);

}
