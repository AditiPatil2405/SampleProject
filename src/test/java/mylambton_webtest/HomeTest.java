package mylambton_webtest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomeTest {

	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Starting the browser session");
		report = new ExtentReports(System.getProperty("user.dir") + "\\Reports\\ExtentReport.html");
		test = report.startTest("SampleDemo");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void login() throws IOException {
		// Setting up the chrome driver exe, the second argument is the location where
		// you have kept the driver in your system
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"/src/main/resources/chromedriver.exe");

		// Setting the driver to chrome driver
		driver = new ChromeDriver();
		String url = "http://35.183.98.124/#";
		driver.get(url);
		
		test.log(LogStatus.PASS, "Navigated to http://35.183.98.124/# URL");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		test.log(LogStatus.PASS,test.addScreenCapture(capture(driver)));
		WebElement element = driver.findElement(By.xpath("(//*[@name='email'])[1]"));
		element.sendKeys("xyz@gmail.com");
		test.log(LogStatus.PASS,"Enter Email Address",test.addScreenCapture(capture(driver)));
		
		/*
		 * //Capturing the title and validating if expected is equal to actual String
		 * expectedTitle = "Google"; String actualTitle = "Google"; // String
		 * actualTitle = driver.getTitle(); System.out.println("Inside test");
		 * Assert.assertEquals(actualTitle, expectedTitle);
		 */
	}
	
	public static String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("src/../ErrImages/" + System.currentTimeMillis()
		+ ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
		}
	
	@AfterMethod
	public void afterMethod() {
		test.log(LogStatus.PASS, "Closing the browser session");
		System.out.println("Closing the browser session");
		driver.quit();
		report.endTest(test);
		report.flush();
	}

}
