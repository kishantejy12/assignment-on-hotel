package dhtml1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class feedback extends wait {
	public static void switchToWindow(int index) {
		List<String> ListOfWindows = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(ListOfWindows.get(index));
	}

	@Test
	public void back() {
		webDriverFluentWait(By.xpath(".//*[@class='trigger']")).click();
		webDriverFluentWait(By.xpath(".//*[@id='hdr-feedback']")).click();

		switchToWindow(1);
		// getDriver().manage().window().maximize();
		webDriverFluentWait(By.xpath(".//*[@id='comment-textarea']")).sendKeys("Ashdgcscgh");
		webDriverFluentWait(By.xpath(".//*[@id='row-head']/div[2]/section/div/section[1]/fieldset/div/div[2]/div[1]"))
				.click();

		webDriverFluentWait(By.xpath(".//*[@id='content-1']")).click();
		webDriverFluentWait(By.xpath(".//*[@id='design-1']")).click();
		webDriverFluentWait(By.xpath(".//*[@id='usability-1']")).click();

		Select dropdown = new Select(getDriver().findElement(By.id("4293415")));

		dropdown.selectByVisibleText("Highly likely");

		webDriverFluentWait(By.id("answer_4293414-2")).click();
		webDriverFluentWait(By.id("answer_4293413-1")).click();
		webDriverFluentWait(By.id("email_address")).sendKeys("kishantejy12@gmail.com");

		webDriverFluentWait(By.xpath("html/body/form/footer/div/div/div[1]/input")).click();
		// switchToRootWindowAndCloseCurrentBrowser();

	}

}
