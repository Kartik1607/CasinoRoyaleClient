package com.stfo.services;

import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.stfo.helper.Constants;
import com.stfo.helper.ResponseModel;
import com.stfo.models.UserModel;

@Service
public class UserService {
	

	public UserService() {
	}

	public ResponseModel<UserModel> getUser(Long userId) {
		ResponseModel<UserModel> response= new ResponseModel<>();
		try {
			HttpResponse<String> userResponse = Unirest.get(Constants.API_URL + "/users/{userId}")
					.routeParam("userId", userId.toString())
					.asString();
			
			com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
			TypeReference<ResponseModel<UserModel>> type = new TypeReference<ResponseModel<UserModel>>() {};
			ResponseModel<UserModel> responseWrapper = objectMapper
					.readValue(userResponse.getRawBody(), type);
			
			response.setSuccess(true);
			response.setData(responseWrapper.getData());
		
		} catch (UnirestException e) {
			response.setSuccess(false);
			response.setError(e.toString());
			e.printStackTrace();
		} catch (JsonParseException e) {
			response.setSuccess(false);
			response.setError(e.toString());
			e.printStackTrace();
		} catch (JsonMappingException e) {
			response.setSuccess(false);
			response.setError(e.toString());
			e.printStackTrace();
		} catch (IOException e) {
			response.setSuccess(false);
			response.setError(e.toString());
			e.printStackTrace();
		}
		return response;
	}
	
	public ResponseModel<UserModel> blockAmount(Long userId, BigDecimal amount) {
		ResponseModel<UserModel> response = new ResponseModel<>();
		try {
			HttpResponse<String> userResponse = Unirest.put(Constants.API_URL + "/blockAmount/{userId}")
					.routeParam("userId", userId.toString())
					.queryString("amount", amount)
					.asString();
			com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
			TypeReference<ResponseModel<UserModel>> type = new TypeReference<ResponseModel<UserModel>>() {};
			ResponseModel<UserModel> responseWrapper = objectMapper
					.readValue(userResponse.getRawBody(), type);
			
			response.setSuccess(true);
			response.setData(responseWrapper.getData());
		} catch (UnirestException e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setError(e.toString());
		} catch (JsonParseException e) {
			response.setSuccess(false);
			response.setError(e.toString());
			e.printStackTrace();
		} catch (JsonMappingException e) {
			response.setSuccess(false);
			response.setError(e.toString());
			e.printStackTrace();
		} catch (IOException e) {
			response.setSuccess(false);
			response.setError(e.toString());
			e.printStackTrace();
		}
		return response;	
	}
	
	public ResponseModel<UserModel> addBalance(Long userId, BigDecimal amount) {
		ResponseModel<UserModel> response = new ResponseModel<>();
		try {
			HttpResponse<String> userResponse = Unirest.put(Constants.API_URL + "/recharge/{userId}")
					.routeParam("userId", userId.toString())
					.queryString("amount", amount)
					.asString();
			
			com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
			TypeReference<ResponseModel<UserModel>> type = new TypeReference<ResponseModel<UserModel>>() {};
			ResponseModel<UserModel> responseWrapper = objectMapper
					.readValue(userResponse.getRawBody(), type);
			
			response.setSuccess(true);
			response.setData(responseWrapper.getData());
		} catch (UnirestException e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setError(e.toString());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;	
	}
	
	public ResponseModel<UserModel> deductBalance(Long userId, BigDecimal amount) {
		ResponseModel<UserModel> response = new ResponseModel<>();
		try {
			HttpResponse<String> userResponse = Unirest.put(Constants.API_URL + "/deduct/{userId}")
					.routeParam("userId", userId.toString())
					.queryString("amount", amount)
					.asString();
			
			com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
			TypeReference<ResponseModel<UserModel>> type = new TypeReference<ResponseModel<UserModel>>() {};
			ResponseModel<UserModel> responseWrapper = objectMapper
					.readValue(userResponse.getRawBody(), type);
			
			response.setSuccess(true);
			response.setData(responseWrapper.getData());
		} catch (UnirestException e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setError(e.toString());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;	
	}
	
	public ResponseModel<UserModel> removeBlockingAmount(Long userId, BigDecimal amount) {
		ResponseModel<UserModel> response = new ResponseModel<>();
		try {
			HttpResponse<String> userResponse = Unirest.put(Constants.API_URL + "/removeBlockedAmount/{userId}")
					.routeParam("userId", userId.toString())
					.queryString("amount", amount)
					.asString();
			
			com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
			TypeReference<ResponseModel<UserModel>> type = new TypeReference<ResponseModel<UserModel>>() {};
			ResponseModel<UserModel> responseWrapper = objectMapper
					.readValue(userResponse.getRawBody(), type);
			
			response.setSuccess(true);
			response.setData(responseWrapper.getData());
		} catch (UnirestException e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setError(e.toString());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;	
	}
	
}
