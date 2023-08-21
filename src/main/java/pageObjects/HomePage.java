package pageObjects;

import components.BaseClass;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs Home page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Kavitha  (Kavitha.t@comakeit.com)
 */
public class HomePage extends BaseClass {

	// ****************** WEB ELEMENTS ****************************//

	public By link_login = By.xpath("//p[normalize-space()='Login']");
	public By link_Canvas = By.xpath("//p[normalize-space()='CanvasToCode']");
	// public By link_Canvas = By.xpath(" chakra-ui-light");

	/*
	 * Method to navigate to Canvas Page
	 *
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */

	public CanvasPage openCanvas() {
		clickOnButton(link_Canvas, "Link Canvas to code");
		return new CanvasPage();

	}
	
	public LoginPage openLoginPage() {
		clickOnButton(link_login, "Login link");
		return new LoginPage();

	}

}
