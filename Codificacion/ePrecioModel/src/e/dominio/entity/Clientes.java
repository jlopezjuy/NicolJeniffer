package e.dominio.entity;

// Generated 01-oct-2015 15:21:07 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import e.base.dominio.DominioBase;

/**
 * Clientes generated by hbm2java
 */
public class Clientes extends DominioBase {

	private int idClientes;
	private String nombre;
	private String apellido;
	private String celular;
	private String telefono;
	private String email;
	private String domicilio;
	private Set medidases = new HashSet(0);
	private Set modeloses = new HashSet(0);

	public Clientes() {
	}

	public Clientes(int idClientes) {
		this.idClientes = idClientes;
	}

	public Clientes(int idClientes, String nombre, String apellido,
			String celular, String telefono, String email, String domicilio,
			Set medidases, Set modeloses) {
		this.idClientes = idClientes;
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.telefono = telefono;
		this.email = email;
		this.domicilio = domicilio;
		this.medidases = medidases;
		this.modeloses = modeloses;
	}

	public int getIdClientes() {
		return this.idClientes;
	}

	public void setIdClientes(int idClientes) {
		this.idClientes = idClientes;
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

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Set getMedidases() {
		return this.medidases;
	}

	public void setMedidases(Set medidases) {
		this.medidases = medidases;
	}

	public Set getModeloses() {
		return this.modeloses;
	}

	public void setModeloses(Set modeloses) {
		this.modeloses = modeloses;
	}

}