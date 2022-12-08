package com.mukul.rating.service.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mukul.rating.service.entites.Rating;
import com.mukul.rating.service.entites.RatingResponseObj;
import com.mukul.rating.service.services.RatingServices;

/**
 * @author mukul
 *
 *         23-Nov-2022
 */
@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	RatingServices ratingServices;

	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
		System.out.println(rating.getFeedback());
		Rating response = ratingServices.creatRating(rating);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<RatingResponseObj>> getRating() {
		List<RatingResponseObj> response = ratingServices.getRating();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {
		List<Rating> ratingByGivenId = ratingServices.GetRatingByUserId(userId);
		return new ResponseEntity<>(ratingByGivenId, HttpStatus.OK);
	}

	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) {
		List<Rating> ratingByGivenId = ratingServices.GetRatingByHotelId(hotelId);
		return new ResponseEntity<>(ratingByGivenId, HttpStatus.OK);
	}

	@RequestMapping(method =RequestMethod.DELETE ,value ="/{ratingId}")
	public ResponseEntity<Object> deleteRating(@PathVariable String ratingId){
		Rating rating= ratingServices.deleteRating(ratingId);
		return  ResponseEntity.status(HttpStatus.OK).body(rating);		
	}
	
	
}