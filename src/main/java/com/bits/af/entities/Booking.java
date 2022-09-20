package com.bits.af.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "book")
@Data
@ToString
public class Booking {

	@Id
	@Column(name = "bookingID")
	private int bookingId;

	@Column(name = "clientID")
	private int clientId;

	@Column(name = "propertyID")
	private int propertyId;

	@Column(name = "Bk_Status")
	private String bookingStatus;
}
