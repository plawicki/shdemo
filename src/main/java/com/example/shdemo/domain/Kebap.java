package com.example.shdemo.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;



@Entity
@NamedQueries({ 
	
	@NamedQuery(name = "kebap.read", query = "Select k from Kebap k"),
	@NamedQuery(name = "kebap.byId", query = "Select k from Kebap k where k.id = :id")
})
public class Kebap {
	
	private Long id;
	private String turek;
	private int sprzedanych;
	private int przychod;
	private List<Kanapka> kanapki = new ArrayList<Kanapka>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Kanapka> getKanapki() {
		return kanapki;
	}

	public void setKanapki(List<Kanapka> kanapki) {
		this.kanapki = kanapki;
	}

	public Kebap() {
	}
	
	public Kebap(String turek, int sprzedanych, int przychod) {
		this.turek = turek;
		this.sprzedanych = sprzedanych;
		this.przychod = przychod;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTurek() {
		return turek;
	}
	public void setTurek(String turek) {
		this.turek = turek;
	}
	public int getSprzedanych() {
		return sprzedanych;
	}
	public void setSprzedanych(int sprzedanych) {
		this.sprzedanych = sprzedanych;
	}
	public int getPrzychod() {
		return przychod;
	}
	public void setPrzychod(int przychod) {
		this.przychod = przychod;
	}
	
}

