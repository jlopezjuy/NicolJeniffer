package ar.com.clothes.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * 
 * @author MostroBook
 *
 */
@Entity
@Table(name = "Empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDEMPRESA")
	private Integer idEmpresa;
	@Column(name = "NOMBREEMPRESA")
	private String nombreEmpresa;
	@Column(name = "DOMICILIO")
	private String domicilio;
	@Column(name = "TELEFONO")
	private String telefono;
	@Column(name = "EMAIL")
	private String email;
	@OneToMany(mappedBy = "empresa", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	private Set<Cliente> clienteses = new HashSet<Cliente>(0);
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	private Set<Encargo> encargos = new HashSet<Encargo>(0);

	/**
	 * 
	 */
	public Empresa() {

	}

	/**
	 * @return the idEmpresa
	 */
	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	/**
	 * @param idEmpresa
	 *           the idEmpresa to set
	 */
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	/**
	 * @return the nombreEmpresa
	 */
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	/**
	 * @param nombreEmpresa
	 *           the nombreEmpresa to set
	 */
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
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
	 * @return the usuarios
	 */
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios
	 *           the usuarios to set
	 */
	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * @return the clienteses
	 */
	public Set<Cliente> getClienteses() {
		return clienteses;
	}

	/**
	 * @param clienteses
	 *           the clienteses to set
	 */
	public void setClienteses(Set<Cliente> clienteses) {
		this.clienteses = clienteses;
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
	 * 
	 */
	public String toString() {
		return "Id Empresa: " + idEmpresa + " Nombre de Empresa: " + nombreEmpresa;
	}

}
