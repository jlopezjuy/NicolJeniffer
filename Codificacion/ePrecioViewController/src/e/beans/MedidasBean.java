package e.beans;

import java.math.BigDecimal;
import java.util.*;

import org.apache.log4j.Logger;

import e.base.excepcion.ExcepcionServicio;
import e.dominio.entity.Clientes;
import e.dominio.entity.Medidas;

public class MedidasBean extends BaseBean{
	private static final Logger LOG = Logger.getLogger(MedidasBean.class);
	
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
	private BigDecimal busto;
	private BigDecimal bajoBusto;
	private BigDecimal anteCadera;
	private BigDecimal picoBusto1;
	private BigDecimal picoBusto2;
	private List<Medidas> listaMedidas = new ArrayList<Medidas>();
	
	public MedidasBean() {
		super();
	}
	
	/**
	 * Metodo para guardar una medida
	 * @return
	 * @author JLopez
	 * @since 24/10/2015
	 * @version 1.0
	 */
	public String gurdarMedida() {
		try {
			getServicioMedida().guardarMedida(getMedida());
			limpiarFormulario();
		} catch (ExcepcionServicio e) {
			LOG.error(e);
			return null;
		}
		return "listaMedidasView";
	}
	
	/**
	 * Metodo que cancela el alta de medida
	 * @return
	 * @author JLopez
	 * @since 27/10/2015
	 * @version 1.0
	 */
	public String cancelarMedida(){
		limpiarFormulario();
		return "listaMedidasView";
	}
	
	/**
	 * Metodo apra limpiar el formulario
	 * @author JLopez
	 * @since 24/10/2015
	 * @version 1.0
	 */
	private void limpiarFormulario() {
		this.largoPolera = null;
		this.largoCorset = null;
		this.espalda = null;
		this.contornoBusto = null;
		this.contornoCadera = null;
		this.costado = null;
		this.cintura = null;
		this.cadera = null;
		this.talleEspalda = null;
		this.talleDelantero = null;
		this.sisa = null;
		this.largoManga = null;
		this.largoPollera = null;
		this.observaciones = null;	
		this.busto = null;
		this.bajoBusto = null;
		this.anteCadera = null;
		this.picoBusto1 = null;
		this.picoBusto2 = null;
	}

	/**
	 * Metodo par obtenr una media para su proceso
	 * @return medida
	 * @author JLopez
	 * @since 24/10/2015
	 * @version 1.0
	 */
	public Medidas getMedida(){
		Medidas medida = new Medidas();
		medida.setClientes(clientes);
		medida.setLargoPolera(largoPolera);
		medida.setLargoCorset(largoCorset);
		medida.setEspalda(espalda);
		medida.setContornoBusto(contornoBusto);
		medida.setContornoCadera(contornoCadera);
		medida.setCostado(costado);
		medida.setCintura(cintura);
		medida.setCadera(cadera);
		medida.setTalleEspalda(talleEspalda);
		medida.setTalleDelantero(talleDelantero);
		medida.setSisa(sisa);
		medida.setLargoManga(largoManga);
		medida.setLargoPollera(largoPollera);
		medida.setObservaciones(observaciones);
		medida.setBusto(busto);
		medida.setBajoBusto(bajoBusto);
		medida.setAnteCadera(anteCadera);
		medida.setPicoBusto1(picoBusto1);
		medida.setPicoBusto2(picoBusto2);
		return medida;
	}
	
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
		try {
			listaMedidas = getServicioMedida().listAll(clientes);
			LOG.debug("cantidad de datos: " + listaMedidas.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMedidas;
	}
	public void setListaMedidas(List<Medidas> listaMedidas) {
		this.listaMedidas = listaMedidas;
	}

	public BigDecimal getBusto() {
		return busto;
	}

	public void setBusto(BigDecimal busto) {
		this.busto = busto;
	}

	public BigDecimal getBajoBusto() {
		return bajoBusto;
	}

	public void setBajoBusto(BigDecimal bajoBusto) {
		this.bajoBusto = bajoBusto;
	}

	public BigDecimal getAnteCadera() {
		return anteCadera;
	}

	public void setAnteCadera(BigDecimal anteCadera) {
		this.anteCadera = anteCadera;
	}

	public BigDecimal getPicoBusto1() {
		return picoBusto1;
	}

	public void setPicoBusto1(BigDecimal picoBusto1) {
		this.picoBusto1 = picoBusto1;
	}

	public BigDecimal getPicoBusto2() {
		return picoBusto2;
	}

	public void setPicoBusto2(BigDecimal picoBusto2) {
		this.picoBusto2 = picoBusto2;
	}
	
	
}
