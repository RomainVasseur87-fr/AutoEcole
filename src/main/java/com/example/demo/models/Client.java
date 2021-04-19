package com.example.demo.models;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="client")
public class Client {
	@Id
	@GeneratedValue
	private Long id;
	@Enumerated (EnumType.STRING)
	@Column(name="civilite")
	private Civilite civilite;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Column(name="adresse")
	private String adresse;
	@Column(name="Date de naissance")
	private Date dateNaissance;
	/*
	@ManyToMany
	@JoinTable (name = "client-score",
			joinColumns = @JoinColumn (name = "clien_id"),
			inverseJoinColumns = @JoinColumn (name = "score_id"))
	*/
	@Transient
	private List<Score> scores;
	
	public Client() {
		super();
	}
	public Client(Civilite civilite, String nom, String prenom, String adresse, Date dateNaissance,
			List<Score> scores) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
		this.scores = scores;
	}
	public Client(Long id, Civilite civilite, String nom, String prenom, String adresse, Date dateNaissance,
			List<Score> scores) {
		super();
		this.id = id;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
		this.scores = scores;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Civilite getCivilite() {
		return civilite;
	}
	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
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
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public List<Score> getScores() {
		return scores;
	}
	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
	

}
