package e.dominio;

import java.math.BigDecimal;
import java.util.Date;

import e.base.dominio.DominioBase;

public class Transaccion extends DominioBase {
	private Date fechaTransaccion;
	private Long idPersonaEmisor;
	private Long idPersonaReceptor;
	private Long idTipoTransaccion;
	private Long idEstadoTransaccion;
	private BigDecimal interes;
	private BigDecimal descuento;
	private BigDecimal ajuste;

	public Date getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(Date fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public Long getIdPersonaEmisor() {
		return idPersonaEmisor;
	}

	public void setIdPersonaEmisor(Long idPersonaEmisor) {
		this.idPersonaEmisor = idPersonaEmisor;
	}

	public Long getIdPersonaReceptor() {
		return idPersonaReceptor;
	}

	public void setIdPersonaReceptor(Long idPersonaReceptor) {
		this.idPersonaReceptor = idPersonaReceptor;
	}

	public Long getIdTipoTransaccion() {
		return idTipoTransaccion;
	}

	public void setIdTipoTransaccion(Long idTipoTransaccion) {
		this.idTipoTransaccion = idTipoTransaccion;
	}

	public Long getIdEstadoTransaccion() {
		return idEstadoTransaccion;
	}

	public void setIdEstadoTransaccion(Long idEstadoTransaccion) {
		this.idEstadoTransaccion = idEstadoTransaccion;
	}

	public BigDecimal getInteres() {
		return interes;
	}

	public void setInteres(BigDecimal interes) {
		this.interes = interes;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public BigDecimal getAjuste() {
		return ajuste;
	}

	public void setAjuste(BigDecimal ajuste) {
		this.ajuste = ajuste;
	}

}
