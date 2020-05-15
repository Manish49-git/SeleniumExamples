package SeleniumExamples;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	public static void main(String[] args) {
		 WebDriver driver;
			
		 System.setProperty("webdriver.chrome.driver","F:\\ChromeDriver\\chromedriver.exe");
			
		 driver = new ChromeDriver();
			 
		 driver.manage().deleteAllCookies();
		 driver.get("https://www.google.com/");

		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 	 
		 driver.findElement(By.name("q")).sendKeys("Software Testing jobs in edmonton");
		 
		 List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));

		 System.out.println(list.size());
		 
		 for (int i = 0;i<= list.size();i++)
		 {
			 System.out.println(list.get(i).getText());
			 if(list.get(i).getText().contains("software tester jobs in edmonton"))
					 {
				 list.get(i).click();
				 break;}
		 }
	}

}
