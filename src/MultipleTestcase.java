import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipleTestcase {

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
	public void testOne()throws InterruptedException {
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
		}
	@Test
	public void testTwo()throws InterruptedException {
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id=\"user_login\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"user_login\"]")).sendKeys("test@gmail.com");
		emailReset = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Reset password']")));
		emailReset.click();
		//Thread.sleep(1000);
		testOutputOne();
	}	
	@Test
	public void testThree()throws InterruptedException{
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id=\"user_login\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"user_login\"]")).sendKeys("");
		blankReset = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Reset password']")));
		blankReset.click();		
	}	
	public void testOutputOne() {
		String message = "//*[@id=\"post-2958\"]/div/div[2]/div/div/div/div/p";
		WebElement result = driver.findElement(By.xpath(message));
		
		String actualResult = result.getText();		
		String expectedResult = "The user does not exist. Please try again!";
		System.out.println("actualResult " + actualResult);
		System.out.println("expected result " + expectedResult);
	}	
	@AfterClass
	public static void tearDown() {
		driver.close();
	}
	

}
