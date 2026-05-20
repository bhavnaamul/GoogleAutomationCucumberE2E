package driver;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import config.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

	public static WebDriver initializeDriver() throws Exception {

		BrowserType browserType = BrowserType.valueOf(ConfigManager.getBrowser().toUpperCase());

		ExecutionType executionType = ExecutionType.valueOf(ConfigManager.getExecutionType().toUpperCase());

		boolean headless = ConfigManager.isHeadless();

		WebDriver driver;

		switch (browserType) {

		case CHROME: {

			ChromeOptions options = new ChromeOptions();

			options.addArguments("--start-maximized");

			options.addArguments("--disable-notifications");

			if (headless) {

				options.addArguments("--headless=new");
			}

			if (executionType == ExecutionType.GRID) {

				driver = new RemoteWebDriver(new URL(ConfigManager.getGridUrl()), options);

			} else {

				driver = new ChromeDriver(options);
			}
		}
			break;
			
		case FIREFOX: {

			FirefoxOptions options = new FirefoxOptions();

			if (headless) {

				options.addArguments("--headless");
			}

			if (executionType == ExecutionType.GRID) {

				driver = new RemoteWebDriver(new URL(ConfigManager.getGridUrl()), options);

			} else {

				driver = new FirefoxDriver(options);
			}
		}
			break;

		case EDGE: {

			EdgeOptions options = new EdgeOptions();

			if (executionType == ExecutionType.GRID) {

				driver = new RemoteWebDriver(new URL(ConfigManager.getGridUrl()), options);

			} else {

				driver = new EdgeDriver(options);
			}
		}
			break;

		default:
			throw new RuntimeException("Invalid browser");
		}

		return driver;
	}

}