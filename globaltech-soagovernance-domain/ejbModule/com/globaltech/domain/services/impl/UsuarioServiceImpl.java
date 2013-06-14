/**
 * 
 */
package com.globaltech.domain.services.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.globaltech.domain.entities.Usuario;
import com.globaltech.domain.services.IUsuarioService;
import com.globaltech.domain.services.remote.IUsuarioServiceRemote;
import com.globaltech.soagovernance.persistence.error.GlobaltechPersistenceError;

/**
 * <b> Clase que implementa el contrato IUsuarioServiceRemote </b>
 * 
 * @author Martin Mena
 * @version $1.0$
 */
@Stateless
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario> implements IUsuarioService, IUsuarioServiceRemote {

	private static final Logger LOG = Logger.getLogger(UsuarioServiceImpl.class);
	/* (non-Javadoc)
	 * @see com.globaltech.domain.test.services.IGenericService#buscarTodos()
	 */
	public List<Usuario> buscarTodos() throws GlobaltechPersistenceError {
		return basicDao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.globaltech.domain.test.services.IGenericService#buscarPorId(java.lang.String)
	 */
	public Usuario buscarPorId(String id) throws GlobaltechPersistenceError {
		Type type = getClass().getGenericSuperclass();
		Class<Usuario> entityClass;
		if (type instanceof ParameterizedType) {
			entityClass = (Class<Usuario>) ((ParameterizedType) type).getActualTypeArguments()[0];
		} else {
			entityClass = (Class<Usuario>) type;
		}
		//LOG.info("GenericServiceImpl class: " + entityClass);
		LOG.info("genericSuperClass: " + type);
		LOG.info("basicDao: " + basicDao.getClass().getGenericSuperclass());
		return basicDao.findById(id);
	}
	
}
