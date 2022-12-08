/**
 * 
 */
package com.mukul.hotel.HotelSerivice.service;

import java.util.List;

import com.mukul.hotel.HotelSerivice.entities.Hotel;
import com.mukul.hotel.HotelSerivice.exception.CreatingHotelObjectException;

/**
 * @author mukul
 *
 * 22-Nov-2022
 */
public interface HotelService {
	
	public Hotel createHotel(Hotel hotel) ;
	
	public List<Hotel> getAll();
	 
	public Hotel getHotelById(String id);
	
	public Hotel updatePutHotel(Hotel hotel);
	
	public Hotel updatePatchHotel(Hotel pathObj);
	
	public Hotel deleteHotel(String hotelId);
}
