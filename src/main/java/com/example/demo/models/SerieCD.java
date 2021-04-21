package com.example.demo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "serieCd")
public class SerieCd {
	
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinTable(name = "series", joinColumns = @JoinColumn(name = "serieCd_id"), inverseJoinColumns = @JoinColumn(name = "cdRom_id") )
	private CdRom cdRom;
	@ManyToMany
	@JoinTable(name = "questions", joinColumns = @JoinColumn(name = "serieCd_id"), inverseJoinColumns = @JoinColumn(name = "question_id"))
	private List<Question> questions;
	
	/**
	 * Constructeur de serieCd sans parrametre
	 */
	public SerieCd() {
		super();
	}
	/**
	 * Constructeur de serieCd sans id avec ces parrametres
	 * @param cdRom contenant cette serie
	 * @param questions contenus dans cette serie
	 */
	public SerieCd(CdRom cdRom, List<Question> questions) {
		super();
		this.cdRom = cdRom;
		this.questions = questions;
	}
	/**
	 * Constructeur de serieCd avec tous ces parrametres
	 * @param id de cette serie
	 * @param cdRom contenant cette serie
	 * @param questions contenus dans cette serie
	 */
	public SerieCd(Long id, CdRom cdRom, List<Question> questions) {
		super();
		this.id = id;
		this.cdRom = cdRom;
		this.questions = questions;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CdRom getCdRom() {
		return cdRom;
	}
	public void setCdRom(CdRom cdRom) {
		this.cdRom = cdRom;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		if (questions.size()>40) {
			throw new RuntimeException("une serie ne contient que 40 questions");
		}
		this.questions = questions;
	}
	
	

}
