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
import org.primefaces.context.RequestContext;

import e.base.excepcion.ExcepcionServicio;
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
	private List<Medidas> listaMedidas = new ArrayList<Medidas>();
	private List<Pagos> listaPagos = new ArrayList<Pagos>();
	private Medidas medida;
	private Pagos pago;
	private Encargos encargo;

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

	public String nuevoEncargo() {
		loadValues();
		return "altaEncargoView";
	}
	
	private void loadValues(){
		cliente = new Clientes();
		medida = new Medidas();
		pago = new Pagos();
		encargo = new Encargos();
		clienteId = (Integer) 0;
	}

	public void changeCliente(ValueChangeEvent event) {
		LOG.info("here " + event.getNewValue());
		Clientes cliente = getServicioCliente().getClienteId(Integer.valueOf(event.getNewValue().toString()));
		LOG.info("Cliente encontrado: " + cliente.getNombre());
		this.cliente = cliente;
		listaMedidas = getServicioMedida().listAll(cliente);
	}

	/**
	 * 
	 * @return
	 */
	public String gurdarEncargo() {
		encargo.setClientes(cliente);
		try {
			getServicioEncargo().guardarEncargo(encargo);
			for(Pagos pago: listaPagos){
				getServicioPago().guardarPago(pago);
			}
			loadValues();
			listaEncargos = getServicioEncargo().listAll();
		} catch (ExcepcionServicio e) {
			e.printStackTrace();
		}
		return "listaEncargosView";
	}

	/**
	 * 
	 * @return
	 */
	public String cancelarEncargo() {
		return "listaEncargosView";
	}
	
	public void loadMedida(){
		LOG.info("Entro a cargar una medida nueva");
		medida = new Medidas();
		medida.setClientes(cliente);
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.execute("PF('dlg2').show();");  
		requestContext.update("altaEncargoForm");
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
			medida.setFechaMedida(new Date());
			getServicioMedida().guardarMedida(getMedida());
			medida = new Medidas();
			listaMedidas = getServicioMedida().listAll(cliente);
		} catch (ExcepcionServicio e) {
			LOG.error(e);
			return null;
		}
		return "";
	}
	
	/**
	 * Metodo que cancela el alta de medida
	 * @return
	 * @author JLopez
	 * @since 27/10/2015
	 * @version 1.0
	 */
	public String cancelarMedida(){
		medida = new Medidas();
		return "";
	}
	
	public void loadPago(){
		LOG.info("Entro a cargar una medida nueva");
		pago = new Pagos();
		pago.setEncargos(encargo);
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.execute("PF('dlg3').show();");  
		requestContext.update("altaEncargoForm");
	}
	
	/**
	 * Metodo para guardar una medida
	 * @return
	 * @author JLopez
	 * @since 24/10/2015
	 * @version 1.0
	 */
	public String gurdarPago() {
		//try {
			pago.setFechaPago(new Date());
			//getServicioMedida().guardarMedida(getMedida());
			listaPagos.add(pago);
			pago = new Pagos();
			//listaMedidas = getServicioMedida().listAll(cliente);
		//} catch (Excepcion e) {
			//LOG.error(e);
			//return null;
		//}
		return "";
	}
	
	/**
	 * Metodo que cancela el alta de medida
	 * @return
	 * @author JLopez
	 * @since 27/10/2015
	 * @version 1.0
	 */
	public String cancelarPago(){
		pago = new Pagos();
		return "";
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
		for (Clientes row : listaClientes) {
			listaClienteItem.add(new SelectItem(row.getIdClientes(), row
					.getApellido() + " - " + row.getNombre()));
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

	public List<Medidas> getListaMedidas() {
		return listaMedidas;
	}

	public void setListaMedidas(List<Medidas> listaMedidas) {
		this.listaMedidas = listaMedidas;
	}

	public List<Pagos> getListaPagos() {
		return listaPagos;
	}

	public void setListaPagos(List<Pagos> listaPagos) {
		this.listaPagos = listaPagos;
	}

	public Medidas getMedida() {
		return medida;
	}

	public void setMedida(Medidas medida) {
		this.medida = medida;
	}

	public Pagos getPago() {
		return pago;
	}

	public void setPago(Pagos pago) {
		this.pago = pago;
	}

	public Encargos getEncargo() {
		return encargo;
	}

	public void setEncargo(Encargos encargo) {
		this.encargo = encargo;
	}
	
}
