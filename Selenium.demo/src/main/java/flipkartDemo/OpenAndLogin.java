package flipkartDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenAndLogin {
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

		// click particular toys
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		WebElement clickToys = driver.findElement(
				By.xpath("//*[@id=\'container\']/div/div[3]/div[1]/div[2]/div[4]/div/div[2]/div/a[3]/div[2]"));
		clickToys.click();
		
		//click buy-now (another tap)
		
	}
}
