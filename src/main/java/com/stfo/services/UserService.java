package com.stfo.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.stfo.helper.Constants;
import com.stfo.models.UserModel;

@Service
public class UserService {
	
	public UserService() {
		Unirest.setObjectMapper(new ObjectMapper() {
			private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper = 
					new com.fasterxml.jackson.databind.ObjectMapper();
			
			@Override
			public String writeValue(Object value) {
				try {
		            return jacksonObjectMapper.writeValueAsString(value);
		        } catch (JsonProcessingException e) {
		            throw new RuntimeException(e);
		        }
			}
			
			@Override
			public <T> T readValue(String value, Class<T> valueType) {
				try {
		            return jacksonObjectMapper.readValue(value, valueType);
		        } catch (IOException e) {
		            throw new RuntimeException(e);
		        }
			}
		});
	}

	public UserModel getUser(Long userId) {
		UserModel user = null;
		try {
			HttpResponse<UserModel> userResponse = Unirest.get(Constants.API_URL + "/users/{userId}")
					.routeParam("userId", userId.toString())
					.asObject(UserModel.class);
			user = userResponse.getBody();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return user;
	}
}
