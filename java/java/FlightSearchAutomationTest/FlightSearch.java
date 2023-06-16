package FlightSearchAutomationTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import flightSearchAutomationPages.EnteringFlightDetails;
import flightSearchAutomationPages.PrintingAvlFlights;
import flightSearchAutomationPages.ReportGen;

@Listeners(ReportGen.class)
public class FlightSearch {
	WebDriver driver;
	EnteringFlightDetails flightDetailsObjects;
	PrintingAvlFlights printingAvlFlightsObject;

	@BeforeTest
	public void launchTheBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NehaKuSingh\\Desktop\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.air.irctc.co.in/");
		String title = driver.getTitle();
		Assert.assertTrue(true, title);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		flightDetailsObjects = new EnteringFlightDetails(driver);
		printingAvlFlightsObject = new PrintingAvlFlights(driver);
	}

	@Test(priority = 2)
	public void clickOnFromStation() throws InterruptedException {
		flightDetailsObjects.ClickOnOrigin("hyd");
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void testPopup() throws InterruptedException {
		flightDetailsObjects.ClickOnPopup();
		Thread.sleep(2000);

	}

	@Test(priority = 3)
	public void testHyd() throws InterruptedException {
		flightDetailsObjects.ClickOnHyd();
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void testDestination() throws InterruptedException {
		flightDetailsObjects.ClickOnDestination("pun");
		Thread.sleep(2000);
	}

	@Test(priority = 5)
	public void testPune() throws InterruptedException {
		flightDetailsObjects.ClickOnPune();
		Thread.sleep(500);
	}

	@Test(priority = 6)
	public void testDeparture() throws InterruptedException {
		flightDetailsObjects.ClickOnDeparture();
		Thread.sleep(2000);

	}

	@Test(priority = 7)
	public void testDate() throws InterruptedException {
		flightDetailsObjects.ClickOnDate();
		Thread.sleep(2000);
	}

	@Test(priority = 8)
	public void testTraveller() throws InterruptedException {
		flightDetailsObjects.ClickOnTraveller();
		Thread.sleep(2000);
	}

	@Test(priority = 9)
	public void testEconomy() throws InterruptedException {
		flightDetailsObjects.ClickOnEconomy();
		Thread.sleep(2000);
	}

	@Test(priority = 10)
	public void testSearch() throws InterruptedException {
		flightDetailsObjects.ClickOnSearch();
		Thread.sleep(2000);
	}

	@Test(priority = 11)
	public void testDetails() throws InterruptedException {
		printingAvlFlightsObject.CheckingDetails();
		Thread.sleep(2000);

	}

	@Test(priority = 12)

	public void displayDetails() throws InterruptedException {
		printingAvlFlightsObject.checkTable();
		Thread.sleep(2000);

	}

	@Test(priority = 13)
	public void captureScreenshot() throws IOException, InterruptedException {
		TakesScreenshot capture = (TakesScreenshot) driver;
		File source = capture.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\NehaKuSingh\\Desktop\\Project\\capture2.png");
		FileUtils.copyFile(source, target);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll (0,  500)");
		Thread.sleep(3000);
		File source1 = capture.getScreenshotAs(OutputType.FILE);
		File target1 = new File("C:\\Users\\NehaKuSingh\\Desktop\\Project\\capture3.png");
		FileUtils.copyFile(source1, target1);
		js.executeScript("window.scroll (0,  1000)");
		Thread.sleep(3000);
		File source2 = capture.getScreenshotAs(OutputType.FILE);
		File target2 = new File("C:\\Users\\NehaKuSingh\\Desktop\\Project\\capture4.png");
		FileUtils.copyFile(source2, target2);

	}

	@AfterTest
	public void closure() {
		// driver.close();
	}

}
