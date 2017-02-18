package ar.com.clothes.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author MostroBook
 *
 */
@Entity
@Table(name = "CLIENTES")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idClientes;
	@ManyToOne(optional = false)
	@JoinColumn(name = "EMPRESA_IDEMPRESA", nullable = false)
	private Empresa empresa;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "APELLIDO")
	private String apellido;
	@Column(name = "CELULAR")
	private String celular;
	@Column(name = "TELEFONO")
	private String telefono;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "DOMICILIO")
	private String domicilio;
	@Column(name = "COLEGIO")
	private String colegio;
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private Set<Encargo> encargos = new HashSet<Encargo>(0);
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private Set<Medida> medidas = new HashSet<Medida>(0);
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private Set<Modelo> modelos = new HashSet<Modelo>(0);

	// private Set fechapruebas = new HashSet(0);

	public Cliente() {

	}

	public String toString() {
		return "Cliente id: " + idClientes + " Nombre de Cliente: " + nombre;
	}

	/**
	 * @return the idClientes
	 */
	public Integer getIdClientes() {
		return idClientes;
	}

	/**
	 * @param idClientes
	 *           the idClientes to set
	 */
	public void setIdClientes(Integer idClientes) {
		this.idClientes = idClientes;
	}

	/**
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa
	 *           the empresa to set
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *           the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido
	 *           the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @param celular
	 *           the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono
	 *           the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *           the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the domicilio
	 */
	public String getDomicilio() {
		return domicilio;
	}

	/**
	 * @param domicilio
	 *           the domicilio to set
	 */
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	/**
	 * @return the colegio
	 */
	public String getColegio() {
		return colegio;
	}

	/**
	 * @param colegio
	 *           the colegio to set
	 */
	public void setColegio(String colegio) {
		this.colegio = colegio;
	}

	/**
	 * @return the encargos
	 */
	public Set<Encargo> getEncargos() {
		return encargos;
	}

	/**
	 * @param encargos
	 *           the encargos to set
	 */
	public void setEncargos(Set<Encargo> encargos) {
		this.encargos = encargos;
	}

	/**
	 * @return the medidas
	 */
	public Set<Medida> getMedidas() {
		return medidas;
	}

	/**
	 * @param medidas
	 *           the medidas to set
	 */
	public void setMedidas(Set<Medida> medidas) {
		this.medidas = medidas;
	}

	/**
	 * @return the modelos
	 */
	public Set<Modelo> getModelos() {
		return modelos;
	}

	/**
	 * @param modelos
	 *           the modelos to set
	 */
	public void setModelos(Set<Modelo> modelos) {
		this.modelos = modelos;
	}

}
