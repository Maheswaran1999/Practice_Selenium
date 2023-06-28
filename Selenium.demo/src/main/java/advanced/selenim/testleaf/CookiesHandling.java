package advanced.selenim.testleaf;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CookiesHandling extends DriverClass {

	@Test(priority = 1)
	public void firstCookiesHandling() {

		Set<Cookie> demo = driver.manage().getCookies();
		System.out.println("The size of the cookies: " + demo.size());

		for (Cookie value : demo) {
			System.out.println(value.getName() + " " + value.getValue());
		}
	}
}
