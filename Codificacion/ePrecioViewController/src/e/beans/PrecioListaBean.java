package e.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import e.base.excepcion.ExcepcionServicio;
import e.dto.busqueda.BusquedaPrecioDto;
import e.dto.dominio.PrecioDto;
import e.servicio.constantes.ConstantesAction;

public class PrecioListaBean extends BaseBean {
	private final static Logger LOG = Logger.getLogger(PrecioListaBean.class);
	private List<PrecioDto> precios = new ArrayList<PrecioDto>();
	private BusquedaPrecioDto busquedaPrecio = new BusquedaPrecioDto();

	public PrecioListaBean() {
		super();
	}

	public void buscar(ActionEvent ev) {
		LOG.debug("");
		try {
			precios = getServicioPrecio().buscarPrecios(busquedaPrecio);
		} catch (ExcepcionServicio e) {
			e.printStackTrace();
		}
	}

	public String verPrecio() {
		LOG.debug("");
		return ConstantesAction.VER_PRECIO;
	}

	public List<PrecioDto> getPrecios() {
		return precios;
	}

	public BusquedaPrecioDto getBusquedaPrecio() {
		return busquedaPrecio;
	}

}
