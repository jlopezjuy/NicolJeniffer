package ar.com.clothes.excepciones;

import java.util.List;

public class ExcepcionServicio extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1628275836930415684L;
	private List<String> mensajes;

	public ExcepcionServicio(String mensaje) {
		super(mensaje);
	}

	public ExcepcionServicio(Exception e) {
		super(e);
	}

	public ExcepcionServicio(List<String> mensajes) {
		super();
		this.mensajes = mensajes;
	}

	public List<String> getMensajes() {
		return mensajes;
	}

}
