/**
 * 
 */
package com.mukul.hotel.HotelSerivice.exception;

/**
 * @author mukul
 *
 *         23-Nov-2022
 */
public class CreatingHotelObjectException extends Exception {

	public CreatingHotelObjectException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CreatingHotelObjectException() {
		super("Error occered while creating hotel object in data base");

	}

}
