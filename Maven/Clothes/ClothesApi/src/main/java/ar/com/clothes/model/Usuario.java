package ar.com.clothes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author MostroBook
 *
 */
@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6189232344370439271L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDUSUARIO")
	private Integer idUsuario;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPRESA_IDEMPRESA", nullable = false)
	@JsonIgnoreProperties(ignoreUnknown = true, value = "usuarios")
	private Empresa empresa;
	@Column(name = "NOMBREUSUARIO", nullable = false)
	private String nombreUsuario;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "NOMBREAPELLIDO")
	private String nombreApellido;

	// private Set usuariorols = new HashSet(0);

	/**
	 * 
	 */
	public Usuario() {

	}

	/**
	 * @return the idUsuario
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario
	 *           the idUsuario to set
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario
	 *           the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *           the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the nombreApellido
	 */
	public String getNombreApellido() {
		return nombreApellido;
	}

	/**
	 * @param nombreApellido
	 *           the nombreApellido to set
	 */
	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	/**
	 * 
	 */
	public String toString() {
		return "Id Usuario: " + idUsuario + " Nombre de Usuario: " + nombreUsuario + " Nombre y Apellido: " + nombreApellido + " Empresa id: " + empresa.getIdEmpresa();
	}
}
