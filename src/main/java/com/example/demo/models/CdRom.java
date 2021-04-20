package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cdRom")
public class CdRom {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column (name = "editeur")
	private String editeur;
	public CdRom() {
		super();
	}
	public CdRom(String editeur) {
		super();
		this.editeur = editeur;
	}
	public CdRom(Long id, String editeur) {
		super();
		this.id = id;
		this.editeur = editeur;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEditeur() {
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	
	

}
