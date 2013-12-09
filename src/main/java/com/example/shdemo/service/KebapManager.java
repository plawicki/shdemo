package com.example.shdemo.service;

import java.util.List;

import com.example.shdemo.domain.Car;
import com.example.shdemo.domain.Kanapka;
import com.example.shdemo.domain.Kebap;
import com.example.shdemo.domain.Person;

public interface KebapManager {
	
	void addKebap(Kebap kebap);
	List<Kebap> getAllKebaps();
	void deleteKebap(Kebap kebap);
	void updateKebap(Kebap kebap);
	Kebap findKebapById(Kebap kebap);
	
	//dodawanie kanapek do bazy
	Long addKanapka(Kanapka kanapka);
	//pobieranie dostepnych kanapek z bazy
	List<Kanapka> getAvailableKanapka();
	//usuwanie kanapki z budki
	void disposeKanapka(Kebap kebap, Kanapka kanapka);
	//szukanie kanapki po id
	Kanapka findKanapkaById(Long id);

	//pobieranie kanapek danej budki
	List<Kanapka> getOwnedKanapka(Kebap kebap);
	//dodawanie kanapek do menu danej budki
	void addKanapkaToMenu(Long kebapId, Long kanapkaId);

}
