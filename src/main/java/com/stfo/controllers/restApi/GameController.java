package com.stfo.controllers.restApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stfo.helper.ResponseModel;
import com.stfo.models.UserModel;
import com.stfo.models.requestModels.GameRequestModel;
import com.stfo.models.responseModels.GameResultResponseModel;
import com.stfo.services.GameService;
import com.stfo.services.UserService;

@RestController
@RequestMapping("/api")
public class GameController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping("/users/{userId}")
	public UserModel getUser(@PathVariable(value="userId", required=true) Long uid) {
		return this.userService.getUser(uid);
	}
	
	@PutMapping("/games")
	public ResponseEntity<ResponseModel<GameResultResponseModel>> getResult(@RequestBody GameRequestModel tableModel) {
		GameResultResponseModel result = this.gameService.getResult(tableModel);
		ResponseModel<GameResultResponseModel> response = new ResponseModel<>();
		response.setSuccess(true);
		response.setData(result);
		return new ResponseEntity<ResponseModel<GameResultResponseModel>>(response, HttpStatus.OK);
	}
}
