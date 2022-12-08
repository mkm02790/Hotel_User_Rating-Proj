/**
 * 
 */
package com.mukul.rating.service.exception;

/**
 * @author mukul
 *
 * 24-Nov-2022
 */
public class ResourceNotPresentException extends RuntimeException{

	public ResourceNotPresentException() {
		super();
		
	}

	public ResourceNotPresentException(String message) {
		super(message);
		
	}

}
