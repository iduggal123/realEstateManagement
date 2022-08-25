package com.bits.af.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BookingRequest {
	
	private int bookingID;
	private int clientID;
	private int propertyID;
	private char bkStatus;
}
