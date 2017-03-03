package ar.com.clothes.model;

import java.util.Date;

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
@Table(name = "Pagos")
public class Pago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPagos;
	@ManyToOne(optional = false)
	@JoinColumn(name = "ENCARGOS_IDENCARGO", nullable = false)
	private Encargo encargo;
	@Column(name = "FECHAPAGO")
	private Date fechaPago;
	@Column(name = "IMPORTE")
	private Double importe;
	@Column(name = "CANTIDAD")
	private Integer cantidad;
	@Column(name = "DETALLE")
	private String detalle;
	@Column(name = "PRECIOUNITARIO")
	private Double precioUnitario;
	@Column(name = "PRECIOTOTAL")
	private Double precioTotal;
	@Column(name = "NUMERORECIBO")
	private String numeroRecibo;

	public Pago() {

	}

	/**
	 * @return the idPagos
	 */
	public Integer getIdPagos() {
		return idPagos;
	}

	/**
	 * @param idPagos
	 *           the idPagos to set
	 */
	public void setIdPagos(Integer idPagos) {
		this.idPagos = idPagos;
	}

	/**
	 * @return the encargo
	 */
	public Encargo getEncargo() {
		return encargo;
	}

	/**
	 * @param encargo
	 *           the encargo to set
	 */
	public void setEncargo(Encargo encargo) {
		this.encargo = encargo;
	}

	/**
	 * @return the fechaPago
	 */
	public Date getFechaPago() {
		return fechaPago;
	}

	/**
	 * @param fechaPago
	 *           the fechaPago to set
	 */
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	/**
	 * @return the importe
	 */
	public Double getImporte() {
		return importe;
	}

	/**
	 * @param importe
	 *           the importe to set
	 */
	public void setImporte(Double importe) {
		this.importe = importe;
	}

	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad
	 *           the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the detalle
	 */
	public String getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle
	 *           the detalle to set
	 */
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	/**
	 * @return the precioUnitario
	 */
	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	/**
	 * @param precioUnitario
	 *           the precioUnitario to set
	 */
	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	/**
	 * @return the precioTotal
	 */
	public Double getPrecioTotal() {
		return precioTotal;
	}

	/**
	 * @param precioTotal
	 *           the precioTotal to set
	 */
	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}

	/**
	 * @return the numeroRecibo
	 */
	public String getNumeroRecibo() {
		return numeroRecibo;
	}

	/**
	 * @param numeroRecibo
	 *           the numeroRecibo to set
	 */
	public void setNumeroRecibo(String numeroRecibo) {
		this.numeroRecibo = numeroRecibo;
	}

}
