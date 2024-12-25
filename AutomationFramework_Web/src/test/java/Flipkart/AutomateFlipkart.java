package Flipkart;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AutomateFlipkart {
	
	WebDriver driver = null;
	@Test
	public void launch() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Browser.....");
		String browser = s.nextLine();
		
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.flipkart.com/");

	}
	
	@Test(dependsOnMethods = "launch")
	public void searchProduct() {
		driver.findElement(By.name("q")).sendKeys("books");
		driver.findElement(By.xpath("//*[local-name()='svg']/ancestor::button")).click();
	}
}
