package com.MiniProject.Models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mRole")
public class RoleModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="name",length=20)
	private String name;
	
	@Column(name="code",length=20)
	private String code;

	@Column(name="createdBy")
	private long createdBy;
	
	@Column(name="createdOn")
	private Timestamp createdOn;
	
	@Column(name="modifiedBy",nullable=true)
	private long modifiedBy;
	
	@Column(name="modifiedOn")
	private Timestamp modifiedOn;
	
	@Column(name="deletedBy",nullable=true)
	private long deletedBy;
	
	@Column(name="deletedOn")
	private Timestamp deletedOn;
	
	@Column(name="isDeleted",nullable=false)
	private boolean isDeleted;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public long getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(long deletedBy) {
		this.deletedBy = deletedBy;
	}

	public Timestamp getDeletedOn() {
		return deletedOn;
	}

	public void setDeletedOn(Timestamp deletedOn) {
		this.deletedOn = deletedOn;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	
}
