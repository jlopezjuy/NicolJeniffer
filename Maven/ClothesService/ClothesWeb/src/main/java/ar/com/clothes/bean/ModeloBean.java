package ar.com.clothes.bean;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import ar.com.clothes.model.Cliente;
import ar.com.clothes.model.Modelo;

@ManagedBean(name = "modeloBean")
@SessionScoped
public class ModeloBean extends BaseBean {
	private static final Logger LOG = Logger.getLogger(ModeloBean.class);
	private int idModelos;
	private Cliente cliente;
	private byte[] imagen;
	private String nombreModelo;
	private String observacion;
	private String colorVestido;
	private Modelo modeloSelect;
	private List<Modelo> listaModelos;
	private String imagenTemp;
	private StreamedContent imageLoad;

	public ModeloBean() {
		super();
	}

	/**
	 * Metodo para guardar un nuevo Modelo
	 * 
	 * @return
	 * @author JLopez
	 * @since 31/10/2015
	 * @version 1.0
	 */
	public String gurdarModelo() {
		try {

			getModeloService().saveModelo(getModeloNuevo());
			limpiarFormulario();
		} catch (Exception e) {
			LOG.error(e);
			return null;

		}
		return "listaModeloView";
	}

	public Boolean validateInsert() {
		Boolean validate = Boolean.TRUE;

		return validate;
	}

	/**
	 * Metodo para obtenr un nuevo modelo
	 *
	 * @return Modelo
	 * @author JLopez
	 * @since 31/10/2015
	 * @version 1.0
	 */
	private Modelo getModeloNuevo() {
		Modelo modelo = new Modelo();
		modelo.setCliente(cliente);
		modelo.setNombreModelo(nombreModelo);
		modelo.setObservacion(observacion);
		modelo.setImagen(imagen);
		modelo.setColorVestido(colorVestido);
		return modelo;
	}

	/**
	 * Metodo par cancelar el alta de un modelo
	 *
	 * @return
	 * @author JLopez
	 * @since 31/10/2015
	 * @version 1.0
	 */
	public String cancelarModelo() {
		limpiarFormulario();
		return "listaModeloView";
	}

	/**
	 * Metodo para limpiar el formulario
	 * 
	 * @author JLopez
	 * @since 31/10/2015
	 * @version 1.0
	 */
	private void limpiarFormulario() {
		imagen = null;
		nombreModelo = null;
		observacion = null;
		colorVestido = null;
		imagenTemp = null;
	}

	public void handleFileUpload(FileUploadEvent event) {
		FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, message);
		LOG.debug("econtro el siguiente archivo: " + event.getFile().getFileName());

		try {
			UploadedFile upFile = event.getFile();

			InputStream input = event.getFile().getInputstream();
			LOG.debug("VALOR DE LA IMAGEN EN uploadedFile: " + upFile.getFileName() + " valor: " + upFile.getContentType());
			byte[] buffer = new byte[8192];
			int bytesRead;
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			while ((bytesRead = input.read(buffer)) != -1) {
				output.write(buffer, 0, bytesRead);
			}
			imagen = output.toByteArray();
			imagenTemp = new sun.misc.BASE64Encoder().encode(output.toByteArray());
			LOG.debug("CONVERTIDO EN BASE 64: " + imagenTemp);
			LOG.debug("Cadena de la imagen: " + output.toByteArray());
			RequestContext.getCurrentInstance().update("form");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para mostrar imagen seleccionada en el datatable
	 * 
	 * @return
	 * @author JLopez
	 * @since 19/11/2015
	 * @versio 1.0
	 */
	public String getLoadImage() {
		if (null != this.getImagen()) {
			imageLoad = new DefaultStreamedContent(new ByteArrayInputStream(this.getImagen()));
			RequestContext.getCurrentInstance().update("form");

			this.refreshCurrentPage();
		}
		return null;
	}

	public StreamedContent getImage() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			// So, we're rendering the HTML. Return a stub StreamedContent so that
			// it will generate right URL.
			return new DefaultStreamedContent();
		} else {
			// So, browser is requesting the image. Return a real StreamedContent
			// with the image bytes.
			String studentId = context.getExternalContext().getRequestParameterMap().get("idModelos");
			Modelo student = getModeloService().findById(Integer.valueOf(studentId).intValue());
			return new DefaultStreamedContent(new ByteArrayInputStream(student.getImagen()));
		}
	}

	/**
	 * Metodo para refrescar el current Page
	 * 
	 * @author JLopez
	 * @since 19/11/2015
	 * @version 1.0
	 */
	public void refreshCurrentPage() {
		FacesContext context = FacesContext.getCurrentInstance();
		String viewId = context.getViewRoot().getViewId();
		ViewHandler handler = context.getApplication().getViewHandler();
		UIViewRoot root = handler.createView(context, viewId);
		root.setViewId(viewId);
		context.setViewRoot(root);
	}

	public int getIdModelos() {
		return this.idModelos;
	}

	public void setIdModelos(int idModelos) {
		this.idModelos = idModelos;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public Modelo getModeloSelect() {
		return modeloSelect;
	}

	public void setModeloSelect(Modelo modeloSelect) {
		this.modeloSelect = modeloSelect;
	}

	public List<Modelo> getListaModelos() {
		try {
			listaModelos = getModeloService().listarModelo(cliente);
			LOG.debug("cantidad de datos: " + listaModelos.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaModelos;
	}

	public void setListaModelos(List<Modelo> listaModelos) {
		this.listaModelos = listaModelos;
	}

	public String getImagenTemp() {
		return imagenTemp;
	}

	public void setImagenTemp(String imagenTemp) {
		this.imagenTemp = imagenTemp;
	}

	public StreamedContent getImageLoad() {
		return imageLoad;
	}

	public void setImageLoad(StreamedContent imageLoad) {
		this.imageLoad = imageLoad;
	}

}
