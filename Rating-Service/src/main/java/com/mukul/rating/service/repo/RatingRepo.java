/**
 * 
 */
package com.mukul.rating.service.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mukul.rating.service.entites.Rating;

/**
 * @author mukul
 *
 * 23-Nov-2022
 */
public interface RatingRepo extends JpaRepository<Rating, String>{

	List<Rating> findByUserId(String UserId);
	List<Rating> findByHotelId(String HotelId);
}
