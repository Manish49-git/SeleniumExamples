package ImageSVG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SVG {
	
	WebDriver driver;
	
	@BeforeMethod
	public void init()
	{
        System.setProperty("webdriver.chrome.driver","F:\\ChromeDriver\\chromedriver.exe");
		
		 driver = new ChromeDriver();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test
	public void checkForSVGImages()
	{
		
		
		driver.get("https://www.flipkart.com/");
		String text = driver.findElement(By.xpath("//*[name()='svg']//*[local-name()='path' and @class= '_2BhAHa']")).getAttribute("d");
		System.out.println(text);
		
		String path =  driver.findElement(By.xpath("//*[name()='svg']//*[local-name()='path' and @class='_3Zc0XY']")).getAttribute("d");
		System.out.println(path);
		
		boolean basket = driver.findElement(By.xpath("//*[name()='svg']//*[local-name()='path' and @class='_2JpNOH']")).isDisplayed();
	
		Assert.assertEquals(basket, true, "Basket is not displayed");
	}
	
	@Test
	public void checkForSVG3DImages()
	{	
		driver.get("http://debeissat.nicolas.free.fr/svg3d.php");
		driver.switchTo().frame("logo");
		while(true) {
		List<WebElement> elementList = driver.findElements(By.xpath("//*[name()='svg']//*[local-name()='path' and contains(@id,'face')]"));
		
		for(WebElement element : elementList)
		{
			String text = null;
			text = element.getAttribute("d");
			System.out.println(text);
		}
		
		}
	}
		
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
