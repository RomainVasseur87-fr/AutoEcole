package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column (name = "intitule")
	private String intitule;
	@Column (name = "reponse")
	private String reponse;
	@Column (name = "difficulte")
	@Enumerated (EnumType.STRING)
	private Difficulte difficulte;
	@Column (name = "theme")
	@Enumerated (EnumType.STRING)
	private Theme theme;
	
	public Question() {
		super();
	}
	public Question(String intitule, String reponse, Difficulte difficulte, Theme theme) {
		super();
		this.intitule = intitule;
		this.reponse = reponse;
		this.difficulte = difficulte;
		this.theme = theme;
	}
	public Question(Long id, String intitule, String reponse, Difficulte difficulte, Theme theme) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.reponse = reponse;
		this.difficulte = difficulte;
		this.theme = theme;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	public Difficulte getDifficulte() {
		return difficulte;
	}
	public void setDifficulte(Difficulte difficulte) {
		this.difficulte = difficulte;
	}
	public Theme getTheme() {
		return theme;
	}
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	
	

}
