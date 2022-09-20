package com.bits.af.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "transaction")
@Data
@ToString
public class Transaction {

	@Id
	@Column(name = "transactiond")
	private int transactionId;

	@Column(name = "bookingid")
	private int bookingId;

	@Column(name = "clientid")
	private int clientId;

	@Column(name = "propertyid")
	private int propertyId;

	@Column(name = "bank_refid")
	private int backReferenceId;

	@Column(name = "tr_startdate")
	private Date transactionStartDate;

	@Column(name = "tr_enddate")
	private Date transactionEndDate;

	@Column(name = "tr_status")
	private int transactionStatus;

}
