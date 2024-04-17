package com.MiniProject.Models;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tCustomerWallet")
public class CustomerWalletModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="customerId",nullable=true)
	private long customerId;
	
	@Column(name="pin",length=6,nullable=true)
	private String pin;
	
	@Column(name="balance",nullable=true)
	private BigDecimal balance;
	
	@Column(name="barcode",length=50,nullable=true)
	private String barcode;
	
	@Column(name="points",nullable=true)
	private BigDecimal points;
	
	@Column(name="createdBy")
	private long createdBy;
	
	@Column(name="createdOn")
	private Timestamp createdOn;
	
	@Column(name="modifiedBy",nullable=true)
	private long modifiedBy;
	
	@Column(name="modifiedOn",nullable=true)
	private Timestamp modifiedOn;
	
	@Column(name="deletedBy",nullable=true)
	private long deletedBy;
	
	@Column(name="deletedOn",nullable=true)
	private Timestamp deletedOn;
	
	@Column(name="isDeleted",nullable=false)
	private boolean isDeleted;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public BigDecimal getPoints() {
		return points;
	}

	public void setPoints(BigDecimal points) {
		this.points = points;
	}
	
	
}
