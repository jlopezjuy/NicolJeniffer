package e.beans;

public class UsuarioBean extends BaseBean {
	private String nombreUsuario;
	private String password;
	public UsuarioBean() {
		super();
	}
	
	public String validarLogin(){
		
		return "";
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
}
