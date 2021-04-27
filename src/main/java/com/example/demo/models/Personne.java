package com.example.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Personne {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column (name = "nom")
	private String nom;
	@Column (name = "prenom")
	private String prenom;
	@Temporal(TemporalType.DATE) 
	@Column (name = "datedeNaissance")
	private Date dateDeNaissance;
	@Column (name = "adresse")
	private String adresse;
	
	/**
	 * Contructeur de personne sans parrametres
	 */
	public Personne() {
		super();
	}
	/**
	 * Constructeur de personne sans id avec ces parrametres
	 * @param nom
	 * @param prenom
	 * @param dateDeNaissance
	 * @param adresse
	 */
	public Personne(String nom, String prenom, Date dateDeNaissance, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
	}
	/**
	 * Contructeur de personne avec tous ces parrametres
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param dateDeNaissance
	 * @param adresse
	 */
	public Personne(Long id, String nom, String prenom, Date dateDeNaissance, String adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
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
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	


}
