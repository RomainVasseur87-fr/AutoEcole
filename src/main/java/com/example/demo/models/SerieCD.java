package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SerieCD")
public class SerieCD {
	
	@Id
	@GeneratedValue
	private Long serieCdId;
	@ManyToOne
	@JoinTable(name="CdRom",
			joinColumns = @JoinColumn(name="serieCdId"),
			inverseJoinColumns = @JoinColumn(name = "cdRomId"))
	private CdRom cdRom;
	@OneToOne
	@JoinColumn(name = "serieContenuId")
	private SerieContenu serieContenu;
	
	public SerieCD() {
		super();
	}
	public SerieCD(CdRom cdRom,SerieContenu serieContenu ) {
		super();
		this.cdRom = cdRom;
		this.serieContenu= serieContenu;
	}
	public SerieCD(Long serieCdId, CdRom cdRom, SerieContenu serieContenu) {
		super();
		this.serieCdId = serieCdId;
		this.cdRom = cdRom;
		this.serieContenu= serieContenu;
	}
	
	public Long getSerieCdId() {
		return serieCdId;
	}
	public void setSerieCdId(Long serieCdId) {
		this.serieCdId = serieCdId;
	}
	public CdRom getCdRom() {
		return cdRom;
	}
	public void setCdRom(CdRom cdRom) {
		this.cdRom = cdRom;
	}
	public SerieContenu getSerieContenu() {
		return serieContenu;
	}
	public void setSerieContenu(SerieContenu serieContenu) {
		this.serieContenu = serieContenu;
	}
	
	

}
