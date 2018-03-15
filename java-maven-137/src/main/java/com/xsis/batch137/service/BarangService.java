package com.xsis.batch137.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.batch137.dao.BarangDao;
import com.xsis.batch137.model.Barang;

@Service
@Transactional
public class BarangService {

	@Autowired
	BarangDao barangDao;
	
	public void save(Barang barang){
		barangDao.save(barang);
	}
	public void delete(Barang barang){
		barangDao.delete(barang);
	}
	public void update(Barang barang){
		barangDao.update(barang);
	}
	public List<Barang> selectAll(){
		return barangDao.selectAll();
	}
	public Barang getOne(String id){
		Barang barang = new Barang();
		barang.setId(id);
		//barang.setNamaBarang("0");
		return barangDao.getOne(barang);
	}
	public List<Barang> getBarangBySearchName(String search) {
		// TODO Auto-generated method stub
		return barangDao.getBarangBySearchName(search);
	}
}
