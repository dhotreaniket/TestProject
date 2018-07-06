/* ======================================================================= *
 *  (c) Copyright 2018-2019, ATOS India , WorldLine 
 *  All Rights Reserved
 *  Company Confidential
 *  Author :Aniket Dhotre
 *  Das Id :A681205
 * ======================================================================= *
 */

/**
 * In this page you can get current date and time in desired format
 */

package com.utilties;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTool {
	
	
	/** Return the current date and time in "dd_MMM_yyyy_HH_mm_ss" format.
	 * @return Returns current date and time.
	 */ 
	public static String getCurrentDateTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MMM_yyyy_HH_mm_ss");
		return sdf.format(new Date().getTime()); 
	}

	/** Return the current date and time in given format. 
	 *@param sFormat Format of the date and time you want.
	 *@return Returns current date and time in given format.
	 */ 
	public static String getCurrentDateTime(String sFormat){
		SimpleDateFormat sdf = new SimpleDateFormat(sFormat);
		return sdf.format(new Date().getTime()); 
	}

	/** Return the current date in "dd_MMM_yyyy" format.
	 * @return Returns current date.
	 */ 
	public static String getCurrentDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MMM_yyyy");
		return sdf.format(new Date().getTime()); 
	}

	/** Return the current time in "HH_mm_ss" format.
	 * @return Returns current time.
	 */ 
	public static String getCurrentTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("HH_mm_ss");
		return sdf.format(new Date().getTime()); 
	}

	/** Return the current year in "yyyy" format.
	 * @return Returns current year.
	 */ 
	public static String getCurrentYear(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(new Date().getTime()); 
	}

	/** Return the current month in "MMMMM" format.
	 * @return Returns current year.
	 */ 
	public static String getCurrentMonth(){
		SimpleDateFormat sdf = new SimpleDateFormat("MMMMM");
		return sdf.format(new Date().getTime()); 
	}

	/** Return the current day in "dd" format.
	 * @return Returns current day.
	 */ 
	public static String getCurrentDay(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		return sdf.format(new Date().getTime()); 
	}

}
