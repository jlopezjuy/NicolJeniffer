package e.dominio.entity;

// Generated 28/10/2016 11:29:40 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import e.base.dominio.DominioBaseNombre;

/**
 * Valordominio generated by hbm2java
 */
@Entity
@Table(name = "valordominio", catalog = "nicolejeniffer")
public class Valordominio extends DominioBaseNombre {

	private Integer idValorDominio;
	private String descripcion;
	private Set encargoses = new HashSet(0);

	public Valordominio() {
	}

	public Valordominio(String descripcion, Set encargoses) {
		this.descripcion = descripcion;
		this.encargoses = encargoses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idValorDominio", unique = true, nullable = false)
	public Integer getIdValorDominio() {
		return this.idValorDominio;
	}

	public void setIdValorDominio(Integer idValorDominio) {
		this.idValorDominio = idValorDominio;
	}

	@Column(name = "Descripcion", length = 45)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "valordominio")
	public Set getEncargoses() {
		return this.encargoses;
	}

	public void setEncargoses(Set encargoses) {
		this.encargoses = encargoses;
	}

}
