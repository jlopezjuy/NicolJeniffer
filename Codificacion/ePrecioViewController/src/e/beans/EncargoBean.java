package e.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import e.dominio.entity.*;

public class EncargoBean extends BaseBean {
	private static final Logger LOG = Logger.getLogger(EncargoBean.class);

	private Encargos encargoSeleccionado;
	private Integer idEncargo;
	private Clientes clientes;
	private Valordominio valordominio;
	private BigDecimal importeTotal;
	private Date fechaEncargo;
	private Date fechaEntrega;
	private String tipoEvento;
	private String detalleVestido;
	private List<Encargos> listaEncargos = new ArrayList<Encargos>();

	public EncargoBean() {
		super();
		try {
			listaEncargos = getServicioEncargo().listAll();
			LOG.debug("cantidad de datos: " + listaEncargos.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Encargos getEncargoSeleccionado() {
		return encargoSeleccionado;
	}

	public void setEncargoSeleccionado(Encargos encargoSeleccionado) {
		this.encargoSeleccionado = encargoSeleccionado;
	}

	public Integer getIdEncargo() {
		return idEncargo;
	}

	public void setIdEncargo(Integer idEncargo) {
		this.idEncargo = idEncargo;
	}

	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	public Valordominio getValordominio() {
		return valordominio;
	}

	public void setValordominio(Valordominio valordominio) {
		this.valordominio = valordominio;
	}

	public BigDecimal getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(BigDecimal importeTotal) {
		this.importeTotal = importeTotal;
	}

	public Date getFechaEncargo() {
		return fechaEncargo;
	}

	public void setFechaEncargo(Date fechaEncargo) {
		this.fechaEncargo = fechaEncargo;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getDetalleVestido() {
		return detalleVestido;
	}

	public void setDetalleVestido(String detalleVestido) {
		this.detalleVestido = detalleVestido;
	}

	public List<Encargos> getListaEncargos() {
		return listaEncargos;
	}

	public void setListaEncargos(List<Encargos> listaEncargos) {
		this.listaEncargos = listaEncargos;
	}

}
