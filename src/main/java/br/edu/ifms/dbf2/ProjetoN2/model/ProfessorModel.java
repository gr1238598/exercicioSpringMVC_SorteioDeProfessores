package br.edu.ifms.dbf2.ProjetoN2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Professor")
public class ProfessorModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name="nome")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "area_id")
	private AreaModel area;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public AreaModel getArea() {
		return area;
	}

	public void setArea(AreaModel area) {
		this.area = area;
	}
	
	
}
