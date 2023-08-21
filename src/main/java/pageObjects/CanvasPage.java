package pageObjects;

import components.BaseClass;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs Home page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Kavitha (Kavitha.t@comakeit.com)
 */
public class CanvasPage extends BaseClass {

	// ****************** WEB ELEMENTS ****************************//

	public By link_login = By.xpath("//p[normalize-space()='Login']");

	By node_UI = By.xpath("//div[normalize-space()='UI+Gateway']");
	By drop_place_UI = By.xpath("//div[@class='react-flow__edgelabel-renderer']");

	By dragged_UI = By.xpath("//div[@role='button']//div[contains(text(),'UI+Gateway')]");

	By UI_application_Name = By.xpath("//input[@id='applicationName']");
	By UI_client_Framework = By.xpath("//select[@id='clientFramework']");
	By UI_package_Name = By.xpath("//input[@id='packageName']");
	By UI_serverPort = By.xpath("//input[@id='serverPort']");
	By UI_button_Sumbit = By.xpath("//button[normalize-space()='Submit']");
	// ** service web elements**//

	By node_Service = By.xpath(" //div[@class='dndnode output'][normalize-space()='Service']");
	By drop_place_service = By.xpath("//div[@class='react-flow__edgelabel-renderer']");

	By dragged_Service = By.xpath("//div[@role='button']//div[contains(text(),'Service')]");

	By Service_application_Name = By.xpath("//input[@id='applicationName']");
	By Service_client_Framework = By.xpath("  //select[@id='applicationFramework']");
	By Service_package_Name = By.xpath("//input[@id='packagename']");
	By Service_serverPort = By.xpath("//input[@id='serverport']");
	By Service_button_Sumbit = By.xpath("//button[normalize-space()='Submit']");
	// *Group web elements*//
	By node_Group = By.xpath(" (//div[@class='dndnode output'][normalize-space()='Group'])[1]");
	By drop_place_Group = By.xpath("//div[@class='react-flow__edgelabel-renderer']");

	By dragged_Group = By.xpath("  //div[@role='button']//div[contains(text(),'Group')]");
	By Group_groupname = By.xpath("  //input[@id='groupName']");
	By Group_button_Sumbit = By.xpath("//button[normalize-space()='Submit']");

	// web elements//

	By link_ProjectName = By.xpath("//input[@id='projectName']");

	// *Nodes*//

	By link_Authentication = By.xpath("//h1[1]");
	By node_Keycloak = By.xpath("//img[@alt='keycloaklogo']");

	By link_Database = By.xpath(" //h1[2]");
	By node_postgrySQL = By.xpath("//img[@alt='postgreslogo']");
	By node_MongoDB = By.xpath(" //img[@alt='mongologo']");

	By link_ServiceDiscovery = By
			.xpath("//body/div[@id='root']/div[@class='dndflow']/aside/div[@class='sideBlock']/h1[3]/span[1]");
	By node_Eureka = By.xpath("//img[@alt='eurekalogo']");
	By link_LogManagement = By
			.xpath("//body/div[@id='root']/div[@class='dndflow']/aside/div[@class='sideBlock']/h1[4]/span[1]");
	By node_Elastic = By.xpath("//img[@alt='ecklogo']");
	By button_Next = By.xpath("//button[normalize-space()='Next']");
	By button_skip_Infrastructure = By.xpath("//button[normalize-space()='Skip Infrastructure']");

	// web element
	By drop_Place_UI_ReactFlow_Minimap = By.xpath("(//div[@class='react-flow__pane'])[1]");
	By dp = By.xpath("//div[@class='react-flow__renderer']");
	By fitView = By.xpath("//button[@title='fit view']");
	By dandd = By.xpath("//button[normalize-space()='Drag & Drop']");

	By button_SaveProject = By.xpath("//span[contains(text(),'Save Project')]");

	By link_logout = By.xpath("//p[@class='chakra-text css-q4s4qa']");

