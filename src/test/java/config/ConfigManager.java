package config;

public class ConfigManager {
	public static String getBrowser() {

		return PropertyReader.getProperty("browser");
	}

	public static boolean isHeadless() {

		return Boolean.parseBoolean(PropertyReader.getProperty("headless"));
	}

	public static String getExecutionType() {

		return PropertyReader.getProperty("execution");
	}

	public static String getBaseUrl() {

		return PropertyReader.getProperty("baseUrl");
	}

	public static String getGridUrl() {

		return PropertyReader.getProperty("gridUrl");
	}

}
