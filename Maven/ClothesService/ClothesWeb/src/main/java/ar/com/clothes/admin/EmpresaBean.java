package ar.com.clothes.admin;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import ar.com.clothes.bean.BaseBean;
import ar.com.clothes.model.Empresa;
import ar.com.clothes.util.StringUtil;

@ManagedBean(name = "empresaBean")
@SessionScoped
public class EmpresaBean extends BaseBean {

	private static final Logger LOG = Logger.getLogger(EmpresaBean.class);

	private Empresa empresa;
	private Empresa empresaSeleccionada;
	private List<Empresa> listaEmpresas;
	private List<Empresa> listaEmpresasFiltradas;
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
	 * 
	 * @return
	 */
	public String busquedaEmpresa() {
		if (StringUtil.esVacio(nombreEmpresa)) {
			listaEmpresas = getEmpresaService().findAllEmpresa();
		} else {
			listaEmpresas = getEmpresaService().findByNombre(nombreEmpresa);
		}
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public String goAlta() {
		empresa = new Empresa();
		return "altaEmpresasView";
	}

	/**
	 * Metodo para guardar un cliente nuevo
	 * 
	 * @return
	 * @author jlopez
	 * @since 17/03/2017
	 * @version 1.0
	 */
	public String gurdar() {
		try {
			getEmpresaService().saveEmpresa(empresa);
			empresa = new Empresa();
			listaEmpresas = getEmpresaService().findAllEmpresa();
		} catch (Exception e) {
			LOG.error(e);
			return null;
		}
		return "adminListaEmpresasView";
	}

	/**
	 * 
	 * @return
	 */
	public String cancelar() {
		return "adminListaEmpresasView";
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

	/**
	 * @return the listaEmpresasFiltradas
	 */
	public List<Empresa> getListaEmpresasFiltradas() {
		return listaEmpresasFiltradas;
	}

	/**
	 * @param listaEmpresasFiltradas
	 *           the listaEmpresasFiltradas to set
	 */
	public void setListaEmpresasFiltradas(List<Empresa> listaEmpresasFiltradas) {
		this.listaEmpresasFiltradas = listaEmpresasFiltradas;
	}
}
