package flipkartDemo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class DriverClass {

	protected WebDriver driver;

	@BeforeSuite
	public void loadDriver() {
		long startTime = System.currentTimeMillis();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + totalTime);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	}
}
