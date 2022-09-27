package flipcart_Scenarios;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartScenario_1_Test
{
	
	
@Test
public void flipKartTest() throws InterruptedException, AWTException
{
	// Launch browser and enter url
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	driver.get("https://www.flipkart.com/");
	
	
	// Pressing Escape
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_ESCAPE); 
	robot.keyRelease(KeyEvent.VK_ESCAPE);
	 
	
	driver.findElement(By.xpath("//input[@title='Search "
			+ "for products, brands and more']")).sendKeys("winter heater");
	driver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[1]"
			+ "/div[1]/div[2]/div[2]/form[1]/div[1]/button[1]/*[1]")).click();
	String mainWindow = driver.getWindowHandle();
	
	driver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[3]/div[1]"
			+ "/div[2]/div[2]/div[1]/div[1]/div[1]/a[2]")).click();
	
	
	// Switching Window//
	Set<String> allWindows = driver.getWindowHandles();
	for (String s: allWindows)
	{
		if (!s.equals(mainWindow))
		{
			driver.switchTo().window(s);
		}
	}
	
	
	driver.findElement(By.xpath("//body/div[@id='container']"
			+ "/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/button[1]")).click();
	
	String actualresult = driver.findElement(By.xpath
			("//div[contains(text(),'Flipkart')]")).getText();
	
	//Validating
	Assert.assertEquals(actualresult, "Flipkart (1)");
	driver.quit();
}
}
