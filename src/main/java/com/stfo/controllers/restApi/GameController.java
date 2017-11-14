package com.stfo.controllers.restApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stfo.models.UserModel;

@RestController
@RequestMapping("/api")
public class GameController {

	@GetMapping("/users/{userId}")
	public UserModel getUser(@PathVariable(value="userId", required=true) Long uid) {
		return null;
	}
	
}
