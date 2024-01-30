package pageObjects;

import components.BaseClass;
import components.Constants;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/*
 * Class which contains the web elements and performs Home page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Kavitha (Kavitha.t@comakeit.com)
 */
public class CanvasPage extends BaseClass {

	// ****************** WEB ELEMENTS ****************************//

	public By canvas = By.xpath("//div[@class='react-flow__pane']");

	// web elements//

	By link_ProjectName = By.xpath("//input[@id='projectName']");

	// ** UI-GATEWAY WEB ELEMENTS **//

	By node_UIGateway = By.xpath("//div[normalize-space()='UI+Gateway']");
	By dragged_UIGatewayNode = By.xpath("//div[@role='button']//div[contains(text(),'UI+Gateway')]");
	By UI_application_Name = By.xpath("//input[@id='applicationName']");
	By UI_client_Framework = By.xpath("//select[@id='clientFramework']");
	By UI_package_Name = By.xpath("//input[@id='packageName']");
	By UI_serverPort = By.xpath("//input[@id='serverPort']");
	By UI_button_Sumbit = By.xpath("//button[normalize-space()='Submit']");
	By button_Save = By.xpath("//button[normalize-space()='Save']");

	// ** service web elements**//

	By node_Service = By.xpath(" //div[@class='dndnode output'][normalize-space()='Service']");
	public By dragged_Service = By.xpath("//div[@role='button']//div[contains(text(),'Service')]");
	By Service_application_Name = By.xpath("//input[@id='applicationName']");
	By Service_client_Framework = By.xpath("  //select[@id='applicationFramework']");
	By Service_package_Name = By.xpath("//input[@id='packagename']");
	By Service_serverPort = By.xpath("//input[@id='serverport']");
	By Service_button_Sumbit = By.xpath("//button[normalize-space()='Submit']");
	// *Group web elements*//
	By node_Group = By.xpath(" (//div[@class='dndnode output'][normalize-space()='Group'])[1]");
	By dragged_Group = By.xpath("  //div[@role='button']//div[contains(text(),'Group')]");
	By Group_groupname = By.xpath("  //input[@id='groupName']");
	By Group_button_Sumbit = By.xpath("//button[normalize-space()='Submit']");

	// *Nodes*//

	By link_Authentication = By.xpath("//h1[1]");
	By Keycloak = By.xpath("//img[@alt='keycloaklogo']");
	// By dragged_Keycloak = By.xpath("//img[@name='oauth2']");
	By link_Database = By.xpath(" //h1[2]");
	By postgreSQL = By.xpath("//img[@alt='postgreslogo']");
	By MongoDB = By.xpath(" //img[@alt='mongologo']");
	// By keycloakNode= By.className("selectorNode3");

	// By link_ServiceDiscovery =
	// By.xpath("//body/div[@id='root']/div[@class='dndflow']/aside/div[@class='sideBlock']/h1[3]/span[1]");

	// By link_LogManagement =
	// By.xpath("//body/div[@id='root']/div[@class='dndflow']/aside/div[@class='sideBlock']/h1[4]/span[1]");

	By link_LogManagement = By.xpath(
			"//body/div[@id='root']/div[@class='dndflow homePage']/aside[@class='sidebar-container sidebar-container-expanded']/div[@class='sideBlock side-content visible']/h1[4]/span[1]");
	By Eureka = By.xpath("//img[@alt='eurekalogo']");
	By link_ServiceDiscovery = By.xpath(
			" //body/div[@id='root']/div[@class='dndflow homePage']/aside[@class='sidebar-container sidebar-container-expanded']/div[@class='sideBlock side-content visible']/h1[4]/span[1]");

	By Elastic = By.xpath("//img[@alt='ecklogo']");
	By button_Next = By.xpath("//button[normalize-space()='Next']");
	By button_skip_Infrastructure = By.xpath("//button[normalize-space()='Skip Infrastructure']");

