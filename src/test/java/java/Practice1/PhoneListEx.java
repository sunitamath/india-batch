package Practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PhoneListEx {
	
	 public static void main(String[] args) throws EncryptedDocumentException, IOException {

	    // declaration and instantiation of objects/variables  
	    	System.setProperty("webdriver.http.factory", "jdk-http-client");
	    System.setProperty("webdriver.chrome.driver", "D:/Sunita/Selenium Advance/chromedriver/chromedriver.exe");  
	    WebDriver driver = new ChromeDriver();  

	    // Launch website
	    driver.navigate().to("https://www.amazon.co.uk/");  
	    
	 // Click on the search text box and send value  
	    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone"); 
	    
	    //click on the search button
	    driver.findElement(By.id("nav-search-submit-button")).click();  
	    
	    FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		 Sheet sheet = book.getSheet("iphone");
		 
		 Row row = sheet.getRow(1);
			Cell cell = row.getCell(3);
			String exceldata = cell.getStringCellValue();
		 
		 

	 }
	 


}
