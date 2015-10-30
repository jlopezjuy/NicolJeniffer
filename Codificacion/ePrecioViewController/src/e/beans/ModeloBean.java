package e.beans;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import e.dominio.entity.Clientes;
import e.dominio.entity.Modelos;

public class ModeloBean extends BaseBean {
	private static final Logger LOG = Logger.getLogger(ModeloBean.class);
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

	public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        LOG.debug("econtro el siguiente archivo: "+event.getFile().getFileName());
        
        try {
        	UploadedFile upFile = event.getFile();
        	
			InputStream input = event.getFile().getInputstream();
			LOG.debug("VALOR DE LA IMAGEN EN uploadedFile: "+upFile.getFileName() + " valor: "+ upFile.getContentType());
			
			byte[] cadena = IOUtils.toByteArray( input );
			LOG.info("Valor de cadena de la foto: "+cadena);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

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
