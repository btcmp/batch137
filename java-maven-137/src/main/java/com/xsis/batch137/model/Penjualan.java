package com.xsis.batch137.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="PENJUALAN_XE")
public class Penjualan {

	public Penjualan(){
		this.createDate = new Date();
		this.statusPembayaran = 0;
	}
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;
	@Column(name="total_items")
	private int totalItems;
	@Column(name="kode_penjualan")
	private String kodePenjualan;
	@Column(name="total_harga")
	private Float totalHarga;
	@Column(name="status_pembayaran")
	private int statusPembayaran;
	@Temporal(TemporalType.DATE)
	@Column(name="create_date")
	private Date createDate;
	@Column(name="user_create")
	private String userCreate;
	@ManyToOne
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUserCreate() {
		return userCreate;
	}
	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public String getKodePenjualan() {
		return kodePenjualan;
	}
	public void setKodePenjualan(String kodePenjualan) {
		this.kodePenjualan = kodePenjualan;
	}
	
	public Float getTotalHarga() {
		return totalHarga;
	}
	public void setTotalHarga(Float totalHarga) {
		this.totalHarga = totalHarga;
	}
	public int getStatusPembayaran() {
		return statusPembayaran;
	}
	public void setStatusPembayaran(int statusPembayaran) {
		this.statusPembayaran = statusPembayaran;
	}
	
}
