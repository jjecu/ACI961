/**
 * 
 */
package com.globaltech.domain.services.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.globaltech.domain.entities.Usuario;
import com.globaltech.domain.services.IGenericService;
import com.globaltech.soagovernance.persistence.dao.IBasicDao;

/**
 * @author smmenam
 *
 */
@Stateless
public class UsuarioServiceImpl {
	
	@EJB(mappedName = "IBasicDaoImpl/local")
	private IBasicDao<Usuario> basicDao;

	public void guardar(Usuario usuario) {
		try {
			basicDao.persist(usuario);
		} catch (Exception e) {
			// TODO reemplazar con log4j, arrojar una excepcion personalizada
			e.printStackTrace();
		}
		
	}

}
