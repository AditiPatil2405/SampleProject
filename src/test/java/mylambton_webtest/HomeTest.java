package mylambton_webtest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class HomeTest {
	WebDriver driver;
	  @Test
	  public void login() {
	  	//Setting up the chrome driver exe, the second argument is the location where you have kept the driver in your system
	  	//  System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	  	 
	  	//Setting the driver to chrome driver
//	  	  driver = new ChromeDriver();
//	  	  String url = "https://www.google.com";
//	  	  driver.get(url);
	  	//Capturing the title and validating if expected is equal to actual
	  	  String expectedTitle = "Google";
	  	  String actualTitle = "Google";
	  	 // String actualTitle = driver.getTitle();
	  	  System.out.println("Inside test");
	  	  Assert.assertEquals(actualTitle, expectedTitle);
	    }
	  @BeforeMethod
	  public void beforeMethod() {
	  	  System.out.println("Starting the browser session");
	  }
	 
	  @AfterMethod
	  public void afterMethod() {
	  	  System.out.println("Closing the browser session");
	  	  //driver.quit();
	  }

}