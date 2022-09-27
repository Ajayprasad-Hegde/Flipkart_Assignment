package flipcart_Scenarios;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartScenario_2_Test 
{
	@Test
	public void flipKartTest_2() throws InterruptedException, AWTException
	{
		
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
				+ "for products, brands and more']")).sendKeys("redMi");
		driver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[1]"
				+ "/div[1]/div[2]/div[2]/form[1]/div[1]/button[1]/*[1]")).click();
		driver.findElement(By.xpath("//body/div[@id='container']"
				+ "/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]"
				+ "/div[1]/section[7]/div[2]/div[1]/div[2]/div[1]/label[1]/div[2]")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div"
				+ "/div[1]/div[1]/div[1]/a[1]/div[2]/div[1]/div[1]"));
		
			int n = Integer.parseInt(driver.findElement(By.xpath("//body/div[@id='container']/div[1]"
					+ "/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]")).getText().substring(12, 14)); 
		
	
			
		  for(int i = 2;i<=n;i++)
		  {
			  System.out.println(  driver.findElement(By.xpath("/html[1]/body[1]"
			  		+ "/div[1]/div[1]/div[3]/div[1]/div[2]/div["+i+"]"
						+ "/div[1]/div[1]/div[1]/a[1]/div[2]/div[1]/div[1]")).getText());
		  }
		  driver.quit();
		 }

	}

