package com.bits.af.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@SuppressWarnings("unused")
public class BookingRequest {

	private int bookingId;
	private int clientId;
	private int propertyId;
	private String bookingStatus;
}
