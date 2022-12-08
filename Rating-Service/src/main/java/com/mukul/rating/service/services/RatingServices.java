/**
 * 
 */
package com.mukul.rating.service.services;

import java.util.List;

import com.mukul.rating.service.entites.Rating;
import com.mukul.rating.service.entites.RatingResponseObj;

/**
 * @author mukul
 *
 * 23-Nov-2022
 */
public interface RatingServices {

	Rating creatRating(Rating rating);
	
	List<RatingResponseObj> getRating();
	
	List<Rating> GetRatingByUserId(String userId);
	
	List<Rating> GetRatingByHotelId(String userId);

	Rating deleteRating(String ratingId);
	
}
