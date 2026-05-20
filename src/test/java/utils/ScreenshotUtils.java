package utils;

import java.io.File;
import driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driver.DriverManager;

public class ScreenshotUtils {

	public static void captureScreenshot(String fileName) {

		try {

			File source = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

			File destination = new File("screenshots/" + fileName + ".png");

			FileUtils.copyFile(source, destination);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
