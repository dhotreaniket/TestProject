/* ======================================================================= *
 *  (c) Copyright 2018-2019, ATOS India , WorldLine 
 *  All Rights Reserved
 *  Company Confidential
 *  Author :Aniket Dhotre
 *  Das Id :A681205
 * ======================================================================= *
 */

/**
 * It helps to Give Basic Resource Path
 */

package com.utilties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ResourceHelper {

	public static String getResourcePath(String resource) {
		String path = getBaseResourcePath() + resource;
		return path;
	}

	public static String getBaseResourcePath() {
		String path = System.getProperty("user.dir");
		return path;
	}

	public static InputStream getResourceInputStream(String path) throws FileNotFoundException {
		return new FileInputStream(ResourceHelper.getResourcePath(path));
	}
}
