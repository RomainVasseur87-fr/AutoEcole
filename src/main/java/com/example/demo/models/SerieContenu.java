package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Serie Contenu")
public class SerieContenu {
	
	@Id
	@GeneratedValue
	private Long serieContenuId;
	@Column(name="seriCD")
	private SerieCD serie;
	@Column(name="questions")
	private Question[] questions;
	
	public SerieContenu() {
		super();
	}
	public SerieContenu(SerieCD serie, Question[] questions) {
		super();
		this.serie = serie;
		this.questions = questions;
	}
	public SerieContenu(Long serieContenuId, SerieCD serie, Question[] questions) {
		super();
		this.serieContenuId = serieContenuId;
		this.serie = serie;
		this.questions = questions;
	}
	public Long getSerieContenuId() {
		return serieContenuId;
	}
	public void setSerieContenuId(Long serieContenuId) {
		this.serieContenuId = serieContenuId;
	}
	public SerieCD getSerie() {
		return serie;
	}
	public void setSerie(SerieCD serie) {
		this.serie = serie;
	}
	public Question[] getQuestions() {
		return questions;
	}
	public void setQuestions(Question[] questions) {
		this.questions = questions;
	}

	
}
