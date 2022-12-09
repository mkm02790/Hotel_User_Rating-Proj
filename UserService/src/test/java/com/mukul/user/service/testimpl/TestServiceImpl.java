package com.mukul.user.service.testimpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
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
		Rating rating = new Rating("a0a3762b", "523b0b91", "1234567890", 7.0, "Goooood hotel", hotel);
		ArrayList<Rating> al = new ArrayList<>();
		al.add(rating);
		User user = new User("523b0b91", "ABC", "AAAAAAAA@gmail.com", "Gorakhpur", "4567891230", al);
		User testUser = UserServiceImpl.getUser(user.getUserId());
		assertEquals(testUser.toString(), user.toString());
	}
	
	@Test
	void TestSaveUser() {
		User user = new User("Mohit", "Mohit@gmail.com", "Jhansi", "123456789");
		User savedUser = UserServiceImpl.saveUser(user);
		assertThat(savedUser.getUserId()).hasSize(8);
		
	}
	
	@Test
	void TestGetAllUser() {
		List<User> userList = UserServiceImpl.getAllUser();		
		assertThat(userList.size()).isGreaterThanOrEqualTo(1);
	}
	
	
	
	@Test
	void TestUpdateUser() {
		User user = UserServiceImpl.getUser("01116df4");		
		user.setAbout("Updated about");
		user.setEmail("");
		user.setName("Updated name");
		User updatedUser = UserServiceImpl.saveUser(user);
		assertThat(updatedUser.getName()).isEqualTo("Updated name");
		
	}
	
	
	
	
}

