package e.base.dto.validacion;

import java.util.ArrayList;
import java.util.List;

import e.base.Constantes;
import e.base.dto.DTOBase;
import e.base.dto.contexto.DTOContextoBase;
import e.base.util.StringUtil;

public class MensajeDto extends DTOBase {

	private String titulo;
	private List<String> mensajes;
	private String retorno;
	private String siguiente;
	private boolean mostrarRetorno;

	@Override
	public String toString() {
		return MensajeDto.class.getName() + ", " + getId() + ", " + titulo + ", " + retorno + ", " + mostrarRetorno + ", " + siguiente + ", " + mensajes;
	}

	public MensajeDto(String titulo, String retorno, String siguiente) {
		setId(Constantes.MENSAJE_OK);
		this.titulo = titulo;
		this.retorno = retorno;
		this.siguiente = siguiente;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<String> getMensajes() {
		if (mensajes == null) {
			mensajes = new ArrayList<String>();
		}
		return mensajes;
	}

	public String getRetorno() {
		return retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}

	public String getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(String siguiente) {
		this.siguiente = siguiente;
	}

	public boolean isMostrarRetorno() {
		return mostrarRetorno;
	}

	public void setMostrarRetorno(boolean mostrarRetorno) {
		this.mostrarRetorno = mostrarRetorno;
	}

}
