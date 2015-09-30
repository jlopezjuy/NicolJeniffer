package e.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import e.base.dto.DTOSeleccionable;

public class ItemBean extends BaseBean {
	private final static String DIMENSIONES = "dimensiones";

	private Map<String, List<DTOSeleccionable>> items = new HashMap<String, List<DTOSeleccionable>>();

	public ItemBean() {
		super();
	}

	public List<DTOSeleccionable> getDimensionesItems() {
		List<DTOSeleccionable> lista = items.get(DIMENSIONES);
		if (lista == null || lista.isEmpty()) {
			lista = getServicioItem().getDimensiones();
			items.put(DIMENSIONES, lista);
		}
		return items.get(DIMENSIONES);
	}

}
