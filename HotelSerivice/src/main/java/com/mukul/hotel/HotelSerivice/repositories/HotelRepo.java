/**
 * 
 */
package com.mukul.hotel.HotelSerivice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mukul.hotel.HotelSerivice.entities.Hotel;

/**
 * @author mukul
 *
 * 22-Nov-2022
 */
public interface HotelRepo extends JpaRepository<Hotel, String>{

}
