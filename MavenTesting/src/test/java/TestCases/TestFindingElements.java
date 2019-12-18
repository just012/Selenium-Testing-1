package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFindingElements {
	public static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://gmail.com");
		
//		WebElement username=driver.findElement(By.id("identifierId"));
//		username.sendKeys("basumataryjust@gmail.com");
//		
//		WebElement nextbtn=driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span"));
//		nextbtn.click();
		
		driver.findElement(By.id("identifierId")).sendKeys("basumataryjust@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
	}

}
