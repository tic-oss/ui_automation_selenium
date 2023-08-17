package components;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;


public class BaseClass extends Operations {

	Properties config;
	FileInputStream fis;
	public static WebDriver driver;
	protected static String tic_url,username, password;
	protected static String headless,browser;
	public static String os;

	/*
	 * This method is to load data from application.properties files
	 * 
	 * Author : kavitha Thota (kavitha.t@comakeit.com)
	 */
	public void loadProperties() throws IOException {

		config = new Properties();
		String fpath = System.getProperty("user.dir") + "//src//test//resources//application.properties";
		fis = new FileInputStream(fpath);

		config.load(fis);
		// OD Configurations
		tic_url = config.getProperty("tic_url");
		username = config.getProperty("username");
		password = config.getProperty("password");

		// Browser Configurations
		browser = config.getProperty("browser");
		headless = config.getProperty("headless");
		os = config.getProperty("os");
			
	}

	/*
	 * This method is to launch the browser
	 * 
	 * @BeforeMethod : annotation to invoke before the execution of each test method
	 * 
	 * Author : kavitha Thota (kavitha.t@comakeit.com)
	 */
	@BeforeMethod(alwaysRun = true)
	public void launchBrowser(Method testMethod) throws InterruptedException, IOException {

		loadProperties();

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			// System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			ChromeOptions ch_options = new ChromeOptions();

			if (Boolean.parseBoolean(headless))
				ch_options.addArguments("--headless");

			ch_options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(ch_options);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions ff_options = new FirefoxOptions();

			if (Boolean.parseBoolean(headless))
				ff_options.addArguments("--headless");
			ff_options.addArguments("--remote-allow-origins=*");
			driver = new FirefoxDriver(ff_options);

			break;
		default:
			WebDriverManager.edgedriver().setup();
			EdgeOptions ed_options = new EdgeOptions();
			if (Boolean.parseBoolean(headless))
				ed_options.addArguments("--headless");

			ed_options.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(ed_options);
			break;

		}
		driver.manage().window().maximize();

		test = report.startTest(getTestCaseName(testMethod));
		report.addSystemInfo("Browser", browser);
		waitForPageLoad(1);

	}

	/*
	 * Usage: to get the test case name to include in the reports
	 * 
	 * Author : kavitha Thota (kavitha.t@comakeit.com)
	 */
	public String getTestCaseName(Method testMethod) {

		String name = testMethod.getDeclaringClass().getTypeName();
		String className = name.substring(name.lastIndexOf(".") + 1);

		return "<span style='color:#d64161;'>" + className + " : </span> " + "<span style='color:#4040a1;'>"
				+ testMethod.getName() + " : </span> ";
	}

	/*
	 * Usage : To get the current timestamp
	 * 
	 * Author : kavitha Thota (kavitha.t@comakeit.com)
	 */
	public String getTimestamp() {
		return new SimpleDateFormat("HHmmss").format(new Date());
	}

	

	/*
	 * Usage : To launch TextPay application
	 * 
	 * Author : kavitha Thota (kavitha.t@comakeit.com)
	 */
	public HomePage launch_TIC_Application() {
		driver.get(tic_url);
		HomePage homePage = new HomePage();
		waitForElementTobeDisplayed(homePage.link_login);
		if (isElementDisplayed(homePage.link_login))
			passStep("Launched the TIC application <b>" + tic_url + "</b>");
		return homePage;
	}

	/*
	 * Usage : This method is to quit the browser
	 * 
	 * @AfterMethod : annotation to invoke after the execution of each test method
	 * 
	 * Author : kavitha Thota (kavitha.t@comakeit.com)
	 */
	@AfterMethod(alwaysRun = true)
	public void quitBrowser() {
		driver.close();
		driver.quit();
	}

	/*
	 * Usage : This method is to get the screenshots of the web page
	 * 
	 * Author : kavitha Thota (kavitha.t@comakeit.com)
	 */
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String d = dateFormat.format(date).toString();

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("HHmmss").format(new Date());
		String screenshot = "Failure_" + timeStamp;
		String destination = "";
		//if(os.equalsIgnoreCase("windows"))
			destination = System.getProperty("user.dir") + "//TestResults//" + d + "//" + screenshot + ".png";
		//else
			//destination = System.getProperty("user.dir") + "\\TestResults\\" + d + "\\" + screenshot + ".png";

		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	/*
	 * Usage : This method is to quit the browser
	 * 
	 * @AfterMethod : annotation to invoke after the execution of each test method
	 * 
	 * Author : kavitha Thota (kavitha.t@comakeit.com)
	 */
	@AfterMethod(alwaysRun = true)
	public void getResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			stepInfo("<i>__Failed due to below exception__ :</i> ");
			failStep(result.getThrowable().toString());
			String screenshotPath = BaseClass.getScreenshot(driver, result.getName());

			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));

		}
	}



	/*
	 * Usage : To generate random number
	 *
	 * Author : Kavitha  (Kavitha.t@comakeit.com)
	 */
	public String getRandomNumber() {
		Random random = new Random();
		return String.format("%02d", random.nextInt(100));
	}

	

}
