package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name = "serieCd")
public class SerieCd {
	
	@Id
	@GeneratedValue
	private Long id;
	@ManyToMany
	@JoinTable(name = "series", joinColumns = @JoinColumn(name = "serieCd_id"), inverseJoinColumns = @JoinColumn(name = "cdRom_id") )
	private List<CdRom> cdRoms;
	@ManyToMany
	@JoinTable(name = "questions", joinColumns = @JoinColumn(name = "serieCd_id"), inverseJoinColumns = @JoinColumn(name = "question_id"))
	private Map<Integer,Question> questions;
	
	/**
	 * Constructeur de serieCd sans parrametre
	 */
	public SerieCd() {
		super();
	}
	/**
	 * Constructeur de serieCd sans id avec ces parrametres
	 * @param cdRoms list des cdRom contenant cette serie
	 * @param questions contenus dans cette serie
	 */
	public SerieCd(List<CdRom> cdRoms, Map<Integer,Question> questions) {
		super();
		this.cdRoms = cdRoms;
		this.questions = questions;
	}
	/**
	 * Constructeur de serieCd avec tous ces parrametres
	 * @param id de cette serie
	 * @param cdRom contenant cette serie
	 * @param questions contenus dans cette serie
	 */
	public SerieCd(Long id, List<CdRom> cdRoms, Map<Integer,Question> questions) {
		super();
		this.id = id;
		this.cdRoms = cdRoms;
		this.questions = questions;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<CdRom> getCdRoms() {
		return cdRoms;
	}
	public void setCdRoms(List<CdRom> cdRoms) {
		this.cdRoms = cdRoms;
	}
	public Map<Integer,Question> getQuestions() {
		return questions;
	}
	
	public void setQuestions(Map<Integer, Question> questions) {
		List<Integer> listKey = new ArrayList<Integer>(questions.keySet());
		if (listKey.size()>40) {
			throw new RuntimeException("une serie ne contient que 40 questions");
		}
		this.questions = questions;
	}
	
	
	

}
