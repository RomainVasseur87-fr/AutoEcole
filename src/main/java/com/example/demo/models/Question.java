package com.example.demo.models;

public class Question {
	
	private Long questionId;
	private String intitule;
	private String reponse;
	private Difficulte difficulte;
	private Theme theme;
	
	public Question() {
		super();
	}
	public Question(String intitule, String reponse, Difficulte difficulte, Theme theme) {
		super();
		this.intitule = intitule;
		this.reponse = reponse;
		this.difficulte = difficulte;
		this.theme = theme;
	}
	public Question(Long questionId, String intitule, String reponse, Difficulte difficulte, Theme theme) {
		super();
		this.questionId = questionId;
		this.intitule = intitule;
		this.reponse = reponse;
		this.difficulte = difficulte;
		this.theme = theme;
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	public Difficulte getDifficulte() {
		return difficulte;
	}
	public void setDifficulte(Difficulte difficulte) {
		this.difficulte = difficulte;
	}
	public Theme getTheme() {
		return theme;
	}
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((difficulte == null) ? 0 : difficulte.hashCode());
		result = prime * result + ((intitule == null) ? 0 : intitule.hashCode());
		result = prime * result + ((questionId == null) ? 0 : questionId.hashCode());
		result = prime * result + ((reponse == null) ? 0 : reponse.hashCode());
		result = prime * result + ((theme == null) ? 0 : theme.hashCode());
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
		Question other = (Question) obj;
		if (difficulte != other.difficulte)
			return false;
		if (intitule == null) {
			if (other.intitule != null)
				return false;
		} else if (!intitule.equals(other.intitule))
			return false;
		if (questionId == null) {
			if (other.questionId != null)
				return false;
		} else if (!questionId.equals(other.questionId))
			return false;
		if (reponse == null) {
			if (other.reponse != null)
				return false;
		} else if (!reponse.equals(other.reponse))
			return false;
		if (theme != other.theme)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", intitule=" + intitule + ", reponse=" + reponse
				+ ", difficulte=" + difficulte + ", theme=" + theme + "]";
	}
	
	

}
