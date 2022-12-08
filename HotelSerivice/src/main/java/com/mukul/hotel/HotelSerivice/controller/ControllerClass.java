/**
 * 
 */
package com.mukul.hotel.HotelSerivice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mukul.hotel.HotelSerivice.entities.Hotel;
import com.mukul.hotel.HotelSerivice.exception.CreatingHotelObjectException;
import com.mukul.hotel.HotelSerivice.exception.UsePatchInsteadOfPutException;
import com.mukul.hotel.HotelSerivice.service.HotelService;

/**
 * @author mukul
 *
 * 22-Nov-2022
 */
@RestController
@RequestMapping("/hotels")
public class ControllerClass {
	
	@Autowired
	HotelService hotelService;
	
	@PostMapping()
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel ht)
	{
		Hotel hotel = hotelService.createHotel(ht);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel);
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotelBYId(@PathVariable String hotelId){
		
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotelById(hotelId));
		}	
		/*
		 * @GetMapping("/{hotelId}") public ResponseEntity<Hotel> getHotel(@PathVariable
		 * String hotelId){ Hotel hotel =hotelService.getHotelById(hotelId); return
		 * ResponseEntity.status(HttpStatus.OK).body(hotel);
		 * 
		 * }
		 */
	@PutMapping
	public ResponseEntity<Hotel> updatePutHotel(@RequestBody Hotel hotel){
		if(null == hotel.getAbout() || null ==hotel.getLocation() || null == hotel.getName()) {			
			throw new UsePatchInsteadOfPutException();
			}		
		Hotel updatedHotel = hotelService.updatePutHotel(hotel);
		return ResponseEntity.status(HttpStatus.OK).body(updatedHotel);
		
	}
	
	@PatchMapping
	public ResponseEntity<Hotel> updatePatchHotel(@RequestBody Hotel hotel){
	Hotel patchedhotel= hotelService.updatePatchHotel(hotel);
		return ResponseEntity.status(HttpStatus.OK).body(patchedhotel);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getall(){		
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAll());
		}

	@DeleteMapping("/{hotelId}")
	public ResponseEntity<Hotel> deleteHotel(@PathVariable String hotelId){
		Hotel deletedHotel = hotelService.deleteHotel(hotelId);
		return ResponseEntity.status(HttpStatus.OK).body(deletedHotel);}

}

