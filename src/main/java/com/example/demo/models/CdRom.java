package com.example.demo.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cdRom")
public class CdRom {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column (name = "editeur")
	private String editeur;
	@OneToMany(mappedBy = "cdRom")
	private List<SerieCd> seriesCd;
	
	
	public CdRom() {
		super();
	}
	public CdRom(String editeur) {
		super();
		this.editeur = editeur;
	}
	public CdRom(Long id, String editeur) {
		super();
		this.id = id;
		this.editeur = editeur;
	}
	
	public CdRom(Long id, String editeur, List<SerieCd> seriesCd) {
		super();
		this.id = id;
		this.editeur = editeur;
		this.seriesCd = seriesCd;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEditeur() {
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	public List<SerieCd> getSeriesCd() {
		return seriesCd;
	}
	public void setSeriesCd(List<SerieCd> seriesCd) {
		this.seriesCd = seriesCd;
	}
	

}
