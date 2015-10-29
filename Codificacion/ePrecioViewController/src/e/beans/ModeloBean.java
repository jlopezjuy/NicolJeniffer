package e.beans;

import java.util.List;

import e.dominio.entity.Clientes;
import e.dominio.entity.Modelos;

public class ModeloBean extends BaseBean{
	private int idModelos;
	private Clientes clientes;
	private byte[] imagen;
	private String nombreModelo;
	private String observacion;
	private String colorVestido;
	private Modelos modeloSelect;
	private List<Modelos> listaModelos;

	public ModeloBean() {
		super();
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


	public Modelos getModeloSelect() {
		return modeloSelect;
	}


	public void setModeloSelect(Modelos modeloSelect) {
		this.modeloSelect = modeloSelect;
	}


	public List<Modelos> getListaModelos() {
		return listaModelos;
	}


	public void setListaModelos(List<Modelos> listaModelos) {
		this.listaModelos = listaModelos;
	}
	
}
