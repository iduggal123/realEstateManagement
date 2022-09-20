package com.bits.af.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "property")
@Data
@ToString
public class Property {

	@Id
	@Column(name = "propertyid")
	private int propertyId;

	@Column(name = "pty_owner")
	private String propertyOwner;

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
}
