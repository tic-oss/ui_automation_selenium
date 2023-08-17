package pageObjects;

import components.BaseClass;
import dataModel.Guest;
import dev.failsafe.internal.util.Assert;

import org.openqa.selenium.By;

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
	By button_SignIn = By.id("kc-login");

	By textbox_firstname = By.xpath("//input[@id='firstName']");
	By textbox_lastname = By.xpath("//input[@id='lastName']");
	By textbox_email = By.xpath("//input[@id='email']");
	By textbox_Register_username = By.xpath("//input[@id='username']");
	By textbox_Register_password = By.xpath("//input[@id='password']");
	By textbox_Confirm_passward = By.xpath("//input[@id='password-confirm']");
	By button_Register = By.xpath("//input[@value='Register']");

	// ****************** ACTIONS ****************************//
	/*
	 * Method to navigate to perform spa login
	 *
	 * Author : Kavitha (Kavitha.t@comakeit.com)
	 */
	public HomePage login() {

		clickOnButton(link_login, "Login Link");
		enterText(textbox_Username, BaseClass.username, "Username Text Box");
		enterText(textbox_Password, BaseClass.password, "Password Text Box");
		clickOnButton(button_SignIn, "Submit Sign In ");

		HomePage homepage = new HomePage();
		// waitForElementTobeDisplayed(accountsPage.logo_PP);
		passStep("Logged in successfully !!!");
		return homepage;
	}

	public void Register(Guest newUser) {
		clickOnButton(link_login, "Login Link");
		clickOnButton(link_register, "Register Link");

			String firstName = newUser.getFirstName() + getTimestamp();
	String lastName = newUser.getLastName() + getTimestamp();
		String email = getTimestamp() + newUser.getEmail();

		if (isElementDisplayed(label_register)) {

			passStep("Registration pop up is opened");
			enterText(textbox_firstname, firstName, "FirstName textbox");
			enterText(textbox_lastname, lastName, "LastName textbox");
			enterText(textbox_email, email, "Email textbox");
			enterText(textbox_Register_username, firstName + lastName, "FirstName textbox");
			enterText(textbox_Register_password, email, "Password textbox");
			enterText(textbox_Confirm_passward, email, "Confirm Password textbox");

			clickOnButton(button_Register, getElementText(button_Register) + " button");

		} else
			failStep("Registration pop up is not opened");

	}
}
