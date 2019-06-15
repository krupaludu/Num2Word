package com.virtusa.assessment.codetest.util;

import com.virtusa.assessment.codetest.constants.CurrencyErrorMessages;
import com.virtusa.assessment.codetest.exception.CurrencyConverterException;

public class CurrencyToWordUtil {
	
	private static boolean isNumber(String s) 
    { 
        for (int i = 0; i < s.length(); i++) 
        if (Character.isDigit(s.charAt(i))  
            == false) 
            return false; 
  
        return true; 
    } 
	
	public static String convert(String currency) throws CurrencyConverterException{
		String c2word = "";
		if(isNumber(currency)) {
			c2word = num2word(Integer.parseInt(currency));
		}else {
			throw new CurrencyConverterException(CurrencyErrorMessages.INVALID_INPUT_NEGATIVE_NUMBER);
		}
		return c2word;
	}

	private static String num2word(int num) throws CurrencyConverterException{
		
		if (num == 0 || num >999999999) {
			throw new CurrencyConverterException(CurrencyErrorMessages.INVALID_INPUT_OUT_OF_RANGE);
		}
		else if(num <0){
			throw new CurrencyConverterException(CurrencyErrorMessages.INVALID_INPUT_NOT_A_VALID_NUMBER);
		}
		String inWords = "";
		String unitsArray[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
		String tensArray[] = { "zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
				"ninety" };

		
		if ((num / 1000000) > 0) {
			inWords += num2word(num / 1000000) + " million ";
			num %= 1000000;
		}
		if ((num / 1000) > 0) {
			inWords += num2word(num / 1000) + " thousand ";
			num %= 1000;
		}
		if ((num / 100) > 0) {
			inWords += num2word(num / 100) + " hundred and ";
			num %= 100;
		}

		if (num > 0) {
			if (num < 20) {
				inWords += unitsArray[num];
			} else {
				inWords += tensArray[num / 10];
				if ((num % 10) > 0) {
					inWords += " " + unitsArray[num % 10];
				}
			}
		}
		return inWords;
	}

}
