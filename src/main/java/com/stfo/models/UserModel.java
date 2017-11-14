package com.stfo.models;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class UserModel {
	
	private Integer id;
	private String name;
	private String contactNumber;
	private Date dateOfBirth;
	private String emailAddress;
	private String idProofLocation;
	private BigDecimal balanceAmount;
	private BigDecimal blockedAmount;
	private Long uid;

	public BigDecimal getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(BigDecimal balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public BigDecimal getBlockedAmount() {
		return blockedAmount;
	}

	public void setBlockedAmount(BigDecimal blockedAmount) {
		this.blockedAmount = blockedAmount;
	}
	
	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public UserModel() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdProofLocation() {
		return idProofLocation;
	}

	public void setIdProofLocation(String idProofLocation) {
		this.idProofLocation = idProofLocation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
