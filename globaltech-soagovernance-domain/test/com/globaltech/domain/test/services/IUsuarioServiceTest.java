/* 
 * IUsuarioServiceTest.java 
 * 06/06/2013
 * Copyright 2013 TCS.
 * Todos los derechos reservados.
 */
package com.globaltech.domain.test.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.globaltech.domain.entities.Usuario;
import com.globaltech.domain.services.remote.IUsuarioServiceRemote;
import com.globaltech.soagovernance.persistence.error.GlobaltechPersistenceError;

/**
 * <b> Descripcion de la clase, interface o enumeracion. </b>
 * 
 * @author smmenam
 * @version $1.0$
 */
public class IUsuarioServiceTest {
	private static final Logger LOG = Logger.getLogger(IUsuarioServiceTest.class);
	private IUsuarioServiceRemote usuarioDao = null;

	@Before
	public void init() {

		InitialContext context = null;
		Properties properties = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try {
			InputStream stream = loader.getResourceAsStream("jndi.properties");
			properties.load(stream);
			Assert.assertEquals("org.jnp.interfaces.NamingContextFactory",
					properties.getProperty("java.naming.factory.initial"));
		} catch (IOException e) {
			LOG.error("Error al cargar el archivo properties", e);
			Assert.fail();
		}
		try {
			context = new InitialContext(properties);
			usuarioDao = (IUsuarioServiceRemote) context.lookup("UsuarioServiceImpl/remote");
		} catch (NamingException e) {
			LOG.error("Error al obtener el jndi UsuarioDaoImpl/remote", e);
			Assert.fail();
		}
		Assert.assertNotNull(usuarioDao);
	}

	//@Test
	public void crearYBuscarUsuarioTest() {
		Usuario usuario = new Usuario();
		try {

			usuario.setApellido("Prueba");
			usuario.setCargo("Analista");
			// Random random = new Random();
			usuario.setCedula(generarCedula());
			LOG.info("cedula creada: " + usuario.getCedula());
			usuario.setNombre("Prueba");
			LOG.info("UsuarioService: " + usuarioDao.toString());
			boolean respuesta = usuarioDao.guardar(usuario);
			Assert.assertTrue(respuesta);
		} catch (GlobaltechPersistenceError e) {
			LOG.error("Error al guardar", e);
			Assert.fail();
		}

		// buscar por id
		try {
			Usuario usuarioResultado = usuarioDao.buscarPorId(usuario.getCedula());
			Assert.assertNotNull(usuarioResultado);
		} catch (GlobaltechPersistenceError e) {
			LOG.error("Error al buscar", e);
			Assert.fail();
		}
	}

	private String generarCedula() {
		StringBuilder cedula = new StringBuilder("1");
		for (int i = 1; i <= 9; i++) {
			cedula.append(String.valueOf((int) (Math.random() * 10)));
		}
		return cedula.toString();
	}
	
	@Test
	public void buscarPorIdTest() {
		try {
			Usuario usuarioResultado = usuarioDao.buscarPorId("1111111111");
			Assert.assertNotNull(usuarioResultado);
		} catch (GlobaltechPersistenceError e) {
			LOG.error("Error al buscar", e);
			Assert.fail();
		}
	}
}
