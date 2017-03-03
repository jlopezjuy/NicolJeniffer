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
@Table(name = "Medidas")
public class Medida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMedidas;
	@ManyToOne(optional = false)
	@JoinColumn(name = "CLIENTES_IDCLIENTES", nullable = false)
	private Cliente cliente;
	@Column(name = "LARGOPOLERA")
	private Double largoPolera;
	@Column(name = "LARGOCORSET")
	private Double largoCorset;
	@Column(name = "ESPALDA")
	private Double espalda;
	@Column(name = "CONTORNOBUSTO")
	private Double contornoBusto;
	@Column(name = "CONTORNOCADERA")
	private Double contornoCadera;
	@Column(name = "COSTADO")
	private Double costado;
	@Column(name = "CINTURA")
	private Double cintura;
	@Column(name = "CADERA")
	private Double cadera;
	@Column(name = "TALLEESPALDA")
	private Double talleEspalda;
	@Column(name = "TALLEDELANTERO")
	private Double talleDelantero;
	@Column(name = "SISA")
	private Double sisa;
	@Column(name = "LARGOMANGA")
	private Double largoManga;
	@Column(name = "LARGOPOLLERA")
	private Double largoPollera;
	@Column(name = "OBSERVACIONES")
	private String observaciones;
	@Column(name = "FECHAMEDIDA")
	private Date fechaMedida;
	@Column(name = "BUSTO")
	private Double busto;
	@Column(name = "BAJOBUSTO")
	private Double bajoBusto;
	@Column(name = "ANTECADERA")
	private Double anteCadera;
	@Column(name = "PICOBUSTO1")
	private Double picoBusto1;
	@Column(name = "PICOBUSTO2")
	private Double picoBusto2;

	public Medida() {

	}

	/**
	 * @return the idMedidas
	 */
	public Integer getIdMedidas() {
		return idMedidas;
	}

	/**
	 * @param idMedidas
	 *           the idMedidas to set
	 */
	public void setIdMedidas(Integer idMedidas) {
		this.idMedidas = idMedidas;
	}

	/**
	 * @return the clientes
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param clientes
	 *           the clientes to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the largoPolera
	 */
	public Double getLargoPolera() {
		return largoPolera;
	}

	/**
	 * @param largoPolera
	 *           the largoPolera to set
	 */
	public void setLargoPolera(Double largoPolera) {
		this.largoPolera = largoPolera;
	}

	/**
	 * @return the largoCorset
	 */
	public Double getLargoCorset() {
		return largoCorset;
	}

	/**
	 * @param largoCorset
	 *           the largoCorset to set
	 */
	public void setLargoCorset(Double largoCorset) {
		this.largoCorset = largoCorset;
	}

	/**
	 * @return the espalda
	 */
	public Double getEspalda() {
		return espalda;
	}

	/**
	 * @param espalda
	 *           the espalda to set
	 */
	public void setEspalda(Double espalda) {
		this.espalda = espalda;
	}

	/**
	 * @return the contornoBusto
	 */
	public Double getContornoBusto() {
		return contornoBusto;
	}

	/**
	 * @param contornoBusto
	 *           the contornoBusto to set
	 */
	public void setContornoBusto(Double contornoBusto) {
		this.contornoBusto = contornoBusto;
	}

	/**
	 * @return the contornoCadera
	 */
	public Double getContornoCadera() {
		return contornoCadera;
	}

	/**
	 * @param contornoCadera
	 *           the contornoCadera to set
	 */
	public void setContornoCadera(Double contornoCadera) {
		this.contornoCadera = contornoCadera;
	}

	/**
	 * @return the costado
	 */
	public Double getCostado() {
		return costado;
	}

	/**
	 * @param costado
	 *           the costado to set
	 */
	public void setCostado(Double costado) {
		this.costado = costado;
	}

	/**
	 * @return the cintura
	 */
	public Double getCintura() {
		return cintura;
	}

	/**
	 * @param cintura
	 *           the cintura to set
	 */
	public void setCintura(Double cintura) {
		this.cintura = cintura;
	}

	/**
	 * @return the cadera
	 */
	public Double getCadera() {
		return cadera;
	}

	/**
	 * @param cadera
	 *           the cadera to set
	 */
	public void setCadera(Double cadera) {
		this.cadera = cadera;
	}

	/**
	 * @return the talleEspalda
	 */
	public Double getTalleEspalda() {
		return talleEspalda;
	}

	/**
	 * @param talleEspalda
	 *           the talleEspalda to set
	 */
	public void setTalleEspalda(Double talleEspalda) {
		this.talleEspalda = talleEspalda;
	}

	/**
	 * @return the talleDelantero
	 */
	public Double getTalleDelantero() {
		return talleDelantero;
	}

	/**
	 * @param talleDelantero
	 *           the talleDelantero to set
	 */
	public void setTalleDelantero(Double talleDelantero) {
		this.talleDelantero = talleDelantero;
	}

	/**
	 * @return the sisa
	 */
	public Double getSisa() {
		return sisa;
	}

	/**
	 * @param sisa
	 *           the sisa to set
	 */
	public void setSisa(Double sisa) {
		this.sisa = sisa;
	}

	/**
	 * @return the largoManga
	 */
	public Double getLargoManga() {
		return largoManga;
	}

	/**
	 * @param largoManga
	 *           the largoManga to set
	 */
	public void setLargoManga(Double largoManga) {
		this.largoManga = largoManga;
	}

	/**
	 * @return the largoPollera
	 */
	public Double getLargoPollera() {
		return largoPollera;
	}

	/**
	 * @param largoPollera
	 *           the largoPollera to set
	 */
	public void setLargoPollera(Double largoPollera) {
		this.largoPollera = largoPollera;
	}

	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones
	 *           the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	/**
	 * @return the fechaMedida
	 */
	public Date getFechaMedida() {
		return fechaMedida;
	}

	/**
	 * @param fechaMedida
	 *           the fechaMedida to set
	 */
	public void setFechaMedida(Date fechaMedida) {
		this.fechaMedida = fechaMedida;
	}

	/**
	 * @return the busto
	 */
	public Double getBusto() {
		return busto;
	}

	/**
	 * @param busto
	 *           the busto to set
	 */
	public void setBusto(Double busto) {
		this.busto = busto;
	}

	/**
	 * @return the bajoBusto
	 */
	public Double getBajoBusto() {
		return bajoBusto;
	}

	/**
	 * @param bajoBusto
	 *           the bajoBusto to set
	 */
	public void setBajoBusto(Double bajoBusto) {
		this.bajoBusto = bajoBusto;
	}

	/**
	 * @return the anteCadera
	 */
	public Double getAnteCadera() {
		return anteCadera;
	}

	/**
	 * @param anteCadera
	 *           the anteCadera to set
	 */
	public void setAnteCadera(Double anteCadera) {
		this.anteCadera = anteCadera;
	}

	/**
	 * @return the picoBusto1
	 */
	public Double getPicoBusto1() {
		return picoBusto1;
	}

	/**
	 * @param picoBusto1
	 *           the picoBusto1 to set
	 */
	public void setPicoBusto1(Double picoBusto1) {
		this.picoBusto1 = picoBusto1;
	}

	/**
	 * @return the picoBusto2
	 */
	public Double getPicoBusto2() {
		return picoBusto2;
	}

	/**
	 * @param picoBusto2
	 *           the picoBusto2 to set
	 */
	public void setPicoBusto2(Double picoBusto2) {
		this.picoBusto2 = picoBusto2;
	}

	public String toString() {
		return "id medida: " + this.getLargoPolera();
	}
}
