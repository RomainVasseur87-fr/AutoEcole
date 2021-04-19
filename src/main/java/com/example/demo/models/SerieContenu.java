package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="serieContenu")
public class SerieContenu {
	
	@Id
	@GeneratedValue
	private Long id;
	@OneToOne(mappedBy = "serieContenu")
	private SerieCD serie;
	/*
	@ManyToMany
	@JoinTable(name="serieContenu-question",
			joinColumns = @JoinColumn(name="serieContenu_id"),
			inverseJoinColumns = @JoinColumn(name = "question_id"))
	*/
	@Transient
	private List<Question> questions = new ArrayList<>();
	
	public SerieContenu() {
		super();
	}
	public SerieContenu(SerieCD serie, List<Question> questions) {
		super();
		this.serie = serie;
		this.questions = questions;
	}
	public SerieContenu(Long id, SerieCD serie, List<Question> questions) {
		super();
		this.id = id;
		this.serie = serie;
		this.questions = questions;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public SerieCD getSerie() {
		return serie;
	}
	public void setSerie(SerieCD serie) {
		this.serie = serie;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	
}
