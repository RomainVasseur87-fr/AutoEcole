package com.example.demo.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Examen {
	
	@Id
	@GeneratedValue
	private Long id;
	@Temporal(TemporalType.DATE) 
	@Column (name = "date")
	private Date date;
	@Temporal(TemporalType.DATE) 
	@Column (name = "heure")
	private Date heure;
	@ManyToMany
	@JoinTable(name = "clients_examens",joinColumns = @JoinColumn(name = "examen_id"), inverseJoinColumns = @JoinColumn(name = "client_id"))
	private List<Client> clients;
	@OneToOne
	@JoinColumn (name = "serieCd_id")
	private SerieCd serieCd;
	
	/**
	 * Constructeur d'examen sans parrametre
	 */
	public Examen() {
		super();
	}
	/**
	 * Constructeur d'examen sans id avec ces parrametres
	 * @param date de l'examen
	 * @param heure de l'examen
	 * @param clients participants à l'examen
	 * @param serieCd presentee à l'examen
	 */
	public Examen(Date date, Date heure, List<Client> clients, SerieCd serieCd) {
		super();
		this.date = date;
		this.heure = heure;
		this.clients = clients;
		this.serieCd = serieCd;
	}
	/**
	 * Constructeur d'examen avec tous ces parrametres
	 * @param id
	 * @param date de l'examen
	 * @param heure de l'examen
	 * @param clients participants à l'examen
	 * @param serieCd presentee à l'examen
	 */
	public Examen(Long id, Date date, Date heure, List<Client> clients, SerieCd serieCd) {
		super();
		this.id = id;
		this.date = date;
		this.heure = heure;
		this.clients = clients;
		this.serieCd = serieCd;
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
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public SerieCd getSerieCd() {
		return serieCd;
	}
	public void setSerieCd(SerieCd serieCd) {
		this.serieCd = serieCd;
	}
	
	

}
