package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import com.poiji.bind.Poiji;

import components.BaseClass;
import reports.Extent_Reports;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Class is to handle the Excel operations i.e. getting test data from excel and binding to Java object
 * 
 * 
 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
 */
public class Excel_Operations extends Extent_Reports {

	BaseClass baseClass = new BaseClass();


	/*
	 * This method is to get the number of sheets from excel sheet
	 * 
	 * Author : Kavitha Thota(Kavitha.t@comakeit.com)
	 */

	public List<String> get_Total_Sheets(String fileName) {
		try {
			List<String> sheets = new ArrayList<String>();
			File file = new File(System.getProperty("user.dir") + "//src//test//resources//" + fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));

			int no_of_Sheets = workbook.getNumberOfSheets();

			for (int i = 0; i < no_of_Sheets; i++) {
				sheets.add(workbook.getSheetName(i));
			}
			return sheets;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}



}
