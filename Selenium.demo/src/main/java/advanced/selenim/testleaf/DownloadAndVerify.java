package advanced.selenim.testleaf;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DownloadAndVerify {
	@Test
	public void demoForDownloadingFile() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/file.xhtml;jsessionid=node0auc805po0w6f4jrbjebjh4fl331606.node0");
		driver.manage().window().maximize();
		WebElement downloadLink = driver.findElement(By.id("j_idt93:j_idt95"));
		downloadLink.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

		File selectFile = new File("C:\\Users\\rajsh\\Downloads");
		File[] allFile = selectFile.listFiles();
		for (File result : allFile) {
			if (result.getName().equals("TestLeaf Logo.png")) {
				System.out.println("File downloded and Found");
				break;
			}
		}

	}
}
