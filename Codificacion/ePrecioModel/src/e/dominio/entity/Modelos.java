package e.dominio.entity;

import e.base.dominio.DominioBaseNombre;
// Generated 05-oct-2015 18:08:53 by Hibernate Tools 3.4.0.CR1

/**
 * Modelos generated by hbm2java
 */
public class Modelos extends DominioBaseNombre {

	private int idModelos;
	private Clientes clientes;
	private byte[] imagen;
	private String nombreModelo;
	private String observacion;
	private String colorVestido;

	public Modelos() {
	}

	public Modelos(int idModelos) {
		this.idModelos = idModelos;
	}

	public Modelos(int idModelos, Clientes clientes, byte[] imagen,
			String nombreModelo, String observacion, String colorVestido) {
		this.idModelos = idModelos;
		this.clientes = clientes;
		this.imagen = imagen;
		this.nombreModelo = nombreModelo;
		this.observacion = observacion;
		this.colorVestido = colorVestido;
	}

	public int getIdModelos() {
		return this.idModelos;
	}

	public void setIdModelos(int idModelos) {
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
