package com.example.demo.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cdRom")
public class CdRom {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column (name = "editeur")
	private String editeur;
	@ManyToMany(mappedBy = "cdRoms")
	private List<SerieCd> seriesCd;
	
	/**
	 * contructeur de cdRom sans parrametre
	 */
	public CdRom() {
		super();
	}
	/**
	 * Constructeur de CdRom sans id avec ces parrametres
	 * @param editeur du cdRom
	 * @param seriesCd liste des serieCd que le cdrom contient
	 */
	public CdRom(String editeur, List<SerieCd> seriesCd) {
		super();
		this.editeur = editeur;
		this.seriesCd = seriesCd;
	}
	/**
	 * Constructeur de cdRom avec tous ces parrametres
	 * @param id du cdRom
	 * @param editeur du cdRom
	 * @param seriesCd liste des serieCd que le cdrom contient
	 */
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
		if (seriesCd.size()>6) {
			throw new RuntimeException("un cdRom ne peut contenir que 6 series");
		}
		this.seriesCd = seriesCd;
	}
	

}
