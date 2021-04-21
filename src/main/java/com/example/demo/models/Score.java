package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "score")
public class Score {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "score")
	private Integer score;
	/**
	 * constructeur de score sans parrametre
	 */
	public Score() {
		super();
	}
	/**
	 * constructeur de score sans id
	 * @param score
	 */
	public Score(Integer score) {
		super();
		this.score = score;
	}
	/**
	 * constructeur de score avec tous ces parrametres
	 * @param id du score
	 * @param score
	 */
	public Score(Long id, Integer score) {
		super();
		this.id = id;
		this.score = score;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		if (score>40) {
			throw new RuntimeException("le score e peut pas depasse 40");
		}
		this.score = score;
	}
	

}
