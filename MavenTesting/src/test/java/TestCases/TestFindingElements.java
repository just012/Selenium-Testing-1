package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFindingElements {
	public static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//WebDriverWait wait= new WebDriverWait(driver, 5);
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(10))
			       .pollingEvery(Duration.ofSeconds(2))
			       .withMessage("Time Out after 30 seconds.")
			       .ignoring(NoSuchElementException.class);
		
//		WebElement username=driver.findElement(By.id("identifierId"));
//		username.sendKeys("basumataryjust@gmail.com");
//		
//		WebElement nextbtn=driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span"));
//		nextbtn.click();
		
		//driver.findElement(By.id("identifierId")).sendKeys("basumataryjust@gmail.com");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("identifierId"))).sendKeys("basumataryjust@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
		
		//driver.findElement(By.name("password")).sendKeys("abcdefg");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"))).sendKeys("abcdefg");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span")).click();
		
		//System.out.println(driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]/span")).getText());
		System.out.println(driver.getTitle());
	}

}
