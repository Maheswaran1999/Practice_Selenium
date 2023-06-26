package flipkartDemo;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OrderPlace {
	public static void main(String[] args) throws InterruptedException {
		// Open flipkart
		long startTime = System.currentTimeMillis();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + totalTime);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

		// login flipkart
		WebElement closeLoginTap = driver.findElement(By.xpath("/html/body/div[2]/div/div/button"));
		closeLoginTap.click();

		// search kid Toys
		WebElement toys = driver.findElement(By.name("q"));
		toys.sendKeys("Kids Toys" + Keys.ENTER);

		// click particular toys and operate other windows
		String oldWindow = driver.getWindowHandle();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		WebElement clickToys = driver.findElement(
				By.xpath("//*[@id=\'container\']/div/div[3]/div[1]/div[2]/div[4]/div/div[2]/div/a[3]/div[2]"));
		clickToys.click();

		Set<String> oldAndNewWindow = driver.getWindowHandles();

		for (String newWindows : oldAndNewWindow) {
			driver.switchTo().window(newWindows);
		}

		WebElement addToCart = driver
				.findElement(By.xpath("//*[@id=\'container\']/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button"));
		addToCart.click();

		// change the addItems
		WebElement addItems = driver.findElement(By
				.xpath("//*[@id=\'container\']/div/div[2]/div/div/div[1]/div/div[3]/div/div[2]/div[1]/div/button[2]"));
		addItems.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

		// click the placeOrder
		WebElement placeOrder = driver
				.findElement(By.xpath("//*[@id=\'container\']/div/div[2]/div/div/div[1]/div/div[4]/div/form/button"));
		placeOrder.click();

		// Enter Phone Number
		WebElement phoneNumber = driver.findElement(By.xpath(
				"//*[@id=\'container\']/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[1]/input"));
		phoneNumber.click();
		phoneNumber.sendKeys("9003379476");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

		// Click the continue button
		WebElement clickContinue = driver.findElement(By.xpath(
				"//*[@id=\'container\']/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[3]/button"));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		clickContinue.click();

		// close the current window
		driver.close();

		// chnage the control of the window(child to parent )
		driver.switchTo().defaultContent();
		/*
		 * WebElement prizeDropDown = driver.findElement(By .xpath(
		 * "//*[@id=\'container\']/div/div[3]/div[1]/div[1]/div/div/div/section[2]/div[4]/div[3]/select"
		 * )); prizeDropDown.click();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000)); Select
		 * value = new Select(prizeDropDown); value.selectByIndex(1);
		 */

	}
}
