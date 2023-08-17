package testcases.smoke;

import dataModel.*;

import org.testng.annotations.Test;

import components.BaseClass;
import pageObjects.*;
import utils.XML_Operations;

public class Smoke_Testcases extends BaseClass {
	// ****************** CLASS INSTANCES ****************************//
	XML_Operations xml_Ops = new XML_Operations();
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	CanvasPage canvasPage = new CanvasPage();

	// ****************** TEST SCRIPTS ****************************//

	/*
	 * TC_01_LoginWithValidData
	 *
	 */

	/*
	 * This is a test case to register a new user to the application with valid data
	 *
	 * Author : Kavitha Thota (kavitha.t@comakeit.com)
	 */
	@Test(groups = { "smoke" })
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
	@Test(groups = { "smoke" })
	public void TC_02_LoginWithValidData() {

		homePage = launch_TIC_Application();
		homePage = loginPage.login();
		canvasPage = homePage.openCanvas();
		canvasPage.createUI();
		canvasPage.dragtheNode_Authentication();
		canvasPage.saveProject();

	}

	@Test(groups = { "smoke" })
	public void TC_03_createProject() {
		homePage = launch_TIC_Application();
		canvasPage = homePage.openCanvas();
		canvasPage.createUI();
		canvasPage.dragtheNode_Authentication();
		canvasPage.saveProject();

	}

}
