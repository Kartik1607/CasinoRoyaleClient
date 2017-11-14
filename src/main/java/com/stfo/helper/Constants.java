package com.stfo.helper;

import java.math.BigDecimal;
import java.util.Random;

public class Constants {
	public static final String API_URL = "http://localhost:8080/api";
	public static final long BETTING_UNIT = 500;

	public static final BigDecimal[] multipliers;
	public static final int iZERO = 0;
	public static final int iFIRST_TWELVE = 1;
	public static final int iSECOND_TWELVE = 2;
	public static final int iTHIRD_TWELVE = 3;
	public static final int iFIRST_EIGHTEEN = 4;
	public static final int iLAST_EIGHTEEN = 5;
	public static final int iODD = 6;
	public static final int iEVEN = 7;
	
	static {
		multipliers = new BigDecimal[8];
		multipliers[iZERO] = new BigDecimal("10");
		
		multipliers[iFIRST_TWELVE] = new BigDecimal("1.5");
		multipliers[iSECOND_TWELVE] = new BigDecimal("1.5");
		multipliers[iTHIRD_TWELVE] = new BigDecimal("1.5");

		multipliers[iFIRST_EIGHTEEN] = new BigDecimal("1.25");
		multipliers[iLAST_EIGHTEEN] = new BigDecimal("1.25");
		
		multipliers[iODD] = new BigDecimal("1.25");
		multipliers[iEVEN] = new BigDecimal("1.25");
	}
	
	private static Random rand = new Random();
	
	public static int getRandomNumber() {
		return rand.nextInt(37);
	}
}