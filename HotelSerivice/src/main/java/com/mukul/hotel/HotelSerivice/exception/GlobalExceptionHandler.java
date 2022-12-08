/**
 * 
 */
package com.mukul.hotel.HotelSerivice.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author mukul
 *
 * 23-Nov-2022
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String ,Object>> requestNotFoundException(ResourceNotFoundException ex){
		HashMap hm = new HashMap();
		hm.put("status", HttpStatus.NOT_FOUND);
		hm.put("success", false);
		hm.put("message", ex.getMessage());		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hm);
		
	}
	
	@ExceptionHandler(CreatingHotelObjectException.class)
	public ResponseEntity<Map<String ,Object>> CreatingHoteException(ResourceNotFoundException ex){
		HashMap hm = new HashMap();
		hm.put("status", HttpStatus.BAD_REQUEST);
		hm.put("success", false);
		hm.put("message", ex.getMessage());		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hm);
		
	}
	
	@ExceptionHandler(UsePatchInsteadOfPutException.class)
	public ResponseEntity<Map<String ,Object>> UsePatchInsteadOfPutMethodException(){
		HashMap hm = new HashMap();
		hm.put("status", HttpStatus.BAD_REQUEST);
		hm.put("success", false);
		hm.put("message", "Use Patch Instead Of Put Method");	
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hm);}
}
