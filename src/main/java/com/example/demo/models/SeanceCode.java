package com.example.demo.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "seanceCode")
public class SeanceCode {
	
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
	@JoinTable(name = "clients_seances",joinColumns = @JoinColumn(name = "seanceCode_id"), inverseJoinColumns = @JoinColumn(name = "client_id"))
	private List<Client> clients;
	@OneToOne
	@JoinColumn (name = "serieCd_id")
	private SerieCd serieCd;
	/**
	 * contructeur sans parametre de seanceCode
	 */
	public SeanceCode() {
		super();
	}
	/**
	 * constructeur de seanceCode sans le parrametre id
	 * @param date de la seance
	 * @param heure de la seance
	 * @param clients liste des participants a cette seance
	 * @param serieCd serie utilisee pour cette seance
	 */
	public SeanceCode(Date date, Date heure, List<Client> clients, SerieCd serieCd) {
		super();
		this.date = date;
		this.heure = heure;
		this.clients = clients;
		this.serieCd = serieCd;
	}

	/**
	 * constructeur de seance Code avec tous ces parrametres
	 * @param id de la seance
	 * @param date de la seance
	 * @param heure de la seance
	 * @param clients liste des participants a cette seance
	 * @param serieCd serie utilisee pour cette seance
	 */
	public SeanceCode(Long id, Date date, Date heure, List<Client> clients, SerieCd serieCd) {
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
