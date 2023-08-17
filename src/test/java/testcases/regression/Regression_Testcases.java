package testcases.regression;

import org.testng.annotations.Test;

import components.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.XML_Operations;

public class Regression_Testcases extends BaseClass {
	// ****************** CLASS INSTANCES ****************************//
	XML_Operations xml_Ops = new XML_Operations();
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	


	// ****************** TEST SCRIPTS ****************************//

	/*
	 * TC_01_LoginWithValidData	 
	 *
	 */

	/*
	 * This is a test case to login to the application with valid data
	 *
	 * Author : Kavitha Thota (kavitha.t@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_01_LoginWithValidData() {

		homePage = launch_TIC_Application();
		homePage = loginPage.login();
		
	}

	

}
