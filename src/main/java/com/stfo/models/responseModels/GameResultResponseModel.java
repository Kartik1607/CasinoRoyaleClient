package com.stfo.models.responseModels;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class GameResultResponseModel {
	private BigDecimal amountBetted;
	private BigDecimal amountWon;
	private int randomNumber;
	
	public GameResultResponseModel() {}

	public BigDecimal getAmountBetted() {
		return amountBetted;
	}

	public void setAmountBetted(BigDecimal amountBetted) {
		this.amountBetted = amountBetted;
	}

	public BigDecimal getAmountWon() {
		return amountWon;
	}

	public void setAmountWon(BigDecimal amountWon) {
		this.amountWon = amountWon;
	}

	public int getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(int randomNumber) {
		this.randomNumber = randomNumber;
	}
	
	
}
