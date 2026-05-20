package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverManager;

public class WaitUtils {
	public static void waitForElement(By locator) {

		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
