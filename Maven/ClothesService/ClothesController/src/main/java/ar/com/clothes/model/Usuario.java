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
@Table(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	@ManyToOne(optional = false)
	@JoinColumn(name = "EMPRESA_IDEMPRESA", nullable = false)
	private Empresa empresa;
	@Column(name = "NOMBREUSUARIO", nullable = false)
	private String nombreUsuario;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "NOMBREAPELLIDO")
	private String nombreApellido;
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<UsuarioRol> usuarioRoles = new HashSet<UsuarioRol>();

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
	 * @return the usuarioRoles
	 */
	public Set<UsuarioRol> getUsuarioRoles() {
		return usuarioRoles;
	}

	/**
	 * @param usuarioRoles
	 *           the usuarioRoles to set
	 */
	public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
		this.usuarioRoles = usuarioRoles;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Usuario [" + (idUsuario != null ? "idUsuario=" + idUsuario + ", " : "") + (empresa != null ? "empresa=" + empresa + ", " : "")
				+ (nombreUsuario != null ? "nombreUsuario=" + nombreUsuario + ", " : "") + (password != null ? "password=" + password + ", " : "")
				+ (nombreApellido != null ? "nombreApellido=" + nombreApellido : "") + "]";
	}
}
