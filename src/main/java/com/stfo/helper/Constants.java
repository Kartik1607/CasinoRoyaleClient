package com.stfo.helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
	
	
	public static int getRandomNumber() {
		return generateRandom(20);
	}
	

	 public static int generateRandom(int cycles) {
	   List<Integer> even = new ArrayList<>(); // Stores all random numbers with even digits
	   List<Integer> odd = new ArrayList<>(); // Stores all random numbers with odd digits
	   /*
	    * Step 1 : Generate 20 random numbers
	    */
	   fillList(even, odd, cycles); // Generates the list
	   int res = 0; //Result random number
	   
	   /*
	    * Example : 
	    * Random numbers generated are : 
	    * EVEN [48, 81, 56] => Even-Odd = [4, -7, 1]
	    * ODD [012, 791, 181] => Even-Odd = [-1, 1, 6]
	    */
	   
	   /*
	    * Numbers with even digits do not change polarity of the sum of other numbers.
	    * We want to minimize odd - even for final number 
	    * 		OD
	    * 	maximize even - odd for final number.
	    * 
	    * STEP 2 : Add all positive even digit numbers to result.
	    * 
	    * Example :
	    * We take [48,56] => Result = 48-56 => Even-Odd = 4+1 = 5
	    */
	   for(int i = 0 ; i < even.size() ; ++i) {
	     if (even.get(i) >= 0) {
	       res += even.get(i);
	     }
	   }
	   
	   /* STEP 3
	    * Odd numbers change the polarity of sum of next number.
	    * First we want to take up all the even digit numbers. 
	    * To make all negative even digit numbers positive, we take the biggest odd number.
	    * This effectively turns all +ve sums to -ve and vice versa.
	    * 
	    * Example :
	    * We take 181 from the list
	    * Result 48-56-181 => 4+1+6 = 11.
	    * Now polarity of other numbers must be changed.
	    * 
	    * List now is 
	    * 
	    * EVEN [81] => Even-Odd = [+7]
	    * ODD [012, 791] => Even-Odd = [+1, -1]
	    */
	   Collections.sort(odd);
	   res += odd.get(odd.size() - 1);
	   odd.remove(odd.size()-1);
	   /*
	    * STEP 4
	    * Take remaining even digit numbers. 
	    * At this point, even digits negative numbers are turned +ve due to previous odd number
	    * 
	    * Example :
	    * We take  81
	    * Result => 48-56-181-81 => 4 + 1 + 6 + 7 = 18
	    */
	   for(int i = 0 ; i < even.size() ; ++i) {
	     if (even.get(i) < 0) {
	       res += (even.get(i) * -1);
	     }
	   }
	   
	   boolean isPositive = false; //Checks if current sign is +ve or not. Previous odd number made it -ve.
	   
	   /*
	    * STEP 5
	    * Recursively take biggest odd number. Change polarity of sign after each iteration.
	    * 
	    * Example 
	    * 
	    * ODD [012, 791]  => Even-Odd = [+1, -1]
	    * 
	    * Iteration 1
	    * Result => 48-56-181-81-012 => 4 + 1 + 6 + 7 + 1= 19
	    * ODD [791] => Even-Odd [+1]
	    * 
	    * Iteration 2
	    * Result => 48-56-181-81-012-791 => 4 + 1 + 6 + 7 + 1 + 1= 20
	    */
	   while (odd.size() > 0) {
	     if (isPositive) {
	       res += odd.get(odd.size() -1 ); //Largest odd number is at back of list
	       odd.remove(odd.size() - 1);
	     } else {
	       res += (-1 * odd.get(0)); //Largest odd number is at front of list
	       odd.remove(0);
	     }
	     isPositive = !isPositive;
	   }
	   
	   /*
	    * STEP 6: We found highest even-odd. But we want smallest odd-even.
	    * We simply reverse the polarity of result.
	    * 
	    * Result = -20. This is minimum odd - even possible.
	    */
	   res = res*-1;
	   
	   /*
	    * STEP 7 : Random number is res % 37.
	    * Answer = -20 + 37 = 17
	    */
	   while(res < 0) {
	     res+=37;
	   }
	   res = res % 37;
	   return res;
	 }
	 
	 private static void fillList(List<Integer> even, List<Integer> odd, int n) {
	   Random rand = new Random();
	   for(int i = 0; i < n; ++i) {
	     int digit = rand.nextInt(10) + 1; // Random number b/w 1 -10 [number of digits]
	     int evenSum = 0; // Stores sum of digits at even places.
	     int oddSum = 0; // Stores sum of digits at odd places.
	     for(int j = 1; j <= digit; ++j) {
	       int x = rand.nextInt(10);
	       if(j%2 == 0) {
	         evenSum += x;
	       } else {
	         oddSum += x;
	       }
	     }
	     if(digit % 2 == 0) {
	       even.add(evenSum - oddSum); 
	     } else {
	       odd.add(evenSum - oddSum);
	     }
	   }
	 }

}