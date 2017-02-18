package ar.com.clothes.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import ar.com.clothes.model.Cliente;
import ar.com.clothes.model.Medida;

/**
 * 
 * @author MostroBook
 *
 */
@ManagedBean(name = "medidasBean")
@SessionScoped
public class MedidasBean extends BaseBean {
	private static final Logger LOG = Logger.getLogger(MedidasBean.class);

	private Integer idMedidas;
	private Cliente cliente;
	private Double largoPolera;
	private Double largoCorset;
	private Double espalda;
	private Double contornoBusto;
	private Double contornoCadera;
	private Double costado;
	private Double cintura;
	private Double cadera;
	private Double talleEspalda;
	private Double talleDelantero;
	private Double sisa;
	private Double largoManga;
	private Double largoPollera;
	private String observaciones;
	private Double busto;
	private Double bajoBusto;
	private Double anteCadera;
	private Double picoBusto1;
	private Double picoBusto2;
	private List<Medida> listaMedidas = new ArrayList<Medida>();
	private Medida medidaCliente;

	public MedidasBean() {

	}

	@PostConstruct
	public void init() {
		if (null != cliente) {
			LOG.info("cliente encontrado: " + cliente.getNombre());
		}
	}

	/**
	 * Metodo para guardar una medida
	 * 
	 * @return
	 * @author JLopez
	 * @since 24/10/2015
	 * @version 1.0
	 */
	public String gurdarMedida() {
		try {
			getMedidaService().saveMedida(getMedida());
			limpiarFormulario();
		} catch (Exception e) {
			LOG.error(e);
			return null;
		}
		return "listaMedidasView";
	}

	/**
	 * Metodo que cancela el alta de medida
	 * 
	 * @return
	 * @author JLopez
	 * @since 27/10/2015
	 * @version 1.0
	 */
	public String cancelarMedida() {
		limpiarFormulario();
		return "listaMedidasView";
	}

	/**
	 * Metodo apra limpiar el formulario
	 * 
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
	 * 
	 * @return medida
	 * @author JLopez
	 * @since 24/10/2015
	 * @version 1.0
	 */
	public Medida getMedida() {
		Medida medida = new Medida();
		medida.setCliente(cliente);
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
		medida.setFechaMedida(new Date());
		return medida;
	}

	public int getIdMedidas() {
		return idMedidas;
	}

	public void setIdMedidas(int idMedidas) {
		this.idMedidas = idMedidas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		LOG.info("Entro a guardar un cliente: " + cliente);
		this.cliente = cliente;
	}

	public Double getLargoPolera() {
		return largoPolera;
	}

	public void setLargoPolera(Double largoPolera) {
		this.largoPolera = largoPolera;
	}

	public Double getLargoCorset() {
		return largoCorset;
	}

	public void setLargoCorset(Double largoCorset) {
		this.largoCorset = largoCorset;
	}

	public Double getEspalda() {
		return espalda;
	}

	public void setEspalda(Double espalda) {
		this.espalda = espalda;
	}

	public Double getContornoBusto() {
		return contornoBusto;
	}

	public void setContornoBusto(Double contornoBusto) {
		this.contornoBusto = contornoBusto;
	}

	public Double getContornoCadera() {
		return contornoCadera;
	}

	public void setContornoCadera(Double contornoCadera) {
		this.contornoCadera = contornoCadera;
	}

	public Double getCostado() {
		return costado;
	}

	public void setCostado(Double costado) {
		this.costado = costado;
	}

	public Double getCintura() {
		return cintura;
	}

	public void setCintura(Double cintura) {
		this.cintura = cintura;
	}

	public Double getCadera() {
		return cadera;
	}

	public void setCadera(Double cadera) {
		this.cadera = cadera;
	}

	public Double getTalleEspalda() {
		return talleEspalda;
	}

	public void setTalleEspalda(Double talleEspalda) {
		this.talleEspalda = talleEspalda;
	}

	public Double getTalleDelantero() {
		return talleDelantero;
	}

	public void setTalleDelantero(Double talleDelantero) {
		this.talleDelantero = talleDelantero;
	}

	public Double getSisa() {
		return sisa;
	}

	public void setSisa(Double sisa) {
		this.sisa = sisa;
	}

	public Double getLargoManga() {
		return largoManga;
	}

	public void setLargoManga(Double largoManga) {
		this.largoManga = largoManga;
	}

	public Double getLargoPollera() {
		return largoPollera;
	}

	public void setLargoPollera(Double largoPollera) {
		this.largoPollera = largoPollera;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public List<Medida> getListaMedidas() {
		try {
			listaMedidas = getMedidaService().listarMedidas(cliente);
			LOG.debug("cantidad de datos: " + listaMedidas.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMedidas;
	}

	public void setListaMedidas(List<Medida> listaMedidas) {
		this.listaMedidas = listaMedidas;
	}

	public Double getBusto() {
		return busto;
	}

	public void setBusto(Double busto) {
		this.busto = busto;
	}

	public Double getBajoBusto() {
		return bajoBusto;
	}

	public void setBajoBusto(Double bajoBusto) {
		this.bajoBusto = bajoBusto;
	}

	public Double getAnteCadera() {
		return anteCadera;
	}

	public void setAnteCadera(Double anteCadera) {
		this.anteCadera = anteCadera;
	}

	public Double getPicoBusto1() {
		return picoBusto1;
	}

	public void setPicoBusto1(Double picoBusto1) {
		this.picoBusto1 = picoBusto1;
	}

	public Double getPicoBusto2() {
		return picoBusto2;
	}

	public void setPicoBusto2(Double picoBusto2) {
		this.picoBusto2 = picoBusto2;
	}

	public Medida getMedidaCliente() {
		return medidaCliente;
	}

	public void setMedidaCliente(Medida medidaCliente) {
		this.medidaCliente = medidaCliente;
	}

}
