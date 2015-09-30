package e.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import e.base.excepcion.ExcepcionServicio;
import e.dto.busqueda.BusquedaDimensionDto;
import e.dto.dominio.DimensionDto;
import e.servicio.constantes.ConstantesAction;

public class DimensionListaBean extends BaseBean {
	private final static Logger LOG = Logger.getLogger(DimensionListaBean.class);
	private List<DimensionDto> dimensiones = new ArrayList<DimensionDto>();
	private BusquedaDimensionDto busquedaDimension = new BusquedaDimensionDto();

	public DimensionListaBean() {
		super();
	}

	public void buscar(ActionEvent ev) {
		LOG.debug("");
		try {
			dimensiones = getServicioPrecio().buscarDimensiones(busquedaDimension);
		} catch (ExcepcionServicio e) {
			e.printStackTrace();
		}
	}

	public String verDimension() {
		LOG.debug("");
		return ConstantesAction.VER_DIMENSION;
	}

	public List<DimensionDto> getDimensiones() {
		return dimensiones;
	}

	public BusquedaDimensionDto getBusquedaDimension() {
		return busquedaDimension;
	}

}
