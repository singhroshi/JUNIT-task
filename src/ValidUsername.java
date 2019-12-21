import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidUsername {

	public static String baseUrl = "http://sethuonline.com/lms/";
	public static String path = "C:\\Users\\roshi\\Documents\\Selenium Folder\\drivers\\chromedriver.exe";
	public static WebDriver driver;
	public static WebDriverWait wait;	
	public static WebElement emailReset;
	public static WebElement loginElement;
	public static WebElement lostElement;
	public static WebElement usernameReset;	

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		// redirect to your home page
		driver.get(baseUrl);		
	}
	
	@Test
	public void usernameTest()throws InterruptedException {
		wait = new WebDriverWait(driver, 10);
		loginElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='thim-widget-login-popup thim-widget-login-popup-base']")));
		loginElement.click();
		lostElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='lost-pass-link']")));
		lostElement.click();						
		driver.findElement(By.id("user_login")).sendKeys("testing");
		usernameReset = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Reset password']")));
		usernameReset.click();		
	}	
	@AfterClass
	public static void tearDown() {
		driver.close();
		
	}
}



