package advanced.selenim.testleaf;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DriverClass {
	
	public WebDriver driver;

	@BeforeMethod
	public void driverLoad() {
		driver = new ChromeDriver();
		driver.get("https://www.leafground.com/input.xhtml;jsessionid=node0ery73s4l1gk218va2101aq5qf148054.node0");
		driver.manage().window().maximize();
	}

}
