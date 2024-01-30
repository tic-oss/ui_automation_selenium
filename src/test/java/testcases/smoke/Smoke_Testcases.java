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

//This is a test case to login to the application with Valid data

	@Test(groups = { "regression" })
	public void TC_02_LoginwithValidData() {

		// Steps
		homePage = launch_TIC_Application();
		homePage.openLoginPage();
		loginPage.login(username, password);
		loginPage.verifyLoggedInUserName(username);
	}
	// This is a test case to create project

	@Test(groups = { "regression" })
	public void TC_03_createProject_withLogin() {
		homePage = launch_TIC_Application();
		homePage.openLoginPage();
		loginPage.login(username, password);
		canvasPage = homePage.openCanvas();
		//canvasPage.createUI();
		canvasPage.dragtheNode_Authentication();
		canvasPage.saveProject();

	}
	@Test(groups = { "regression" })
	public void TC_03_createProject() {
		homePage = launch_TIC_Application();
		canvasPage = homePage.openCanvas();
		//canvasPage.createUI();
		canvasPage.dragtheNode_Authentication();
//		canvasPage.moveDraggedKeycloakNodeToLeft();
//		canvasPage.dragtheNode_LogManagement();
//		
//		canvasPage.moveDraggedElasticNodeToDown();
		canvasPage. enterProjectName();

	}

}
