package e.beans;

import java.math.BigDecimal;
import java.util.*;

import e.base.dominio.DominioBaseNombre;
import e.dominio.entity.Clientes;
import e.dominio.entity.Medidas;

public class MedidasBean extends DominioBaseNombre{
	private int idMedidas;
	private Clientes clientes;
	private BigDecimal largoPolera;
	private BigDecimal largoCorset;
	private BigDecimal espalda;
	private BigDecimal contornoBusto;
	private BigDecimal contornoCadera;
	private BigDecimal costado;
	private BigDecimal cintura;
	private BigDecimal cadera;
	private BigDecimal talleEspalda;
	private BigDecimal talleDelantero;
	private BigDecimal sisa;
	private BigDecimal largoManga;
	private BigDecimal largoPollera;
	private String observaciones;
	private List<Medidas> listaMedidas = new ArrayList<Medidas>();
	
	public int getIdMedidas() {
		return idMedidas;
	}
	public void setIdMedidas(int idMedidas) {
		this.idMedidas = idMedidas;
	}
	public Clientes getClientes() {
		return clientes;
	}
	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}
	public BigDecimal getLargoPolera() {
		return largoPolera;
	}
	public void setLargoPolera(BigDecimal largoPolera) {
		this.largoPolera = largoPolera;
	}
	public BigDecimal getLargoCorset() {
		return largoCorset;
	}
	public void setLargoCorset(BigDecimal largoCorset) {
		this.largoCorset = largoCorset;
	}
	public BigDecimal getEspalda() {
		return espalda;
	}
	public void setEspalda(BigDecimal espalda) {
		this.espalda = espalda;
	}
	public BigDecimal getContornoBusto() {
		return contornoBusto;
	}
	public void setContornoBusto(BigDecimal contornoBusto) {
		this.contornoBusto = contornoBusto;
	}
	public BigDecimal getContornoCadera() {
		return contornoCadera;
	}
	public void setContornoCadera(BigDecimal contornoCadera) {
		this.contornoCadera = contornoCadera;
	}
	public BigDecimal getCostado() {
		return costado;
	}
	public void setCostado(BigDecimal costado) {
		this.costado = costado;
	}
	public BigDecimal getCintura() {
		return cintura;
	}
	public void setCintura(BigDecimal cintura) {
		this.cintura = cintura;
	}
	public BigDecimal getCadera() {
		return cadera;
	}
	public void setCadera(BigDecimal cadera) {
		this.cadera = cadera;
	}
	public BigDecimal getTalleEspalda() {
		return talleEspalda;
	}
	public void setTalleEspalda(BigDecimal talleEspalda) {
		this.talleEspalda = talleEspalda;
	}
	public BigDecimal getTalleDelantero() {
		return talleDelantero;
	}
	public void setTalleDelantero(BigDecimal talleDelantero) {
		this.talleDelantero = talleDelantero;
	}
	public BigDecimal getSisa() {
		return sisa;
	}
	public void setSisa(BigDecimal sisa) {
		this.sisa = sisa;
	}
	public BigDecimal getLargoManga() {
		return largoManga;
	}
	public void setLargoManga(BigDecimal largoManga) {
		this.largoManga = largoManga;
	}
	public BigDecimal getLargoPollera() {
		return largoPollera;
	}
	public void setLargoPollera(BigDecimal largoPollera) {
		this.largoPollera = largoPollera;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public List<Medidas> getListaMedidas() {
		return listaMedidas;
	}
	public void setListaMedidas(List<Medidas> listaMedidas) {
		this.listaMedidas = listaMedidas;
	}
	
	
}
