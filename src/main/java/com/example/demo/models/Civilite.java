package com.example.demo.models;

public enum Civilite {
	M("Monsieur"),MME("Madame"), MLLE("Mademoiselle");
	
	private final String label;
	
	Civilite(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
	
	
	

}
