package e.dominio.entity;

// Generated 28/10/2016 11:29:40 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import e.base.dominio.DominioBaseNombre;

/**
 * Clientes generated by hbm2java
 */
@Entity
@Table(name = "clientes", catalog = "nicolejeniffer")
public class Clientes extends DominioBaseNombre {

	private int idClientes;
	private String nombre;
	private String apellido;
	private String celular;
	private String telefono;
	private String email;
	private String domicilio;
	private String colegio;
	private Set encargoses = new HashSet(0);
	private Set medidases = new HashSet(0);
	private Set modeloses = new HashSet(0);

	public Clientes() {
	}

	public Clientes(int idClientes) {
		this.idClientes = idClientes;
	}

	public Clientes(int idClientes, String nombre, String apellido,
			String celular, String telefono, String email, String domicilio,
			String colegio, Set encargoses, Set medidases, Set modeloses) {
		this.idClientes = idClientes;
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.telefono = telefono;
		this.email = email;
		this.domicilio = domicilio;
		this.colegio = colegio;
		this.encargoses = encargoses;
		this.medidases = medidases;
		this.modeloses = modeloses;
	}

	@Id
	@Column(name = "idClientes", unique = true, nullable = false)
	public int getIdClientes() {
		return this.idClientes;
	}

	public void setIdClientes(int idClientes) {
		this.idClientes = idClientes;
	}

	@Column(name = "Nombre", length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "Apellido", length = 45)
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Column(name = "Celular", length = 45)
	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Column(name = "Telefono", length = 45)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name = "Email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Domicilio", length = 45)
	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	@Column(name = "Colegio", length = 45)
	public String getColegio() {
		return this.colegio;
	}

	public void setColegio(String colegio) {
		this.colegio = colegio;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clientes")
	public Set getEncargoses() {
		return this.encargoses;
	}

	public void setEncargoses(Set encargoses) {
		this.encargoses = encargoses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clientes")
	public Set getMedidases() {
		return this.medidases;
	}

	public void setMedidases(Set medidases) {
		this.medidases = medidases;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clientes")
	public Set getModeloses() {
		return this.modeloses;
	}

	public void setModeloses(Set modeloses) {
		this.modeloses = modeloses;
	}

}
