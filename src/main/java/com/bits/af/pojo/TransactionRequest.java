package com.bits.af.pojo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@SuppressWarnings("unused")
public class TransactionRequest {
	private int transactionId;
	private int bookingId;
	private int clientId;
	private int propertyId;
	private int backReferenceId;
	private Date transactionStartDate;
	private Date transactionEndDate;
	private int transactionStatus;
}
