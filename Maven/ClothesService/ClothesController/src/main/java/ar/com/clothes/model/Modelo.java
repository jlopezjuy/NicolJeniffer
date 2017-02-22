package ar.com.clothes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author MostroBook
 *
 */
@Entity
@Table(name = "Modelos")
public class Modelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idModelos;
	@ManyToOne(optional = false)
	@JoinColumn(name = "CLIENTES_IDCLIENTES", nullable = false)
	private Cliente cliente;
	@Column(name = "IMAGEN")
	private byte[] imagen;
	@Column(name = "NOMBREMODELO")
	private String nombreModelo;
	@Column(name = "OBSERVACION")
	private String observacion;
	@Column(name = "COLORVESTIDO")
	private String colorVestido;

	public Modelo() {

	}

	/**
	 * @return the idModelos
	 */
	public Integer getIdModelos() {
		return idModelos;
	}

	/**
	 * @param idModelos
	 *           the idModelos to set
	 */
	public void setIdModelos(Integer idModelos) {
		this.idModelos = idModelos;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 *           the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the imagen
	 */
	public byte[] getImagen() {
		return imagen;
	}

	/**
	 * @param imagen
	 *           the imagen to set
	 */
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	/**
	 * @return the nombreModelo
	 */
	public String getNombreModelo() {
		return nombreModelo;
	}

	/**
	 * @param nombreModelo
	 *           the nombreModelo to set
	 */
	public void setNombreModelo(String nombreModelo) {
		this.nombreModelo = nombreModelo;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion
	 *           the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	/**
	 * @return the colorVestido
	 */
	public String getColorVestido() {
		return colorVestido;
	}

	/**
	 * @param colorVestido
	 *           the colorVestido to set
	 */
	public void setColorVestido(String colorVestido) {
		this.colorVestido = colorVestido;
	}

	public String toString() {
		return "id modelo: " + idModelos + " Nombre modelo: " + nombreModelo;
	}

}
