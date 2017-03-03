package ar.com.clothes.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author MostroBook
 *
 */
@Entity
@Table(name = "Encargos")
public class Encargo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEncargo;
	@ManyToOne(optional = false)
	@JoinColumn(name = "CLIENTES_IDCLIENTES", nullable = false)
	private Cliente cliente;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "VALORDOMINIO_IDVALORDOMINIO", nullable = false)
	@JsonIgnoreProperties(ignoreUnknown = true, value = "encargos")
	private ValorDominio valordominio;
	@Column(name = "IMPORTETOTAL")
	private Double importeTotal;
	@Column(name = "FECHAENCARGO")
	private Date fechaEncargo;
	@Column(name = "FECHAENTREGA")
	private Date fechaEntrega;
	@Column(name = "TIPOEVENTO")
	private String tipoEvento;
	@Column(name = "DETALLEVESTIDO")
	private String detalleVestido;
	@OneToMany(mappedBy = "encargo", cascade = CascadeType.ALL)
	private Set<Pago> pagos = new HashSet<Pago>(0);
	@ManyToOne(optional = false)
	@JoinColumn(name = "IDEMPRESA", nullable = false)
	private Empresa empresa;

	/**
	 * 
	 */
	public Encargo() {

	}

	/**
	 * @return the idEncargo
	 */
	public Integer getIdEncargo() {
		return idEncargo;
	}

	/**
	 * @param idEncargo
	 *           the idEncargo to set
	 */
	public void setIdEncargo(Integer idEncargo) {
		this.idEncargo = idEncargo;
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
	 * @return the valordominio
	 */
	public ValorDominio getValordominio() {
		return valordominio;
	}

	/**
	 * @param valordominio
	 *           the valordominio to set
	 */
	public void setValordominio(ValorDominio valordominio) {
		this.valordominio = valordominio;
	}

	/**
	 * @return the importeTotal
	 */
	public Double getImporteTotal() {
		return importeTotal;
	}

	/**
	 * @param importeTotal
	 *           the importeTotal to set
	 */
	public void setImporteTotal(Double importeTotal) {
		this.importeTotal = importeTotal;
	}

	/**
	 * @return the fechaEncargo
	 */
	public Date getFechaEncargo() {
		return fechaEncargo;
	}

	/**
	 * @param fechaEncargo
	 *           the fechaEncargo to set
	 */
	public void setFechaEncargo(Date fechaEncargo) {
		this.fechaEncargo = fechaEncargo;
	}

	/**
	 * @return the fechaEntrega
	 */
	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	/**
	 * @param fechaEntrega
	 *           the fechaEntrega to set
	 */
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	/**
	 * @return the tipoEvento
	 */
	public String getTipoEvento() {
		return tipoEvento;
	}

	/**
	 * @param tipoEvento
	 *           the tipoEvento to set
	 */
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	/**
	 * @return the detalleVestido
	 */
	public String getDetalleVestido() {
		return detalleVestido;
	}

	/**
	 * @param detalleVestido
	 *           the detalleVestido to set
	 */
	public void setDetalleVestido(String detalleVestido) {
		this.detalleVestido = detalleVestido;
	}

	/**
	 * @return the pagos
	 */
	public Set<Pago> getPagos() {
		return pagos;
	}

	/**
	 * @param pagos
	 *           the pagos to set
	 */
	public void setPagos(Set<Pago> pagos) {
		this.pagos = pagos;
	}

	/**
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa
	 *           the empresa to set
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
