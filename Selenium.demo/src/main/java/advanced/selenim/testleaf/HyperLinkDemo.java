package advanced.selenim.testleaf;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HyperLinkDemo {

	@Test
	public void demoHyperLink() {

		WebDriver driver = new ChromeDriver();

		// driver.get("url); > we couldn't refresh the page
		// navigate().to("url"); > we can refresh the page and forward and backward

		driver.navigate().to("https://www.leafground.com/link.xhtml");
		WebElement dashBoardLink = driver.findElement(By.xpath("//*[@id=\'j_idt87\']/div/div[1]/div[1]/div/div/a"));
		dashBoardLink.click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

		// Backward the page
		driver.navigate().back();

		// Refresh the page
		driver.navigate().refresh();

		// find the URL without click
		WebElement findURL = driver.findElement(By.partialLinkText("Find the URL"));
		String where = findURL.getAttribute("href");
		System.out.println("This link is going to :" + where);

		// Broken?(we have to check the link broken or not?)
	 WebElement broken =
	driver.findElement(By.xpath("//*[@id=\'j_idt87\']/div/div[1]/div[3]/div/div?"));
		 broken.click();
	}
}
