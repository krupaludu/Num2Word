package com.virtusa.assessment.codetest;

import org.junit.Test;

import com.virtusa.assessment.codetest.constants.CurrencyErrorMessages;
import com.virtusa.assessment.codetest.util.CurrencyToWordUtil;

import junit.framework.TestCase;

public class CurrencyToWordUtilTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testConvert_ForInvalidInputNotANumber() {
		String curr = "A1000000000";
		try {
			CurrencyToWordUtil.convert(curr);
		} catch (Exception e) {
			// String errMsg = e.getMessage().trim();
			if (CurrencyErrorMessages.INVALID_INPUT_NEGATIVE_NUMBER.equals(e.getMessage().trim())) {
				assertTrue(true);
			} else {
				fail("Test case Failed : testConvert_ForInvalidInputNegativeNumber");
			}
		}
	}

	@Test
	public void testConvert_ForZeroCurrency() {
		String curr = "0";
		try {
			CurrencyToWordUtil.convert(curr);
		} catch (Exception e) {
			if (CurrencyErrorMessages.INVALID_INPUT_OUT_OF_RANGE.equals(e.getMessage().trim())) {
				assertTrue(true);
			} else {
				fail("Test case Failed : testConvert_ForZeroCurrency");
			}
		}
	}

	@Test
	public void testConvert_ForInvalidInputNegativeNumber() {
		String curr = "-10";
		try {
			CurrencyToWordUtil.convert(curr);
		} catch (Exception e) {
			// String errMsg = e.getMessage().trim();
			if (CurrencyErrorMessages.INVALID_INPUT_NEGATIVE_NUMBER.equals(e.getMessage().trim())) {
				assertTrue(true);
			} else {
				fail("Test case Failed : testConvert_ForInvalidInputNegativeNumber");
			}
		}
	}

	@Test
	public void testConvert_ForInvalidInputOutOfRangeNumber() {
		String curr = "1000000000";
		try {
			CurrencyToWordUtil.convert(curr);
		} catch (Exception e) {
			// String errMsg = e.getMessage().trim();
			if (CurrencyErrorMessages.INVALID_INPUT_OUT_OF_RANGE.equals(e.getMessage().trim())) {
				assertTrue(true);
			} else {
				fail("Test case Failed : testConvert_ForInvalidInputNegativeNumber");
			}
		}
	}

	@Test
	public void testConvert_ForValidCurrencyMillion() {
		String curr = "56945781";
		String inWords = "";
		try {
			inWords = CurrencyToWordUtil.convert(curr);
		} catch (Exception e) {
			fail("Test case Failed : testConvert_ForValidCurrency");
		}
		assertEquals("fifty six million nine hundred and forty five thousand seven hundred and eighty one", inWords);
	}

	@Test
	public void testConvert_ForValidCurrencyHundreds() {
		String curr = "781";
		String inWords = "";
		try {
			inWords = CurrencyToWordUtil.convert(curr);
		} catch (Exception e) {
			fail("Test case Failed : testConvert_ForValidCurrencyHundreds");
		}
		assertEquals("seven hundred and eighty one", inWords);
	}

	@Test
	public void testConvert_ForValidCurrencyThousands() {
		String curr = "5781";
		String inWords = "";
		try {
			inWords = CurrencyToWordUtil.convert(curr);
		} catch (Exception e) {
			fail("Test case Failed : testConvert_ForValidCurrencyThousands");
		}
		assertEquals("five thousand seven hundred and eighty one", inWords);
	}

	@Test
	public void testConvert_ForValidCurrencyTens() {
		String curr = "81";
		String inWords = "";
		try {
			inWords = CurrencyToWordUtil.convert(curr);
		} catch (Exception e) {
			fail("Test case Failed : testConvert_ForValidCurrencyTens");
		}
		assertEquals("eighty one", inWords);
	}

	@Test
	public void testConvert_ForValidCurrencyOnes() {
		String curr = "1";
		String inWords = "";
		try {
			inWords = CurrencyToWordUtil.convert(curr);
		} catch (Exception e) {
			fail("Test case Failed : testConvert_ForValidCurrencyOnes");
		}
		assertEquals("one", inWords);
	}
}
