package com.automationpractice.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class AppProperties {
	
	private final static Logger logger = Logger.getLogger(AppProperties.class);
	private static Properties properties = getProperties();
	
	public static final String AUTOMATION_PRACTICE_BASE_URL = properties.getProperty("automation_practice_base_url");
	public static final String BROWSER_TYPE = properties.getProperty("browser_type");
	public static final boolean IS_EACH_STEP_SCREENSHOT = Boolean.parseBoolean(properties.getProperty("take_screenshot_on_each_step"));
	public static final int TIME_OUT_IN_SECONDS = Integer.parseInt(properties.getProperty("global_time_out_in_seconds"));
	
	public static final String DB_URL = properties.getProperty("db_url");
	public static final String DB_PORT = properties.getProperty("db_port");
	public static final String DB_NAME = properties.getProperty("db_name");
	public static final String DB_USER = properties.getProperty("db_user");
	public static final String DB_PASSWORD = properties.getProperty("db_password");
	
	private static Properties getProperties () {
		Properties properties = new Properties();
		
		try {
			String filePath = System.getProperty("user.dir") + 
					"/src/test/resources/properties/config.properties";
			InputStream inputStream = new FileInputStream(filePath);
			properties.load(inputStream);
		} catch ( IOException e ) {
			logger.error(e.getMessage());
		}
		return properties;
	}
}
