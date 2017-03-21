package ar.com.clothes.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import ar.com.clothes.model.Empresa;
import ar.com.clothes.model.Usuario;
import ar.com.clothes.util.EncriptacionUtil;

/**
 * 
 * @author MostroBook
 *
 */
@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean extends BaseBean {
	private static final Logger LOG = Logger.getLogger(UsuarioBean.class);

	private List<Usuario> listaUsuarios;
	private List<Usuario> listaUsuariosFiltrado;
	private Usuario usuario;
	private String nombreUsuario;
	private String passwordConfirm;

	private List<Empresa> listaEmpresas;
	private List<SelectItem> listaEmpresaItem;
	private int empresaId;
	private Empresa empresa;

	public UsuarioBean() {
		super();
	}

	@PostConstruct
	public void init() {
		listaUsuarios = getUsuarioService().findAllUsuarios();
		listaEmpresas = this.getEmpresaService().findAllEmpresa();
		for (Empresa row : listaEmpresas) {
			listaEmpresaItem.add(new SelectItem(row.getIdEmpresa(), row.getNombreEmpresa()));
		}
	}

	/**
	 * 
	 * @param event
	 */
	public void changeEmpresa(ValueChangeEvent event) {
		LOG.info("here " + event.getNewValue());
		Empresa empresa = getEmpresaService().findById(Integer.valueOf(event.getNewValue().toString()));
		LOG.info("Cliente encontrado: " + empresa.getNombreEmpresa());
		this.empresa = empresa;
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
			usuario.setEmpresa(empresa);
			usuario.setPassword(EncriptacionUtil.Encriptar(usuario.getPassword()));
			getUsuarioService().saveUsuario(usuario);
			usuario = new Usuario();
			listaUsuarios = getUsuarioService().findAllUsuarios();
		} catch (Exception e) {
			LOG.error(e);
			return null;
		}
		return "adminListaUsuariosView";
	}

	/**
	 * 
	 * @return
	 */
	public String cancelar() {
		return "adminListaUsuariosView";
	}

	/**
	 * 
	 * @return
	 */
	public String goAlta() {
		usuario = new Usuario();
		return "altaUsuariosView";
	}

	/**
	 * @return the listaUsuarios
	 */
	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	/**
	 * @param listaUsuarios
	 *           the listaUsuarios to set
	 */
	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	/**
	 * @return the listaUsuariosFiltrado
	 */
	public List<Usuario> getListaUsuariosFiltrado() {
		return listaUsuariosFiltrado;
	}

	/**
	 * @param listaUsuariosFiltrado
	 *           the listaUsuariosFiltrado to set
	 */
	public void setListaUsuariosFiltrado(List<Usuario> listaUsuariosFiltrado) {
		this.listaUsuariosFiltrado = listaUsuariosFiltrado;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *           the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario
	 *           the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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
	 * @return the listaEmpresaItem
	 */
	public List<SelectItem> getListaEmpresaItem() {
		listaEmpresaItem = new ArrayList<SelectItem>();
		listaEmpresas = this.getEmpresaService().findAllEmpresa();
		for (Empresa row : listaEmpresas) {
			listaEmpresaItem.add(new SelectItem(row.getIdEmpresa(), row.getNombreEmpresa()));
		}
		return listaEmpresaItem;
	}

	/**
	 * @param listaEmpresaItem
	 *           the listaEmpresaItem to set
	 */
	public void setListaEmpresaItem(List<SelectItem> listaEmpresaItem) {
		this.listaEmpresaItem = listaEmpresaItem;
	}

	/**
	 * @return the empresaId
	 */
	public int getEmpresaId() {
		return empresaId;
	}

	/**
	 * @param empresaId
	 *           the empresaId to set
	 */
	public void setEmpresaId(int empresaId) {
		this.empresaId = empresaId;
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
	 * @return the passwordConfirm
	 */
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	/**
	 * @param passwordConfirm
	 *           the passwordConfirm to set
	 */
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

}
