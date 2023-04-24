package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;

public class CreateCampaignWithProductTest {

public void CreateCampaignWithProduct() throws Throwable {
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
				
				ChromeDriver driver = new ChromeDriver();
				
				driver.manage().window().maximize();
				WebDriver_Utility wlib=new WebDriver_Utility();
				wlib.implicitlyWait(driver);
			    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

				
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
				
				
				
				driver.findElement(By.linkText("Products")).click();
				driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img")).click();
				
				
				Random ran1=new Random();
				int RanNum = ran1.nextInt(1000);
				
				
				Excel_Utility elib=new Excel_Utility();
				String productdata = elib.getExcelData("product",1,1)+RanNum;
				
				/*FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
				Workbook book = WorkbookFactory.create(fes);
				 Sheet sheet = book.getSheet("Product");
				Row row = sheet.getRow(1);
				Cell cell = row.getCell(1);
				String productdata = cell.getStringCellValue()+RanNum;*/
				
				driver.findElement(By.name("productname")).sendKeys(productdata);
				
				driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td[2]/form/div/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[31]/td/div/input[1]")).click();
				
			
				driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/table/tbody/tr/td[22]")).click();
				driver.findElement(By.linkText("Campaigns")).click();
				
				driver.findElement(By.xpath	("//img[@alt='Create Campaign...']")).click();
				
				Random ran11=new Random();
				int RanNum1=ran11.nextInt(1000);
				
				 Excel_Utility elib1=new Excel_Utility();
				 String CampData=elib.getExcelDataFormatter("Campagin",1,2)+RanNum1;
				 
				/*FileInputStream fes1=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
				Workbook book1 = WorkbookFactory.create(fes1);
				 Sheet sheet1 = book1.getSheet("Campagin");
				Row row1 = sheet1.getRow(1);
				Cell cell1 = row1.getCell(2);
				String CampData = cell1.getStringCellValue()+RanNum;*/
				
				driver.findElement(By.name("campaignname")).sendKeys(CampData);
				driver.findElement(By.xpath	("/html/body/table[4]/tbody/tr/td[2]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[5]/td[4]/img")).click();
				
				wlib.switchwindow(driver,"Products&action");
				
				/*Set<String>allid = driver.getWindowHandles();
				Iterator<String> id = allid.iterator();
				
				while(id.hasNext())
				{
					String wid = id.next();
					driver.switchTo().window(wid);
					String title = driver.getTitle();
					
					if(title.contains("Products&action"))
					{
						break;
					}
				}*/
					driver.findElement(By.id("search_txt")).sendKeys(productdata);
					driver.findElement(By.name("search")).click();
					
					
					//dynamic xpath
					driver.findElement(By.xpath("//a[text()='"+productdata+"']")).click();
					
					wlib.switchwindow(driver," Campaigns&action");
					
					/*Set<String>allid1 = driver.getWindowHandles();
					Iterator<String> id1 = allid1.iterator();
					
					while(id1.hasNext())
					{
						String wid1 = id1.next();
						driver.switchTo().window(wid1);
						String title1 = driver.getTitle();
						
						if(title1.contains("Campaigns&action"))
						{
							break;
						}
				
					}*/	// TODO Auto-generated method stub
				
					driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td[2]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td/div/input[1]")).click();
					
					String act = driver.findElement(By.xpath("//*[@id=\"dtlview_Campaign Name\"]")).getText();
					if(act.contains(CampData))
					{
						System.out.println("camp pass");
					}
					else
					{
						System.out.println("camp fail");
					}
					
					String actData = driver.findElement(By.xpath("//*[@id=\"mouseArea_Product\"]")).getText();
					if(actData.contains(productdata))
					{
						System.out.println("prod pass");
					}
					else
					{
						System.out.println("prod fail");
					}
					driver.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/img")).click();
					driver.findElement(By.linkText("Sign Out")).click();
					
	}		
		// TODO Auto-generated method stub

	
}

