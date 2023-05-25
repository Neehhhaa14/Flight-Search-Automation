package flightSearchAutomationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EnteringFlightDetails {
	By Origin = By.id("stationFrom");
	By popup = By.xpath("//button[text()='Later']");
	By Hyderabad = By.xpath("//li[@class='ui-menu-item']//div[text()='Hyderabad (HYD)']");
	By Destination = By.id("stationTo");
	By Pune = By.xpath("//ul[@id='ui-id-2']//li//div[text()='Pune (PNQ)']");
	By Departure = By.id("originDate");
	By Date = By.xpath("//span[@class='act active-red']");
	By Traveller = By.id("noOfpaxEtc");
	By Economy = By.id("travelClass");
	By Search = By.xpath("//button[text()='Search ']");
	WebDriver driver;

	public EnteringFlightDetails(WebDriver driver) {
		this.driver = driver;
	}

	public void ClickOnOrigin(String from) {

		driver.findElement(Origin).sendKeys(from);
		;
	}

	public void ClickOnPopup() {
		driver.findElement(popup).click();
	}

	public void ClickOnHyd() {
		Actions act = new Actions(driver);

		act.sendKeys(driver.findElement(Hyderabad))

				.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_UP).click()

				.build().perform();

	}

	public void ClickOnDestination(String to) {
		driver.findElement(Destination).sendKeys(to);
	}

	public void ClickOnPune() {
		Actions act = new Actions(driver);
		act.sendKeys(driver.findElement(Pune)).keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_UP).click().build().perform();
	}

	public void ClickOnDeparture() {
		driver.findElement(Departure).click();
	}

	public void ClickOnDate() {
		driver.findElement(Date).click();
	}

	public void ClickOnTraveller() {
		driver.findElement(Traveller).click();
	}

	public void ClickOnEconomy() {
		WebElement sortBy = driver.findElement(Economy);
		Select sort = new Select(sortBy);
		sort.selectByIndex(1);
	}

	public void ClickOnSearch() {
		driver.findElement(Search).click();
	}

}