	//
	/*
	 * Method to create UI node
	 *
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */

	public void createUI() {

		draganddropwithJSE(node_UI, fitView);
		// dragAndDrop(node_UI, dp);
		//lc(node_UI, dp);
		// drdp(dp,node_UI);

		_moveLeft(node_UI);
		_moveLeft(node_UI);
		_moveLeft(node_UI);
		_moveLeft(node_UI);
		_moveLeft(node_UI);

		clickOnButton(dragged_UI);
		_moveRight(dragged_UI, dandd);
		_moveDown(dragged_UI);
		doubleClick(dragged_UI);
		enterText(UI_application_Name, "TestApp", "Application Name");
		selectDropdown(UI_client_Framework, "React", "Application Framework");
		enterText(UI_package_Name, "testPackage", "Package Name");
		enterText(UI_serverPort, "1234", "Server Port");
		clickOnButton(UI_button_Sumbit, "Submit button");

	}

	//
	/*
	 * Method to create Service node
	 *
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */
	public void createService() {
		// dragAndDrop(node_Service, drop_place);
		draganddropwithJSE(node_Service, drop_place_service);
		doubleClick(dragged_Service);
		enterText(Service_application_Name, "TestApp", "Application Name");
		selectDropdown(Service_client_Framework, "Spring Boot", "Client Framework");
		enterText(Service_package_Name, "testPackage", "Package Name");
		enterText(Service_serverPort, "1234", "Server Port");
		clickOnButton(Service_button_Sumbit, "Submit button");

	}

	public void createGroup() {
		// dragAndDrop(node_Group, drop_place);
		draganddropwithJSE(node_Group, drop_place_Group);
		doubleClick(dragged_Group);
		enterText(Group_groupname, "TestGroup", "Group Name");
		clickOnButton(Group_button_Sumbit, "Submit button");
	}

	public void dragtheNode_Authentication() {
		clickOnButton(link_Authentication, "authentication");
		draganddropwithJSE(node_Keycloak, drop_place_service);
	}

	/*
	 * public void
	 * dragtheNodes_Authentication_Database_serviceDiscovery_LogManagement() {
	 * clickOnButton(link_Authentication , "authentication");
	 * draganddropwithJSE(node_Keycloak,drop_place);
	 * 
	 * clickOnButton(link_Database , "Database"); draganddropwithJSE(
	 * node_postgrySQL,drop_place); draganddropwithJSE(node_MongoDB,drop_place);
	 * 
	 * clickOnButton(link_ServiceDiscovery , "ServiceDiscovery");
	 * draganddropwithJSE(node_Eureka ,drop_place);
	 * 
	 * clickOnButton(link_LogManagement , " LogManagement");
	 * draganddropwithJSE(node_Elastic,drop_place); }
	 */

	public void dragtheNode_Database_MongoDB() {
		clickOnButton(link_Database, "Database");
		draganddropwithJSE(node_MongoDB, drop_place_service);
	}

	public void dragtheNode_Database_postgrySQL() {
		clickOnButton(link_Database, "Database");
		draganddropwithJSE(node_postgrySQL, drop_place_service);
	}

	public void dragtheNode_serviceDiscovery() {
		clickOnButton(link_ServiceDiscovery, "ServiceDiscovery");
		draganddropwithJSE(node_Eureka, drop_place_service);

	}

	public void dragtheNode_LogManagement() {
		clickOnButton(link_LogManagement, " LogManagement");
		draganddropwithJSE(node_Elastic, drop_place_service);
	}

	public void saveProject() {
		enterText(link_ProjectName, "TestProject" + getTimestamp(), "ProjectName");
		clickOnButton(button_SaveProject, "Save_Project");
		clickOnButton(button_Next, "Next button");
		clickOnButton(button_skip_Infrastructure, "Skip");
		waitForPageLoad(45);
	}

}