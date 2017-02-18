package ar.com.clothes.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

import ar.com.clothes.model.Cliente;
import ar.com.clothes.model.Encargo;
import ar.com.clothes.model.Medida;
import ar.com.clothes.model.Pago;
import ar.com.clothes.model.ValorDominio;

/**
 * 
 * @author MostroBook
 *
 */
@ManagedBean(name = "encargoBean")
@SessionScoped
public class EncargoBean extends BaseBean {
	private static final Logger LOG = Logger.getLogger(EncargoBean.class);

	private Encargo encargoSeleccionado;
	private Integer idEncargo;
	private Cliente cliente;
	private ValorDominio valordominio;
	private BigDecimal importeTotal;
	private Date fechaEncargo;
	private Date fechaEntrega;
	private String tipoEvento;
	private String detalleVestido;
	private List<Encargo> listaEncargos = new ArrayList<Encargo>();
	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	private List<Medida> listaMedidas = new ArrayList<Medida>();
	private List<Pago> listaPagos = new ArrayList<Pago>();
	private Medida medida;
	private Pago pago;
	private Encargo encargo;

	private List<SelectItem> listaClienteItem;
	private int clienteId;

	public EncargoBean() {
		super();
		try {
			listaEncargos = getEncargoService().findAllEncargos();
			LOG.debug("cantidad de datos: " + listaEncargos.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String nuevoEncargo() {
		loadValues();
		return "altaEncargoView";
	}

	private void loadValues() {
		cliente = new Cliente();
		medida = new Medida();
		pago = new Pago();
		encargo = new Encargo();
		clienteId = (Integer) 0;
	}

	public void changeCliente(ValueChangeEvent event) {
		LOG.info("here " + event.getNewValue());
		Cliente cliente = getClienteService().findById(Integer.valueOf(event.getNewValue().toString()));
		LOG.info("Cliente encontrado: " + cliente.getNombre());
		this.cliente = cliente;
		listaMedidas = getMedidaService().listarMedidas(cliente);
	}

	/**
	 *
	 * @return
	 */
	public String gurdarEncargo() {
		encargo.setCliente(cliente);
		try {

			ValorDominio valor = getValorDominioService().findById(Integer.valueOf("1"));
			encargo.setValordominio(valor);
			getEncargoService().saveEncargo(encargo);
			for (Pago pago : listaPagos) {
				getPagoService().savePago(pago);
			}
			loadValues();
			listaEncargos = getEncargoService().findAllEncargos();
		} catch (Exception e) {
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

	public void loadMedida() {
		LOG.info("Entro a cargar una medida nueva");
		medida = new Medida();
		medida.setCliente(cliente);
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.execute("PF('dlg2').show();");
		requestContext.update("altaEncargoForm");
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
			medida.setFechaMedida(new Date());
			getMedidaService().saveMedida(getMedida());
			medida = new Medida();
			listaMedidas = getMedidaService().listarMedidas(cliente);
		} catch (Exception e) {
			LOG.error(e);
			return null;
		}
		return "";
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
		medida = new Medida();
		return "";
	}

	public void loadPago() {
		LOG.info("Entro a cargar una medida nueva");
		pago = new Pago();
		pago.setEncargo(encargo);
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.execute("PF('dlg3').show();");
		requestContext.update("altaEncargoForm");
	}

	/**
	 * Metodo para guardar una medida
	 * 
	 * @return
	 * @author JLopez
	 * @since 24/10/2015
	 * @version 1.0
	 */
	public String gurdarPago() {
		// try {
		pago.setFechaPago(new Date());
		// getServicioMedida().guardarMedida(getMedida());
		listaPagos.add(pago);
		pago = new Pago();
		// listaMedidas = getServicioMedida().listAll(cliente);
		// } catch (Excepcion e) {
		// LOG.error(e);
		// return null;
		// }
		return "";
	}

	/**
	 * Metodo que cancela el alta de medida
	 * 
	 * @return
	 * @author JLopez
	 * @since 27/10/2015
	 * @version 1.0
	 */
	public String cancelarPago() {
		pago = new Pago();
		return "";
	}

	public Encargo getEncargoSeleccionado() {
		return encargoSeleccionado;
	}

	public void setEncargoSeleccionado(Encargo encargoSeleccionado) {
		this.encargoSeleccionado = encargoSeleccionado;
	}

	public Integer getIdEncargo() {
		return idEncargo;
	}

	public void setIdEncargo(Integer idEncargo) {
		this.idEncargo = idEncargo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ValorDominio getValordominio() {
		return valordominio;
	}

	public void setValordominio(ValorDominio valordominio) {
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

	public List<Encargo> getListaEncargos() {
		return listaEncargos;
	}

	public void setListaEncargos(List<Encargo> listaEncargos) {
		this.listaEncargos = listaEncargos;
	}

	public List<Cliente> getListaCliente() {
		listaCliente = this.getClienteService().findAllClientes();
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public List<SelectItem> getListaClienteItem() {
		listaClienteItem = new ArrayList<SelectItem>();
		listaCliente = this.getClienteService().findAllClientes();
		for (Cliente row : listaCliente) {
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

	public List<Medida> getListaMedidas() {
		return listaMedidas;
	}

	public void setListaMedidas(List<Medida> listaMedidas) {
		this.listaMedidas = listaMedidas;
	}

	public List<Pago> getListaPagos() {
		return listaPagos;
	}

	public void setListaPagos(List<Pago> listaPagos) {
		this.listaPagos = listaPagos;
	}

	public Medida getMedida() {
		return medida;
	}

	public void setMedida(Medida medida) {
		this.medida = medida;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public Encargo getEncargo() {
		return encargo;
	}

	public void setEncargo(Encargo encargo) {
		this.encargo = encargo;
	}

}
