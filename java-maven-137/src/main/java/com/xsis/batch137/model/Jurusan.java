package com.xsis.batch137.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="jurusan_xe")
public class Jurusan {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name="name_jurusan")
	private String nameJurusan;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="jurusan")
	private List<Mahasiswa> mahasiswas;
	
	public List<Mahasiswa> getMahasiswas() {
		return mahasiswas;
	}
	public void setMahasiswas(List<Mahasiswa> mahasiswas) {
		this.mahasiswas = mahasiswas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameJurusan() {
		return nameJurusan;
	}
	public void setNameJurusan(String nameJurusan) {
		this.nameJurusan = nameJurusan;
	}
	
}
