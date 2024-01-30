package pageObjects;

import components.BaseClass;
import dataModel.Guest;

import org.openqa.selenium.By;
import org.testng.Assert;

/*
 * Class which contains the web elements and performs Spa Home page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Kavitha (pavanprasad.v@comakeit.com)
 */
public class LoginPage extends BaseClass {
	// ****************** WEB ELEMENTS ****************************//
	public By link_login = By.xpath("//p[normalize-space()='Login']");
	By link_register = By.xpath("//a[normalize-space()='Register']");
	By label_register = By.id("kc-page-title");
	By textbox_Username = By.id("username");
	By textbox_Password = By.id("password");
	//By button_SignIn = By.id("kc-login");
	By button_SignIn = By.xpath("//input[@id='kc-login']");

	By textbox_firstname = By.xpath("//input[@id='firstName']");
	By textbox_lastname = By.xpath("//input[@id='lastName']");
	By textbox_email = By.xpath("//input[@id='email']");
	By textbox_Register_username = By.xpath("//input[@id='username']");
	By textbox_Register_password = By.xpath("//input[@id='password']");
	By textbox_Confirm_passward = By.xpath("//input[@id='password-confirm']");
	By button_Register = By.xpath("//input[@value='Register']");

	By link_logout = By.xpath("//p[@class='chakra-text css-q4s4qa']");
	By Label_InValidEmail = By.xpath("//span[@id='input-error-email']");
	By Lable_Email_Error = By.xpath("//span[@id='input-error-email']");
	By Text_Invalid_username_or_password = By.xpath("//span[@id='input-error']");
	
	// After login 
	
		public By canvasToCodeMenuButton = By.xpath("//button[@id='menu-button-:r1:']");
		public By canvasToCodeMenuNewButton = By.xpath("//button[@id='menu-list-:r1:-menuitem-:r2:']");
		public By canvasToCodeMenuExistingButton = By.xpath("//button[@id='menu-list-:r1:-menuitem-:r3:']");

	// ****************** ACTIONS ****************************//
	/*
	 * Method to navigate to perform spa login
	 *
	 * Author : Kavitha (Kavitha.t@comakeit.com)
	 */
	public HomePage login(String username, String password) {

		//clickOnButton(link_login, "Login Link");
		enterText(textbox_Username, username, "Username Text Box");
		enterText(textbox_Password, password, "Password Text Box");
		clickOnButton(button_SignIn, "Submit Sign In ");

		HomePage homepage = new HomePage();
		// waitForElementTobeDisplayed(accountsPage.logo_PP);
		passStep("Logged in successfully !!!");
		return homepage;
	}

	public void Registration(Guest newUser) {
		clickOnButton(link_login, "Login Link");
		clickOnButton(link_register, "Register Link");

		if (isElementDisplayed(label_register)) {

			passStep("Registration pop up is opened");
			enterText(textbox_firstname, newUser.getFirstName(), "FirstName textbox");
			enterText(textbox_lastname, newUser.getLastName(), "LastName textbox");
			enterText(textbox_email, newUser.getEmail(), "Email textbox");
			enterText(textbox_Register_username, newUser.getUserName(), "FirstName textbox");
			enterText(textbox_Register_password, newUser.getEmail(), "Password textbox");
			enterText(textbox_Confirm_passward, newUser.getEmail(), "Confirm Password textbox");

			clickOnButton(button_Register, getElementText(button_Register) + " button");

		} else
			failStep("Registration pop up is not opened");

	}

	public void verifyLoggedInUserName(String userName) {

		String actualUN = getElementText(link_logout);
		String expectedUN = "Logout (" + userName.toLowerCase() + ")";

		Assert.assertEquals(actualUN, expectedUN, " Username is displayed wrong");

		if (isElementDisplayed(link_logout))
			passStep("Login/Registration succesful and displayed " + actualUN);
		else
			failStep("Login/Registration failed");

	}

	public void verifyErrorMessageForUnsuccessfulRegistation(String expectedErrorMessage) {

		if (isElementDisplayed(Lable_Email_Error)) {
			passStep("Email validation message is displayed as " + getElementText(Label_InValidEmail));
			Assert.assertEquals(getElementText(Label_InValidEmail), expectedErrorMessage,
					"Email validation message is displayed wrong");
		}

	}

	public void verifyErrorMessageForInvalidLogin(String expectedErrorMessage) {

		if (isElementDisplayed(Text_Invalid_username_or_password)) {
			passStep("Email validation message is displayed as " + getElementText(Text_Invalid_username_or_password));
			Assert.assertEquals(getElementText(Text_Invalid_username_or_password), expectedErrorMessage,
					"Invalid username or password.");
		}
	}
	public HomePage openLoginPage() {
		clickOnButton(link_login, "Login link");
		return new HomePage();

	}

	public LoginPage openCanvasToCodeMenuNewButton() {
		clickOnButton(canvasToCodeMenuButton, "CanvasToCode");
		clickOnButton(canvasToCodeMenuNewButton, " New");

		return new LoginPage();
	}

	public LoginPage openCanvasToCodeMenuExistingButton() {
		clickOnButton(canvasToCodeMenuButton, "CanvasToCode");
		clickOnButton(canvasToCodeMenuExistingButton, " New");

		return new LoginPage();
	}

	
	

	public void logout() {
		clickOnButton(link_logout, "Log out button");
		waitForElementTobeDisplayed(link_login);
	}

}
