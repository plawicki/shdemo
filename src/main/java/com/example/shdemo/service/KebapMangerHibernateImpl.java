package com.example.shdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.Car;
import com.example.shdemo.domain.Kanapka;
import com.example.shdemo.domain.Kebap;
import com.example.shdemo.domain.Person;


@Component
@Transactional
public class KebapMangerHibernateImpl implements KebapManager {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addKebap(Kebap kebap) {
		kebap.setId(null);
		sessionFactory.getCurrentSession().persist(kebap);
	}
	
	@Override
	public void deleteKebap(Kebap kebap) {
		kebap = (Kebap) sessionFactory.getCurrentSession().get(Kebap.class,
				kebap.getId());
		
		// lazy loading here
				for (Kanapka kanapka : kebap.getKanapki()) {
					kanapka.setWycofana(false);
					sessionFactory.getCurrentSession().update(kanapka);
				}
		
		
		sessionFactory.getCurrentSession().delete(kebap);
	}
	
	@Override
	public void updateKebap(Kebap kebap) {
		kebap = (Kebap) sessionFactory.getCurrentSession().get(Kebap.class,
				kebap.getId());
		

		sessionFactory.getCurrentSession().update(kebap);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Kebap> getAllKebaps() {
		return sessionFactory.getCurrentSession().getNamedQuery("kebap.read")
				.list();
	}

	@Override
	public Kebap findKebapById(Kebap kebap) {
		kebap = (Kebap) sessionFactory.getCurrentSession().get(Kebap.class,
				kebap.getId());
		
		return kebap;
	}

	@Override
	public Long addKanapka(Kanapka kanapka) {
		// TODO Auto-generated method stub
		kanapka.setId(null);
		return (Long) sessionFactory.getCurrentSession().save(kanapka);

	}

	@Override
	public List<Kanapka> getAvailableKanapka() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().getNamedQuery("kanapka.wycofana")
				.list();
	}

	@Override
	public void disposeKanapka(Kebap kebap, Kanapka kanapka) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Kanapka findKanapkaById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Kanapka> getOwnedKanapka(Kebap kebap) {
		// TODO Auto-generated method stub
		
		kebap = (Kebap) sessionFactory.getCurrentSession().get(Person.class,
				kebap.getId());
		
		List<Kanapka> kanapki = new ArrayList<Kanapka>(kebap.getKanapki());
		return kanapki;

	}

	@Override
	public void addKanapkaToMenu(Long kebapId, Long kanapkaId) {
		// TODO Auto-generated method stub
		Kebap kebap = (Kebap) sessionFactory.getCurrentSession().get(
				Person.class, kebapId);
		Kanapka kanapka = (Kanapka) sessionFactory.getCurrentSession()
				.get(Car.class, kanapkaId);
		kanapka.setWycofana(false);
		
		kebap.getKanapki().add(kanapka);
		
	}


}
