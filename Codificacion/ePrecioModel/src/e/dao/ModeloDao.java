package e.dao;

import java.util.List;

import e.base.dao.DAOBase;
import e.dominio.entity.Clientes;
import e.dominio.entity.Modelos;

/**
 * Interfaz Dao de Modelo
 * @author JLopez
 *
 */
public interface ModeloDao extends DAOBase<Modelos, Long>{
	List<Modelos> buscarNombreImagen(String nombreImagen);
	List<Modelos> listarModelos(Clientes cliente);
	void guardarModelo(Modelos modelo);
}
