package com.example.shdemo.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.Kebap;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class KebapManagerTest {

	@Autowired
	KebapManager kebapManager;
	

	private final String TUREK_1 = "uTurasa";
	private final Long ID_1 = new Long(0);
	private final int SPRZEDANYCH_1 = 1;
	private final int PRZYCHOD_1 = 5;

	private final String TUREK_2 = "Turasek123";
	private final Long ID_2 = new Long(1);
	private final int SPRZEDANYCH_2 = 23;
	private final int PRZYCHOD_2 = 120;

	//check adding
	@Test
	public void addKebapCheck() {

		List<Kebap> retrievedKebaps = kebapManager.getAllKebaps();

		// If there is a kebap with ID_1 delete it
		for (Kebap kebap : retrievedKebaps) {
			if (kebap.getId().equals(ID_1)) {
				kebapManager.deleteKebap(kebap);
			}
		}

		Kebap kebap = new Kebap();
		kebap.setTurek(TUREK_1);
		kebap.setSprzedanych(SPRZEDANYCH_1);
		kebap.setPrzychod(PRZYCHOD_1);

		kebapManager.addKebap(kebap);

		Kebap retrievedKebap = kebapManager.findKebapById(kebap);

		assertEquals(TUREK_1, retrievedKebap.getTurek());
		
		// delete all kebaps
		for (Kebap kebap1 : retrievedKebaps) 
			kebapManager.deleteKebap(kebap1);
		
	}
	
	
	@Test 
	public void readKebapCheck()
	{
		//pusta baza, dodanie kebaba
		Kebap kebap = new Kebap();
		kebap.setTurek(TUREK_1);
		kebap.setSprzedanych(SPRZEDANYCH_1);
		kebap.setPrzychod(PRZYCHOD_1);

		kebapManager.addKebap(kebap);
		
		kebap.setTurek(TUREK_2);
		kebap.setSprzedanych(SPRZEDANYCH_2);
		kebap.setPrzychod(PRZYCHOD_2);
		
		kebapManager.addKebap(kebap);
		
		List<Kebap> retrievedKebaps = kebapManager.getAllKebaps();
		
		assertEquals(TUREK_1, retrievedKebaps.get(0).getTurek());
		assertEquals(TUREK_2, retrievedKebaps.get(1).getTurek());
	}
	
	@Test 
	public void updateKebapCheck()
	{
		Kebap kebap = new Kebap();
		kebap.setTurek(TUREK_1);
		kebap.setSprzedanych(SPRZEDANYCH_1);
		kebap.setPrzychod(PRZYCHOD_1);

		kebapManager.addKebap(kebap);
		
		List<Kebap> retrievedKebaps = kebapManager.getAllKebaps();
		
		assertEquals(TUREK_1, retrievedKebaps.get(0).getTurek());

		kebap.setTurek(TUREK_2);
		kebap.setSprzedanych(SPRZEDANYCH_2);
		kebap.setPrzychod(PRZYCHOD_2);

		kebapManager.updateKebap(kebap);
		
		retrievedKebaps = kebapManager.getAllKebaps();
		
		assertEquals(TUREK_2, retrievedKebaps.get(0).getTurek());
	}

	
	@Test 
	public void deleteKebapCheck()
	{
		Kebap kebap = new Kebap();
		kebap.setTurek(TUREK_1);
		kebap.setSprzedanych(SPRZEDANYCH_1);
		kebap.setPrzychod(PRZYCHOD_1);
		
		kebapManager.addKebap(kebap);
		
		Kebap kebap1 = new Kebap();
		kebap1.setTurek(TUREK_2);
		kebap1.setSprzedanych(SPRZEDANYCH_2);
		kebap1.setPrzychod(PRZYCHOD_2);
		
		kebapManager.addKebap(kebap1);
		
		List<Kebap> retrievedKebaps = kebapManager.getAllKebaps();
		
		assertEquals(TUREK_1, retrievedKebaps.get(0).getTurek());
		
		kebapManager.deleteKebap(retrievedKebaps.get(0));
		
		retrievedKebaps = kebapManager.getAllKebaps();
		
		assertEquals(TUREK_2, retrievedKebaps.get(0).getTurek());
		
		// delete all kebaps
				for (Kebap kebap2 : retrievedKebaps) 
					kebapManager.deleteKebap(kebap2);
		
	}
	



}
