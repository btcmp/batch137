package com.xsis.batch137.dao;

import java.util.List;

import com.xsis.batch137.model.Barang;
import com.xsis.batch137.model.Employee;

public interface BarangDao {

	public void save(Barang barang);
	//jamak employee -- list
	public List<Barang> selectAll();
	//single employee
	public Barang getOne(Barang barang);
	//delete
	public void delete(Barang barang);
	//update
	public void update(Barang barang);
	//save or update
	public void saveAtauUpdate(Barang barang);
	//search barang berdasarkan nama
	public List<Barang> getBarangBySearchName(String search);
}
