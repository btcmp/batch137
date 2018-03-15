package com.xsis.batch137.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.batch137.model.Barang;

@Repository
public class BarangDaoImpl implements BarangDao {

	@Autowired
	SessionFactory sessionFactory;
	public void save(Barang barang) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(barang);
		session.flush();
	}

	public List<Barang> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Barang.class).list();
	}

	public Barang getOne(Barang barang) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Barang.class, barang.getId());
	}

	public void delete(Barang barang) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(barang);
		session.flush();
	}

	public void update(Barang barang) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(barang);
		session.flush();
	}

	public void saveAtauUpdate(Barang barang) {
		// TODO Auto-generated method stub
		
	}

	public List<Barang> getBarangBySearchName(String search) {
		// TODO Auto-generated method stub
		String hql = "from Barang br where lower(br.namaBarang) like :nb";
		Session session = sessionFactory.getCurrentSession();
		
		List<Barang> barangs = session.createQuery(hql)
				.setParameter("nb", "%"+search.toLowerCase()+"%").list();
		if(barangs.isEmpty()){
			return null;
		} 
		
		return barangs;
	}

}
