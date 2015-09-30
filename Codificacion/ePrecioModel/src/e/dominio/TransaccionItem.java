package e.dominio;

import java.math.BigDecimal;

import e.base.dominio.DominioBase;

public class TransaccionItem extends DominioBase {
	private Long idTransaccion;
	private BigDecimal cantidad;
	private Long idUnidad;
	private Long idProducto;
	private Long idMarca;
	private BigDecimal precioUnitario;

	public Long getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(Long idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public Long getIdUnidad() {
		return idUnidad;
	}

	public void setIdUnidad(Long idUnidad) {
		this.idUnidad = idUnidad;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public Long getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

}
