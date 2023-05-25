package flightSearchAutomationPages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class PrintingAvlFlights {
	By CheckingDetailsHyd = By.xpath("//div[@class='right-searchbarbtm-in']//div[2]//span[text()='Hyderabad (HYD)']");
	By CheckingDetailsPune = By.xpath("//div[@class='right-searchbarbtm-in']//div[3]//span[text()='Pune (PNQ)']");
	By CheckingDetailsDate = By.xpath("//a[@tabindex='0']//span[text()='Wed, 24 May']");
	By Flights = By.tagName("div");
	By table = By.xpath("//div[@class='right-searchbarbtm']");
	By FlightNameAirIndia = By.xpath(("//div[@class='right-searchbarbtm-in']//div//div//b[text()='Air India']"));
	By FlightNameVistara = By.xpath("//div[@class='right-searchbarbtm-in']//div//div//b[text()='Vistara']");
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
		List<WebElement> row = tableRow.findElements(Flights);
		System.out.println("number of rows:" + row.size());
		for (WebElement name : row) {
			String flightName = name.findElement(FlightNameAirIndia).getText();
			String flightName2 = name.findElement(FlightNameVistara).getText();
			System.out.println("flight name1:" + flightName);
			System.out.println("flight name2:" + flightName2);
		}
	}
}
