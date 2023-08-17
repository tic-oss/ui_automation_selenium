package reports;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/*
 * This class is to handle the HTML reports upon the execution
 * 
 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
 */

public class Extent_Reports {

	protected static ExtentTest test;
	public static ExtentReports report;
	
	public static final Logger logger = LogManager.getLogger(Extent_Reports.class);


	/*
	 * This method is to start the HTML report when test cases gets triggered
	 * 
	 * @BeforeSuite : annotation to invoke before the execution of entire suite
	 * 
	 * Author : Kavitha Thota (Kavitha.t@comakeit.com)
	 */
	@BeforeSuite(alwaysRun = true)
	public static void startTest() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String d = dateFormat.format(date).toString();
		String timeStamp = new SimpleDateFormat("HHmmss").format(new Date());
		String reportName = "AutomationReport_" + timeStamp;

		report = new ExtentReports(
				System.getProperty("user.dir") + "//TestResults//" + d + "//" + reportName + ".html");

		report.addSystemInfo("Environment", "QA").addSystemInfo("User Name", "Kavitha Thota (kavitha.t@comakeit.com)");

		// Configure Log4j
		System.setProperty("log4j.configurationFile",
				System.getProperty("user.dir") + " //src//main//java//utils//log4j2.xml");

	}

	/*
	 * This method is to end the HTML report afer test cases gets executed
	 * 
	 * @AfterMethod : annotation to invoke aftwr the execution of entire suite
	 * 
	 * Author : Kavitha Thota (Kavitha.t@comakeit.com)
	 */
	@AfterMethod(alwaysRun = true)
	public static void endTest() {
		report.endTest(test);
		report.flush();
	}

	/*
	 * This method is to include a statement as passed
	 * 
	 * Author : Kavitha Thota (Kavitha.t@comakeit.com)
	 */
	public void passStep(String stepinfo) {
		test.log(LogStatus.PASS, stepinfo);
		logger.info("This is an info log message.");
	}

	/*
	 * This method is to include a statement as failed
	 * 
	 * Author : Kavitha Thota (Kavitha.t@comakeit.com)
	 */
	public void failStep(String stepinfo) {
		test.log(LogStatus.FAIL, stepinfo);
	}

	/*
	 * This method is to include a statement as information
	 * 
	 * Author : Kavitha Thota (Kavitha.t@comakeit.com)
	 */
	public void stepInfo(String stepinfo) {
		test.log(LogStatus.INFO, "<b>" + stepinfo + "</b>");
	}
}
