package com.example.demo.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="seanceCode")
public class SeanceCode {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="date")
	private Date date;
	@Column(name="heure")
	private Date heure;
	/*
	@ManyToMany (mappedBy = "seances")
	*/
	@Transient
	private List<SerieCD> series = new ArrayList<>();
	
	/*
	@ManyToMany
	@JoinTable(name ="seance-client",
			joinColumns = @JoinColumn (name = "seanceCode_id"),
			inverseJoinColumns = @JoinColumn (name ="client_id"))
	*/
	@Transient
	private List<Client> clients = new ArrayList<>();
	
	public SeanceCode() {
		super();
	}
	public SeanceCode(Date date, Date heure, List<SerieCD> series, List<Client> clients) {
		super();
		this.date = date;
		this.heure = heure;
		this.series = series;
		this.clients = clients;
	}
	public SeanceCode(Long id, Date date, Date heure, List<SerieCD> series, List<Client> clients) {
		super();
		this.id = id;
		this.date = date;
		this.heure = heure;
		this.series = series;
		this.clients = clients;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getHeure() {
		return heure;
	}
	public void setHeure(Date heure) {
		this.heure = heure;
	}
	public List<SerieCD> getSerie() {
		return series;
	}
	public void setSerie(List<SerieCD> series) {
		this.series = series;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	
	
	
	

}
