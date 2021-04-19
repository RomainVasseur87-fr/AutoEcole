package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "cdRom")
public class CdRom {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="Editeur")
	private String editeur;
	/*
	@ManyToMany (mappedBy = "cdRoms")
	*/
	@Transient
	private List<SerieCD> seriesCD = new ArrayList<>();
	
	
	public CdRom() {
		super();
	}
	public CdRom(String editeur, List<SerieCD> seriesCD) {
		super();
		this.editeur = editeur;
		this.seriesCD = seriesCD;
	}
	public CdRom(Long id, String editeur, List<SerieCD> seriesCD) {
		super();
		this.id = id;
		this.editeur = editeur;
		this.seriesCD = seriesCD;
	}
	
	public Long getId() {
		return this.id;
	}
	public void setid(Long id) {
		this.id = id;
	}
	public String getEditeur() {
		return this.editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	public List<SerieCD> getSeriesCD() {
		return seriesCD;
	}
	public void setSeriesCD(List<SerieCD> seriesCD) {
		this.seriesCD = seriesCD;
	}
	
}
