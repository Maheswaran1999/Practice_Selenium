package advanced.selenim.testleaf;

import java.util.Set;
import org.openqa.selenium.Cookie;
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

	@Test(priority = 2)
	public void addCookies() {
		Cookie add = new Cookie("myCookies", "123456789");
		driver.manage().addCookie(add);
	}

	@Test(priority = 3)
	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
		int finalSize = driver.manage().getCookies().size();
		System.out.println("Afrer delete all cookies, The size is :" + finalSize);
	}
}
