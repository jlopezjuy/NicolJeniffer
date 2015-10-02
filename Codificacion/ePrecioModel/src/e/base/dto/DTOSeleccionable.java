package e.base.dto;

public class DTOSeleccionable extends DTOBase {
	private String idItem;
	private String nombre;
	private String descripcion;

	public DTOSeleccionable() {

	}

	public DTOSeleccionable(String idItem, String nombre) {
		this.idItem = idItem;
		this.nombre = nombre;
	}

	public DTOSeleccionable(Long id, String nombre) {
		setId(id);
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdItem() {
		return idItem;
	}

	public void setIdItem(String idItem) {
		this.idItem = idItem;
	}
}
