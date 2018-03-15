package com.xsis.batch137.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ORDER_XE")
public class Order {

	public Order(){
		this.statusBarang = 0;
		this.createDate= new Date();
	}
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;
	@Column(name="create_date")
	private Date createDate;
	private int jumlahBeli;
	@ManyToOne
	private Customer customer;
	@ManyToOne
	private Barang barang;
	@Column(name="status_barang")
	private int statusBarang;
	
	public int getJumlahBeli() {
		return jumlahBeli;
	}
	public void setJumlahBeli(int jumlahBeli) {
		this.jumlahBeli = jumlahBeli;
	}
	public int getStatusBarang() {
		return statusBarang;
	}
	public void setStatusBarang(int statusBarang) {
		this.statusBarang = statusBarang;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Barang getBarang() {
		return barang;
	}
	public void setBarang(Barang barang) {
		this.barang = barang;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
