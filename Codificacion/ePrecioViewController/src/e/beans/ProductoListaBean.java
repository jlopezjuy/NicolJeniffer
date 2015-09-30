package e.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import e.base.excepcion.ExcepcionServicio;
import e.dto.busqueda.BusquedaProductoDto;
import e.dto.dominio.ProductoDto;
import e.servicio.constantes.ConstantesAction;

public class ProductoListaBean extends BaseBean {
	private final static Logger LOG = Logger.getLogger(ProductoListaBean.class);
	private List<ProductoDto> productos = new ArrayList<ProductoDto>();
	private BusquedaProductoDto busquedaProducto = new BusquedaProductoDto();

	public ProductoListaBean() {
		super();
	}

	public void buscar(ActionEvent ev) {
		LOG.debug("");
		try {
			productos = getServicioPrecio().buscarProductos(busquedaProducto);
		} catch (ExcepcionServicio e) {
			e.printStackTrace();
		}
	}

	public String verProducto() {
		LOG.debug("");
		return ConstantesAction.VER_PRODUCTO;
	}

	public List<ProductoDto> getProductos() {
		return productos;
	}

	public BusquedaProductoDto getBusquedaProducto() {
		return busquedaProducto;
	}

}
