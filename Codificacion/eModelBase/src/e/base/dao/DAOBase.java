package e.base.dao;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

import e.base.dominio.DominioBase;
import e.base.excepcion.ExcepcionBaseDeDato;

public interface DAOBase<T extends DominioBase, ID extends Serializable> {
	T obtener(ID id) throws ExcepcionBaseDeDato;

	Long getNextVal() throws ExcepcionBaseDeDato;

	Object guardar(T objeto) throws ExcepcionBaseDeDato;

	void editar(T objeto) throws ExcepcionBaseDeDato;

	void eliminar(T objeto) throws ExcepcionBaseDeDato;

	List<T> listar() throws ExcepcionBaseDeDato;

	Blob getBlob(InputStream contenidoBinario) throws ExcepcionBaseDeDato;
}
