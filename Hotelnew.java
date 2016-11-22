package dhtml1;

import java.awt.AWTException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Hotelnew extends wait {

	@Test
	public void hoteldeals() {
		// getDriver().manage().window().maximize();
		webDriverFluentWait(By.xpath(".//*[@class='trigger']")).click();
		webDriverFluentWait(By.xpath(".//*[@id='hdr-deals']")).click();

		webDriverFluentWait(By.xpath(".//*[@id='qf-1q-destination']")).sendKeys("London");

		webDriverFluentWait(By.xpath(".//*[@id='citysqm-asi0-s0']/td/div[2]")).click();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yy");
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime then = now.plusDays(7);

		webDriverFluentWait(By.id("qf-1q-localised-check-in")).sendKeys(now.format(format));

		webDriverFluentWait(By.id("qf-1q-localised-check-out")).clear();
		webDriverFluentWait(By.id("qf-1q-localised-check-out")).sendKeys(then.format(format));
		Select dropdown = new Select(getDriver().findElement(By.id("qf-1q-rooms")));
		dropdown.selectByVisibleText("2");
		Select dropdown1 = new Select(webDriverFluentWait(By.id("qf-1q-room-0-children")));
		dropdown1.selectByVisibleText("1");
		Select dropdown11 = new Select(webDriverFluentWait(By.id("qf-1q-room-0-child-0-age")));
		dropdown11.selectByVisibleText("2");
		Select dropdown2 = new Select(webDriverFluentWait(By.id("qf-1q-room-1-adults")));
		dropdown2.selectByVisibleText("4");
		webDriverFluentWait(By.xpath(".//*[@class='cta cta-strong' and text()='Search']")).click();

		WebElement source = webDriverFluentWait(By.xpath(".//*[@id='filter-price']/div[2]/div/div[2]/div[3]"));
		WebElement target = webDriverFluentWait(By.xpath(".//*[@id='filter-price']/div[2]/div/div[2]/div[2]"));
		Actions action = new Actions(getDriver());
		action.dragAndDrop(source, target);
		action.dragAndDropBy(source, 62, 0).release().build().perform();
		String actual = getDriver()
				.findElement(By.xpath(".//*[@id='listings']/ol/li[1]/article/div/div[3]/div[1]/span[2]/ins")).getText();
		String expected = "first hotel price is less then 200";
		Assert.assertEquals(actual, expected);
	}
}
