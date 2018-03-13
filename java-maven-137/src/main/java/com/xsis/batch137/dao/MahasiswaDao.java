package com.xsis.batch137.dao;

import java.util.List;

import com.xsis.batch137.model.Employee;
import com.xsis.batch137.model.Mahasiswa;

public interface MahasiswaDao {

	//create
		public void save(Mahasiswa mahasiswa);
		//jamak employee -- list
		public List<Mahasiswa> selectAll();
		//single employee
		public Mahasiswa getOne(Mahasiswa mahasiswa);
		//delete
		public void delete(Mahasiswa mahasiswa);
		//update
		public void update(Mahasiswa mahasiswa);
		//save or update
		public void saveAtauUpdate(Mahasiswa mahasiswa);
}
