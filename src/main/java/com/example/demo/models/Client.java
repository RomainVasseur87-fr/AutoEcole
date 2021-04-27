package com.example.demo.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name = "client")
public class Client extends Personne {
	
	@ManyToMany
	@JoinTable(name = "scores", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "score_id"))
	private List<Score> scores;
	
	/**
	 * constructeur de client sans parrametre
	 */
	public Client() {
		super();
	}

	/**
	 * Constructeur de client avec tous ces parrametres
	 * @param scores obtenues par le client
	 */
	public Client(List<Score> scores) {
		super();
		this.scores = scores;
	}



	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
	
	
	

}
