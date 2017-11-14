package com.stfo.controllers.restApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stfo.models.UserModel;
import com.stfo.services.UserService;

@RestController
@RequestMapping("/api")
public class GameController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users/{userId}")
	public UserModel getUser(@PathVariable(value="userId", required=true) Long uid) {
		return this.userService.getUser(uid);
	}
	
}
