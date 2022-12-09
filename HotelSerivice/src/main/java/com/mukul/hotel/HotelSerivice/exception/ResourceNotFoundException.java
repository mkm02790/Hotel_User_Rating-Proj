package com.mukul.hotel.HotelSerivice.exception;
import net.bytebuddy.implementation.bind.annotation.Super;

/**
 * @author mukul
 *
 * 22-Nov-2022
 */
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * @param string
	 */
	public ResourceNotFoundException(String string) {
		super(string);
	}

	public ResourceNotFoundException() {
		super("Resource of given id is not found");
		
	}

	
}
