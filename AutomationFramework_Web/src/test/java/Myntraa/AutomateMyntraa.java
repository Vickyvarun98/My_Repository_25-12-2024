package Myntraa;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomateMyntraa {
	@Test
	public void searchProduct() throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.myntra.com/");
		Assert.assertEquals(driver.getTitle(), "Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra");
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("shoes",
				Keys.ENTER);
		WebElement element = driver.findElement(By.xpath("//h3[text()='Campus']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);

		Thread.sleep(2000);
		// driver.quit();
	}

	@Test
	public void getList() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.myntra.com/");
		Assert.assertEquals(driver.getTitle(), "Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra");
//		WebElement element = driver.findElement(By.linkText("Kids"));
		Actions action = new Actions(driver);
//		action.moveToElement(element).perform();
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='desktop-navContent']"));
		System.out.println(elements.size());
		for (WebElement element : elements) {
			String text = element.getText();
			System.out.println(text);
			action.moveToElement(element).perform();
			List<WebElement> dropElements = driver.findElements(By.xpath(
					"//li[@class='desktop-oddColumnContent' or @class='desktop-evenColumnContent desktop-oddColumnContent']"));
			for (WebElement dropElement : dropElements) {
				action.moveToElement(dropElement).perform();
				String droptext = dropElement.getText();
				System.out.println(droptext);
				System.out.println();
			}

		}
		driver.quit();
	}

}
