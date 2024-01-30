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
	public By link_logout = By.xpath("//p[@class='chakra-text css-q4s4qa']");
	public By link_Canvas = By.xpath("//p[normalize-space()='CanvasToCode']");
	
	//public By canvas_TIC = By.xpath("//div[@class='react-flow__pane']");
	
	// public By link_Canvas = By.xpath(" chakra-ui-light");

	// react flow application

	public By iframe = By.xpath("//iframe[@title='Sandpack Preview']");

	public By logo_reactflow = By.xpath("//p[@class='font-black text-xl leading-none']");
	public By source_elem = By.xpath("//p[@class='font-black text-xl leading-none']");

	public By sourceXPath = By.xpath("//div[normalize-space()='Input Node']");
	public By targetXPath = By.xpath("//div[normalize-space()='Default Node']");

	public By button_Plus = By.xpath("//button[@title='Add Node']//*[name()='svg']");
	public By menu_Agents = By.xpath("//div[@id='nodes-accordian-header-Agents']");
	public By node_AirtableAgent = By.xpath("//span[normalize-space()='Airtable Agent']");
	public By node_AutoGPT = By.xpath("//span[normalize-space()='AutoGPT']");
	public By node_BabyAGI = By.xpath("//span[normalize-space()='BabyAGI']");

	public By node_prompts = By.xpath("//div[@id='nodes-accordian-header-Prompts']");
	public By node_promptTemplate = By.xpath("//span[normalize-space()='Prompt Template']");

	public By node_LLms = By.xpath("//div[@id='nodes-accordian-header-LLMs']");
	public By node_openAI = By.xpath("//span[normalize-space()='OpenAI']");

//	public By node_Service = By.xpath("//div[normalize-space()='Service']");
//	public By node_UIGateway = By.xpath("//div[normalize-space()='UI+Gateway']");
//	public By dragged_ServiceNode = By.xpath("//div[@role='button']//div[contains(text(),'Service')]");
//	
//	public By dragged_UIGatewayNode = By.xpath("//div[@role='button']//div[contains(text(),'UI+Gateway')]");
//	public By dragged_GroupNode = By.xpath("");
//	public By dragged_KeycloakNode = By.xpath("//img[@name='oauth2']");
//	public By keycloakNode= By.className("selectorNode3");
//	public By dragged_PostgreSQL = By.xpath("");
//	public By dragged_MongoDB = By.xpath("");
//	public By dragged_Eureka = By.xpath("");
//	public By dragged_Elastic = By.xpath("");

	
	

	

	public By canvas_Flowise = By.xpath("//div[@class='react-flow__pane']");
	//public By canvas_TIC = By.xpath("//div[@class='react-flow__pane']");

	public By dragged_AirtableAgent = By.xpath(
			"//body/div[@id='root']/div[@class='MuiBox-root css-0']/div[@class='MuiBox-root css-16wq90v']/div[@class='reactflow-parent-wrapper']/div[@class='reactflow-wrapper']/div[@class='react-flow']/div[@class='react-flow__renderer']/div[@class='react-flow__pane']/div[@class='react-flow__viewport react-flow__container']/div[@class='react-flow__nodes']/div[@role='button']/div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0 MuiCard-root css-hlu2r1']/div[1]");
	public By dragged_AutoGPT = By.xpath(
			"//body/div[@id='root']/div[@class='MuiBox-root css-0']/div[@class='MuiBox-root css-16wq90v']/div[@class='reactflow-parent-wrapper']/div[@class='reactflow-wrapper']/div[@class='react-flow']/div[@class='react-flow__renderer']/div[@class='react-flow__pane']/div[@class='react-flow__viewport react-flow__container']/div[@class='react-flow__nodes']/div[@role='button']/div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0 MuiCard-root css-hlu2r1']/div[1]");
	public By dragged_BabyAGI = By.xpath(
			"//body/div[@id='root']/div[@class='MuiBox-root css-0']/div[@class='MuiBox-root css-16wq90v']/div[@class='reactflow-parent-wrapper']/div[@class='reactflow-wrapper']/div[@class='react-flow']/div[@class='react-flow__renderer']/div[@class='react-flow__pane']/div[@class='react-flow__viewport react-flow__container']/div[@class='react-flow__nodes']/div[2]/div[1]/div[1]");

	/*
	 * Method to navigate to Canvas Page
	 *
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */

	public CanvasPage openCanvas() {
		clickOnButton(link_Canvas, "Link Canvas to code");
		return new CanvasPage();

	}

 
	public void performDrangAndDrop_reactflow() {

		switchToIframe(iframe);
		waitForPageLoad(3);
		dragAndDrop(sourceXPath, targetXPath);
		waitForPageLoad(5);

	}

	public void performDrangAndDrop_flowise() {

		clickOnButton(button_Plus);
		waitForPageLoad(2);
		clickOnButton(menu_Agents);
		waitForPageLoad(2);
		dragAndDrop(node_AirtableAgent, canvas_Flowise);
		waitForPageLoad(2);

		clickOnButton(button_Plus);
		waitForPageLoad(2);
//		clickOnButton(menu_Agents);
		dragAndDrop(node_BabyAGI, canvas_Flowise);
		waitForPageLoad(2);

		clickOnButton(dragged_BabyAGI);
//		_moveRight(dragged_BabyAGI, 50);
//
//		clickOnButton(dragged_BabyAGI);
//		_moveDown(dragged_BabyAGI, 50);
		waitForPageLoad(5);

	}


	public void openLoginPage() {
		 
			clickOnButton(link_login, "Login link");
			 
		// TODO Auto-generated method stub
		
	}
}

 