package e.dominio.entity;

// Generated 28/10/2016 11:29:40 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import e.base.dominio.DominioBaseNombre;

/**
 * Usuario generated by hbm2java
 */
public class Usuario extends DominioBaseNombre{

	private Integer idUsuario;
	private String nombreUsuario;
	private String password;
	private String nombreApellido;
	private Set usuariorols = new HashSet(0);

	public Usuario() {
	}

	public Usuario(String nombreUsuario, String password,
			String nombreApellido, Set usuariorols) {
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.nombreApellido = nombreApellido;
		this.usuariorols = usuariorols;
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombreApellido() {
		return this.nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public Set getUsuariorols() {
		return this.usuariorols;
	}

	public void setUsuariorols(Set usuariorols) {
		this.usuariorols = usuariorols;
	}

}
