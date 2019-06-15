package com.virtusa.assessment.codetest;

import java.util.Scanner;

import com.virtusa.assessment.codetest.exception.CurrencyConverterException;
import com.virtusa.assessment.codetest.util.CurrencyToWordUtil;

public class CurrencyToWordConvertApp {
	public static void main(String[] args) {

		Scanner inputReader = new Scanner(System.in);
		String confirmToExit = "y";

		do {
			System.out.println("Enter number to convert currency in words = ");
			confirmToExit = inputReader.nextLine();
			if (!confirmToExit.equalsIgnoreCase("y")) {
				try {
					// number = 56945781;// 0;
					System.out.println("Given Number (" + confirmToExit + ") in words: "
							+ CurrencyToWordUtil.convert(confirmToExit));
				} catch (CurrencyConverterException e) {
					// e.printStackTrace();
					System.out.println(e.getMessage());
				} catch (Exception e) {
					// e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}else {
				inputReader.close();
			}
		} while (!confirmToExit.equalsIgnoreCase("y"));

	}
}
