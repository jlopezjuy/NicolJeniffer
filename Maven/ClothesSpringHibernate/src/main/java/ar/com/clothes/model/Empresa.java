package ar.com.clothes.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * 
 * @author MostroBook
 *
 */
@Entity
@Table(name="EMPRESA")
public class Empresa {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEmpresa;
	@Column (name = "NOMBREEMPRESA")
	private String nombreEmpresa;
	@Column(name = "DOMICILIO")
	private String domicilio;
	@Column (name = "TELEFONO")
	private String telefono;
	@Column (name = "EMAIL")
	private String email;
	@OneToMany(fetch = FetchType.LAZY, mappedBy="empresa")
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);
	//private Set clienteses = new HashSet(0);
	
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
	 * @param idEmpresa the idEmpresa to set
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
	 * @param nombreEmpresa the nombreEmpresa to set
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
	 * @param domicilio the domicilio to set
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
	 * @param telefono the telefono to set
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
	 * @param email the email to set
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
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String toString(){
		return "Id Empresa: " + idEmpresa + " Nombre de Empresa: "+ nombreEmpresa;
	}
	
}
