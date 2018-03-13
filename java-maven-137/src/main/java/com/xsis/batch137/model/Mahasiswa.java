package com.xsis.batch137.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="MAHASISWA_XE")
public class Mahasiswa {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	@NotNull
	@NotEmpty(message="cannot be empty")
	@Size(min=4, max=20, message="must min = 4 until max = 20 character")
	@Column(nullable=false)
	private String name;
	
	//related to jurusan
	@ManyToOne
	private Jurusan jurusan;
	
	public Jurusan getJurusan() {
		return jurusan;
	}
	public void setJurusan(Jurusan jurusan) {
		this.jurusan = jurusan;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name.trim();
	}
	
	
}
