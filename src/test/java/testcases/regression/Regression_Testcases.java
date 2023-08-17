package testcases.regression;

import org.testng.annotations.Test;

import components.BaseClass;
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
	public void TC_01_registerNewUser() {
		Guest newUser = (Guest) xml_Ops.getTestData("guest");

		homePage = launch_TIC_Application();
		loginPage.Register(newUser);
		canvasPage = homePage.openCanvas();
		canvasPage.createUI();
		canvasPage.dragtheNode_Authentication();
		canvasPage.saveProject();

	}

	/*
	 * This is a test case to login to the application with valid data
	 *
	 * Author : Kavitha Thota (kavitha.t@comakeit.com)
	 */
	@Test(groups = { "regression" })
	public void TC_02_LoginWithValidData() {

		homePage = launch_TIC_Application();
		homePage = loginPage.login();
		canvasPage = homePage.openCanvas();
		canvasPage.createUI();
		canvasPage.dragtheNode_Authentication();
		canvasPage.saveProject();

	}

	@Test(groups = { "regression" })
	public void Tc_3_Create_UI() {

		homePage = launch_TIC_Application();
		canvasPage = homePage.openCanvas();
		canvasPage.createUI();

	}

	@Test(groups = { "regression" })
	public void TC_4_create_Service() {
		homePage = launch_TIC_Application();
		canvasPage = homePage.openCanvas();
		canvasPage.createService();
	}

	@Test(groups = { "regression" })
	public void TC_5_create_Group() {
		homePage = launch_TIC_Application();
		canvasPage = homePage.openCanvas();
		canvasPage.createGroup();
	}

	@Test(groups = { "regression" })
	public void TC_06_DragtheNode_Authentication() {
		homePage = launch_TIC_Application();
		canvasPage = homePage.openCanvas();
		canvasPage.dragtheNode_Authentication();
	}

	@Test(groups = { "regression" })
	public void TC_07_createProject() {
		homePage = launch_TIC_Application();
		canvasPage = homePage.openCanvas();
		canvasPage.createUI();
		canvasPage.dragtheNode_Authentication();
		canvasPage.saveProject();

	}

	

}
