package com.example.demo.models;

public enum Theme {
	FxC("Feux de circulation"), Px("panneaux"),Ev("Environement"),Mc("Mecanique"),
	Sec("Securite"),Eq("Equipements");
	
private final String label;
	
	Theme(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	

}
