/**
 * 
 */
package com.mukul.hotel.HotelSerivice.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mukul.hotel.HotelSerivice.entities.Hotel;
import com.mukul.hotel.HotelSerivice.exception.CreatingHotelObjectException;
import com.mukul.hotel.HotelSerivice.exception.ResourceNotFoundException;
import com.mukul.hotel.HotelSerivice.repositories.HotelRepo;
import com.mukul.hotel.HotelSerivice.service.HotelService;

/**
 * @author mukul
 *
 *         22-Nov-2022
 */
@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepo hotelRepo;

	@Override
	public Hotel createHotel(Hotel ht) {
		Hotel hotel = new Hotel();
		try {
			String randomId = UUID.randomUUID().toString().substring(0, 8);
			hotel.setId(randomId);
//	        hotel.setId(ht.getId());
			hotel.setAbout(ht.getAbout());
			hotel.setLocation(ht.getLocation());
			hotel.setName(ht.getName());
			hotelRepo.save(hotel);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return hotel;
	}

	@Override
	public List<Hotel> getAll() {
		List<Hotel> listHotel = hotelRepo.findAll();
		return listHotel;
	}

	@Override
	public Hotel getHotelById(String id) {
		return hotelRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel of Id " + id + " is not present in data base"));
	}

	@Override
	public Hotel updatePutHotel(Hotel hotel) {
		Hotel newHotel = hotelRepo.findById(hotel.getId()).orElseThrow(
				() -> new ResourceNotFoundException("Hotel of Id " + hotel.getId() + " is not present in data base"));
		newHotel.setAbout(hotel.getAbout());
		newHotel.setLocation(hotel.getLocation());
		newHotel.setName(hotel.getName());
		return newHotel;
	}

	@Override
	public Hotel updatePatchHotel(Hotel pathObj) {
		Hotel newHotel = hotelRepo.findById(pathObj.getId()).orElseThrow(
				() -> new ResourceNotFoundException("Hotel of Id " + pathObj.getId() + " is not present in data base"));
		if (!(null == pathObj.getAbout())) {
			newHotel.setAbout(pathObj.getAbout());
		}
		if (!(null == pathObj.getName())) {
			newHotel.setLocation(pathObj.getName());
		}
		if (!(null == pathObj.getLocation())) {
			newHotel.setLocation(pathObj.getLocation());
		}
		hotelRepo.save(newHotel);
		return newHotel;
	}

	@Override
	public Hotel deleteHotel(String hotelId) {
		Hotel hotelObj = hotelRepo.findById(hotelId).orElseThrow(
				() -> new ResourceNotFoundException("Hotel of Id " + hotelId + " is not present in data base"));
		hotelRepo.delete(hotelObj);
		return hotelObj;
	}

}
