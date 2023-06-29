package flipkartDemo;

import java.time.Duration;
import org.testng.annotations.*;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class PlaceOrder extends DriverClass {

	@Test(priority = 1)
	public void logIn() {

		WebElement closeLoginTap = driver.findElement(By.xpath("/html/body/div[2]/div/div/button"));
		closeLoginTap.click();
	}

	@Test(priority = 2)
	public void searchKidToys() {

		WebElement toys = driver.findElement(By.name("q"));
		toys.sendKeys("Kids Toys" + Keys.ENTER);
	}

	@Test(priority = 3)
	public void windowHandle() {
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
	}

	@Test(priority = 4)
	public void addItems() {
		WebElement addItems = driver.findElement(By
				.xpath("//*[@id=\'container\']/div/div[2]/div/div/div[1]/div/div[3]/div/div[2]/div[1]/div/button[2]"));
		addItems.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}

	@Test(priority = 5)
	public void placeOrder() {
		// click the placeOrder
		WebElement placeOrder = driver
				.findElement(By.xpath("//*[@id=\'container\']/div/div[2]/div/div/div[1]/div/div[4]/div/form/button"));
		placeOrder.click();

	}

	@Test(priority = 6)
	public void enterPhoneNumber() {
		// Enter Phone Number
		WebElement phoneNumber = driver.findElement(By.xpath(
				"//*[@id=\'container\']/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[1]/input"));
		phoneNumber.click();
		phoneNumber.sendKeys("9003379476");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}

	@Test(priority = 7)
	public void continueButton() {
		// Click the continue button
		WebElement clickContinue = driver.findElement(By.xpath(
				"//*[@id=\'container\']/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[3]/button"));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		clickContinue.click();
	}

	@Test(priority = 8)
	public void backToHome() {
		// close the current window
		driver.close();
	}
}
