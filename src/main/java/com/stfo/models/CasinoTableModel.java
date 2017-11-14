package com.stfo.models;

import java.math.BigInteger;

import org.springframework.stereotype.Component;

import com.stfo.helper.Constants;

@Component
public class CasinoTableModel {
	
	private Long[] numbers;
	
	public CasinoTableModel(){}

	public Long[] getNumbers() {
		return numbers;
	}

	public void setNumbers(Long[] numbers) {
		this.numbers = numbers;
	}
	
	public long calculateBettingAmount() {
		long answer = 0;
		for(long val: numbers) {
			answer += (val * Constants.BETTING_UNIT);
		}
		return answer;
	}
	
	

}
