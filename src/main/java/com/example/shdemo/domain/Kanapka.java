package com.example.shdemo.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "kanapka.wycofana", query = "Select k from Kanapka k where k.wycofana = false")
})
public class Kanapka {
	
	private long id;
	private String nazwa;
	private int cena;
	private long kebap;
	private boolean wycofana;
	
	public Kanapka(String nazwa, int cena, long kebap, boolean wycofana)
	{
		this.nazwa = nazwa;
		this.cena = cena;
		this.kebap = kebap;
		this.wycofana = wycofana;
	}
	
	public boolean isWycofana() {
		return wycofana;
	}

	public void setWycofana(boolean wycofana) {
		this.wycofana = wycofana;
	}

	public Kanapka()
	{
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int i) {
		this.cena = i;
	}
	
	public long getKebap() {
		return kebap;
	}
	public void setKebap(long kebap) {
		this.kebap = kebap;
	}

}
