package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CdRom")
public class CdRom {
	
	@Id
	@GeneratedValue
	private Long cdRomId;
	@Column(name="Editeur")
	private String editeur;
	@OneToMany
	@JoinTable (name="Series",
		joinColumns = @JoinColumn(name="cdRomId"),
		inverseJoinColumns = @JoinColumn(name = "serieCdId"))
	private SerieCD[] seriesCD;
	
	public CdRom() {
		super();
	}
	public CdRom(String editeur, SerieCD[] seriesCD) {
		super();
		this.editeur = editeur;
		this.seriesCD = seriesCD;
	}
	public CdRom(Long cdRomId, String editeur, SerieCD[] seriesCD) {
		super();
		this.cdRomId = cdRomId;
		this.editeur = editeur;
		this.seriesCD = seriesCD;
	}
	
	public Long getCdRomId() {
		return this.cdRomId;
	}
	public void setCdRomId(Long cdRomId) {
		this.cdRomId = cdRomId;
	}
	public String getEditeur() {
		return this.editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	public SerieCD[] getSeriesCD() {
		return seriesCD;
	}
	public void setSeriesCD(SerieCD[] seriesCD) {
		this.seriesCD = seriesCD;
	}
	
}
