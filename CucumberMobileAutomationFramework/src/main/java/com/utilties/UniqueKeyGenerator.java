/* ======================================================================= *
 *  (c) Copyright 2018-2019, ATOS India , WorldLine 
 *  All Rights Reserved
 *  Company Confidential
 *  Author :Aniket Dhotre
 *  Das Id :A681205
 * ======================================================================= *
 */

/**
 * In this page you can generate random string integer and alphanumeric values according to requirement
 */

package com.utilties;

import org.apache.commons.lang3.RandomStringUtils;

public class UniqueKeyGenerator {
	/**
	 * Gets unique string appending current date and time to the given string.
	 * @param sItem Text for which unique key is to be generated.
	 * @return Returns unique string appending current date and time to the given string.
	 */
	public static String getStringWithCurrentDateAndTime(String sItem){
		return sItem + TimeTool.getCurrentDateTime("ddMMyyyyHHmmss");
	}

	/**
	 * Gets unique string appending current date and time to the given string with underscore.
	 * @param sItem Text for which unique key is to be generated.
	 * @return Returns unique string appending current date and time to the given string with underscore.
	 */
	public static String getStringWithCurrentDateAndTimeAndUnderscore(String sItem){
		return sItem+"_"+TimeTool.getCurrentDateTime("ddMMyyyyHHmmss");
	}

	/**
	 * Gets unique random integer for given no. of digits.
	 * @param iNumberOfDigits Number of digits.
	 * @return Returns unique random integer as string for given no. of digits.
	 */
	public static String getRandomInteger(int iNumberOfDigits){	
		return RandomStringUtils.randomNumeric(iNumberOfDigits);
	}

	/**
	 * Gets unique random alphabetic for given no. of characters.
	 * @param iNumberOfCharacters Number of characters.
	 * @return Returns unique random alphabetic for given no. of characters.
	 */
	public static String getRandomString(int iNumberOfCharacters){	
		return RandomStringUtils.randomAlphabetic(iNumberOfCharacters);
	}

	/**
	 * Gets unique random alphanumeric for given no. of characters.
	 * @param iNumberOfCharacters Number of characters.
	 * @return Returns unique random alphanumeric for given no. of characters.
	 */
	public static String getrandomAlphanumericString(int iNumberOfCharacters){	
		return RandomStringUtils.randomAlphanumeric(iNumberOfCharacters);
	}

}
