package TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDropDown {

	public static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.findElement(By.name("country")).sendKeys("Germany");
		WebElement dropdown= driver.findElement(By.id("searchLanguage"));
		Select select= new Select(dropdown);
		//select.selectByVisibleText("Italy");
		select.selectByValue("hi");
		
		List<WebElement> values=driver.findElements(By.tagName("option"));
		System.out.println("Total options in dropdown: "+values.size());
		
		for(int i=0;i<values.size();i++) {
			
			System.out.println(values.get(i).getText());
		}
		
		System.out.println("----------Printing links---------------");
		
		WebElement block= driver.findElement(By.xpath("//*[@id='www-wikipedia-org']/div[10]/div[3]"));
		
		List<WebElement> links= block.findElements(By.tagName("a"));
		
		System.out.println("Total links are: "+links.size());
		
		for(WebElement link: links) {
			
			System.out.println(link.getText()+"----URL : -----"+link.getAttribute("href"));
		}

	}

}
