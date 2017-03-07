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

/**
 * 
 * @author MostroBook
 *
 */
@Entity
@Table(name = "Rol")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRol;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@OneToMany(mappedBy = "rol", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<UsuarioRol> usuarioRoles = new HashSet<UsuarioRol>();

	public Rol() {

	}

	/**
	 * @return the idRol
	 */
	public Integer getIdRol() {
		return idRol;
	}

	/**
	 * @param idRol
	 *           the idRol to set
	 */
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *           the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
		return "Rol [idRol=" + idRol + ", descripcion=" + descripcion + ", usuarioRoles=" + usuarioRoles + "]";
	}

}
