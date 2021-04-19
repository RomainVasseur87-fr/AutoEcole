package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="serieCd")
public class SerieCD {
	
	@Id
	@GeneratedValue
	private Long id;
	/*
	@ManyToMany
	@JoinTable(name="Cdrom-Series",
			joinColumns = @JoinColumn(name="serieCd_id"),
			inverseJoinColumns = @JoinColumn(name = "cdRom_id"))
	*/
	@Transient
	private List<CdRom> cdRoms = new ArrayList<>();
	@OneToOne
	@JoinColumn(name = "serieContenu_id")
	private SerieContenu serieContenu;
	/*
	@ManyToMany
	@JoinTable(name="seance-serie",
			joinColumns = @JoinColumn(name="serieCd_id"),
			inverseJoinColumns = @JoinColumn(name = "seanceCode_id"))
	*/
	@Transient
	private List<SeanceCode> seances = new ArrayList<>();
	
	public SerieCD() {
		super();
	}
	public SerieCD(List<CdRom> cdRoms,SerieContenu serieContenu,List<SeanceCode> seances ) {
		super();
		this.cdRoms = cdRoms;
		this.serieContenu = serieContenu;
		this.seances = seances;
	}
	public SerieCD(Long id, List<CdRom> cdRoms, SerieContenu serieContenu,List<SeanceCode> seances) {
		super();
		this.id = id;
		this.cdRoms = cdRoms;
		this.serieContenu = serieContenu;
		this.seances = seances;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<CdRom> getCdRoms() {
		return cdRoms;
	}
	public void setCdRoms(List<CdRom> cdRoms) {
		this.cdRoms = cdRoms;
	}
	public SerieContenu getSerieContenu() {
		return serieContenu;
	}
	public void setSerieContenu(SerieContenu serieContenu) {
		this.serieContenu = serieContenu;
	}
	public List<SeanceCode> getSeances() {
		return seances;
	}
	public void setSeances(List<SeanceCode> seances) {
		this.seances = seances;
	}
	
	

}
