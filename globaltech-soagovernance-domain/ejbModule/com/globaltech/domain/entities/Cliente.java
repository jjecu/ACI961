package com.globaltech.domain.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Cliente
 * 
 */
@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable {

	@Id
	private String cedula;
	private String nombre;
	private String apellido;
	private String cargo;
	private static final long serialVersionUID = 1L;

	public Cliente() {
		super();
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
