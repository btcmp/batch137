package com.xsis.batch137.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.batch137.model.Employee;
import com.xsis.batch137.model.Mahasiswa;

@Repository
public class MahasiswaDaoImpl implements MahasiswaDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void save(Mahasiswa mahasiswa) {
		// TODO Auto-generated method stub
		Session session =sessionFactory.getCurrentSession();
		session.save(mahasiswa);
		session.flush();
	}

	public List<Mahasiswa> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Mahasiswa.class).list();
	}

	public Mahasiswa getOne(Mahasiswa mahasiswa) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Mahasiswa.class, mahasiswa.getId());
	}

	public void delete(Mahasiswa mahasiswa) {
		// TODO Auto-generated method stub
		
	}

	public void update(Mahasiswa mahasiswa) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(mahasiswa);
		session.flush();
	}

	public void saveAtauUpdate(Mahasiswa mahasiswa) {
		// TODO Auto-generated method stub
		
	}

}
