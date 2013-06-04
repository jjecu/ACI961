/**
 * 
 */
package com.globaltech.domain.services;

import javax.ejb.Local;

import com.globaltech.domain.entities.Cliente;

/**
 * @author smmenam
 *
 */
@Local
public interface IClienteService {
	public void guardar(Cliente cliente);
}
