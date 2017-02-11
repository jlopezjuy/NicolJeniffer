package ar.com.clothes.model;

/**
 * 
 * @author MostroBook
 *
 */
public class Usuario {
	private Integer idUsuario;
	//private Empresa empresa;
	private String nombreUsuario;
	private String password;
	private String nombreApellido;
	//private Set usuariorols = new HashSet(0);
	
	/**
	 * 
	 */
	public Usuario() {
		
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}
	
	
}
