package com.rcslopes.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rcslopes.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1","Maria Laura", "maria@email.com");
		User anne = new User("2","Anne Moura", "anne@email.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria,anne));
		return ResponseEntity.ok().body(list);
		
	}
}
