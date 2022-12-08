/**
 * 
 */
package com.mukul.rating.service.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mukul.rating.service.entites.Hotel;

/**
 * @author mukul
 *
 * 05-Dec-2022
 */
@Component
public class VerifyHotelIdClassImpl {

	@Autowired
	static
	RestTemplate restTemplate;
	
	public static boolean verifyHotelId(String hotelId) throws Exception {
		
	List<Hotel>	hotelList = restTemplate.getForObject("http://localhost:8002/hotels/"+hotelId, ArrayList.class);
    boolean res =false ;

		for (Hotel hotel : hotelList) {
			if (hotel.getId().equals(hotelId))
				 res= true ;
				return res ;
		}
		return res;
		
		
	}

}
