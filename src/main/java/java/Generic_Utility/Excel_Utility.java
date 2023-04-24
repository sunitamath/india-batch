package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


	
	/**
	 * this method is used to fetch data from Excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author Sunita
	 */
	
	
	
	
	public class Excel_Utility {

	
	public String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String value = cell.getStringCellValue();
		return value;
	}
	public String getExcelDataFormatter(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		DataFormatter format=new DataFormatter();
		String data = format.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
		return data;
		
	}
	
	public Object[][] readMultipleData(String SheetName)throws Throwable{
	FileInputStream fis1=new FileInputStream("src/test/resources/ExcelSheetData.xlsx");
	Workbook book=WorkbookFactory.create(fis1);
	
	Sheet sh=book.getSheet(SheetName);
	int lastrow=sh.getLastRowNum()+1;
	int lastcell=sh.getRow(0).getLastCellNum();
	
	
	//Sheet sheet = book.getSheet(SheetName);
	//int numrow=sheet.getPhysicalNumberOfRows();
	//int numcel=sheet.getRow(0).getLastCellNum();
	
	Object[][] objarr=new Object[lastrow][lastcell];
	for(int i=0;i<3;i++)
	{
		for(int j=0;j<2;j++)
		{
			objarr[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return objarr;
}
	}
	
	

	
	
	

	
