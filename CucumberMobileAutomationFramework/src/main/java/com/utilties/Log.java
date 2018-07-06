/* ======================================================================= *
 *  (c) Copyright 2018-2019, ATOS India , WorldLine 
 *  All Rights Reserved
 *  Company Confidential
 *  Author :Aniket Dhotre
 *  Das Id :A681205
 * ======================================================================= *
 */

/**
 * Provides common log method
 */

package com.utilties;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

public class Log {

	static Logger log = Logger.getLogger(Log.class.getName());

	/**
	 * Logs information message in log file.
	 */
	public static void info(String sMessage) {
		log.info(sMessage);
	}

	/**
	 * Logs warn message in log file.
	 */
	public static void warn(String sMessage) {
		log.warn(sMessage);
	}

	/**
	 * Logs error message in log file.
	 */
	public static void error(String sMessage,Exception e) {
		log.error("Error = " +sMessage);
		log.error("Exception Message = " + e.getMessage());
		log.error("Backtrace = " +StringUtils.join(ExceptionUtils.getRootCauseStackTrace(e), "\n"));
	}

	/**
	 * Logs fatal message in log file.
	 */
	public static void fatal(String sMessage) {
		log.fatal(sMessage);
	}

	/**
	 * Logs debug message in log file.
	 */
	public static void debug(String sMessage,Exception e) {
		log.debug(sMessage,e);
	}
}