	// web element
	By drop_Place_UI_ReactFlow_Minimap = By.xpath("(//div[@class='react-flow__pane'])[1]");
	By dp = By.xpath("//div[@class='react-flow__renderer']");
	By fitView = By.xpath("//button[@title='fit view']");
	By dandd = By.xpath("//button[normalize-space()='Drag & Drop']");

	// public By node_Service = By.xpath("//div[normalize-space()='Service']");
	// public By node_UIGateway = By.xpath("//div[normalize-space()='UI+Gateway']");
	// public By dragged_UIGatewayNode =
	// By.xpath("//div[@role='button']//div[contains(text(),'UI+Gateway')]");
	public By dragged_ServiceNode = By.xpath("//div[@role='button']//div[contains(text(),'Service')]");
	public By dragged_GroupNode = By.xpath(" (//div[contains(text(),'Group')])[1]");
	public By dragged_Keycloak = By.xpath("//img[@name='oauth2']");
	public By dragged_PostgreSQL = By
			.xpath("//div[@class='react-flow__node react-flow__node-selectorNode nopan selectable']");
	public By dragged_MongoDB = By
			.xpath(" //div[@class='react-flow__node react-flow__node-selectorNode nopan selectable']");
	public By dragged_Eureka = By.xpath("//img[@name='eureka']");
	public By dragged_Elastic = By.xpath("//img[@name='eck']");

	By button_SaveProject = By.xpath("//span[contains(text(),'Save Project')]");
	By link_logout = By.xpath("//p[@class='chakra-text css-q4s4qa']");

	By button_Close = By.xpath("//button[@aria-label='Close']");

	By NodeUI_rightpoint = By
			.xpath("//div[contains(text(),'UITestUI01')]/following-sibling::div[contains(@data-id,'Right-target')]");

	By NodeService_leftpoint = By
			.xpath("//div[contains(text(),'Service02')]/following-sibling::div[contains(@data-id,'Left-target')]");

	By connecting_edge = By.className("react-flow__edge-path");
	/*
	 * Method to create UI node
	 *
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */

	public void createUI(String name) {

		dragAndDrop(node_UIGateway, canvas);
		clickOnButton(dragged_UIGatewayNode);
		enterText(UI_application_Name, name, "Application Name");
		selectDropdown(UI_client_Framework, "React", "Application Framework");
		enterText(UI_package_Name, "testPackage", "Package Name");
		enterText(UI_serverPort, getRandomPortNumber(), "Server Port");
		clickOnButton(button_Save, "Save button");

	}

