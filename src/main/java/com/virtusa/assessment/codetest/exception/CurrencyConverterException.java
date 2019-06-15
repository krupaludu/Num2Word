package com.virtusa.assessment.codetest.exception;

public class CurrencyConverterException extends Exception{
	
	private static final long serialVersionUID = -8492990086419098222L;
	
	private String errMsg = null;
	public CurrencyConverterException(String errMsg) {
		this.errMsg = errMsg;
	}
	
	public String toString() {
		return errMsg;
	}
	
	public String getMessage() {
		return errMsg;
	}

}
