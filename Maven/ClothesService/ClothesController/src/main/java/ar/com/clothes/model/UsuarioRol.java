package ar.com.clothes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author MostroBook
 *
 */
@Entity
@Table(name = "UsuarioRol")
public class UsuarioRol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuarioRol;
	@ManyToOne(optional = false)
	@JoinColumn(name = "USUARIO_IDUSUARIO", nullable = false)
	private Usuario usuario;
	@ManyToOne(optional = false)
	@JoinColumn(name = "ROL_IDROL", nullable = false)
	private Rol rol;

	public UsuarioRol() {

	}

	/**
	 * @return the idUsuarioRol
	 */
	public Integer getIdUsuarioRol() {
		return idUsuarioRol;
	}

	/**
	 * @param idUsuarioRol
	 *           the idUsuarioRol to set
	 */
	public void setIdUsuarioRol(Integer idUsuarioRol) {
		this.idUsuarioRol = idUsuarioRol;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *           the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the rol
	 */
	public Rol getRol() {
		return rol;
	}

	/**
	 * @param rol
	 *           the rol to set
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UsuarioRol [idUsuarioRol=" + idUsuarioRol + ", usuario=" + usuario + ", rol=" + rol + "]";
	}
}
