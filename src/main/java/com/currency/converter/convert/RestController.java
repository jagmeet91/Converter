package com.currency.converter.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
	
	UserPOJO user1;
	UserPOJO user2;
	public RestController() {
		// TODO Auto-generated constructor stub
		
	user1	 = new UserPOJO(1,"Harpreet","26","she is my sister doing it for her");
	user2	 = new UserPOJO(2,"Jagmeet","22","This is me");
		
	}
	
	
	
	@GetMapping("/get_users")
	public List<UserPOJO> getAllUser() {
		
		List<UserPOJO> allUsers = new ArrayList<UserPOJO>();
		
			allUsers.add(user1);
			allUsers.add(user2);
	
		return allUsers;
	}
	
	@GetMapping("/get_users/{userId}")
	public ResponseEntity<?> getUserWithId(@PathVariable int id) {
		
		List<UserPOJO> allUsers = new ArrayList<UserPOJO>();
		
			if(user1.id==id){
				return new ResponseEntity<UserPOJO>(user1,HttpStatus.OK);
			}
			else {
				if(user2.id==id) {
					return new ResponseEntity<UserPOJO>(user2,HttpStatus.OK);
				}
				else {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				}
			}
		
		
		
	}
	
	
	
	
	
	
}
