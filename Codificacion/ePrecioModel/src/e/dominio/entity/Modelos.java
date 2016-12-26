package e.dominio.entity;

import e.base.dominio.DominioBaseNombre;

// default package
// Generated 26/12/2016 09:56:18 by Hibernate Tools 4.0.0

/**
 * Modelos generated by hbm2java
 */
public class Modelos extends DominioBaseNombre {

	private Integer idModelos;
	private Clientes clientes;
	private byte[] imagen;
	private String nombreModelo;
	private String observacion;
	private String colorVestido;

	public Modelos() {
	}

	public Modelos(Clientes clientes, byte[] imagen, String nombreModelo, String observacion, String colorVestido) {
		this.clientes = clientes;
		this.imagen = imagen;
		this.nombreModelo = nombreModelo;
		this.observacion = observacion;
		this.colorVestido = colorVestido;
	}

	public Integer getIdModelos() {
		return this.idModelos;
	}

	public void setIdModelos(Integer idModelos) {
		this.idModelos = idModelos;
	}

	public Clientes getClientes() {
		return this.clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	public byte[] getImagen() {
		return this.imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getNombreModelo() {
		return this.nombreModelo;
	}

	public void setNombreModelo(String nombreModelo) {
		this.nombreModelo = nombreModelo;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getColorVestido() {
		return this.colorVestido;
	}

	public void setColorVestido(String colorVestido) {
		this.colorVestido = colorVestido;
	}

}
