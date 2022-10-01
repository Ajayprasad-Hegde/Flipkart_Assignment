package flipcart_Scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip_Scenario_1_Test
{
@Test()
public void scenario_1() throws InterruptedException
{
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	driver.get("https://www.makemytrip.com/");
	
	driver.findElement(By.xpath("//label[@for='fromCity']")).click();
	driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Mumbai");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//ul[@ role='listbox']/li[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Chennai");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//ul[@role='listbox']/li[1]")).click();
	Thread.sleep(2000);
	WebElement date = driver.findElement(By.xpath("//div[@aria-label = \"Mon Oct 03 2022\"]"));
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,300)", "");
	Thread.sleep(2000);
	
	date.click();
	
}
}
