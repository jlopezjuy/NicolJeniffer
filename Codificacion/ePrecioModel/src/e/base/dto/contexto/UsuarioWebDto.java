package e.base.dto.contexto;

import java.io.Serializable;

import e.base.dto.DTOBase;

public class UsuarioWebDto extends DTOBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5145948511150344513L;
	private Long id;
	private String usuario;

	public String toString() {
		return UsuarioWebDto.class.getName() + " id: " + this.id + ", usuario: " + this.usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
