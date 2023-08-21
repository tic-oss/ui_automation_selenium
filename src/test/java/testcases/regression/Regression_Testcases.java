package testcases.regression;

import org.testng.annotations.Test;

import components.BaseClass;
import components.Constants;
import dataModel.Guest;
import pageObjects.CanvasPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.XML_Operations;

public class Regression_Testcases extends BaseClass {
	// ****************** CLASS INSTANCES ****************************//
	XML_Operations xml_Ops = new XML_Operations();
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	CanvasPage canvasPage = new CanvasPage();
	

	// ****************** TEST SCRIPTS ****************************//

	/*
	 * This is a test case to register a new user to the application with valid data
	 *
	 * Author : Kavitha Thota (kavitha.t@comakeit.com)
	 */

	@Test(groups = { "regression" })
	public void TC_01_RegisterwithValidData() {

		// Testdata setup
		Guest newUser = (Guest) xml_Ops.getTestData("guest");
		String firstName = newUser.getFirstName() + getTimestamp();
		String lastName = newUser.getLastName() + getTimestamp();
		String email = getTimestamp() + newUser.getEmail();

		// Test data assignment
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setUserName(firstName + lastName);
		newUser.setEmail(email);

		// Steps
		homePage = launch_TIC_Application();
		loginPage.Registration(newUser);
		loginPage.verifyLoggedInUserName(newUser.getUserName());
	}

	/*
	 * This is a test case to register a new user to the application with INvalid
	 * data
	 *
	 * Author : Kavitha Thota (kavitha.t@comakeit.com)
	 */

	@Test(groups = { "regression" })
	public void TC_02_RegisterWithInvalidData() {

		// Testdata setup
		Guest newUser = (Guest) xml_Ops.getTestData("guest");
		String firstName = newUser.getFirstName() + getTimestamp();
		String lastName = newUser.getLastName() + getTimestamp();

		// Test data assignment
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setUserName(firstName + lastName);
		newUser.setEmail("test123");

		homePage = launch_TIC_Application();
		loginPage.Registration(newUser);
		loginPage.verifyErrorMessageForUnsuccessfulRegistation(Constants.INVALID_EMAIL_ERROR);

	}

	/*
	 * This is a test case to Register to the application with Duplicate data
	 *
	 * Author : Kavitha Thota (kavitha.t@comakeit.com)
	 */

	@Test(groups = { "regression" })
	public void TC_03_registerWithDuplicateData() {
		// Testdata setup
		Guest newUser = (Guest) xml_Ops.getTestData("guest");
		String firstName = newUser.getFirstName() + getTimestamp();
		String lastName = newUser.getLastName() + getTimestamp();
		String email = getTimestamp() + newUser.getEmail();

		// Test data assignment
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setUserName(firstName + lastName);
		newUser.setEmail(email);

		// Steps
		homePage = launch_TIC_Application();
		loginPage.Registration(newUser);
		loginPage.verifyLoggedInUserName(newUser.getUserName());
		loginPage.logout();

		loginPage.Registration(newUser);
		loginPage.verifyErrorMessageForUnsuccessfulRegistation(Constants.EMAIL_EXIST_ERROR);

	}
// This is a test case to login to the application with Valid data

	@Test(groups = { "regression" })
	public void TC_04_LoginwithValidData() {

		// Steps
		homePage = launch_TIC_Application();
		homePage.openLoginPage();
		loginPage.login(username, password);
		loginPage.verifyLoggedInUserName(username);
	}

	// This is a test case to login to the application with InValid data

	@Test(groups = { "regression" })
	public void TC_05_LoginWithInValidData() {
		// Steps
		homePage = launch_TIC_Application();
		homePage.openLoginPage();

		stepInfo("Login with invalid username and valid password");
		loginPage.login("abc", password);
		loginPage.verifyErrorMessageForInvalidLogin(Constants.INVALID_USERNAME_OR_PASSWORD_ERROR);

		stepInfo("Login with empty username and valid password");
		loginPage.login("", password);
		loginPage.verifyErrorMessageForInvalidLogin(Constants.INVALID_USERNAME_OR_PASSWORD_ERROR);

		stepInfo("Login with valid username and invalid password");
		loginPage.login(username, "abc");
		loginPage.verifyErrorMessageForInvalidLogin(Constants.INVALID_USERNAME_OR_PASSWORD_ERROR);

		stepInfo("Login with valid username and empty password");
		loginPage.login(username, "");
		loginPage.verifyErrorMessageForInvalidLogin(Constants.INVALID_USERNAME_OR_PASSWORD_ERROR);

		stepInfo("Login with invalid username and invalid password");
		loginPage.login("xyz", "abc");
		loginPage.verifyErrorMessageForInvalidLogin(Constants.INVALID_USERNAME_OR_PASSWORD_ERROR);

		stepInfo("Login with empty username and empty password");
		loginPage.login("", "");
		loginPage.verifyErrorMessageForInvalidLogin(Constants.INVALID_USERNAME_OR_PASSWORD_ERROR);

		stepInfo("Login with valid username and valid password");
		loginPage.login(username, password);
		loginPage.verifyLoggedInUserName(username);
	}
	// This is a test case to create UI

	@Test(groups = { "regression" })
	public void Tc_06_Create_UI() {

		homePage = launch_TIC_Application();
		canvasPage = homePage.openCanvas();
		canvasPage.createUI();

	}
	// This is a test case to create Service

	@Test(groups = { "regression" })
	public void TC_07_create_Service() {
		homePage = launch_TIC_Application();
		canvasPage = homePage.openCanvas();
		canvasPage.createService();
	}
	// This is a test case to create Group

	@Test(groups = { "regression" })
	public void TC_08_create_Group() {
		homePage = launch_TIC_Application();
		canvasPage = homePage.openCanvas();
		canvasPage.createGroup();
	}
	// This is a test case to Drag the Authentication

	@Test(groups = { "regression" })
	public void TC_09_DragtheNode_Authentication() {
		homePage = launch_TIC_Application();
		canvasPage = homePage.openCanvas();
		canvasPage.dragtheNode_Authentication();
	}

	// This is a test case to create project

	@Test(groups = { "regression" })
	public void TC_10_createProject() {
		// Testdata setup
		Guest newUser = (Guest) xml_Ops.getTestData("guest");
		String firstName = newUser.getFirstName() + getTimestamp();
		String lastName = newUser.getLastName() + getTimestamp();
		String email = getTimestamp() + newUser.getEmail();

		// Test data assignment
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setUserName(firstName + lastName);
		newUser.setEmail(email);

		// Steps
		homePage = launch_TIC_Application();
		loginPage.Registration(newUser);

		canvasPage = homePage.openCanvas();
		canvasPage.createUI();
		canvasPage.dragtheNode_Authentication();
		canvasPage.saveProject();

	}

}
