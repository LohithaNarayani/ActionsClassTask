package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public String getExcelData(String columnName, int rowNumber) throws IOException {
		String cellValue = null;

		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\test_data_sheet.xlsx");
		XSSFWorkbook workbook = null;

		try {
			workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet("Dev");

			XSSFRow row = sheet.getRow(0);
			int col_num = -1;

			for(int i=0; i < row.getLastCellNum(); i++)
			{
				if(row.getCell(i).getStringCellValue().trim().equals(columnName))
					col_num = i;
			}

			row = sheet.getRow(rowNumber);
			XSSFCell cell = row.getCell(col_num);

			cellValue = cell.getStringCellValue();
			System.out.println("Value of the Excel Cell is - "+ cellValue);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		finally {

			workbook.close();
		}

		return cellValue;
	}

	public ArrayList<String> getExcelData(String columnName) throws IOException {

		ArrayList<String> columnData = null;

		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\test_data_sheet.xlsx");
		XSSFWorkbook workbook = null;

		try {
			workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet("Dev");

			XSSFRow row = sheet.getRow(0);
			int col_num = -1;

			for(int i=0; i < row.getLastCellNum(); i++)
			{
				if(row.getCell(i).getStringCellValue().trim().equals(columnName))
					col_num = i;
			}

			int totalRows = sheet.getLastRowNum();
			columnData = new ArrayList<String>();

			for(int index=1;index<=totalRows;index++) {

				XSSFRow currentRow = sheet.getRow(index);
				XSSFCell cell = currentRow.getCell(col_num);

				String value = cell.getStringCellValue();
				System.out.println("Cell value: "+ value);
				columnData.add(value);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		finally {

			workbook.close();
		}

		return columnData;
	}

}
