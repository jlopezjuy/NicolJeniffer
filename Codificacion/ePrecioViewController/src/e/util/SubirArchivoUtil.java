package e.util;

import java.io.InputStream;

import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

public class SubirArchivoUtil {
	private final static Logger LOG = Logger.getLogger(SubirArchivoUtil.class);

	private StreamedContent contenidoBinario;
	private byte[] bytes;

	public void subirArchivo(FileUploadEvent event) {
		LOG.debug("");
		try {
			UploadedFile tempFile = event.getFile();

			LOG.debug(tempFile.getFileName());
			contenidoBinario = new DefaultStreamedContent(tempFile.getInputstream(), "image/jpg");
			bytes = tempFile.getContents();
			//
			// FacesMessage message = new FacesMessage("Succesful",
			// tempFile.getFileName() + " is uploaded.");
			// FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {
			contenidoBinario = null;
			bytes = null;
			e.printStackTrace();

		}
	}

	public void recuperarArchivo(InputStream inputStream) {
		try {
			if (inputStream != null) {
				contenidoBinario = new DefaultStreamedContent(inputStream, "image/jpg");
			}
		} catch (Exception e) {
			contenidoBinario = null;
			e.printStackTrace();
		}
	}
	public void recuperarArchivo(byte[] bytesImagen) {
		try {
			if (bytesImagen != null) {
				
//				contenidoBinario = new DefaultStreamedContent(bytesImagen, "image/jpg");				
			}
		} catch (Exception e) {
			contenidoBinario = null;
			e.printStackTrace();
		}
		
	}
	public void reiniciar() {
		contenidoBinario = null;
	}

	// ExternalContext externalContext =
	// FacesContext.getCurrentInstance().getExternalContext();
	// String absoluteWebPath = externalContext.getRealPath("/");
	public boolean isArchivoCargado() {
		return contenidoBinario != null;
	}

	public StreamedContent getContenidoBinario() {
		return contenidoBinario;
	}

	public byte[] getBytes() {
		return bytes;
	}

	
}
