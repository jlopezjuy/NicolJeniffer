package ar.com.clothes.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author MostroBook
 *
 */
@Entity
@Table(name = "ValorDominio")
public class ValorDominio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idValorDominio;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@OneToMany(mappedBy = "valordominio", cascade = CascadeType.ALL)
	private Set<Encargo> encargos = new HashSet<Encargo>(0);

	public ValorDominio() {

	}

	/**
	 * @return the idValorDominio
	 */
	public Integer getIdValorDominio() {
		return idValorDominio;
	}

	/**
	 * @param idValorDominio
	 *           the idValorDominio to set
	 */
	public void setIdValorDominio(Integer idValorDominio) {
		this.idValorDominio = idValorDominio;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *           the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the encargos
	 */
	public Set<Encargo> getEncargos() {
		return encargos;
	}

	/**
	 * @param encargos
	 *           the encargos to set
	 */
	public void setEncargos(Set<Encargo> encargos) {
		this.encargos = encargos;
	}

}
