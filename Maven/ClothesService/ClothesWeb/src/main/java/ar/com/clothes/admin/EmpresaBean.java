package ar.com.clothes.admin;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ar.com.clothes.bean.BaseBean;
import ar.com.clothes.model.Empresa;

@ManagedBean(name = "empresaBean")
@SessionScoped
public class EmpresaBean extends BaseBean {
	private Empresa empresa;
	private Empresa empresaSeleccionada;
	private List<Empresa> listaEmpresas = new ArrayList<Empresa>();
	private String nombreEmpresa;

	/**
	 * 
	 */
	public EmpresaBean() {
		super();
		try {
			listaEmpresas = getEmpresaService().findAllEmpresa();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa
	 *           the empresa to set
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return the empresaSeleccionada
	 */
	public Empresa getEmpresaSeleccionada() {
		return empresaSeleccionada;
	}

	/**
	 * @param empresaSeleccionada
	 *           the empresaSeleccionada to set
	 */
	public void setEmpresaSeleccionada(Empresa empresaSeleccionada) {
		this.empresaSeleccionada = empresaSeleccionada;
	}

	/**
	 * @return the listaEmpresas
	 */
	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	/**
	 * @param listaEmpresas
	 *           the listaEmpresas to set
	 */
	public void setListaEmpresas(List<Empresa> listaEmpresas) {
		this.listaEmpresas = listaEmpresas;
	}

	/**
	 * @return the nombreEmpresa
	 */
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	/**
	 * @param nombreEmpresa
	 *           the nombreEmpresa to set
	 */
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
}
