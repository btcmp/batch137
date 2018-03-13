package com.xsis.batch137.dao;

import java.util.List;

import com.xsis.batch137.model.Employee;
import com.xsis.batch137.model.Jurusan;

public interface JurusanDao {
	//create
		public void save(Jurusan jurusan);
		//jamak employee -- list
		public List<Jurusan> selectAll();
		//single employee
		public Jurusan getOne(Jurusan jurusan);
		//delete
		public void delete(Jurusan jurusan);
		//update
		public void update(Jurusan jurusan);
		//save or update
		public void saveAtauUpdate(Jurusan jurusan);
}
