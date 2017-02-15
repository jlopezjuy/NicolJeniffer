package ar.com.clothes.util;

import java.io.InputStream;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

public class UploadImage implements Serializable {

	private static final long serialVersionUID = 1L;
	private UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void upload() {
		System.out.println("sssss");
		if (file != null) {
			try {
				System.out.println(file.getFileName());
				InputStream fin2 = file.getInputstream();
				// Connection con = Database.getConnection();

				FacesMessage msg = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
				FacesContext.getCurrentInstance().addMessage(null, msg);

			} catch (Exception e) {
				System.out.println("Exception-File Upload." + e.getMessage());
			}
		} else {
			FacesMessage msg = new FacesMessage("Please select image!!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
}