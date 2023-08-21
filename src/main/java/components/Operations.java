package components;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.Extent_Reports;

public class Operations extends Extent_Reports {

	/*
	 * This method is to enter text into TEXTBOX
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void enterText(By ele, String text, String field) {
		waitForElementTobeDisplayed(ele);
		waitForElementTobeClickable(ele);

		WebElement element = BaseClass.driver.findElement(ele);
		if (isElementDisplayed(ele) && element.isEnabled()) {
			highlightElement(element);
			element.clear();
			element.sendKeys(text);
			waitForPageLoad(1);
			passStep("Entered '" + text + "' into " + field);
		}
	}

	public void clearText(By ele) {
		waitForElementTobeDisplayed(ele);
		waitForElementTobeClickable(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		if (isElementDisplayed(ele) && element.isEnabled()) {
			highlightElement(element);
			element.clear();

		}
	}

	/*
	 * This method is to enter text into TEXTBOX using JSE
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void enterText_with_JSE(By ele, String text, String field) {
		waitForElementTobeDisplayed(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		if (isElementDisplayed(ele) && element.isEnabled()) {
			highlightElement(element);

			JavascriptExecutor jse = (JavascriptExecutor) BaseClass.driver;

			jse.executeScript("arguments[0].value='" + text + "';", element);

			// jse.executeScript("document.getElementById('pass').value = 'mukeshotwani';");
			element.clear();
			element.sendKeys(text);
			waitForPageLoad(1);
			passStep("Entered '" + text + "' into " + field);
		}
	}

	/*
	 * This method is to enter text into TEXTBOX but won't include in the report
	 * 
	 * Ex: username, password
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void enterText(By ele, String text) {
		waitForElementTobeDisplayed(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		if (isElementDisplayed(ele) && element.isEnabled()) {
			highlightElement(element);
			element.clear();
			element.sendKeys(text);
			waitForPageLoad(1);
			// passStep("Entered '" + text + "' into " + field);
		}
	}

	/*
	 * This method is to click on BUTTON
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void clickOnButton(By ele, String field) {
		waitForElementTobeDisplayed(ele);
		waitForElementTobeClickable(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		if (isElementDisplayed(ele) && element.isEnabled()) {
			highlightElement(element);
			element.click();
			passStep("Clicked on " + field);
			logger.info("Clicked on " + field);
			waitForPageLoad(1);
		}

	}

	/*
	 * This method is to click on BUTTON
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void clickOnButton(By ele) {
		waitForElementTobeDisplayed(ele);
		waitForElementTobeClickable(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		if (isElementDisplayed(ele) && element.isEnabled()) {
			highlightElement(element);
			element.click();
			waitForPageLoad(1);
		}

	}

	/*
	 * This method is to click on BUTTON
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void clickOnButton_using_Actions(By ele, String field) {
		waitForElementTobeDisplayed(ele);
		waitForElementTobeClickable(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		waitForPageLoad(1);
		if (isElementDisplayed(ele) && element.isEnabled()) {
			highlightElement(element);
			Actions act = new Actions(BaseClass.driver);
			act.moveToElement(BaseClass.driver.findElement(ele)).click().perform();
			// element.click();
			passStep("Clicked on " + field);
			waitForPageLoad(1);
		}

	}

	/*
	 * This method is to click on BUTTON
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void clickOnButton_using_JSE(By ele, String field) {

		// waitForElementTobeDisplayed(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		waitForPageLoad(1);
		if (isElementDisplayed(ele) && element.isEnabled()) {
			highlightElement(element);
			JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
			js.executeScript("arguments[0].click();", BaseClass.driver.findElement(ele));
			passStep("Clicked on " + field);
			waitForPageLoad(2);
		}

	}

	/*
	 * This method is to verify whether the element is DISPLAYED or NOT and will
	 * include in the report
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public Boolean isElementDisplayed(By ele, String field) {
		WebElement element = BaseClass.driver.findElement(ele);
		waitForElementTobeDisplayed(ele);
		if (element.isDisplayed()) {
			passStep("'" + field + "' is displayed");
			return true;
		}
		return false;
	}

	/*
	 * This method is to verify whether the element is ENABLED or NOT and will
	 * include in the report
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public Boolean isElementEnabled(By ele, String field) {
		WebElement element = BaseClass.driver.findElement(ele);
		waitForElementTobeDisplayed(ele);
		if (element.isEnabled()) {
			passStep("'" + field + "' is enabled");
			return true;
		}
		return false;
	}

	/*
	 * This method is to verify whether the element is DISPLAYED or NOT
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public Boolean isElementDisplayed(By element) {
		WebElement ele = BaseClass.driver.findElement(element);
		highlightElement(ele);
		return ele.isDisplayed();

	}

	/*
	 * This method is to verify whether the element is ENABLED or NOT
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public Boolean isElementEnabled(By element) {
		return BaseClass.driver.findElement(element).isEnabled();

	}

	/*
	 * This method is to select RADIO BUTTON
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void select_Radiobutton(By ele, String field) {
		waitForElementTobeDisplayed(ele);
		waitForElementTobeClickable(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		if (isElementDisplayed(ele, field) && element.isEnabled()) {
			highlightElement(element);
			if (element.isSelected()) {
				passStep(field + " is already selected");
			} else {
				element.click();
				passStep(field + " is selected");
			}
		}
	}

	/*
	 * This method is to select CHECKBOX
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void select_Checkbox(By ele, String field) {
		waitForElementTobeDisplayed(ele);
		waitForElementTobeClickable(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		if (isElementDisplayed(ele, field) && element.isEnabled()) {
			highlightElement(element);
			if (element.isSelected()) {
				passStep(field + " is already selected");
			} else {
				element.click();
				passStep(field + " is selected");
			}
		}
	}

	/*
	 * This method is to UNselect CHECKBOX
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void unselect_Checkbox(By ele, String field) {
		waitForElementTobeDisplayed(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		if (isElementDisplayed(ele, field) && element.isEnabled()) {
			highlightElement(element);
			if (element.isSelected()) {
				element.click();
				passStep(field + " is unselected");
			} else {
				passStep(field + " is already uselected");
			}
		}
	}

	public boolean isCheckBoxChecked(By ele) {
		waitForElementTobeDisplayed(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		if (isElementDisplayed(ele) && element.isEnabled()) {
			highlightElement(element);
			if (element.isSelected()) {
				return true;

			}
		}
		return false;
	}

	/*
	 * This method is to select DROPDOWN based on the text
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void selectDropdown(By ele, String text, String field) {
		waitForElementTobeDisplayed(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		if (element.isDisplayed() && element.isEnabled()) {
			highlightElement(element);
			Select dropdown = new Select(element);
			dropdown.selectByVisibleText(text);
			passStep("Selected '" + text + "' from '" + field + "'");
		}
	}

	/*
	 * This method is to HIGHLIGHT the webelement
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public static void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
		js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid #B8F866;');", element);
	}

	/*
	 * Usage :Explicit wait for the element to be displayed
	 * 
	 * Author : Kavitha Thota (Kavitha.t@comakeit.com)
	 */
	public void waitForElementTobeDisplayed(By locator) {
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/*
	 * Usage :Explicit wait for the element to be clickable
	 * 
	 * Author : Kavitha Thota (Kavitha.t@comakeit.com)
	 */
	public void waitForElementTobeClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/*
	 * Usage : Force wait to hold the execution for the given specific time period
	 * 
	 * Author : Kavitha Thota (Kavitha.t@comakeit.com)
	 */
	public void waitForPageLoad(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Usage : To get the value of the element (Ex: Button name)
	 * 
	 * Author : Kavitha Thota (Kavitha.t@comakeit.com)
	 */
	public String getElementValue(By ele) {
		return BaseClass.driver.findElement(ele).getAttribute("value");
	}

	/*
	 * Usage : To get the value of the element (Ex: Text)
	 * 
	 * Author : Kavitha Thota (Kavitha.t@comakeit.com)
	 */
	public String getElementText(By ele) {
		return BaseClass.driver.findElement(ele).getText();
	}

	/*
	 * This method is to select the search result on the search box
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void selectFromSearch(By ele, String text, String field) {
		waitForElementTobeDisplayed(ele);
		WebElement element = BaseClass.driver.findElement(ele);
		if (isElementDisplayed(ele) && element.isEnabled()) {
			highlightElement(element);
			// element.clear();
			element.sendKeys(text);
			element.sendKeys(Keys.ARROW_DOWN);
			waitForPageLoad(1);
			element.sendKeys(Keys.ENTER);
			passStep("Selected  '" + text + "' on the " + field);
		}
	}

	/*
	 * This method is to select the dynamic value on the dropdown
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void select_FromDropDown(String text) {
		By value = By.xpath(".//li[@data-value='" + text + "']");
		clickOnButton(value, text);
	}

	/*
	 * This method is to move to the specific element
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void moveToElement(By ele) {
		WebElement element = BaseClass.driver.findElement(ele);
		Actions actions = new Actions(BaseClass.driver);
		actions.moveToElement(element);
	}

	/*
	 * This method is to accept the windows alert
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void acceptAlert() {
		BaseClass.driver.switchTo().alert().accept();
	}

	/*
	 * This method is to click an element but not include in the report
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void performClick(By ele) {
		WebElement element = BaseClass.driver.findElement(ele);
		element.click();
	}

	/*
	 * This method is to hit the enter key
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void hitEnter(By ele) {
		WebElement element = BaseClass.driver.findElement(ele);
		element.sendKeys(Keys.ENTER);
	}

	/*
	 * This method is click based on x,y coordinates
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void clickWithPoints(By ele) {
		WebElement element = BaseClass.driver.findElement(ele);
		// Used points class to get x and y coordinates of element.
		Point point = element.getLocation();
		int xcord = point.getX();
		int ycord = point.getY();

		// Using Actions class
		Actions action = new Actions(BaseClass.driver);

		// clicking on the element based on x coordinate and y coordinate
		action.moveToElement(element, xcord, ycord).click().build().perform();
	}

	/*
	 * This method is used to open new tab
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void openNewTab(String url) {
		// BaseClass.driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +
		// "t");
		BaseClass.driver.switchTo().newWindow(WindowType.TAB);
		BaseClass.driver.get(url);
	}

	/*
	 * This method is used get all open tabs(windows)
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public ArrayList<String> getAllTabs() {
		return new ArrayList<String>(BaseClass.driver.getWindowHandles());
	}

	/*
	 * This method is used switch to the specific tab
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void switch_to_Tab(ArrayList<String> tabs, int number) {
		BaseClass.driver.switchTo().window(tabs.get(number));
	}

	/*
	 * This method is used close the specific tab
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void close_Tab(ArrayList<String> tabs, int number) {
		BaseClass.driver.switchTo().window(tabs.get(number)).close();
	}

	/*
	 * This method is used to the refresh the tab
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void refresh_Page() {
		BaseClass.driver.navigate().refresh();
	}

	/*
	 * This method is used to the go back to the previous page
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void gotoBackPage() {
		BaseClass.driver.navigate().back();
	}

	/*
	 * This method is used to the switch iFrame
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void switchToIframe(By ele) {
		WebElement iframe = BaseClass.driver.findElement(ele);
		BaseClass.driver.switchTo().frame(iframe);
	}

	/*
	 * This method is used to choose time on timebar
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void changeTimeBar(String id, String time) {
		JavascriptExecutor jse = (JavascriptExecutor) BaseClass.driver;

		// jse.executeScript("arguments[0].value='" + time + "';", element);
		jse.executeScript("document.getElementById('" + id + "').value='" + time + "'");
	}

	public void scrollToElement(By ele) {

		WebElement element = BaseClass.driver.findElement(ele);

		JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", element);
		passStep("Scrolled down to  " + element.getText());
	}

	public void getMonthName() {
		// Get the current date
		LocalDate currentDate = LocalDate.now();

		// Get the month from the current date
		Month currentMonth = currentDate.getMonth();

		// Get the integer representation of the month (1 to 12)
		int monthValue = currentMonth.getValue();

		// Get the month name (full name or abbreviated name)
		String fullMonthName = currentMonth.getDisplayName(TextStyle.FULL, Locale.getDefault());
		String abbreviatedMonthName = currentMonth.getDisplayName(TextStyle.SHORT, Locale.getDefault());

		System.out.println("Current month (1 to 12): " + monthValue);
		System.out.println("Full month name: " + fullMonthName);
		System.out.println("Abbreviated month name: " + abbreviatedMonthName);

	}

	public void dragAndDrop(By source, By destination) {

		WebElement sourceElement = BaseClass.driver.findElement(source);
		highlightElement(sourceElement);

		// Find the target element where the source element will be dropped
		WebElement targetElement = BaseClass.driver.findElement(destination);
		highlightElement(targetElement);

		// Create Actions object
		Actions actions = new Actions(BaseClass.driver);
		// Perform drag and drop
		actions.clickAndHold(sourceElement).moveToElement(targetElement).release().build().perform();

	}

	public void draganddropwithJSE(By source, By destination) {

		WebElement sourceElement = BaseClass.driver.findElement(source);
		WebElement targetElement = BaseClass.driver.findElement(destination);

		JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;

		String jsScript = "function createEvent(typeOfEvent) {\n"
				+ "    var event = document.createEvent(\"CustomEvent\");\n"
				+ "    event.initCustomEvent(typeOfEvent, true, true, null);\n" + "    event.dataTransfer = {\n"
				+ "        data: {},\n" + "        setData: function (key, value) {\n"
				+ "            this.data[key] = value;\n" + "        },\n" + "        getData: function (key) {\n"
				+ "            return this.data[key];\n" + "        }\n" + "    };\n" + "    return event;\n" + "}\n"
				+ "\n" + "function dispatchEvent(element, event, transferData) {\n"
				+ "    if (transferData !== undefined) {\n" + "        event.dataTransfer = transferData;\n" + "    }\n"
				+ "    if (element.dispatchEvent) {\n" + "        element.dispatchEvent(event);\n"
				+ "    } else if (element.fireEvent) {\n" + "        element.fireEvent(\"on\" + event.type, event);\n"
				+ "    }\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, target) {\n"
				+ "    var dragStartEvent = createEvent('dragstart');\n"
				+ "    dispatchEvent(element, dragStartEvent);\n" + "    var dropEvent = createEvent('drop');\n"
				+ "    dispatchEvent(target, dropEvent, dragStartEvent.dataTransfer);\n"
				+ "    var dragEndEvent = createEvent('dragend');\n"
				+ "    dispatchEvent(element, dragEndEvent, dropEvent.dataTransfer);\n" + "}\n" + "\n"
				+ "var sourceElement = arguments[0];\n" + "var targetElement = arguments[1];\n"
				+ "simulateHTML5DragAndDrop(sourceElement, targetElement);";
		js.executeScript(jsScript, sourceElement, targetElement);

		// js.executeScript(jsScript, sourceElement, targetElement, 100, 150);
		waitForPageLoad(2);
	}

	public void doubleClick(By ele) {
		WebElement element = BaseClass.driver.findElement(ele);

		Actions actions = new Actions(BaseClass.driver);
		actions.doubleClick(element).perform();
		waitForPageLoad(2);
	}

	public void ddAC(By source, By destination) {
		WebElement a = BaseClass.driver.findElement(source);
		WebElement b = BaseClass.driver.findElement(destination);

		 // Create Actions object
        Actions actions = new Actions(BaseClass.driver);

        // Perform drag and drop using JavaScript
        String script = "function createEvent(typeOfEvent) {"
                        + "var event = document.createEvent(\"CustomEvent\");"
                        + "event.initCustomEvent(typeOfEvent, true, true, null);"
                        + "event.dataTransfer = { data: {}, setData: function (key, value) { this.data[key] = value; }, getData: function (key) { return this.data[key]; } };"
                        + "return event;"
                        + "} "
                        + "function dispatchEvent(element, event, transferData) {"
                        + "if (transferData !== undefined) {"
                        + "event.dataTransfer = transferData;"
                        + "}"
                        + "if (element.dispatchEvent) {"
                        + "element.dispatchEvent(event);"
                        + "} else if (element.fireEvent) {"
                        + "element.fireEvent(\"on\" + event.type, event);"
                        + "}"
                        + "}"
                        + "function simulateDragAndDrop(sourceElement, targetElement) {"
                        + "var dragStartEvent = createEvent('dragstart');"
                        + "dispatchEvent(sourceElement, dragStartEvent);"
                        + "var dropEvent = createEvent('drop');"
                        + "dispatchEvent(targetElement, dropEvent, dragStartEvent.dataTransfer);"
                        + "var dragEndEvent = createEvent('dragend');"
                        + "dispatchEvent(sourceElement, dragEndEvent, dropEvent.dataTransfer);"
                        + "}"
                        + "simulateDragAndDrop(arguments[0], arguments[1]);";

        ((JavascriptExecutor) BaseClass.driver).executeScript(script, a, b);

        // Perform the drag and drop action
        actions.dragAndDrop(a, b).perform();
	}

	public void moveRight(By ele, By destination) {
		WebElement a = BaseClass.driver.findElement(ele);
		WebElement b = BaseClass.driver.findElement(destination);

		Actions actions = new Actions(BaseClass.driver);
		actions.moveToElement(b).release().build().perform();
	}

	public void _moveRight(By ele, By destination) {
		WebElement a = BaseClass.driver.findElement(ele);
		WebElement b = BaseClass.driver.findElement(destination);

		Actions actions = new Actions(BaseClass.driver);
		actions.click(a).sendKeys(Keys.ARROW_RIGHT).perform();
	}

	public void _moveDown(By ele) {
		WebElement a = BaseClass.driver.findElement(ele);

		Actions actions = new Actions(BaseClass.driver);
		actions.click(a).sendKeys(Keys.ARROW_DOWN).perform();
	}

	public void _moveLeft(By ele) {
		WebElement a = BaseClass.driver.findElement(ele);

		highlightElement(a);

		Actions actions = new Actions(BaseClass.driver);
		actions.clickAndHold(a).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT)
				.sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT)
				.sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT)
				.sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT)
				.sendKeys(Keys.ARROW_LEFT).perform();
	}

	public void drdp(By canv, By src) {
		// Locate canvas element
		WebElement canvas = BaseClass.driver.findElement(canv);
		highlightElement(canvas);

		WebElement a = BaseClass.driver.findElement(src);
		highlightElement(a);

		// a.getSize().getWidth()
		// Get canvas size
		int canvasWidth = canvas.getSize().getWidth();
		int canvasHeight = canvas.getSize().getHeight();

		// Calculate source and target coordinates
		int sourceX = a.getSize().getWidth(); // Adjust as needed
		int sourceY = a.getSize().getWidth(); // Adjust as needed
		int targetX = canvasWidth / 2; // Adjust as needed
		int targetY = canvasHeight /2; // Adjust as needed

		// Create Actions object
		Actions actions = new Actions(BaseClass.driver);

		// Perform drag and drop using mouse movements
		actions.clickAndHold(a).moveToElement(canvas,targetX-sourceX, targetY-sourceY).release().build().perform();

		// Wait for a moment (optional)
		waitForPageLoad(2);
		;
	}

	public void lc(By source, By canv) {
		WebElement sourceElement = BaseClass.driver.findElement(source);
		WebElement canvas = BaseClass.driver.findElement(canv);

		 // Calculate source and target element positions
        int sourceX = sourceElement.getLocation().getX() + sourceElement.getSize().getWidth() / 2;
        int sourceY = sourceElement.getLocation().getY() + sourceElement.getSize().getHeight() / 2;
        int targetX = canvas.getLocation().getX() + canvas.getSize().getWidth() / 2;
        int targetY = canvas.getLocation().getY() + canvas.getSize().getHeight() / 2;

        // Use JavaScript to simulate drag and drop
        JavascriptExecutor jsExecutor = (JavascriptExecutor) BaseClass.driver;
        String dragAndDropScript = "function createEvent(type) {\n" +
                "  var event = document.createEvent('MouseEvent');\n" +
                "  event.initMouseEvent(type, true, true, window, 0, 0, 0, %d, %d, false, false, false, false, 0, null);\n" +
                "  return event;\n" +
                "}\n" +
                "var source = arguments[0];\n" +
                "var target = arguments[1];\n" +
                "source.dispatchEvent(createEvent('mousedown'));\n" +
                "setTimeout(function() {\n" +
                "  source.dispatchEvent(createEvent('mousemove'));\n" +
                "  target.dispatchEvent(createEvent('mousemove'));\n" +
                "  target.dispatchEvent(createEvent('mouseup'));\n" +
                "}, 100);\n";

        String formattedScript = String.format(dragAndDropScript, sourceX, sourceY, targetX, targetY);
        jsExecutor.executeScript(formattedScript, sourceElement, canvas);


	}

}
