package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Question")
public class Question {
	
	@Id
	@GeneratedValue
	private Long questionId;
	@Column(name="intitule")
	private String intitule;
	@Column(name="reponse")
	private String reponse;
	@Column(name="difficulte")
	private Difficulte difficulte;
	@Column(name="theme")
	private Theme theme;
	@ManyToOne
	@JoinTable(name="serieContenu",
			joinColumns = @JoinColumn(name="questionId"),
			inverseJoinColumns = @JoinColumn(name = "serieContenuId"))
	private SerieContenu serieContenu;
	
	public Question() {
		super();
	}
	public Question(String intitule, String reponse, Difficulte difficulte, Theme theme, SerieContenu serieContenu) {
		super();
		this.intitule = intitule;
		this.reponse = reponse;
		this.difficulte = difficulte;
		this.theme = theme;
		this.serieContenu= serieContenu;
	}
	public Question(Long questionId, String intitule, String reponse, Difficulte difficulte, Theme theme,SerieContenu serieContenu) {
		super();
		this.questionId = questionId;
		this.intitule = intitule;
		this.reponse = reponse;
		this.difficulte = difficulte;
		this.theme = theme;
		this.serieContenu= serieContenu;
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
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
	public SerieContenu getSerieContenu() {
		return serieContenu;
	}
	public void setSerieContenu(SerieContenu serieContenu) {
		this.serieContenu = serieContenu;
	}
	
}
