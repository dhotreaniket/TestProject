/* ======================================================================= *
 *  (c) Copyright 2018-2019, ATOS India , WorldLine 
 *  All Rights Reserved
 *  Company Confidential
 *  Author :Aniket Dhotre
 *  Das Id :A681205
 * ======================================================================= *
 */
package com.configreader;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Properties;

/**
 * Provides utility to perform read/write operations on properties file.
 */

public class PropertyFile {

	private Properties properties;

	/**
	 * Default constructor.
	 * Creates object for properties file.
	 */
	public PropertyFile(){
		properties = new Properties();
	}

	/**
	 * Loads properties file.
	 */
	public void loadFile(InputStream in){
		try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Stores properties file.
	 */
	public void storeFile(Writer in){
		try {
			properties.store(in, "");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sets value for key in properties file.
	 * @param sKey Key for which value to be changed.
	 * @param sValue Value to be updated for key
	 */
	public void setValue(String sKey, String sValue){
		properties.setProperty(sKey, sValue);
	}

	/**
	 * Sets value for key in properties file.
	 * @param sKey Key for which value to be retrieved.
	 * @return Returns value for given key.
	 */
	public String getValue(String sKey){
		return properties.getProperty(sKey);
	}
}