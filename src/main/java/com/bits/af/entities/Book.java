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
public class Book {

	@Id
	@Column(name = "bookingID")
	private int bookingID;
	
	@Column(name = "clientID")
	private int clientID;
	
	@Column(name = "propertyID")
	private int propertyID;
	
	@Column(name = "Bk_Status")
	private char bkStatus;
}
