/**
 * 
 */
package com.mukul.rating.service.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mukul.rating.service.entites.Hotel;
import com.mukul.rating.service.entites.Rating;
import com.mukul.rating.service.entites.RatingResponseObj;
import com.mukul.rating.service.entites.User;
import com.mukul.rating.service.exception.ResourceNotPresentException;
import com.mukul.rating.service.repo.RatingRepo;
import com.mukul.rating.service.services.RatingServices;

/**
 * @author mukul
 *
 *         23-Nov-2022
 */
@Service
public class RatingServiceImpl implements RatingServices {

	@Autowired
	RatingRepo ratingRepo;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public Rating creatRating(Rating ratingObj) {
		Rating rating = new Rating();
		String UiniqueId = UUID.randomUUID().toString().substring(0, 8);
		rating.setRatingId(UiniqueId);
		rating.setRating(ratingObj.getRating());
		rating.setFeedback(ratingObj.getFeedback());
		rating.setHotelId(ratingObj.getHotelId());
		rating.setUserId(ratingObj.getUserId());
		ratingRepo.save(rating);
		return rating;
	}

	@Override
	public List<RatingResponseObj> getRating() {
		List<Rating> listOfRatings = ratingRepo.findAll();
		RatingResponseObj ratingResponseObj = new RatingResponseObj();
		ArrayList<RatingResponseObj> ratingResponseObjList = new ArrayList<>();

		User[] userArray = restTemplate.getForObject("http://USERSERVICE/users", User[].class);
		List<User> userList = Arrays.stream(userArray).toList();

		Hotel[] hotelArray = restTemplate.getForObject("http://HOTELSERVICE/hotels", Hotel[].class);
		List<Hotel> hotelList = Arrays.stream(hotelArray).toList();
		for (Rating rating : listOfRatings) {

			for (User user : userList) {
				if (rating.getUserId().equals(user.getUserId())) {
					ratingResponseObj.setUserName(user.getName());
				}
			}
			for (Hotel hotel : hotelList) {
				if (rating.getHotelId().equals(hotel.getId())) {
					ratingResponseObj.setHotelName(hotel.getName());
				}
			}
			ratingResponseObj.setFeedback(rating.getFeedback());
			ratingResponseObj.setHotelId(rating.getHotelId());
			ratingResponseObj.setUserId(rating.getUserId());
			ratingResponseObj.setRating(rating.getRating());
			ratingResponseObj.setRatingId(rating.getRatingId());
			ratingResponseObj.setUserId(rating.getUserId());
			ratingResponseObjList.add(ratingResponseObj);
            System.out.println(ratingResponseObj);
            
		}

		return ratingResponseObjList;
	}

	@Override
	public List<Rating> GetRatingByUserId(String userId) {

		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> GetRatingByHotelId(String hotelId) {

		return ratingRepo.findByHotelId(hotelId);
	}

	@Override
	public Rating deleteRating(String ratingId) {
		Rating ratingObj = ratingRepo.findById(ratingId).orElseThrow(() -> new ResourceNotPresentException(
				"Rating Id " + ratingId + " is Not Present in database so Deletion operation can not be done"));
		ratingRepo.delete(ratingObj);
		return ratingObj;
	}

}
