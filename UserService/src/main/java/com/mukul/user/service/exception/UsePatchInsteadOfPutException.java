/**
 * 
 */
package com.mukul.user.service.exception;

/**
 * @author mukul
 *
 * 23-Nov-2022
 */
public class UsePatchInsteadOfPutException extends RuntimeException{
	
	

	public String UsePatchInsteadOfPutException() {
		return "If only some fields need to update then use Patch method";
	}

	public UsePatchInsteadOfPutException(String message) {
		super(message);
		
	}

}
