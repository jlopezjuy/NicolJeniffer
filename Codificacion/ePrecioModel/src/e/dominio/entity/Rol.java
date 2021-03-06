package e.dominio.entity;
// default package
// Generated 26/12/2016 09:56:18 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Rol generated by hbm2java
 */
public class Rol implements java.io.Serializable {

	private Integer idRol;
	private String descripcion;
	private Set usuariorols = new HashSet(0);

	public Rol() {
	}

	public Rol(String descripcion, Set usuariorols) {
		this.descripcion = descripcion;
		this.usuariorols = usuariorols;
	}

	public Integer getIdRol() {
		return this.idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set getUsuariorols() {
		return this.usuariorols;
	}

	public void setUsuariorols(Set usuariorols) {
		this.usuariorols = usuariorols;
	}

}
