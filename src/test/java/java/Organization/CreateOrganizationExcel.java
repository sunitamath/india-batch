package Organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.WebDriver_Utility;
import POM.HomePage;
import POM.LoginPage;


public class CreateOrganizationExcel {

	
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.implicitlyWait(driver);
	   // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    
	    Property_Utility plib=new Property_Utility();
	   String URL = plib.getKeyValue("url");
	    String USERNAME = plib.getKeyValue("username");
	   String PASSWORD = plib.getKeyValue("password");
	    

		
		/*FileInputStream fis=new FileInputStream("./src/test/resources/config.properties");
		
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");*/

		driver.get(URL);
	
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		
		
		
		
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img")).click();
		
		
		
		
		
		
		/*Random ran=new Random();
		int RanNum=ran.nextInt(1000);*/
		
		Java_Utility jlib=new Java_Utility();
		int RanNum = jlib.getRandomNum();
		
		Excel_Utility elib=new Excel_Utility();
		String exceldata = elib.getExcelData("Organization", 1,1)+RanNum;
		
		
		/*FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Organization");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(1);
		String exceldata = cell.getStringCellValue()+RanNum;*/
		
		driver.findElement(By.name("accountname")).sendKeys(exceldata);
		driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td[2]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[22]/td/div/input[1]")).click();
		String actdata = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		if(actdata.contains(exceldata))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
			
		
		driver.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/img")).click();
		driver.findElement(By.linkText("Sign Out")).click();

		// TODO Auto-generated method stub/*

	}

}
