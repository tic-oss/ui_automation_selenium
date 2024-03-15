package utils;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import components.BaseClass;
import dataModel.*;

/*
 * Class is to handle the XML operations i.e. getting test data from xml and binding to Java object
 * 
 * 
 * Author : Kavitha Thota
 */
public class XML_Operations extends BaseClass {

	/*
	 * This method is to load the data from XML file and bind it to the respective
	 * JAVA object
	 * 
	 * Author : Kavitha Thota
	 */
	public Object getTestData(String model) {
		JAXBContext jaxbContext;
		File xmlFile;

		switch (model.toLowerCase()) {
		case "guest":
			Guest guest = null;			
			xmlFile = new File("src//test//java//testdata//Guest.xml");
			try {
				jaxbContext = JAXBContext.newInstance(Guest.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				guest = (Guest) jaxbUnmarshaller.unmarshal(xmlFile);

			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return guest;

		}
		return null;
	}
}
