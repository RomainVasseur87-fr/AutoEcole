package com.example.demo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Client")
public class Client extends Personne {
	
	private List<Integer> scores;

	public Client(List<Integer> scores) {
		super();
		this.scores = scores;
	}

	public List<Integer> getScores() {
		return scores;
	}

	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}
	
	

}
