package com.currency.converter.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
	
	UserPOJO user1;
	UserPOJO user2;
	UserPOJO user3;
	List<UserPOJO> allUsers = new ArrayList<UserPOJO>();
	public RestController() {
		// TODO Auto-generated constructor stub
		
	user1	 = new UserPOJO(1,"Vishakha","21","New member of our Team");
	user2	 = new UserPOJO(2,"Gaurangi","21","New member of our Team");
	user3	 = new UserPOJO(3,"Shubham","21", "New member of our Team");
	allUsers.add(user1);
	allUsers.add(user2);
	allUsers.add(user3);

	}
	
	
	
	@GetMapping("/get_users")
	public List<UserPOJO> getAllUser() {

		return allUsers;
	}
	
	@GetMapping("/get_users/{userId}")
	public ResponseEntity<?> getUserWithId(@PathVariable("userId") int id) {
		
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
			@PostMapping("/insert_user")
			public ResponseEntity<?> insertUser(@RequestBody UserPOJO user) {
				
				
					if(user.getId()==2) {
					 
					for(UserPOJO u : allUsers) {
					
						if(u.getId()==2) {
							u.setAge(user.getAge());
							u.setDescription(user.getDescription());
							u.setName(user.getName());
											}
					}
						
					return new ResponseEntity<List<UserPOJO>>(allUsers,HttpStatus.OK);
	
					}	else {
						
						return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
			}
				
		
	}
	
	
	
	
	
	
}
