package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CdRom")
public class CdRom {
	
	@Id
	@GeneratedValue
	private Long CdRomId;
	@Column(name="Editeur")
	private String Editeur;
	@Column(name="Serie")
	private SerieCD[] seriesCD;
	
	public CdRom() {
		super();
	}
	public CdRom(String editeur, SerieCD[] seriesCD) {
		super();
		Editeur = editeur;
		this.seriesCD = seriesCD;
	}
	public CdRom(Long cdRomId, String editeur, SerieCD[] seriesCD) {
		super();
		CdRomId = cdRomId;
		Editeur = editeur;
		this.seriesCD = seriesCD;
	}
	
	public Long getCdRomId() {
		return CdRomId;
	}
	public void setCdRomId(Long cdRomId) {
		CdRomId = cdRomId;
	}
	public String getEditeur() {
		return Editeur;
	}
	public void setEditeur(String editeur) {
		Editeur = editeur;
	}
	public SerieCD[] getSeriesCD() {
		return seriesCD;
	}
	public void setSeriesCD(SerieCD[] seriesCD) {
		this.seriesCD = seriesCD;
	}
	
}
