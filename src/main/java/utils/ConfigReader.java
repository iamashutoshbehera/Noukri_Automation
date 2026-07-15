package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	Properties prop;
	
	public ConfigReader() {
		prop = new Properties();
		
		try {
			FileInputStream file = new FileInputStream("src\\test\\resources\\config.properties");
            prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getUrl() {
		return prop.getProperty("URL");
	}
	
	public String getUsername() {
		return prop.getProperty("Username");
	}
	
	public String getPassword() {
		return prop.getProperty("Password");
	}

	public int getDefaultPageLoadTime() {
		return Integer.parseInt(prop.getProperty("DefaultPageLoadTime"));
	}
	
	public String getProfileName() {
		return prop.getProperty("ProfileName");
	}
	
	public String getLoginPageTitle() {
		return prop.getProperty("LoginPageTitle");
	}
}
