package e.dto.dominio;

import java.util.HashSet;
import java.util.Set;

import e.base.dto.DTOBase;

public class ClienteDto extends DTOBase {
	private Long idClientes;
	private String nombre;
	private String apellido;
	private String celular;
	private String telefono;
	private String email;
	private String domicilio;
	private Set medidases = new HashSet(0);
	private Set modeloses = new HashSet(0);
	
	public Long getIdClientes() {
		return idClientes;
	}
	public void setIdClientes(Long idClientes) {
		this.idClientes = idClientes;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public Set getMedidases() {
		return medidases;
	}
	public void setMedidases(Set medidases) {
		this.medidases = medidases;
	}
	public Set getModeloses() {
		return modeloses;
	}
	public void setModeloses(Set modeloses) {
		this.modeloses = modeloses;
	}
	
	
}
