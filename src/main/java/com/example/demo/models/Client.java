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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "client")
public class Client {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column (name = "nom")
	private String nom;
	@Column (name = "prenom")
	private String prenom;
	@Column (name = "adresse")
	private String adresse;
	@Temporal(TemporalType.DATE) 
	@Column (name = "datedeNaissance")
	private Date dateDeNaissance;
	@ManyToMany
	@JoinTable(name = "scores", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "score_id"))
	private List<Score> scores;
	
	/**
	 * constructeur de cliet sans parrametre
	 */
	public Client() {
		super();
	}

	/**
	 * Constructeur de client sans id avec ces parrametres
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param dateDeNaissance
	 * @param scores obtenus par le client
	 */
	public Client(String nom, String prenom, String adresse, Date dateDeNaissance, List<Score> scores) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.dateDeNaissance = dateDeNaissance;
		this.scores = scores;
	}

	/**
	 * Constructeur de client avec tous ces parrametres
	 * @param id du client
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param dateDeNaissance
	 * @param scores obtenus par le client
	 */
	public Client(Long id, String nom, String prenom, String adresse, Date dateDeNaissance, List<Score> scores) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.dateDeNaissance = dateDeNaissance;
		this.scores = scores;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
	
	
	

}
