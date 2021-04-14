package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Serie CD")
public class SerieCD {
	
	@Id
	@GeneratedValue
	private Long serieCdId;
	@Column(name="cdRom")
	private CdRom cdRom;
	
	public SerieCD() {
		super();
	}
	public SerieCD(CdRom cdRom) {
		super();
		this.cdRom = cdRom;
	}
	public SerieCD(Long serieCdId, CdRom cdRom) {
		super();
		this.serieCdId = serieCdId;
		this.cdRom = cdRom;
	}
	public Long getSerieCdId() {
		return serieCdId;
	}
	public void setSerieCdId(Long serieCdId) {
		this.serieCdId = serieCdId;
	}
	public CdRom getCdRom() {
		return cdRom;
	}
	public void setCdRom(CdRom cdRom) {
		this.cdRom = cdRom;
	}
	
	

}
