package advanced.selenim.testleaf;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/frame.xhtml");
		driver.manage().window().maximize();

		driver.switchTo().frame(0);
		WebElement clickFrame = driver.findElement(By.id("Click"));
		clickFrame.click();

		String text = driver.findElement(By.id("Click")).getText();
		System.out.println(text);

		driver.switchTo().defaultContent();

		WebElement countFrame = driver.findElement(By.tagName("iframe"));
		Dimension size = countFrame.getSize();
		System.out.println(size);

	}

}
