package config;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
	 private static Properties properties;

	    static {

	        try {

	            FileInputStream fis =
	                    new FileInputStream(
	                            "src/test/resources/config/framework.properties"
	                    );

	            properties = new Properties();
	            properties.load(fis);

	        } catch (Exception e) {

	            throw new RuntimeException(e);
	        }
	    }

	    public static String getProperty(String key) {

	        return System.getProperty(
	                key,
	                properties.getProperty(key)
	        );
	    }


}
