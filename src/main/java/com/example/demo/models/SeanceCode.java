package com.example.demo.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SeanceCode")
public class SeanceCode {
	
	@Id
	@GeneratedValue
	private Long seanceId;
	@Column(name="date")
	private Date date;
	@Column(name="heure")
	private Date heure;
	@Column(name="Serie")
	private SerieCD serie;
	@Column(name="participants")
	private List<Client> participants;
	
	public SeanceCode() {
		super();
	}
	public SeanceCode(Date date, Date heure, SerieCD serie, List<Client> participants) {
		super();
		this.date = date;
		this.heure = heure;
		this.serie = serie;
		this.participants = participants;
	}
	public SeanceCode(Long seanceId, Date date, Date heure, SerieCD serie, List<Client> participants) {
		super();
		this.seanceId = seanceId;
		this.date = date;
		this.heure = heure;
		this.serie = serie;
		this.participants = participants;
	}
	
	public Long getSeanceId() {
		return seanceId;
	}
	public void setSeanceId(Long seanceId) {
		this.seanceId = seanceId;
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
	public SerieCD getSerie() {
		return serie;
	}
	public void setSerie(SerieCD serie) {
		this.serie = serie;
	}
	public List<Client> getParticipants() {
		return participants;
	}
	public void setParticipants(List<Client> participants) {
		this.participants = participants;
	}
	
	
	
	
	

}
