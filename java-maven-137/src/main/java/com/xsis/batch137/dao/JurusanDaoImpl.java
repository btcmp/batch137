package com.xsis.batch137.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.batch137.model.Jurusan;
import com.xsis.batch137.model.Mahasiswa;

@Repository
public class JurusanDaoImpl implements JurusanDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void save(Jurusan jurusan) {
		// TODO Auto-generated method stub
		
	}

	public List<Jurusan> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Jurusan.class).list();
	}

	public Jurusan getOne(Jurusan jurusan) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Jurusan jurusan) {
		// TODO Auto-generated method stub
		
	}

	public void update(Jurusan jurusan) {
		// TODO Auto-generated method stub
		
	}

	public void saveAtauUpdate(Jurusan jurusan) {
		// TODO Auto-generated method stub
		
	}

}
