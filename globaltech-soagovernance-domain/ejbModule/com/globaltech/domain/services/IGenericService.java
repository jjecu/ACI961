/**
 * 
 */
package com.globaltech.domain.services;

import java.util.List;

import javax.ejb.Local;

/**
 * @author smmenam
 */
@Local
public interface IGenericService<T> {
	public boolean guardar(T t);

	public T actualizar(T t);

	public boolean eliminar(T t);

	public List<T> buscarTodos();

	public T buscarPorId(String id);
}
