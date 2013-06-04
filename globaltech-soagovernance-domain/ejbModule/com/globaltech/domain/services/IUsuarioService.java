/**
 * 
 */
package com.globaltech.domain.services;

import javax.ejb.Local;

import com.globaltech.domain.entities.Usuario;

/**
 * @author smmenam
 *
 */
@Local
public interface IUsuarioService {
	public void guardar(Usuario usuario);
}
