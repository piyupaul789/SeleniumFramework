package ExcelSheet;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetExample {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		// simple code
		{
			XSSFWorkbook wb = new XSSFWorkbook(new File("data/datasheet_1.xlsx"));
			XSSFSheet sh = wb.getSheet("Sheet1");
			for (int rowCount = 0; rowCount < sh.getLastRowNum(); rowCount++) {
				for (int colCount = 0; colCount < sh.getRow(rowCount).getLastCellNum(); colCount++) {
					System.out.println(sh.getRow(rowCount).getCell(colCount));
				}
			}
		}

		// call from method
		System.err.println(getData("ROLB_Script_2", "AccountNumber"));

	}

	public static String getData(String featureName, String columnName) throws InvalidFormatException, IOException {
		String data = null;
		XSSFWorkbook wb = new XSSFWorkbook(new File("data/datasheet_1.xlsx"));
		XSSFSheet sh = wb.getSheet("Sheet1");
		// iterate through rows
		for (int rowCount = 1; rowCount <= sh.getLastRowNum(); rowCount++) {
			// check if 1st column of each row contains feature name
			if (sh.getRow(rowCount).getCell(0).toString().equals(featureName)) {
				// iterate through columns
				for (int colCount = 1; colCount < sh.getRow(rowCount).getLastCellNum(); colCount++) {
					// check if any column of feature row contains column name
					if (sh.getRow(0).getCell(colCount).toString().equals(columnName)) {
						data = sh.getRow(rowCount).getCell(colCount).toString();
						break;
					}
				}
			}
		}
		return data;

	}

}
