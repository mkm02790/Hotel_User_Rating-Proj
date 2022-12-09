package com.mukul.user.service.testimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mukul.user.service.entities.Hotel;
import com.mukul.user.service.entities.Rating;
import com.mukul.user.service.entities.User;
import com.mukul.user.service.impl.UserServiceImpl;
import com.mukul.user.service.repo.UserRepo;

@SpringBootTest
public class TestServiceImpl {

	@Autowired
	UserServiceImpl UserServiceImpl;

	@Autowired
	UserRepo userRepo;

	
	@Test
	void TestGetUserById() {
		Hotel hotel = new Hotel("1234567890", "KFC", "Kanpur", "Non-veg Restoraunt");
		Rating rating = new Rating("262e043b", "14b0ed74", "1234567890", 7.0, "Non veg Restorent", hotel);
		ArrayList<Rating> al = new ArrayList<>();
		al.add(rating);
		User user = new User("14b0ed74", "Mohit", "Mohit@gmail.com", "Jhansi", "123456789", al);
		User testUser = UserServiceImpl.getUser(user.getUserId());
		assertEquals(testUser.toString(), user.toString());
	}
	
	@Test
	void TestGetUserBy() {
		
	}
	
	
}
