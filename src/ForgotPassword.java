import static org.junit.Assert.*;
import static org.testng.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class ForgotPassword {

	public static String baseUrl = "http://sethuonline.com/lms/";
	public static String path = "C:\\Users\\roshi\\Documents\\Selenium Folder\\drivers\\chromedriver.exe";
	public static WebDriver driver;
	public static WebDriverWait wait;	
	public static WebElement emailReset;
	public static WebElement loginElement;
	public static WebElement lostElement;
	public static WebElement usernameReset;	
	public static WebElement blankReset;
	public static String username = "testing";
	

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		// redirect to your home page
		driver.get(baseUrl);		
	}
	
	
	
	@Test
	public void testCase()throws InterruptedException {
		wait = new WebDriverWait(driver, 10);
		//Login
		loginElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='thim-widget-login-popup thim-widget-login-popup-base']")));
		loginElement.click();
		//Forgot Password
		lostElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='lost-pass-link']")));
		lostElement.click();
		//Username
		driver.findElement(By.xpath("//*[@id=\"user_login\"]")).sendKeys("testing");
		//Reset Button
		usernameReset = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Reset password']")));
		usernameReset.click();	
		Thread.sleep(1000);
		
		driver.navigate().back();
		
		driver.findElement(By.xpath("//*[@id=\"user_login\"]")).clear();
		
		driver.findElement(By.xpath("//*[@id=\"user_login\"]")).sendKeys("test@gmail.com");
		emailReset = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Reset password']")));
		emailReset.click();
		Thread.sleep(1000);
		
		driver.navigate().back();
		
		driver.findElement(By.xpath("//*[@id=\"user_login\"]")).clear();
		
		driver.findElement(By.xpath("//*[@id=\"user_login\"]")).sendKeys("");
		blankReset = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Reset password']")));
		blankReset.click();
		Thread.sleep(1000);	
		
		}
	
	@AfterClass
	public static void tearDown() {
		driver.close();
	}
	
	
	

		
}
