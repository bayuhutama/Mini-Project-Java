package com.MiniProject.Models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mUser")
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="biodataId",nullable=true)
	private long biodataId;
	
	@Column(name="roleId",nullable=true)
	private long roleId;
	
	@Column(name="email",length=100,nullable=true)
	private String email;
	
	@Column(name="password",length=255,nullable=true)
	private String password;
	
	@Column(name="loginAttempt",nullable=true)
	private int loginAttempt;
	
	@Column(name="isLocked",nullable=true)
	private boolean isLocked;
	
	@Column(name="lastLogin",nullable=true)
	private Timestamp lastLogin;
	
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

	public long getBiodataId() {
		return biodataId;
	}

	public void setBiodataId(long biodataId) {
		this.biodataId = biodataId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLoginAttempt() {
		return loginAttempt;
	}

	public void setLoginAttempt(int loginAttempt) {
		this.loginAttempt = loginAttempt;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
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
