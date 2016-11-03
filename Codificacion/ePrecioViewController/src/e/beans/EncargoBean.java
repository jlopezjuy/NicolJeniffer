package e.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import e.dominio.entity.*;
import e.servicio.ServicioCliente;

public class EncargoBean extends BaseBean {
	private static final Logger LOG = Logger.getLogger(EncargoBean.class);

	private Encargos encargoSeleccionado;
	private Integer idEncargo;
	private Clientes cliente;
	private Valordominio valordominio;
	private BigDecimal importeTotal;
	private Date fechaEncargo;
	private Date fechaEntrega;
	private String tipoEvento;
	private String detalleVestido;
	private List<Encargos> listaEncargos = new ArrayList<Encargos>();
	private List<Clientes> listaClientes = new ArrayList<Clientes>();
	
	private List<SelectItem> listaClienteItem;
	private int clienteId;

	public EncargoBean() {
		super();
		try {
			listaEncargos = getServicioEncargo().listAll();
			LOG.debug("cantidad de datos: " + listaEncargos.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String nuevoEncargo(){
		cliente = new Clientes();
		return "altaEncargoView";
	}

	public void changeCliente(ValueChangeEvent event) {
		LOG.info("here " + event.getNewValue());
		Clientes cliente = getServicioCliente().getClienteId(Integer.valueOf(event.getNewValue().toString()));
		LOG.info("Cliente encontrado: "+ cliente.getNombre());
		this.cliente = cliente;
	}
	
	public void handleKeyEvent(AjaxBehaviorEvent event) {
		UIInput input =  (UIInput) event.getSource();
	    System.out.println(input.getValue());
	
		LOG.info("here " + input);
		LOG.info("Cliente seleccionado: "+clienteId);
    }

	/**
	 * 
	 * @return
	 */
	public String gurdarEncargo() {
		return "listaEncargosView";
	}

	/**
	 * 
	 * @return
	 */
	public String cancelarEncargo() {
		return "listaEncargosView";
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

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
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

	public List<Clientes> getListaClientes() {
		listaClientes = this.getServicioCliente().listAll();
		return listaClientes;
	}

	public void setListaClientes(List<Clientes> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<SelectItem> getListaClienteItem() {
		listaClienteItem = new ArrayList<SelectItem>();
		listaClientes = this.getServicioCliente().listAll();
		for(Clientes row: listaClientes){
			listaClienteItem.add(new SelectItem(row.getIdClientes(), row.getApellido() + " - " + row.getNombre()));
		}
		return listaClienteItem;
	}

	public void setListaClienteItem(List<SelectItem> listaClienteItem) {
		this.listaClienteItem = listaClienteItem;
	}
	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
}