	//
	/*
	 * Method to create Service node
	 *
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void createService(String name) {
		dragAndDrop(node_Service, canvas);
		clickOnButton(dragged_Service);
		enterText(Service_application_Name, name, "Application Name");
		selectDropdown(Service_client_Framework, "Spring Boot", "Client Framework");
		enterText(Service_package_Name, "testPackage", "Package Name");
		enterText(Service_serverPort, getRandomPortNumber(), "Server Port");
		clickOnButton(button_Save, "Save button");

	}

	public void dragServiceNode() {
		dragAndDrop(node_Service, canvas);
	}

	public void fillServiceNode() {
		clickOnButton(dragged_Service);
		enterText(Service_application_Name, "Service", "Application Name");
		selectDropdown(Service_client_Framework, "Spring Boot", "Client Framework");
		enterText(Service_package_Name, "testPackage", "Package Name");
		enterText(Service_serverPort, getRandomPortNumber(), "Server Port");
		clickOnButton(button_Save, "Save button");

	}

	public void createGroup() {
		dragAndDrop(node_Group, canvas);
		clickOnButton(dragged_Group);
		enterText(Group_groupname, "Group", "Group Name");
		clickOnButton(button_Save, "Save button");
	}

	public void dragtheNode_Authentication() {
		clickOnButton(link_Authentication, "authentication");
		dragAndDrop(Keycloak, canvas);
	}

	public void dragtheNode_Database_MongoDB() {
		clickOnButton(link_Database, "Database");
		dragAndDrop(MongoDB, canvas);
	}

	public void dragtheNode_Database_postgrySQL() {
		clickOnButton(link_Database, "Database");
		dragAndDrop(postgreSQL, canvas);
	}

	public void dragtheNode_serviceDiscovery() {
		clickOnButton(link_ServiceDiscovery, "ServiceDiscovery");
		dragAndDrop(Eureka, canvas);

	}

	public void dragtheNode_LogManagement() {
		clickOnButton(link_LogManagement, " LogManagement");
		dragAndDrop(Elastic, canvas);
	}

	public void dragService_Node() {
		waitForPageLoad(2);
		dragAndDrop(node_Service, canvas);
		waitForPageLoad(5);
	}

	public void dragUIGateway_Node() {
		waitForPageLoad(2);
		dragAndDrop(node_UIGateway, canvas);
		waitForPageLoad(5);
	}

	public By getDraggedElement(String name) {
		return By.xpath("//div[contains(text(),'" + name + "')]");
	}

	public void moveNode(String name, String direction, int count) {
		switch (direction) {
		case "Left":
			doubleClick(getDraggedElement(name));
			_moveLeft(count);
			break;

		case "Right":
			doubleClick(getDraggedElement(name));
			_moveRight(count);
			break;

		case "Up":
			doubleClick(getDraggedElement(name));
			_moveUp(count);
			break;

		case "Down":
			doubleClick(getDraggedElement(name));
			_moveDown(count);
			break;

		default:
			break;
		}
	}

	public void enterProjectName() {
		enterText(link_ProjectName, "TestProject" + getTimestamp(), "ProjectName");
//		clickOnButton(button_Next, "Next button");
//		clickOnButton(button_skip_Infrastructure, "Skip");
//		waitForPageLoad(45);
	}

	public void saveProject() {
		enterText(link_ProjectName, "TestProject" + getTimestamp(), "ProjectName");
		clickOnButton(button_SaveProject, "Save_Project");
		clickOnButton(button_Next, "Next button");
		clickOnButton(button_skip_Infrastructure, "Skip");
		waitForPageLoad(45);
	}

	public By getElementSourcePosition(String name, String position) {
		return By.xpath("//div[contains(text(),'" + name + "')]/following-sibling::div[contains(@data-id,'" + position
				+ "-source')]");
	}

	public By getElementTargetPosition(String name, String position) {
		return By.xpath("//div[contains(text(),'" + name + "')]/following-sibling::div[contains(@data-id,'" + position
				+ "-target')]");

	}

	public void createConnection(String from, String fromPosition, String to, String toPosition) {
		By sourceElement = getElementSourcePosition(from,fromPosition);
		By targetElement = getElementTargetPosition(to, toPosition);

		//dragAndDrop(sourceElement, targetElement);
		dragAndDrop1(sourceElement, targetElement);
		//draganddropwithJSE(sourceElement,targetElement);

	}
	

	public void createConnection() {
		By sourceElement = By.xpath("//div[@data-id='UI-source.Right-source']");
		By targetElement = By.xpath("//div[@class='react-flow__node react-flow__node-ResizableNode nopan selected selectable']//div[@class='react-flow__handle react-flow__handle-left nodrag nopan source connectable connectablestart connectableend connectionindicator']");

		dragAndDrop1(sourceElement, targetElement);

	}
	
	public void createConnectionuiTOservice() {
		By sourceElement = By.xpath(" //div[@data-id='UI-source.Bottom-source']");
		By targetElement = By.xpath("//div[@class='react-flow__nodes']//div[2]//div[4] ");
		dragAndDrop(sourceElement, targetElement);
	}

	public void createConnection1() {
		By sourceElement = By.xpath("//div[@data-id='UI-source.Right-source']");
		By targetElement = By.xpath("//div[@class='react-flow__node react-flow__node-selectorNode nopan selectable']//div[@class='react-flow__handle react-flow__handle-top nodrag nopan target connectable connectablestart connectableend connectionindicator'] ");
		dragAndDrop1(targetElement, sourceElement);

	}
	public void clickConnection() {
		clickOnButton(connecting_edge);

	}

}