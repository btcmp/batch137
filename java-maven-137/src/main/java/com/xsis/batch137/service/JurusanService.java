package com.xsis.batch137.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.batch137.dao.JurusanDao;
import com.xsis.batch137.model.Jurusan;

@Service
@Transactional
public class JurusanService {
	
	@Autowired
	JurusanDao jurusanDao;

	public List<Jurusan> selectAll() {
		// TODO Auto-generated method stub
		return jurusanDao.selectAll();
	}

}
