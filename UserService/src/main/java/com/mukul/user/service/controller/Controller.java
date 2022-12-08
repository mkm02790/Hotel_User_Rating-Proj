/**
 * 
 */
package com.mukul.user.service.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.String;
import java.net.URL;
import java.util.List;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mukul.user.service.entities.User;
import com.mukul.user.service.exception.UsePatchInsteadOfPutException;
import com.mukul.user.service.services.UserServices;

/**
 * @author mukul
 *
 *         01-Dec-2022
 */
@RestController
@RequestMapping("/users")
public class Controller {
	private static String CLASS_NAME = "Controller";

	@Autowired
	UserServices userServices;

	private static Logger logger = LogManager.getLogger(Controller.class);
	 
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		String METHOD_NAME = "createUser";
		PropertyConfigurator.configure("log4j.properties");
		long entryTime = System.currentTimeMillis();
		logger.debug("Entry Inside Create user method of Controller class", CLASS_NAME, METHOD_NAME);

		User response = userServices.saveUser(user);

		long exitTime = System.currentTimeMillis();
		long netTime = exitTime - entryTime;
		logger.debug("Exit From Create user method of Controller class", CLASS_NAME, METHOD_NAME,
				"Time Taken in method Excution " + netTime);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		String METHOD_NAME = "getAllUser";
		List<User> userList = userServices.getAllUser();
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable String userId) {
		String METHOD_NAME = "getUserById";
		User user = userServices.getUser(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{userId}")
	public ResponseEntity<Object> deleteUser(@PathVariable String userId) {
		String METHOD_NAME = "deleteUser";
		User user = userServices.deleteUser(userId);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<User> updatePutUser(@RequestBody User obj) {
		String METHOD_NAME = "updatePutUser";
		if (null == obj.getAbout() || null == obj.getEmail() || null == obj.getName()) {
			throw new UsePatchInsteadOfPutException("If only some fields need to update then use Patch method");
		}
		User user = userServices.updateUser(obj);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PATCH)
	public ResponseEntity<User> updatePatchUser(@RequestBody User obj) {
		String METHOD_NAME = "updatePatchUser";
		User user = userServices.updatePatch(obj);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
