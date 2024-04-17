package com.MiniProject.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mBank")
public class BankModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="nama", length=100)
	private String nama;
	
	@Column(name="vaCode",length=10)
	private String vaCode;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getVaCode() {
		return vaCode;
	}

	public void setVaCode(String vaCode) {
		this.vaCode = vaCode;
	}

}
