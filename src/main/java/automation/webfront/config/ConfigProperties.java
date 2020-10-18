package automation.webfront.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Singleton class to read test configuration properties file.
 */
public final class ConfigProperties {
	
	private static final String CONFIG_PROPERTIES = "config/config.properties";
	private static final String BROWSER = "browser";
	private static final String BASE_URL = "base.url";
	
	private static ConfigProperties instance = null;
	private Properties prop = null;
	private InputStream inStream;
	
	private ConfigProperties() {
		prop = new Properties();
		inStream = getClass().getClassLoader().getResourceAsStream(CONFIG_PROPERTIES);
		
		try {
			prop.load(inStream);
			inStream.close();
		} catch (IOException e) {
			throw new RuntimeException("Failure to read properties file.");
		}
	}
	
	public static ConfigProperties getInstance() {
		if (instance == null) {
			instance = new ConfigProperties();
		}
		
		return instance;
	}

	public String getBrowser() {
		return prop.getProperty(BROWSER);
	}

	public String getBaseUrl() {
		return prop.getProperty(BASE_URL);
	}
	
}
