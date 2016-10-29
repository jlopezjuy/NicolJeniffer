package e.dominio.entity;

// Generated 28/10/2016 11:29:40 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import e.base.dominio.DominioBaseNombre;

/**
 * Encargos generated by hbm2java
 */
@Entity
@Table(name = "encargos", catalog = "nicolejeniffer")
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

	public Encargos(Valordominio valordominio) {
		this.valordominio = valordominio;
	}

	public Encargos(Clientes clientes, Valordominio valordominio,
			BigDecimal importeTotal, Date fechaEncargo, Date fechaEntrega,
			String tipoEvento, String detalleVestido, Set pagoses) {
		this.clientes = clientes;
		this.valordominio = valordominio;
		this.importeTotal = importeTotal;
		this.fechaEncargo = fechaEncargo;
		this.fechaEntrega = fechaEntrega;
		this.tipoEvento = tipoEvento;
		this.detalleVestido = detalleVestido;
		this.pagoses = pagoses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idEncargo", unique = true, nullable = false)
	public Integer getIdEncargo() {
		return this.idEncargo;
	}

	public void setIdEncargo(Integer idEncargo) {
		this.idEncargo = idEncargo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Clientes_idClientes")
	public Clientes getClientes() {
		return this.clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ValorDominio_idValorDominio", nullable = false)
	public Valordominio getValordominio() {
		return this.valordominio;
	}

	public void setValordominio(Valordominio valordominio) {
		this.valordominio = valordominio;
	}

	@Column(name = "ImporteTotal", precision = 14, scale = 3)
	public BigDecimal getImporteTotal() {
		return this.importeTotal;
	}

	public void setImporteTotal(BigDecimal importeTotal) {
		this.importeTotal = importeTotal;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FechaEncargo", length = 10)
	public Date getFechaEncargo() {
		return this.fechaEncargo;
	}

	public void setFechaEncargo(Date fechaEncargo) {
		this.fechaEncargo = fechaEncargo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FechaEntrega", length = 10)
	public Date getFechaEntrega() {
		return this.fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	@Column(name = "TipoEvento", length = 45)
	public String getTipoEvento() {
		return this.tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	@Column(name = "DetalleVestido", length = 45)
	public String getDetalleVestido() {
		return this.detalleVestido;
	}

	public void setDetalleVestido(String detalleVestido) {
		this.detalleVestido = detalleVestido;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "encargos")
	public Set getPagoses() {
		return this.pagoses;
	}

	public void setPagoses(Set pagoses) {
		this.pagoses = pagoses;
	}

}
