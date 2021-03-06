package demo1;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class windowHndlingAssign 
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	}
	public static void main(String[] args) 
	{
	 WebDriver driver= new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	 driver.get("https://the-internet.herokuapp.com/");
	 driver.navigate().to("https://the-internet.herokuapp.com/windows");
	 driver.findElement(By.xpath("//a[text()='Click Here']")).click();
	 Set<String> window = driver.getWindowHandles();
	 Iterator<String> it = window.iterator();
	 String PID = it.next();
	 String CID = it.next();
	 driver.switchTo().window(CID);
	 System.out.println(driver.findElement(By.xpath("//h3[text()='New Window']")).getText());
	 driver.switchTo().window(PID);
	 System.out.println(driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText());
	 driver.quit();
	 
	}
}
