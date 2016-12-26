package e.dominio.entity;
// default package
// Generated 26/12/2016 09:56:18 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import e.base.dominio.DominioBaseNombre;

/**
 * Encargos generated by hbm2java
 */
public class Encargos extends DominioBaseNombre {

	private Integer idEncargo;
	private Clientes clientes;
	private Valordominio valordominio;
	private BigDecimal importeTotal;
	private Date fechaEncargo;
	private Date fechaEntrega;
	private String tipoEvento;
	private String detalleVestido;
	private Set pagoses = new HashSet(0);

	public Encargos() {
	}

	public Encargos(Clientes clientes, Valordominio valordominio, BigDecimal importeTotal, Date fechaEncargo, Date fechaEntrega, String tipoEvento, String detalleVestido, Set pagoses) {
		this.clientes = clientes;
		this.valordominio = valordominio;
		this.importeTotal = importeTotal;
		this.fechaEncargo = fechaEncargo;
		this.fechaEntrega = fechaEntrega;
		this.tipoEvento = tipoEvento;
		this.detalleVestido = detalleVestido;
		this.pagoses = pagoses;
	}

	public Integer getIdEncargo() {
		return this.idEncargo;
	}

	public void setIdEncargo(Integer idEncargo) {
		this.idEncargo = idEncargo;
	}

	public Clientes getClientes() {
		return this.clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	public Valordominio getValordominio() {
		return this.valordominio;
	}

	public void setValordominio(Valordominio valordominio) {
		this.valordominio = valordominio;
	}

	public BigDecimal getImporteTotal() {
		return this.importeTotal;
	}

	public void setImporteTotal(BigDecimal importeTotal) {
		this.importeTotal = importeTotal;
	}

	public Date getFechaEncargo() {
		return this.fechaEncargo;
	}

	public void setFechaEncargo(Date fechaEncargo) {
		this.fechaEncargo = fechaEncargo;
	}

	public Date getFechaEntrega() {
		return this.fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getTipoEvento() {
		return this.tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getDetalleVestido() {
		return this.detalleVestido;
	}

	public void setDetalleVestido(String detalleVestido) {
		this.detalleVestido = detalleVestido;
	}

	public Set getPagoses() {
		return this.pagoses;
	}

	public void setPagoses(Set pagoses) {
		this.pagoses = pagoses;
	}

}
