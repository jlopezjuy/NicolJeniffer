package e.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import e.base.excepcion.ExcepcionServicio;
import e.dto.busqueda.BusquedaMarcaDto;
import e.dto.dominio.MarcaDto;
import e.servicio.constantes.ConstantesAction;

public class MarcaListaBean extends BaseBean {
	private final static Logger LOG = Logger.getLogger(MarcaListaBean.class);
	private List<MarcaDto> marcas = new ArrayList<MarcaDto>();
	private BusquedaMarcaDto busquedaMarca = new BusquedaMarcaDto();

	public MarcaListaBean() {
		super();
	}

	public void buscar(ActionEvent ev) {
		LOG.debug("");
		try {
			marcas = getServicioPrecio().buscarMarcas(busquedaMarca);
		} catch (ExcepcionServicio e) {
			e.printStackTrace();
		}
	}

	public String verMarca() {
		LOG.debug("");
		return ConstantesAction.VER_MARCA;
	}

	public List<MarcaDto> getMarcas() {
		return marcas;
	}

	public BusquedaMarcaDto getBusquedaMarca() {
		return busquedaMarca;
	}

}
