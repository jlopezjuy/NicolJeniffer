package e.dominio;

import e.base.dominio.DominioBase;

public class Persona extends DominioBase {
	private Long idTipoPersona;
	private String apellido;
	private String apellido2;
	private String nombres;
	private String documento;
	private String correoElectronico;

	public Persona() {
		super();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.append("Id: ").append(this.getId()).append(", Apellido: ").append(this.apellido).append(", Apellido2: ").append(this.apellido2).append(", Nombres: ").append(this.nombres).toString();
	}

	public Long getIdTipoPersona() {
		return idTipoPersona;
	}

	public void setIdTipoPersona(Long idTipoPersona) {
		this.idTipoPersona = idTipoPersona;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

}
