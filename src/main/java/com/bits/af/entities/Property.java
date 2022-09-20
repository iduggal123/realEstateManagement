package com.bits.af.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "property")
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int propertyId;

	@Column(name = "pty_town")
	private String propertyTown;

	@Column(name = "pty_city")
	private String propertyCity;

	@Column(name = "pty_state")
	private String propertyState;

	@Column(name = "pty_category")
	private String propertyCategory;

	@Column(name = "pty_type")
	private String propertyType;

	@Column(name = "pty_price")
	private float propertyPrice;

	@Column(name = "pty_picture")
	private String propertyPicture;

	@Column(name = "pty_status")
	private String propertyStatus;

	@Column(name = "pty_owner")
	private String propertyOwner;

	public String getPropertyOwner() {
		return propertyOwner;
	}

	public void setPropertyOwner(String propertyOwner) {
		this.propertyOwner = propertyOwner;
	}

	public String getPropertyTown() {
		return propertyTown;
	}

	public void setPropertyTown(String propertyTown) {
		this.propertyTown = propertyTown;
	}

	public String getPropertyCity() {
		return propertyCity;
	}

	public void setPropertyCity(String propertyCity) {
		this.propertyCity = propertyCity;
	}

	public String getPropertyState() {
		return propertyState;
	}

	public void setPropertyState(String propertyState) {
		this.propertyState = propertyState;
	}

	public String getPropertyCategory() {
		return propertyCategory;
	}

	public void setPropertyCategory(String propertyCategory) {
		this.propertyCategory = propertyCategory;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public float getPropertyPrice() {
		return propertyPrice;
	}

	public void setPropertyPrice(float propertyPrice) {
		this.propertyPrice = propertyPrice;
	}

	public String getPropertyPicture() {
		return propertyPicture;
	}

	public void setPropertyPicture(String propertyPicture) {
		this.propertyPicture = propertyPicture;
	}

	public String getPropertyStatus() {
		return propertyStatus;
	}

	public void setPropertyStatus(String propertyStatus) {
		this.propertyStatus = propertyStatus;
	}

}
