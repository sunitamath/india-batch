package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;

public class CreateCampaignTest extends BaseClass  {

	@Test
	public  void CreateCampaign() throws Throwable {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
				
				ChromeDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				
			  //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

				
				FileInputStream fis=new FileInputStream("./src/test/resources/config.properties");
				Properties pro=new Properties();
				pro.load(fis);
				String URL = pro.getProperty("url");
				String USERNAME = pro.getProperty("username");
				String PASSWORD = pro.getProperty("password");

				driver.get(URL);
			
				
				//driver.get("http://localhost:8888/");
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);

				driver.findElement(By.id("submitButton")).click();
				
			driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/table/tbody/tr/td[22]")).click();
			driver.findElement(By.linkText("Campaigns")).click();
			driver.findElement(By.xpath	("//img[@alt='Create Campaign...']")).click();
			
			Random ran=new Random();
			int RanNum = ran.nextInt(1000);
			
			Excel_Utility elib=new Excel_Utility();
			String CampData=elib.getExcelDataFormatter("Campagin",1,2) +RanNum;
			
			/*FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
			Workbook book = WorkbookFactory.create(fes);
			 Sheet sheet = book.getSheet("Campagin");
			Row row = sheet.getRow(1);
			Cell cell = row.getCell(2);
			String CampData = cell.getStringCellValue()+RanNum;*/
			
			driver.findElement(By.name("campaignname")).sendKeys(CampData);
			//save
			driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td[2]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td/div/input[1]")).click();
					// TODO Auto-generated method stub
			String actData = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
			if(actData .contains(CampData))
			{
				System.out.println("pass");
			}
			else
			{
				System.out.println("fail");
			}
			driver.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/img")).click();
			driver.findElement(By.linkText("Sign Out")).click();
	
	}

}
