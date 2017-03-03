package ar.com.clothes.dao;

import java.util.List;

import ar.com.clothes.model.Empresa;

/**
 * 
 * @author MostroBook
 *
 */
public interface EmpresaDao {
	void saveEmpresa(Empresa empresa);
    
    List<Empresa> findAllEmpresa();
     
    void deleteEmpresaById(Integer idEmpresa);
     
    Empresa findById(Integer idEmpresa);
     
    void updateEmpresa(Empresa empresa);
}
