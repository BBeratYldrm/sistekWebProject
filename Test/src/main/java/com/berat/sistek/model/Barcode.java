package com.berat.sistek.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Barcode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long barcodeId;

	private String barcodeName;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Barcode() {
	}

	public long getBarcodeId() {
		return barcodeId;
	}

	public void setBarcodeId(long barcodeId) {
		this.barcodeId = barcodeId;
	}

	public String getBarcodeName() {
		return barcodeName;
	}

	public void setBarcodeName(String barcodeName) {
		this.barcodeName = barcodeName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
