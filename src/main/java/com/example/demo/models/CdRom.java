package com.example.demo.models;

public class CdRom {
	
	private Long CdRomId;
	private String Editeur;
	
	public CdRom() {
		super();
	}
	public CdRom(String editeur) {
		super();
		Editeur = editeur;
	}
	public CdRom(Long cdRomId, String editeur) {
		super();
		CdRomId = cdRomId;
		Editeur = editeur;
	}
	public Long getCdRomId() {
		return CdRomId;
	}
	public void setCdRomId(Long cdRomId) {
		CdRomId = cdRomId;
	}
	public String getEditeur() {
		return Editeur;
	}
	public void setEditeur(String editeur) {
		Editeur = editeur;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CdRomId == null) ? 0 : CdRomId.hashCode());
		result = prime * result + ((Editeur == null) ? 0 : Editeur.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CdRom other = (CdRom) obj;
		if (CdRomId == null) {
			if (other.CdRomId != null)
				return false;
		} else if (!CdRomId.equals(other.CdRomId))
			return false;
		if (Editeur == null) {
			if (other.Editeur != null)
				return false;
		} else if (!Editeur.equals(other.Editeur))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CdRom [CdRomId=" + CdRomId + ", Editeur=" + Editeur + "]";
	}
	
	

}
