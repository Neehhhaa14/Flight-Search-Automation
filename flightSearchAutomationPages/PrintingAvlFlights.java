package flightSearchAutomationPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PrintingAvlFlights {
	By CheckingDetailsHyd = By.xpath("//div[@class='right-searchbarbtm-in']//div[2]//span[text()='Hyderabad (HYD)']");
	By CheckingDetailsPune = By.xpath("//div[@class='right-searchbarbtm-in']//div[3]//span[text()='Pune (PNQ)']");
	By CheckingDetailsDate = By.xpath("//a[@tabindex='0']//span[text()='Fri, 26 May']");
	By table = By.xpath("//div[@class='col-12 col-md-9 right-searchbar']");
	By FlightName = By.xpath(("//div[@class='right-searchbarbtm']"));
	By FlightName2 = By.className("right-searchbarbtm-in");
	WebDriver driver;

	public PrintingAvlFlights(WebDriver driver) {
		this.driver = driver;
	}

	public void CheckingDetails() {
		WebElement msg1 = driver.findElement(CheckingDetailsHyd);
		WebElement msg2 = driver.findElement(CheckingDetailsPune);
		WebElement msg3 = driver.findElement(CheckingDetailsDate);
		if (CheckingDetailsHyd.equals(msg1)
				&& (CheckingDetailsPune.equals(msg2) && (CheckingDetailsDate.equals(msg3)))) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}
	}

	public void checkTable() {
		WebElement tableRow = driver.findElement(table);
		List<WebElement> Flight = tableRow.findElements(FlightName);
		System.out.println("number of flights:" + Flight.size());
		for (WebElement name : Flight) {
			String flightName = name.findElement(FlightName2).getText();
			System.out.println("flight name:" + flightName);

		}

	}

}
