package testcases.smoke;

import org.testng.annotations.Test;

import components.BaseClass;
import pageObjects.HomePage;

public class DragDrop extends BaseClass{
	
	HomePage homePage = new HomePage();
	
//	@Test(groups = { "regression" })
	public void TC_01_performDragAndDrop() {	

		// Steps
//		homePage = launch_ReactFlowApplication();
		homePage.performDrangAndDrop_reactflow();
		
	}
	
	
	@Test(groups = { "regression" })
	public void TC_02_performDragAndDropOnFlowiseApplication() {	

		// Steps
		homePage = launch_FlowiseApplication();
		homePage.performDrangAndDrop_flowise();
		
	}
	
	
	@Test(groups = { "regression" })
	public void TC_03_performDragAndDropOnFlowiseApplication() {	

		// Steps
		homePage = launch_TIC_Application();
		//homePage.dragService_Node();
        //homePage.moveServiceNodeToLeft();
		//homePage.dragUIGateway_Node();
		
	}


}
