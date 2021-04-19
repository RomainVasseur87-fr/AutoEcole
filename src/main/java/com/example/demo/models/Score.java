package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "score")
public class Score {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column (name = "score")
	private Integer score;
	
	public Score() {
		super();
	}
	public Score(Integer score) {
		super();
		this.score = score;
	}
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
		this.score = score;
	}
	
	

}
